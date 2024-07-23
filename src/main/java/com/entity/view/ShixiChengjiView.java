package com.entity.view;

import com.entity.ShixiChengjiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 实习成绩
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shixi_chengji")
public class ShixiChengjiView extends ShixiChengjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 成绩结果的值
		*/
		private String shixiChengjiValue;



		//级联表 shixi
			/**
			* 实习 的 学生
			*/
			private Integer shixiXueshengId;
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
				* 单位性质的值
				*/
				private String shixiValue;
			/**
			* 实习岗位
			*/
			private String shixiGangwei;
			/**
			* 实习开始时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
			@DateTimeFormat
			private Date kaishiTime;
			/**
			* 实习结束时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
				* 审核状态的值
				*/
				private String shixiYesnoValue;
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

	public ShixiChengjiView() {

	}

	public ShixiChengjiView(ShixiChengjiEntity shixiChengjiEntity) {
		try {
			BeanUtils.copyProperties(this, shixiChengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 成绩结果的值
			*/
			public String getShixiChengjiValue() {
				return shixiChengjiValue;
			}
			/**
			* 设置： 成绩结果的值
			*/
			public void setShixiChengjiValue(String shixiChengjiValue) {
				this.shixiChengjiValue = shixiChengjiValue;
			}
















				//级联表的get和set shixi

					/**
					* 获取：实习 的 学生
					*/
					public Integer getShixiXueshengId() {
						return shixiXueshengId;
					}
					/**
					* 设置：实习 的 学生
					*/
					public void setShixiXueshengId(Integer shixiXueshengId) {
						this.shixiXueshengId = shixiXueshengId;
					}


					/**
					* 获取： 实习编号
					*/
					public String getShixiUuidNumber() {
						return shixiUuidNumber;
					}
					/**
					* 设置： 实习编号
					*/
					public void setShixiUuidNumber(String shixiUuidNumber) {
						this.shixiUuidNumber = shixiUuidNumber;
					}

					/**
					* 获取： 单位名称
					*/
					public String getShixiName() {
						return shixiName;
					}
					/**
					* 设置： 单位名称
					*/
					public void setShixiName(String shixiName) {
						this.shixiName = shixiName;
					}

					/**
					* 获取： 单位地址
					*/
					public String getShixiAddress() {
						return shixiAddress;
					}
					/**
					* 设置： 单位地址
					*/
					public void setShixiAddress(String shixiAddress) {
						this.shixiAddress = shixiAddress;
					}

					/**
					* 获取： 单位性质
					*/
					public Integer getShixiTypes() {
						return shixiTypes;
					}
					/**
					* 设置： 单位性质
					*/
					public void setShixiTypes(Integer shixiTypes) {
						this.shixiTypes = shixiTypes;
					}


						/**
						* 获取： 单位性质的值
						*/
						public String getShixiValue() {
							return shixiValue;
						}
						/**
						* 设置： 单位性质的值
						*/
						public void setShixiValue(String shixiValue) {
							this.shixiValue = shixiValue;
						}

					/**
					* 获取： 实习岗位
					*/
					public String getShixiGangwei() {
						return shixiGangwei;
					}
					/**
					* 设置： 实习岗位
					*/
					public void setShixiGangwei(String shixiGangwei) {
						this.shixiGangwei = shixiGangwei;
					}

					/**
					* 获取： 实习开始时间
					*/
					public Date getKaishiTime() {
						return kaishiTime;
					}
					/**
					* 设置： 实习开始时间
					*/
					public void setKaishiTime(Date kaishiTime) {
						this.kaishiTime = kaishiTime;
					}

					/**
					* 获取： 实习结束时间
					*/
					public Date getJieshuTime() {
						return jieshuTime;
					}
					/**
					* 设置： 实习结束时间
					*/
					public void setJieshuTime(Date jieshuTime) {
						this.jieshuTime = jieshuTime;
					}

					/**
					* 获取： 实习详情
					*/
					public String getShixiContent() {
						return shixiContent;
					}
					/**
					* 设置： 实习详情
					*/
					public void setShixiContent(String shixiContent) {
						this.shixiContent = shixiContent;
					}

					/**
					* 获取： 审核状态
					*/
					public Integer getShixiYesnoTypes() {
						return shixiYesnoTypes;
					}
					/**
					* 设置： 审核状态
					*/
					public void setShixiYesnoTypes(Integer shixiYesnoTypes) {
						this.shixiYesnoTypes = shixiYesnoTypes;
					}


						/**
						* 获取： 审核状态的值
						*/
						public String getShixiYesnoValue() {
							return shixiYesnoValue;
						}
						/**
						* 设置： 审核状态的值
						*/
						public void setShixiYesnoValue(String shixiYesnoValue) {
							this.shixiYesnoValue = shixiYesnoValue;
						}

					/**
					* 获取： 审核意见
					*/
					public String getShixiYesnoText() {
						return shixiYesnoText;
					}
					/**
					* 设置： 审核意见
					*/
					public void setShixiYesnoText(String shixiYesnoText) {
						this.shixiYesnoText = shixiYesnoText;
					}

					/**
					* 获取： 审核时间
					*/
					public Date getUnpdateTime() {
						return unpdateTime;
					}
					/**
					* 设置： 审核时间
					*/
					public void setUnpdateTime(Date unpdateTime) {
						this.unpdateTime = unpdateTime;
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
