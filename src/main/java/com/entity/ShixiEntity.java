package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 实习
 *
 * @author 
 * @email
 */
@TableName("shixi")
public class ShixiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShixiEntity() {

	}

	public ShixiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 实习编号
     */
    @TableField(value = "shixi_uuid_number")

    private String shixiUuidNumber;


    /**
     * 单位名称
     */
    @TableField(value = "shixi_name")

    private String shixiName;


    /**
     * 单位地址
     */
    @TableField(value = "shixi_address")

    private String shixiAddress;


    /**
     * 单位性质
     */
    @TableField(value = "shixi_types")

    private Integer shixiTypes;


    /**
     * 实习岗位
     */
    @TableField(value = "shixi_gangwei")

    private String shixiGangwei;


    /**
     * 实习开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "kaishi_time")

    private Date kaishiTime;


    /**
     * 实习结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "jieshu_time")

    private Date jieshuTime;


    /**
     * 实习详情
     */
    @TableField(value = "shixi_content")

    private String shixiContent;


    /**
     * 审核状态
     */
    @TableField(value = "shixi_yesno_types")

    private Integer shixiYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "shixi_yesno_text")

    private String shixiYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "unpdate_time")

    private Date unpdateTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }
    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：实习编号
	 */
    public String getShixiUuidNumber() {
        return shixiUuidNumber;
    }
    /**
	 * 获取：实习编号
	 */

    public void setShixiUuidNumber(String shixiUuidNumber) {
        this.shixiUuidNumber = shixiUuidNumber;
    }
    /**
	 * 设置：单位名称
	 */
    public String getShixiName() {
        return shixiName;
    }
    /**
	 * 获取：单位名称
	 */

    public void setShixiName(String shixiName) {
        this.shixiName = shixiName;
    }
    /**
	 * 设置：单位地址
	 */
    public String getShixiAddress() {
        return shixiAddress;
    }
    /**
	 * 获取：单位地址
	 */

    public void setShixiAddress(String shixiAddress) {
        this.shixiAddress = shixiAddress;
    }
    /**
	 * 设置：单位性质
	 */
    public Integer getShixiTypes() {
        return shixiTypes;
    }
    /**
	 * 获取：单位性质
	 */

    public void setShixiTypes(Integer shixiTypes) {
        this.shixiTypes = shixiTypes;
    }
    /**
	 * 设置：实习岗位
	 */
    public String getShixiGangwei() {
        return shixiGangwei;
    }
    /**
	 * 获取：实习岗位
	 */

    public void setShixiGangwei(String shixiGangwei) {
        this.shixiGangwei = shixiGangwei;
    }
    /**
	 * 设置：实习开始时间
	 */
    public Date getKaishiTime() {
        return kaishiTime;
    }
    /**
	 * 获取：实习开始时间
	 */

    public void setKaishiTime(Date kaishiTime) {
        this.kaishiTime = kaishiTime;
    }
    /**
	 * 设置：实习结束时间
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }
    /**
	 * 获取：实习结束时间
	 */

    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }
    /**
	 * 设置：实习详情
	 */
    public String getShixiContent() {
        return shixiContent;
    }
    /**
	 * 获取：实习详情
	 */

    public void setShixiContent(String shixiContent) {
        this.shixiContent = shixiContent;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getShixiYesnoTypes() {
        return shixiYesnoTypes;
    }
    /**
	 * 获取：审核状态
	 */

    public void setShixiYesnoTypes(Integer shixiYesnoTypes) {
        this.shixiYesnoTypes = shixiYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getShixiYesnoText() {
        return shixiYesnoText;
    }
    /**
	 * 获取：审核意见
	 */

    public void setShixiYesnoText(String shixiYesnoText) {
        this.shixiYesnoText = shixiYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getUnpdateTime() {
        return unpdateTime;
    }
    /**
	 * 获取：审核时间
	 */

    public void setUnpdateTime(Date unpdateTime) {
        this.unpdateTime = unpdateTime;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shixi{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", shixiUuidNumber=" + shixiUuidNumber +
            ", shixiName=" + shixiName +
            ", shixiAddress=" + shixiAddress +
            ", shixiTypes=" + shixiTypes +
            ", shixiGangwei=" + shixiGangwei +
            ", kaishiTime=" + kaishiTime +
            ", jieshuTime=" + jieshuTime +
            ", shixiContent=" + shixiContent +
            ", shixiYesnoTypes=" + shixiYesnoTypes +
            ", shixiYesnoText=" + shixiYesnoText +
            ", unpdateTime=" + unpdateTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
