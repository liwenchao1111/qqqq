package com.dzqc.campus.entity;








import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="HQ_HW_KP")
public class HqHwKp {
	@Id
	@Column(name = "HQ_HW_KP_ID",length = 32, nullable = false)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	private String HQ_HW_KP_ID;//后勤环卫考评ID
	@Column(name="HQ_HW_ZQYGL_ID")
	private String HQ_HW_ZQYGL_ID;//后勤环卫子区域ID
	@Column(name="HQ_HW_FZR_ID")
	private String HQ_HW_FZR_ID;//负责人 ID
	@Column(name="HQ_HW_KPLX")
	private Integer HQ_HW_KPLX;//考评类型 0.赞赏,1.投诉
	@Column(name="HQ_HW_KPR_ID")
	private String HQ_HW_KPR_ID;//考评人ID
	@Column(name="HQ_HW_KPDJ_ID")
	private String HQ_HW_KPDJ_ID;//考评等级id
	@Column(name="HQ_HW_KPNR")
	private String HQ_HW_KPNR;//考评内容
	@Column(name="HQ_HW_KPSJ")
	private Date HQ_HW_KPSJ;//考评时间
	@Column(name="HQ_HW_FB_ZT")
	private Integer HQ_HW_FB_ZT;//发布状态 0.发布,1.未发布
	@Column(name="HQ_HW_KY_ZT")
	private Integer HQ_HW_KY_ZT;//可用状态 0.可用, 1.删除
	@Column(name="HQ_HW_FQYGL_ID")
	private String HQ_HW_FQYGL_ID;//父区域ID
	public String getHQ_HW_KP_ID() {
		return HQ_HW_KP_ID;
	}
	public void setHQ_HW_KP_ID(String hQ_HW_KP_ID) {
		HQ_HW_KP_ID = hQ_HW_KP_ID;
	}
	public String getHQ_HW_ZQYGL_ID() {
		return HQ_HW_ZQYGL_ID;
	}
	public void setHQ_HW_ZQYGL_ID(String hQ_HW_ZQYGL_ID) {
		HQ_HW_ZQYGL_ID = hQ_HW_ZQYGL_ID;
	}
	public String getHQ_HW_FZR_ID() {
		return HQ_HW_FZR_ID;
	}
	public void setHQ_HW_FZR_ID(String hQ_HW_FZR_ID) {
		HQ_HW_FZR_ID = hQ_HW_FZR_ID;
	}
	public Integer getHQ_HW_KPLX() {
		return HQ_HW_KPLX;
	}
	public void setHQ_HW_KPLX(Integer hQ_HW_KPLX) {
		HQ_HW_KPLX = hQ_HW_KPLX;
	}
	public String getHQ_HW_KPR_ID() {
		return HQ_HW_KPR_ID;
	}
	public void setHQ_HW_KPR_ID(String hQ_HW_KPR_ID) {
		HQ_HW_KPR_ID = hQ_HW_KPR_ID;
	}
	public String getHQ_HW_KPDJ_ID() {
		return HQ_HW_KPDJ_ID;
	}
	public void setHQ_HW_KPDJ_ID(String hQ_HW_KPDJ_ID) {
		HQ_HW_KPDJ_ID = hQ_HW_KPDJ_ID;
	}
	public String getHQ_HW_KPNR() {
		return HQ_HW_KPNR;
	}
	public void setHQ_HW_KPNR(String hQ_HW_KPNR) {
		HQ_HW_KPNR = hQ_HW_KPNR;
	}
	public Integer getHQ_HW_FB_ZT() {
		return HQ_HW_FB_ZT;
	}
	public void setHQ_HW_FB_ZT(Integer hQ_HW_FB_ZT) {
		HQ_HW_FB_ZT = hQ_HW_FB_ZT;
	}
	public Integer getHQ_HW_KY_ZT() {
		return HQ_HW_KY_ZT;
	}
	public void setHQ_HW_KY_ZT(Integer hQ_HW_KY_ZT) {
		HQ_HW_KY_ZT = hQ_HW_KY_ZT;
	}
	public String getHQ_HW_FQYGL_ID() {
		return HQ_HW_FQYGL_ID;
	}
	public void setHQ_HW_FQYGL_ID(String hQ_HW_FQYGL_ID) {
		HQ_HW_FQYGL_ID = hQ_HW_FQYGL_ID;
	}
	public Date getHQ_HW_KPSJ() {
		return HQ_HW_KPSJ;
	}
	public void setHQ_HW_KPSJ(Date hQ_HW_KPSJ) {
		HQ_HW_KPSJ = hQ_HW_KPSJ;
	}
	@Override
	public String toString() {
		return "HqHwKp [HQ_HW_KP_ID=" + HQ_HW_KP_ID + ", HQ_HW_ZQYGL_ID=" + HQ_HW_ZQYGL_ID + ", HQ_HW_FZR_ID="
				+ HQ_HW_FZR_ID + ", HQ_HW_KPLX=" + HQ_HW_KPLX + ", HQ_HW_KPR_ID=" + HQ_HW_KPR_ID + ", HQ_HW_KPDJ_ID="
				+ HQ_HW_KPDJ_ID + ", HQ_HW_KPNR=" + HQ_HW_KPNR + ", HQ_HW_KPSJ=" + HQ_HW_KPSJ + ", HQ_HW_FB_ZT="
				+ HQ_HW_FB_ZT + ", HQ_HW_KY_ZT=" + HQ_HW_KY_ZT + ", HQ_HW_FQYGL_ID=" + HQ_HW_FQYGL_ID + "]";
	}
	
	
	
	
}