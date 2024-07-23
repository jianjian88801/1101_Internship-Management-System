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
 * 实习分享
 *
 * @author 
 * @email
 */
@TableName("shixi_fenxiang")
public class ShixiFenxiangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShixiFenxiangEntity() {

	}

	public ShixiFenxiangEntity(T t) {
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
     * 分享标题
     */
    @TableField(value = "shixi_fenxiang_name")

    private String shixiFenxiangName;


    /**
     * 分享照片
     */
    @TableField(value = "shixi_fenxiang_photo")

    private String shixiFenxiangPhoto;


    /**
     * 分享类型
     */
    @TableField(value = "shixi_fenxiang_types")

    private Integer shixiFenxiangTypes;


    /**
     * 热度
     */
    @TableField(value = "shixi_fenxiang_clicknum")

    private Integer shixiFenxiangClicknum;


    /**
     * 分享内容
     */
    @TableField(value = "shixi_fenxiang_content")

    private String shixiFenxiangContent;


    /**
     * 逻辑删除
     */
    @TableField(value = "shixi_fenxiang_delete")

    private Integer shixiFenxiangDelete;


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
	 * 设置：分享标题
	 */
    public String getShixiFenxiangName() {
        return shixiFenxiangName;
    }
    /**
	 * 获取：分享标题
	 */

    public void setShixiFenxiangName(String shixiFenxiangName) {
        this.shixiFenxiangName = shixiFenxiangName;
    }
    /**
	 * 设置：分享照片
	 */
    public String getShixiFenxiangPhoto() {
        return shixiFenxiangPhoto;
    }
    /**
	 * 获取：分享照片
	 */

    public void setShixiFenxiangPhoto(String shixiFenxiangPhoto) {
        this.shixiFenxiangPhoto = shixiFenxiangPhoto;
    }
    /**
	 * 设置：分享类型
	 */
    public Integer getShixiFenxiangTypes() {
        return shixiFenxiangTypes;
    }
    /**
	 * 获取：分享类型
	 */

    public void setShixiFenxiangTypes(Integer shixiFenxiangTypes) {
        this.shixiFenxiangTypes = shixiFenxiangTypes;
    }
    /**
	 * 设置：热度
	 */
    public Integer getShixiFenxiangClicknum() {
        return shixiFenxiangClicknum;
    }
    /**
	 * 获取：热度
	 */

    public void setShixiFenxiangClicknum(Integer shixiFenxiangClicknum) {
        this.shixiFenxiangClicknum = shixiFenxiangClicknum;
    }
    /**
	 * 设置：分享内容
	 */
    public String getShixiFenxiangContent() {
        return shixiFenxiangContent;
    }
    /**
	 * 获取：分享内容
	 */

    public void setShixiFenxiangContent(String shixiFenxiangContent) {
        this.shixiFenxiangContent = shixiFenxiangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShixiFenxiangDelete() {
        return shixiFenxiangDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setShixiFenxiangDelete(Integer shixiFenxiangDelete) {
        this.shixiFenxiangDelete = shixiFenxiangDelete;
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
        return "ShixiFenxiang{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", shixiFenxiangName=" + shixiFenxiangName +
            ", shixiFenxiangPhoto=" + shixiFenxiangPhoto +
            ", shixiFenxiangTypes=" + shixiFenxiangTypes +
            ", shixiFenxiangClicknum=" + shixiFenxiangClicknum +
            ", shixiFenxiangContent=" + shixiFenxiangContent +
            ", shixiFenxiangDelete=" + shixiFenxiangDelete +
            ", createTime=" + createTime +
        "}";
    }
}
