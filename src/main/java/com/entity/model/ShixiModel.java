package com.entity.model;

import com.entity.ShixiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 实习
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShixiModel implements Serializable {
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
     * 实习编号
     */
    private String shixiUuidNumber;


    /**
     * 单位名称
     */
    private String shixiName;


    /**
     * 单位地址
     */
    private String shixiAddress;


    /**
     * 单位性质
     */
    private Integer shixiTypes;


    /**
     * 实习岗位
     */
    private String shixiGangwei;


    /**
     * 实习开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaishiTime;


    /**
     * 实习结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieshuTime;


    /**
     * 实习详情
     */
    private String shixiContent;


    /**
     * 审核状态
     */
    private Integer shixiYesnoTypes;


    /**
     * 审核意见
     */
    private String shixiYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date unpdateTime;


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
	 * 获取：实习编号
	 */
    public String getShixiUuidNumber() {
        return shixiUuidNumber;
    }


    /**
	 * 设置：实习编号
	 */
    public void setShixiUuidNumber(String shixiUuidNumber) {
        this.shixiUuidNumber = shixiUuidNumber;
    }
    /**
	 * 获取：单位名称
	 */
    public String getShixiName() {
        return shixiName;
    }


    /**
	 * 设置：单位名称
	 */
    public void setShixiName(String shixiName) {
        this.shixiName = shixiName;
    }
    /**
	 * 获取：单位地址
	 */
    public String getShixiAddress() {
        return shixiAddress;
    }


    /**
	 * 设置：单位地址
	 */
    public void setShixiAddress(String shixiAddress) {
        this.shixiAddress = shixiAddress;
    }
    /**
	 * 获取：单位性质
	 */
    public Integer getShixiTypes() {
        return shixiTypes;
    }


    /**
	 * 设置：单位性质
	 */
    public void setShixiTypes(Integer shixiTypes) {
        this.shixiTypes = shixiTypes;
    }
    /**
	 * 获取：实习岗位
	 */
    public String getShixiGangwei() {
        return shixiGangwei;
    }


    /**
	 * 设置：实习岗位
	 */
    public void setShixiGangwei(String shixiGangwei) {
        this.shixiGangwei = shixiGangwei;
    }
    /**
	 * 获取：实习开始时间
	 */
    public Date getKaishiTime() {
        return kaishiTime;
    }


    /**
	 * 设置：实习开始时间
	 */
    public void setKaishiTime(Date kaishiTime) {
        this.kaishiTime = kaishiTime;
    }
    /**
	 * 获取：实习结束时间
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }


    /**
	 * 设置：实习结束时间
	 */
    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }
    /**
	 * 获取：实习详情
	 */
    public String getShixiContent() {
        return shixiContent;
    }


    /**
	 * 设置：实习详情
	 */
    public void setShixiContent(String shixiContent) {
        this.shixiContent = shixiContent;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getShixiYesnoTypes() {
        return shixiYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setShixiYesnoTypes(Integer shixiYesnoTypes) {
        this.shixiYesnoTypes = shixiYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getShixiYesnoText() {
        return shixiYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setShixiYesnoText(String shixiYesnoText) {
        this.shixiYesnoText = shixiYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getUnpdateTime() {
        return unpdateTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setUnpdateTime(Date unpdateTime) {
        this.unpdateTime = unpdateTime;
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
