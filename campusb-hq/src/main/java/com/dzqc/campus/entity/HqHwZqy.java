package com.dzqc.campus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*
 * 环卫区域表实体类
 */

@Entity
@Table(name = "HQ_HW_ZQY")
public class HqHwZqy {
	@Id
	@Column(name = "HQ_HW_ID", length = 32, nullable = true)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")

	private String HQ_HW_ID; // ID

	@Column(name = "HQ_HW_NUM") // 编码
	private Integer HQ_HW_NUM;

	@Column(name = "HQ_HW_FQY_ID") // 父区域ID
	private String HQ_HW_FQY_ID;

	@Column(name = "HQ_HW_ZQY_ID") // 子区域ID
	private String HQ_HW_ZQY_ID;

	@Column(name = "HQ_HW_MM") // 面积
	private Double HQ_HW_MM;

	@Column(name = "HQ_HW_JCGZ") // 基础工资
	private Double HQ_HW_JCGZ;

	@Column(name = "HQ_HW_WYFL") // 物业费率
	private Double HQ_HW_WYFL;

	@Column(name = "HQ_HW_GLFL") // 管理费率
	private Double HQ_HW_GLFL;

	@Column(name = "HQ_HW_GZYS") // 工资预算
	private Double HQ_HW_GZYS;

	@Column(name = "HQ_HW_TYPE_ID") // 类型ID
	private String HQ_HW_TYPE_ID;

	@Column(name = "HQ_HW_BJBZ_ID") // 保洁标准ID
	private String HQ_HW_BJBZ_ID;

	@Column(name = "HQ_HW_IMG") // 图片
	private String HQ_HW_IMG;

	@Column(name = "STATUS") // 状态/0默认/1代表删除
	private Integer STATUS;

	

	public String getHQ_HW_ID() {
		return HQ_HW_ID;
	}



	public void setHQ_HW_ID(String hQ_HW_ID) {
		HQ_HW_ID = hQ_HW_ID;
	}



	public Integer getHQ_HW_NUM() {
		return HQ_HW_NUM;
	}



	public void setHQ_HW_NUM(Integer hQ_HW_NUM) {
		HQ_HW_NUM = hQ_HW_NUM;
	}



	public String getHQ_HW_FQY_ID() {
		return HQ_HW_FQY_ID;
	}



	public void setHQ_HW_FQY_ID(String hQ_HW_FQY_ID) {
		HQ_HW_FQY_ID = hQ_HW_FQY_ID;
	}



	public String getHQ_HW_ZQY_ID() {
		return HQ_HW_ZQY_ID;
	}



	public void setHQ_HW_ZQY_ID(String hQ_HW_ZQY_ID) {
		HQ_HW_ZQY_ID = hQ_HW_ZQY_ID;
	}



	public Double getHQ_HW_MM() {
		return HQ_HW_MM;
	}



	public void setHQ_HW_MM(Double hQ_HW_MM) {
		HQ_HW_MM = hQ_HW_MM;
	}



	public Double getHQ_HW_JCGZ() {
		return HQ_HW_JCGZ;
	}



	public void setHQ_HW_JCGZ(Double hQ_HW_JCGZ) {
		HQ_HW_JCGZ = hQ_HW_JCGZ;
	}



	public Double getHQ_HW_WYFL() {
		return HQ_HW_WYFL;
	}



	public void setHQ_HW_WYFL(Double hQ_HW_WYFL) {
		HQ_HW_WYFL = hQ_HW_WYFL;
	}



	public Double getHQ_HW_GLFL() {
		return HQ_HW_GLFL;
	}



	public void setHQ_HW_GLFL(Double hQ_HW_GLFL) {
		HQ_HW_GLFL = hQ_HW_GLFL;
	}



	public Double getHQ_HW_GZYS() {
		return HQ_HW_GZYS;
	}



	public void setHQ_HW_GZYS(Double hQ_HW_GZYS) {
		HQ_HW_GZYS = hQ_HW_GZYS;
	}



	public String getHQ_HW_TYPE_ID() {
		return HQ_HW_TYPE_ID;
	}



	public void setHQ_HW_TYPE_ID(String hQ_HW_TYPE_ID) {
		HQ_HW_TYPE_ID = hQ_HW_TYPE_ID;
	}



	public String getHQ_HW_BJBZ_ID() {
		return HQ_HW_BJBZ_ID;
	}



	public void setHQ_HW_BJBZ_ID(String hQ_HW_BJBZ_ID) {
		HQ_HW_BJBZ_ID = hQ_HW_BJBZ_ID;
	}



	public String getHQ_HW_IMG() {
		return HQ_HW_IMG;
	}



	public void setHQ_HW_IMG(String hQ_HW_IMG) {
		HQ_HW_IMG = hQ_HW_IMG;
	}



	public Integer getSTATUS() {
		return STATUS;
	}



	public void setSTATUS(Integer sTATUS) {
		STATUS = sTATUS;
	}



	@Override
	public String toString() {
		return "HqHwZqy [HQ_HW_ID=" + HQ_HW_ID + ", HQ_HW_NUM=" + HQ_HW_NUM + ", HQ_HW_FQY_ID=" + HQ_HW_FQY_ID
				+ ", HQ_HW_ZQY_ID=" + HQ_HW_ZQY_ID + ", HQ_HW_MM=" + HQ_HW_MM + ", HQ_HW_JCGZ=" + HQ_HW_JCGZ
				+ ", HQ_HW_WYFL=" + HQ_HW_WYFL + ", HQ_HW_GLFL=" + HQ_HW_GLFL + ", HQ_HW_GZYS=" + HQ_HW_GZYS
				+ ", HQ_HW_TYPE_ID=" + HQ_HW_TYPE_ID + ", HQ_HW_BJBZ_ID=" + HQ_HW_BJBZ_ID + ", HQ_HW_IMG=" + HQ_HW_IMG
				+ ", STATUS=" + STATUS + "]";
	}

	
	
}
