package com.entity.model;

import com.entity.ShixiFenxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 实习分享
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShixiFenxiangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 分享标题
     */
    private String shixiFenxiangName;


    /**
     * 分享照片
     */
    private String shixiFenxiangPhoto;


    /**
     * 分享类型
     */
    private Integer shixiFenxiangTypes;


    /**
     * 热度
     */
    private Integer shixiFenxiangClicknum;


    /**
     * 分享内容
     */
    private String shixiFenxiangContent;


    /**
     * 逻辑删除
     */
    private Integer shixiFenxiangDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 设置：学生
	 */
    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：分享标题
	 */
    public String getShixiFenxiangName() {
        return shixiFenxiangName;
    }


    /**
	 * 设置：分享标题
	 */
    public void setShixiFenxiangName(String shixiFenxiangName) {
        this.shixiFenxiangName = shixiFenxiangName;
    }
    /**
	 * 获取：分享照片
	 */
    public String getShixiFenxiangPhoto() {
        return shixiFenxiangPhoto;
    }


    /**
	 * 设置：分享照片
	 */
    public void setShixiFenxiangPhoto(String shixiFenxiangPhoto) {
        this.shixiFenxiangPhoto = shixiFenxiangPhoto;
    }
    /**
	 * 获取：分享类型
	 */
    public Integer getShixiFenxiangTypes() {
        return shixiFenxiangTypes;
    }


    /**
	 * 设置：分享类型
	 */
    public void setShixiFenxiangTypes(Integer shixiFenxiangTypes) {
        this.shixiFenxiangTypes = shixiFenxiangTypes;
    }
    /**
	 * 获取：热度
	 */
    public Integer getShixiFenxiangClicknum() {
        return shixiFenxiangClicknum;
    }


    /**
	 * 设置：热度
	 */
    public void setShixiFenxiangClicknum(Integer shixiFenxiangClicknum) {
        this.shixiFenxiangClicknum = shixiFenxiangClicknum;
    }
    /**
	 * 获取：分享内容
	 */
    public String getShixiFenxiangContent() {
        return shixiFenxiangContent;
    }


    /**
	 * 设置：分享内容
	 */
    public void setShixiFenxiangContent(String shixiFenxiangContent) {
        this.shixiFenxiangContent = shixiFenxiangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShixiFenxiangDelete() {
        return shixiFenxiangDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setShixiFenxiangDelete(Integer shixiFenxiangDelete) {
        this.shixiFenxiangDelete = shixiFenxiangDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
