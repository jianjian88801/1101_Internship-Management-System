package com.entity.vo;

import com.entity.ShixiChengjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 实习成绩
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shixi_chengji")
public class ShixiChengjiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 实习
     */

    @TableField(value = "shixi_id")
    private Integer shixiId;


    /**
     * 学生
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 成绩编号
     */

    @TableField(value = "shixi_chengji_uuid_number")
    private String shixiChengjiUuidNumber;


    /**
     * 成绩结果
     */

    @TableField(value = "shixi_chengji_types")
    private Integer shixiChengjiTypes;


    /**
     * 成绩分数
     */

    @TableField(value = "fenshu")
    private Double fenshu;


    /**
     * 实习评语
     */

    @TableField(value = "shixi_chengji_yesno_text")
    private String shixiChengjiYesnoText;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：实习
	 */
    public Integer getShixiId() {
        return shixiId;
    }


    /**
	 * 获取：实习
	 */

    public void setShixiId(Integer shixiId) {
        this.shixiId = shixiId;
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
	 * 设置：成绩编号
	 */
    public String getShixiChengjiUuidNumber() {
        return shixiChengjiUuidNumber;
    }


    /**
	 * 获取：成绩编号
	 */

    public void setShixiChengjiUuidNumber(String shixiChengjiUuidNumber) {
        this.shixiChengjiUuidNumber = shixiChengjiUuidNumber;
    }
    /**
	 * 设置：成绩结果
	 */
    public Integer getShixiChengjiTypes() {
        return shixiChengjiTypes;
    }


    /**
	 * 获取：成绩结果
	 */

    public void setShixiChengjiTypes(Integer shixiChengjiTypes) {
        this.shixiChengjiTypes = shixiChengjiTypes;
    }
    /**
	 * 设置：成绩分数
	 */
    public Double getFenshu() {
        return fenshu;
    }


    /**
	 * 获取：成绩分数
	 */

    public void setFenshu(Double fenshu) {
        this.fenshu = fenshu;
    }
    /**
	 * 设置：实习评语
	 */
    public String getShixiChengjiYesnoText() {
        return shixiChengjiYesnoText;
    }


    /**
	 * 获取：实习评语
	 */

    public void setShixiChengjiYesnoText(String shixiChengjiYesnoText) {
        this.shixiChengjiYesnoText = shixiChengjiYesnoText;
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

}
