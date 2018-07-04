package com.dzqc.campus.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 后勤父类项目分类
 * @author Administrator
 *
 */
@Entity
@Table(name = "HQ_FXM")
public class HqFxm implements Serializable{

	@Id
	@Column(name = "HQ_FXM_ID",length = 32, nullable = true)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	private String id;

	@Column(name = "HQ_FXM_MC")
	private String mc;// 部门名称

	@Column(name="HQ_FXM_CT")
	private Date ct;//创建时间
	
	@Column(name="HQ_FXM_CJR")
	private String cjr;//创建人
	
	@Column(name="HQ_FXM_UT")
	private Date ut;//更新时间
	
	@Column(name="HQ_FXM_XGR")
	private String xgr;//修改人

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public Date getCt() {
		return ct;
	}

	public void setCt(Date ct) {
		this.ct = ct;
	}

	public String getCjr() {
		return cjr;
	}

	public void setCjr(String cjr) {
		this.cjr = cjr;
	}

	public Date getUt() {
		return ut;
	}

	public void setUt(Date ut) {
		this.ut = ut;
	}

	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	@Override
	public String toString() {
		return "HqFXM [id=" + id + ", mc=" + mc + ", ct=" + ct + ", cjr=" + cjr + ", ut=" + ut + ", xgr=" + xgr + "]";
	}
}
