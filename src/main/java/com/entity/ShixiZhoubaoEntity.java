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
 * 实习周报
 *
 * @author 
 * @email
 */
@TableName("shixi_zhoubao")
public class ShixiZhoubaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShixiZhoubaoEntity() {

	}

	public ShixiZhoubaoEntity(T t) {
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
     * 实习
     */
    @TableField(value = "shixi_id")

    private Integer shixiId;


    /**
     * 实习周报编号
     */
    @TableField(value = "shixi_zhoubao_uuid_number")

    private String shixiZhoubaoUuidNumber;


    /**
     * 周报标题
     */
    @TableField(value = "shixi_zhoubao_name")

    private String shixiZhoubaoName;


    /**
     * 第几周
     */
    @TableField(value = "shixi_zhoubao_types")

    private Integer shixiZhoubaoTypes;


    /**
     * 实习周报详情
     */
    @TableField(value = "shixi_zhoubao_content")

    private String shixiZhoubaoContent;


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
	 * 设置：实习周报编号
	 */
    public String getShixiZhoubaoUuidNumber() {
        return shixiZhoubaoUuidNumber;
    }
    /**
	 * 获取：实习周报编号
	 */

    public void setShixiZhoubaoUuidNumber(String shixiZhoubaoUuidNumber) {
        this.shixiZhoubaoUuidNumber = shixiZhoubaoUuidNumber;
    }
    /**
	 * 设置：周报标题
	 */
    public String getShixiZhoubaoName() {
        return shixiZhoubaoName;
    }
    /**
	 * 获取：周报标题
	 */

    public void setShixiZhoubaoName(String shixiZhoubaoName) {
        this.shixiZhoubaoName = shixiZhoubaoName;
    }
    /**
	 * 设置：第几周
	 */
    public Integer getShixiZhoubaoTypes() {
        return shixiZhoubaoTypes;
    }
    /**
	 * 获取：第几周
	 */

    public void setShixiZhoubaoTypes(Integer shixiZhoubaoTypes) {
        this.shixiZhoubaoTypes = shixiZhoubaoTypes;
    }
    /**
	 * 设置：实习周报详情
	 */
    public String getShixiZhoubaoContent() {
        return shixiZhoubaoContent;
    }
    /**
	 * 获取：实习周报详情
	 */

    public void setShixiZhoubaoContent(String shixiZhoubaoContent) {
        this.shixiZhoubaoContent = shixiZhoubaoContent;
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
        return "ShixiZhoubao{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", shixiId=" + shixiId +
            ", shixiZhoubaoUuidNumber=" + shixiZhoubaoUuidNumber +
            ", shixiZhoubaoName=" + shixiZhoubaoName +
            ", shixiZhoubaoTypes=" + shixiZhoubaoTypes +
            ", shixiZhoubaoContent=" + shixiZhoubaoContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
