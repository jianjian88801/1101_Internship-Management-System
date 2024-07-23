package com.entity.model;

import com.entity.ShixiChengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 实习成绩
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShixiChengjiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 实习
     */
    private Integer shixiId;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 成绩编号
     */
    private String shixiChengjiUuidNumber;


    /**
     * 成绩结果
     */
    private Integer shixiChengjiTypes;


    /**
     * 成绩分数
     */
    private Double fenshu;


    /**
     * 实习评语
     */
    private String shixiChengjiYesnoText;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：实习
	 */
    public Integer getShixiId() {
        return shixiId;
    }


    /**
	 * 设置：实习
	 */
    public void setShixiId(Integer shixiId) {
        this.shixiId = shixiId;
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
	 * 获取：成绩编号
	 */
    public String getShixiChengjiUuidNumber() {
        return shixiChengjiUuidNumber;
    }


    /**
	 * 设置：成绩编号
	 */
    public void setShixiChengjiUuidNumber(String shixiChengjiUuidNumber) {
        this.shixiChengjiUuidNumber = shixiChengjiUuidNumber;
    }
    /**
	 * 获取：成绩结果
	 */
    public Integer getShixiChengjiTypes() {
        return shixiChengjiTypes;
    }


    /**
	 * 设置：成绩结果
	 */
    public void setShixiChengjiTypes(Integer shixiChengjiTypes) {
        this.shixiChengjiTypes = shixiChengjiTypes;
    }
    /**
	 * 获取：成绩分数
	 */
    public Double getFenshu() {
        return fenshu;
    }


    /**
	 * 设置：成绩分数
	 */
    public void setFenshu(Double fenshu) {
        this.fenshu = fenshu;
    }
    /**
	 * 获取：实习评语
	 */
    public String getShixiChengjiYesnoText() {
        return shixiChengjiYesnoText;
    }


    /**
	 * 设置：实习评语
	 */
    public void setShixiChengjiYesnoText(String shixiChengjiYesnoText) {
        this.shixiChengjiYesnoText = shixiChengjiYesnoText;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
