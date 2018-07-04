package com.dzqc.campus.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "HQ_SXM")
public class HqSxm {
	@Id
	@Column(name = "HQ_SXM_ID",length = 32, nullable = true)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	private String HQ_SXM_ID;// 后勤子类项目id
	
	@Column(name = "HQ_SXM_FXM_ID")
	private String HQ_SXM_FXM_ID;// 后勤子类项目所属父类项目id
	
	@Column(name = "HQ_SXM_MC")
	private String HQ_SXM_MC;// 后勤子类项目名称
	
	@Column(name = "HQ_SXM_CT")
	private Date HQ_SXM_CT;// 后勤子类项目修改时间
	
	@Column(name = "HQ_SXM_CJR")
	private String HQ_SXM_CJR;// 后勤子类项目修改人
	
	@Column(name = "HQ_SXM_UT")
	private Date HQ_SXM_UT;// 后勤子类项目更新时间
	
	@Column(name = "HQ_SXM_XGR")
	private String HQ_SXM_XGR;// 后勤子类项目修改人

	public HqSxm() {
	}

	@Override
	public String toString() {
		return "HQ_SXM{" + "HQ_SXM_ID=" + HQ_SXM_ID + ", HQ_SXM_FXM_ID=" + HQ_SXM_FXM_ID + ", HQ_SXM_MC='" + HQ_SXM_MC
				+ '\'' + ", HQ_SXM_CT=" + HQ_SXM_CT + ", HQ_SXM_CJR='" + HQ_SXM_CJR + '\'' + ", HQ_SXM_UT=" + HQ_SXM_UT
				+ ", HQ_SXM_XGR='" + HQ_SXM_XGR + '\'' + '}';
	}

	public String getHQ_SXM_ID() {
		return HQ_SXM_ID;
	}

	public void setHQ_SXM_ID(String HQ_SXM_ID) {
		this.HQ_SXM_ID = HQ_SXM_ID;
	}

	public String getHQ_SXM_FXM_ID() {
		return HQ_SXM_FXM_ID;
	}

	public void setHQ_SXM_FXM_ID(String HQ_SXM_FXM_ID) {
		this.HQ_SXM_FXM_ID = HQ_SXM_FXM_ID;
	}

	public String getHQ_SXM_MC() {
		return HQ_SXM_MC;
	}

	public void setHQ_SXM_MC(String HQ_SXM_MC) {
		this.HQ_SXM_MC = HQ_SXM_MC;
	}

	public Date getHQ_SXM_CT() {
		return HQ_SXM_CT;
	}

	public void setHQ_SXM_CT(Date HQ_SXM_CT) {
		this.HQ_SXM_CT = HQ_SXM_CT;
	}

	public String getHQ_SXM_CJR() {
		return HQ_SXM_CJR;
	}

	public void setHQ_SXM_CJR(String HQ_SXM_CJR) {
		this.HQ_SXM_CJR = HQ_SXM_CJR;
	}

	public Date getHQ_SXM_UT() {
		return HQ_SXM_UT;
	}

	public void setHQ_SXM_UT(Date HQ_SXM_UT) {
		this.HQ_SXM_UT = HQ_SXM_UT;
	}

	public String getHQ_SXM_XGR() {
		return HQ_SXM_XGR;
	}

	public void setHQ_SXM_XGR(String HQ_SXM_XGR) {
		this.HQ_SXM_XGR = HQ_SXM_XGR;
	}
}
