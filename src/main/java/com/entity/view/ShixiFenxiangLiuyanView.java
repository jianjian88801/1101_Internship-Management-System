package com.entity.view;

import com.entity.ShixiFenxiangLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 实习分享留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shixi_fenxiang_liuyan")
public class ShixiFenxiangLiuyanView extends ShixiFenxiangLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 shixi_fenxiang
			/**
			* 实习分享 的 学生
			*/
			private Integer shixiFenxiangXueshengId;
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
				* 分享类型的值
				*/
				private String shixiFenxiangValue;
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

		//级联表 xuesheng
			/**
			* 学号
			*/
			private String xueshengUuidNumber;
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 院系
			*/
			private Integer yuanxiTypes;
				/**
				* 院系的值
				*/
				private String yuanxiValue;
			/**
			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;

	public ShixiFenxiangLiuyanView() {

	}

	public ShixiFenxiangLiuyanView(ShixiFenxiangLiuyanEntity shixiFenxiangLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, shixiFenxiangLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

























				//级联表的get和set shixi_fenxiang

					/**
					* 获取：实习分享 的 学生
					*/
					public Integer getShixiFenxiangXueshengId() {
						return shixiFenxiangXueshengId;
					}
					/**
					* 设置：实习分享 的 学生
					*/
					public void setShixiFenxiangXueshengId(Integer shixiFenxiangXueshengId) {
						this.shixiFenxiangXueshengId = shixiFenxiangXueshengId;
					}


					/**
					* 获取： 分享标题
					*/
					public String getShixiFenxiangName() {
						return shixiFenxiangName;
					}
					/**
					* 设置： 分享标题
					*/
					public void setShixiFenxiangName(String shixiFenxiangName) {
						this.shixiFenxiangName = shixiFenxiangName;
					}

					/**
					* 获取： 分享照片
					*/
					public String getShixiFenxiangPhoto() {
						return shixiFenxiangPhoto;
					}
					/**
					* 设置： 分享照片
					*/
					public void setShixiFenxiangPhoto(String shixiFenxiangPhoto) {
						this.shixiFenxiangPhoto = shixiFenxiangPhoto;
					}

					/**
					* 获取： 分享类型
					*/
					public Integer getShixiFenxiangTypes() {
						return shixiFenxiangTypes;
					}
					/**
					* 设置： 分享类型
					*/
					public void setShixiFenxiangTypes(Integer shixiFenxiangTypes) {
						this.shixiFenxiangTypes = shixiFenxiangTypes;
					}


						/**
						* 获取： 分享类型的值
						*/
						public String getShixiFenxiangValue() {
							return shixiFenxiangValue;
						}
						/**
						* 设置： 分享类型的值
						*/
						public void setShixiFenxiangValue(String shixiFenxiangValue) {
							this.shixiFenxiangValue = shixiFenxiangValue;
						}

					/**
					* 获取： 热度
					*/
					public Integer getShixiFenxiangClicknum() {
						return shixiFenxiangClicknum;
					}
					/**
					* 设置： 热度
					*/
					public void setShixiFenxiangClicknum(Integer shixiFenxiangClicknum) {
						this.shixiFenxiangClicknum = shixiFenxiangClicknum;
					}

					/**
					* 获取： 分享内容
					*/
					public String getShixiFenxiangContent() {
						return shixiFenxiangContent;
					}
					/**
					* 设置： 分享内容
					*/
					public void setShixiFenxiangContent(String shixiFenxiangContent) {
						this.shixiFenxiangContent = shixiFenxiangContent;
					}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getShixiFenxiangDelete() {
						return shixiFenxiangDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShixiFenxiangDelete(Integer shixiFenxiangDelete) {
						this.shixiFenxiangDelete = shixiFenxiangDelete;
					}













				//级联表的get和set xuesheng

					/**
					* 获取： 学号
					*/
					public String getXueshengUuidNumber() {
						return xueshengUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setXueshengUuidNumber(String xueshengUuidNumber) {
						this.xueshengUuidNumber = xueshengUuidNumber;
					}

					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}

					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}

					/**
					* 获取： 院系
					*/
					public Integer getYuanxiTypes() {
						return yuanxiTypes;
					}
					/**
					* 设置： 院系
					*/
					public void setYuanxiTypes(Integer yuanxiTypes) {
						this.yuanxiTypes = yuanxiTypes;
					}


						/**
						* 获取： 院系的值
						*/
						public String getYuanxiValue() {
							return yuanxiValue;
						}
						/**
						* 设置： 院系的值
						*/
						public void setYuanxiValue(String yuanxiValue) {
							this.yuanxiValue = yuanxiValue;
						}

					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
					}


						/**
						* 获取： 班级的值
						*/
						public String getBanjiValue() {
							return banjiValue;
						}
						/**
						* 设置： 班级的值
						*/
						public void setBanjiValue(String banjiValue) {
							this.banjiValue = banjiValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}



}
