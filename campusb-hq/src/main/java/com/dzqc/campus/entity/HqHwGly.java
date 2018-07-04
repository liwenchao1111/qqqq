package com.dzqc.campus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*
 * 管理员实体
 */
@Entity
@Table(name="HQ_HW_GLY")
public class HqHwGly {
	@Id
	@Column(name="HQ_HW_GLY_ID",length=32,nullable=false)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	private String HQ_HW_GLY_ID;//管理员ID
	@Column(name="HQ_HW_GLY_FQY")
	private String HQ_HW_GLY_FQY;//父区域ID
	@Column(name="HQ_HW_GLY_FZR_ID")
	private String HQ_HW_GLY_FZR_ID;//负责人ID
	@Column(name="STATUS")
	private Integer status;//状态码，0表示可用，1表示删除

	public String getHQ_HW_GLY_ID() {
		return HQ_HW_GLY_ID;
	}

	public void setHQ_HW_GLY_ID(String hQ_HW_GLY_ID) {
		HQ_HW_GLY_ID = hQ_HW_GLY_ID;
	}

	public String getHQ_HW_GLY_FQY() {
		return HQ_HW_GLY_FQY;
	}

	public void setHQ_HW_GLY_FQY(String hQ_HW_GLY_FQY) {
		HQ_HW_GLY_FQY = hQ_HW_GLY_FQY;
	}

	public String getHQ_HW_GLY_FZR_ID() {
		return HQ_HW_GLY_FZR_ID;
	}

	public void setHQ_HW_GLY_FZR_ID(String hQ_HW_GLY_FZR_ID) {
		HQ_HW_GLY_FZR_ID = hQ_HW_GLY_FZR_ID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HqHwGly [HQ_HW_GLY_ID=" + HQ_HW_GLY_ID + ", HQ_HW_GLY_FQY=" + HQ_HW_GLY_FQY + ", HQ_HW_GLY_FZR_ID="
				+ HQ_HW_GLY_FZR_ID + ", status=" + status + "]";
	}
	
	
}
