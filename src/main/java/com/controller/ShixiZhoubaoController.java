
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
 * 实习周报
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shixiZhoubao")
public class ShixiZhoubaoController {
    private static final Logger logger = LoggerFactory.getLogger(ShixiZhoubaoController.class);

    @Autowired
    private ShixiZhoubaoService shixiZhoubaoService;


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
        PageUtils page = shixiZhoubaoService.queryPage(params);

        //字典表数据转换
        List<ShixiZhoubaoView> list =(List<ShixiZhoubaoView>)page.getList();
        for(ShixiZhoubaoView c:list){
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
        ShixiZhoubaoEntity shixiZhoubao = shixiZhoubaoService.selectById(id);
        if(shixiZhoubao !=null){
            //entity转view
            ShixiZhoubaoView view = new ShixiZhoubaoView();
            BeanUtils.copyProperties( shixiZhoubao , view );//把实体数据重构到view中

                //级联表
                ShixiEntity shixi = shixiService.selectById(shixiZhoubao.getShixiId());
                if(shixi != null){
                    BeanUtils.copyProperties( shixi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShixiId(shixi.getId());
                    view.setShixiXueshengId(shixi.getXueshengId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(shixiZhoubao.getXueshengId());
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
    public R save(@RequestBody ShixiZhoubaoEntity shixiZhoubao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shixiZhoubao:{}",this.getClass().getName(),shixiZhoubao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            shixiZhoubao.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShixiZhoubaoEntity> queryWrapper = new EntityWrapper<ShixiZhoubaoEntity>()
            .eq("xuesheng_id", shixiZhoubao.getXueshengId())
            .eq("shixi_id", shixiZhoubao.getShixiId())
            .eq("shixi_zhoubao_uuid_number", shixiZhoubao.getShixiZhoubaoUuidNumber())
            .eq("shixi_zhoubao_name", shixiZhoubao.getShixiZhoubaoName())
            .eq("shixi_zhoubao_types", shixiZhoubao.getShixiZhoubaoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShixiZhoubaoEntity shixiZhoubaoEntity = shixiZhoubaoService.selectOne(queryWrapper);
        if(shixiZhoubaoEntity==null){
            shixiZhoubao.setInsertTime(new Date());
            shixiZhoubao.setCreateTime(new Date());
            shixiZhoubaoService.insert(shixiZhoubao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShixiZhoubaoEntity shixiZhoubao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shixiZhoubao:{}",this.getClass().getName(),shixiZhoubao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            shixiZhoubao.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShixiZhoubaoEntity> queryWrapper = new EntityWrapper<ShixiZhoubaoEntity>()
            .notIn("id",shixiZhoubao.getId())
            .andNew()
            .eq("xuesheng_id", shixiZhoubao.getXueshengId())
            .eq("shixi_id", shixiZhoubao.getShixiId())
            .eq("shixi_zhoubao_uuid_number", shixiZhoubao.getShixiZhoubaoUuidNumber())
            .eq("shixi_zhoubao_name", shixiZhoubao.getShixiZhoubaoName())
            .eq("shixi_zhoubao_types", shixiZhoubao.getShixiZhoubaoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShixiZhoubaoEntity shixiZhoubaoEntity = shixiZhoubaoService.selectOne(queryWrapper);
        if(shixiZhoubaoEntity==null){
            shixiZhoubaoService.updateById(shixiZhoubao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shixiZhoubaoService.deleteBatchIds(Arrays.asList(ids));
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
            List<ShixiZhoubaoEntity> shixiZhoubaoList = new ArrayList<>();//上传的东西
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
                            ShixiZhoubaoEntity shixiZhoubaoEntity = new ShixiZhoubaoEntity();
//                            shixiZhoubaoEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            shixiZhoubaoEntity.setShixiId(Integer.valueOf(data.get(0)));   //实习 要改的
//                            shixiZhoubaoEntity.setShixiZhoubaoUuidNumber(data.get(0));                    //实习周报编号 要改的
//                            shixiZhoubaoEntity.setShixiZhoubaoName(data.get(0));                    //周报标题 要改的
//                            shixiZhoubaoEntity.setShixiZhoubaoTypes(Integer.valueOf(data.get(0)));   //第几周 要改的
//                            shixiZhoubaoEntity.setShixiZhoubaoContent("");//详情和图片
//                            shixiZhoubaoEntity.setInsertTime(date);//时间
//                            shixiZhoubaoEntity.setCreateTime(date);//时间
                            shixiZhoubaoList.add(shixiZhoubaoEntity);


                            //把要查询是否重复的字段放入map中
                                //实习周报编号
                                if(seachFields.containsKey("shixiZhoubaoUuidNumber")){
                                    List<String> shixiZhoubaoUuidNumber = seachFields.get("shixiZhoubaoUuidNumber");
                                    shixiZhoubaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shixiZhoubaoUuidNumber = new ArrayList<>();
                                    shixiZhoubaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shixiZhoubaoUuidNumber",shixiZhoubaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //实习周报编号
                        List<ShixiZhoubaoEntity> shixiZhoubaoEntities_shixiZhoubaoUuidNumber = shixiZhoubaoService.selectList(new EntityWrapper<ShixiZhoubaoEntity>().in("shixi_zhoubao_uuid_number", seachFields.get("shixiZhoubaoUuidNumber")));
                        if(shixiZhoubaoEntities_shixiZhoubaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShixiZhoubaoEntity s:shixiZhoubaoEntities_shixiZhoubaoUuidNumber){
                                repeatFields.add(s.getShixiZhoubaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [实习周报编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shixiZhoubaoService.insertBatch(shixiZhoubaoList);
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
        PageUtils page = shixiZhoubaoService.queryPage(params);

        //字典表数据转换
        List<ShixiZhoubaoView> list =(List<ShixiZhoubaoView>)page.getList();
        for(ShixiZhoubaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShixiZhoubaoEntity shixiZhoubao = shixiZhoubaoService.selectById(id);
            if(shixiZhoubao !=null){


                //entity转view
                ShixiZhoubaoView view = new ShixiZhoubaoView();
                BeanUtils.copyProperties( shixiZhoubao , view );//把实体数据重构到view中

                //级联表
                    ShixiEntity shixi = shixiService.selectById(shixiZhoubao.getShixiId());
                if(shixi != null){
                    BeanUtils.copyProperties( shixi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShixiId(shixi.getId());
                }
                //级联表
                    XueshengEntity xuesheng = xueshengService.selectById(shixiZhoubao.getXueshengId());
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
    public R add(@RequestBody ShixiZhoubaoEntity shixiZhoubao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shixiZhoubao:{}",this.getClass().getName(),shixiZhoubao.toString());
        Wrapper<ShixiZhoubaoEntity> queryWrapper = new EntityWrapper<ShixiZhoubaoEntity>()
            .eq("xuesheng_id", shixiZhoubao.getXueshengId())
            .eq("shixi_id", shixiZhoubao.getShixiId())
            .eq("shixi_zhoubao_uuid_number", shixiZhoubao.getShixiZhoubaoUuidNumber())
            .eq("shixi_zhoubao_name", shixiZhoubao.getShixiZhoubaoName())
            .eq("shixi_zhoubao_types", shixiZhoubao.getShixiZhoubaoTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShixiZhoubaoEntity shixiZhoubaoEntity = shixiZhoubaoService.selectOne(queryWrapper);
        if(shixiZhoubaoEntity==null){
            shixiZhoubao.setInsertTime(new Date());
            shixiZhoubao.setCreateTime(new Date());
        shixiZhoubaoService.insert(shixiZhoubao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
