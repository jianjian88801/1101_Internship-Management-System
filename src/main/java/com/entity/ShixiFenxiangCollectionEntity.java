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
 * 实习分享收藏
 *
 * @author 
 * @email
 */
@TableName("shixi_fenxiang_collection")
public class ShixiFenxiangCollectionEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShixiFenxiangCollectionEntity() {

	}

	public ShixiFenxiangCollectionEntity(T t) {
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
     * 实习分享
     */
    @TableField(value = "shixi_fenxiang_id")

    private Integer shixiFenxiangId;


    /**
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 类型
     */
    @TableField(value = "shixi_fenxiang_collection_types")

    private Integer shixiFenxiangCollectionTypes;


    /**
     * 收藏时间
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
	 * 设置：实习分享
	 */
    public Integer getShixiFenxiangId() {
        return shixiFenxiangId;
    }
    /**
	 * 获取：实习分享
	 */

    public void setShixiFenxiangId(Integer shixiFenxiangId) {
        this.shixiFenxiangId = shixiFenxiangId;
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
	 * 设置：类型
	 */
    public Integer getShixiFenxiangCollectionTypes() {
        return shixiFenxiangCollectionTypes;
    }
    /**
	 * 获取：类型
	 */

    public void setShixiFenxiangCollectionTypes(Integer shixiFenxiangCollectionTypes) {
        this.shixiFenxiangCollectionTypes = shixiFenxiangCollectionTypes;
    }
    /**
	 * 设置：收藏时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：收藏时间
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
        return "ShixiFenxiangCollection{" +
            "id=" + id +
            ", shixiFenxiangId=" + shixiFenxiangId +
            ", xueshengId=" + xueshengId +
            ", shixiFenxiangCollectionTypes=" + shixiFenxiangCollectionTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
