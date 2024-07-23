package com.entity.model;

import com.entity.ShixiZhoubaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 实习周报
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShixiZhoubaoModel implements Serializable {
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
     * 实习
     */
    private Integer shixiId;


    /**
     * 实习周报编号
     */
    private String shixiZhoubaoUuidNumber;


    /**
     * 周报标题
     */
    private String shixiZhoubaoName;


    /**
     * 第几周
     */
    private Integer shixiZhoubaoTypes;


    /**
     * 实习周报详情
     */
    private String shixiZhoubaoContent;


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
	 * 获取：实习周报编号
	 */
    public String getShixiZhoubaoUuidNumber() {
        return shixiZhoubaoUuidNumber;
    }


    /**
	 * 设置：实习周报编号
	 */
    public void setShixiZhoubaoUuidNumber(String shixiZhoubaoUuidNumber) {
        this.shixiZhoubaoUuidNumber = shixiZhoubaoUuidNumber;
    }
    /**
	 * 获取：周报标题
	 */
    public String getShixiZhoubaoName() {
        return shixiZhoubaoName;
    }


    /**
	 * 设置：周报标题
	 */
    public void setShixiZhoubaoName(String shixiZhoubaoName) {
        this.shixiZhoubaoName = shixiZhoubaoName;
    }
    /**
	 * 获取：第几周
	 */
    public Integer getShixiZhoubaoTypes() {
        return shixiZhoubaoTypes;
    }


    /**
	 * 设置：第几周
	 */
    public void setShixiZhoubaoTypes(Integer shixiZhoubaoTypes) {
        this.shixiZhoubaoTypes = shixiZhoubaoTypes;
    }
    /**
	 * 获取：实习周报详情
	 */
    public String getShixiZhoubaoContent() {
        return shixiZhoubaoContent;
    }


    /**
	 * 设置：实习周报详情
	 */
    public void setShixiZhoubaoContent(String shixiZhoubaoContent) {
        this.shixiZhoubaoContent = shixiZhoubaoContent;
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
