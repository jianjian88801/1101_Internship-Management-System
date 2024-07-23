
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 实习成绩
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shixiChengji")
public class ShixiChengjiController {
    private static final Logger logger = LoggerFactory.getLogger(ShixiChengjiController.class);

    @Autowired
    private ShixiChengjiService shixiChengjiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShixiService shixiService;
    @Autowired
    private XueshengService xueshengService;

    @Autowired
    private LaoshiService laoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shixiChengjiService.queryPage(params);

        //字典表数据转换
        List<ShixiChengjiView> list =(List<ShixiChengjiView>)page.getList();
        for(ShixiChengjiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShixiChengjiEntity shixiChengji = shixiChengjiService.selectById(id);
        if(shixiChengji !=null){
            //entity转view
            ShixiChengjiView view = new ShixiChengjiView();
            BeanUtils.copyProperties( shixiChengji , view );//把实体数据重构到view中

                //级联表
                ShixiEntity shixi = shixiService.selectById(shixiChengji.getShixiId());
                if(shixi != null){
                    BeanUtils.copyProperties( shixi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShixiId(shixi.getId());
                    view.setShixiXueshengId(shixi.getXueshengId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(shixiChengji.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShixiChengjiEntity shixiChengji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shixiChengji:{}",this.getClass().getName(),shixiChengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            shixiChengji.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShixiChengjiEntity> queryWrapper = new EntityWrapper<ShixiChengjiEntity>()
            .eq("shixi_id", shixiChengji.getShixiId())
                .orNew(
                )
            .eq("xuesheng_id", shixiChengji.getXueshengId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShixiChengjiEntity shixiChengjiEntity = shixiChengjiService.selectOne(queryWrapper);
        if(shixiChengjiEntity==null){
            shixiChengji.setInsertTime(new Date());
            shixiChengji.setCreateTime(new Date());
            shixiChengjiService.insert(shixiChengji);
            return R.ok();
        }else {
            return R.error(511,"该实习或者该学生已经有成绩记录");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShixiChengjiEntity shixiChengji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shixiChengji:{}",this.getClass().getName(),shixiChengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            shixiChengji.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShixiChengjiEntity> queryWrapper = new EntityWrapper<ShixiChengjiEntity>()
            .notIn("id",shixiChengji.getId())
            .andNew()
                .eq("shixi_id", shixiChengji.getShixiId())
                .orNew(
                )
                .eq("xuesheng_id", shixiChengji.getXueshengId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShixiChengjiEntity shixiChengjiEntity = shixiChengjiService.selectOne(queryWrapper);
        if(shixiChengjiEntity==null){
            shixiChengjiService.updateById(shixiChengji);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该实习或者该学生已经有成绩记录");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shixiChengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShixiChengjiEntity> shixiChengjiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShixiChengjiEntity shixiChengjiEntity = new ShixiChengjiEntity();
//                            shixiChengjiEntity.setShixiId(Integer.valueOf(data.get(0)));   //实习 要改的
//                            shixiChengjiEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            shixiChengjiEntity.setShixiChengjiUuidNumber(data.get(0));                    //成绩编号 要改的
//                            shixiChengjiEntity.setShixiChengjiTypes(Integer.valueOf(data.get(0)));   //成绩结果 要改的
//                            shixiChengjiEntity.setFenshu(data.get(0));                    //成绩分数 要改的
//                            shixiChengjiEntity.setShixiChengjiYesnoText(data.get(0));                    //实习评语 要改的
//                            shixiChengjiEntity.setInsertTime(date);//时间
//                            shixiChengjiEntity.setCreateTime(date);//时间
                            shixiChengjiList.add(shixiChengjiEntity);


                            //把要查询是否重复的字段放入map中
                                //成绩编号
                                if(seachFields.containsKey("shixiChengjiUuidNumber")){
                                    List<String> shixiChengjiUuidNumber = seachFields.get("shixiChengjiUuidNumber");
                                    shixiChengjiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shixiChengjiUuidNumber = new ArrayList<>();
                                    shixiChengjiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shixiChengjiUuidNumber",shixiChengjiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //成绩编号
                        List<ShixiChengjiEntity> shixiChengjiEntities_shixiChengjiUuidNumber = shixiChengjiService.selectList(new EntityWrapper<ShixiChengjiEntity>().in("shixi_chengji_uuid_number", seachFields.get("shixiChengjiUuidNumber")));
                        if(shixiChengjiEntities_shixiChengjiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShixiChengjiEntity s:shixiChengjiEntities_shixiChengjiUuidNumber){
                                repeatFields.add(s.getShixiChengjiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [成绩编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shixiChengjiService.insertBatch(shixiChengjiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = shixiChengjiService.queryPage(params);

        //字典表数据转换
        List<ShixiChengjiView> list =(List<ShixiChengjiView>)page.getList();
        for(ShixiChengjiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShixiChengjiEntity shixiChengji = shixiChengjiService.selectById(id);
            if(shixiChengji !=null){


                //entity转view
                ShixiChengjiView view = new ShixiChengjiView();
                BeanUtils.copyProperties( shixiChengji , view );//把实体数据重构到view中

                //级联表
                    ShixiEntity shixi = shixiService.selectById(shixiChengji.getShixiId());
                if(shixi != null){
                    BeanUtils.copyProperties( shixi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShixiId(shixi.getId());
                }
                //级联表
                    XueshengEntity xuesheng = xueshengService.selectById(shixiChengji.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShixiChengjiEntity shixiChengji, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shixiChengji:{}",this.getClass().getName(),shixiChengji.toString());
        Wrapper<ShixiChengjiEntity> queryWrapper = new EntityWrapper<ShixiChengjiEntity>()
            .eq("shixi_id", shixiChengji.getShixiId())
            .eq("xuesheng_id", shixiChengji.getXueshengId())
            .eq("shixi_chengji_uuid_number", shixiChengji.getShixiChengjiUuidNumber())
            .eq("shixi_chengji_types", shixiChengji.getShixiChengjiTypes())
            .eq("shixi_chengji_yesno_text", shixiChengji.getShixiChengjiYesnoText())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShixiChengjiEntity shixiChengjiEntity = shixiChengjiService.selectOne(queryWrapper);
        if(shixiChengjiEntity==null){
            shixiChengji.setInsertTime(new Date());
            shixiChengji.setCreateTime(new Date());
        shixiChengjiService.insert(shixiChengji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
