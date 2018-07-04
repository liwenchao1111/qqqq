package com.dzqc.campus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 
 * 后勤环卫负责人
 *@Project:campusb-hq
 *@Package:com.dzqc.campus.entity
 *@ClassName: HqHwFzr.java
 *@Author:煕寳
 *@Email:rjx97820@163.com
 *@date:2018年6月21日上午10:44:41 
 *
 */
@Entity
@Table(name="HQ_HW_FZR")
public class HqHwFzr {

	@Id
	@Column(name="HQ_HW_ID",length = 32,nullable =true)
	@GenericGenerator(name="sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	private Integer HQ_HW_ID;//id
	
	@Column(name="HQ_HW_FZR_ID")
	private String HQ_HW_FZR_ID;//负责人id
	
	@Column(name="HQ_HW_ZQYGL_ID")
	private String HQ_HW_ZQYGL_ID;//子区域id
	
	@Column(name="HQ_HW_BJLX_ID")
	private String HQ_HW_BJLX_ID;//保洁类型id
	
	@Column(name="HQ_HW_BJBZ_ID")
	private String HQ_HW_BJBZ_ID;//保洁标准id

	@Column(name="HQ_HW_BJBZ_MJ")
	private String HQ_HW_BJBZ_MJ;//保洁标准面积
	
	@Column(name="STATUS")
	private String STATUS;//状态码 0表示可用，1表示删
	
	@Column(name="HQ_HW_FQYGL_ID")
	private String HQ_HW_FQYGL_ID;//父区域id

	public String getHQ_HW_FQYGL_ID() {
		return HQ_HW_FQYGL_ID;
	}

	public void setHQ_HW_FQYGL_ID(String HQ_HW_FQYGL_ID) {
		HQ_HW_FQYGL_ID = HQ_HW_FQYGL_ID;
	}

	public Integer getHQ_HW_ID() {
		return HQ_HW_ID;
	}

	public void setHQ_HW_ID(Integer hQ_HW_ID) {
		HQ_HW_ID = hQ_HW_ID;
	}

	public String getHQ_HW_FZR_ID() {
		return HQ_HW_FZR_ID;
	}

	public void setHQ_HW_FZR_ID(String hQ_HW_FZR_ID) {
		HQ_HW_FZR_ID = hQ_HW_FZR_ID;
	}

	public String getHQ_HW_ZQYGL_ID() {
		return HQ_HW_ZQYGL_ID;
	}

	public void setHQ_HW_ZQYGL_ID(String HQ_HW_ZQYGL_ID) {
		HQ_HW_ZQYGL_ID = HQ_HW_ZQYGL_ID;
	}

	public String getHQ_HW_BJLX_ID() {
		return HQ_HW_BJLX_ID;
	}

	public void setHQ_HW_BJLX_ID(String hQ_HW_BJLX_ID) {
		HQ_HW_BJLX_ID = hQ_HW_BJLX_ID;
	}

	public String getHQ_HW_BJBZ_ID() {
		return HQ_HW_BJBZ_ID;
	}

	public void setHQ_HW_BJBZ_ID(String hQ_HW_BJBZ_ID) {
		HQ_HW_BJBZ_ID = hQ_HW_BJBZ_ID;
	}

	public String getHQ_HW_BJBZ_MJ() {
		return HQ_HW_BJBZ_MJ;
	}

	public void setHQ_HW_BJBZ_MJ(String hQ_HW_BJBZ_MJ) {
		HQ_HW_BJBZ_MJ = hQ_HW_BJBZ_MJ;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	@Override
	public String toString() {
		return "HqHwFzr [HQ_HW_ID=" + HQ_HW_ID + ", HQ_HW_FZR_ID=" + HQ_HW_FZR_ID + ", HQ_HW_ZQYGL_ID=" + HQ_HW_ZQYGL_ID
				+ ", HQ_HW_BJLX_ID=" + HQ_HW_BJLX_ID + ", HQ_HW_BJBZ_ID=" + HQ_HW_BJBZ_ID + ", HQ_HW_BJBZ_MJ="
				+ HQ_HW_BJBZ_MJ + ", STATUS=" + STATUS + ", HQ_HW_FQYGL_ID=" + HQ_HW_FQYGL_ID + "]";
	}

	

	
}
