package com.dzqc.campus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HQ_HW_HWFL")
public class HqHwHwfl {
	@Id
	@Column(name = "HQ_HW_ID",length = 32, nullable = true)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	private String HQ_HW_ID;//环卫工设定id
	
	
	@Column(name = "HQ_HW_FLNAME")
	private String HQ_HW_FLNAME;//环卫工分类名称
	
	@Column(name = "DELETE_FLAG")
	private String DELETE_FLAG;//环卫工分类状态  0表示存在  1表示不存在

	public String getHQ_HW_ID() {
		return HQ_HW_ID;
	}


	public void setHQ_HW_ID(String hQ_HW_ID) {
		HQ_HW_ID = hQ_HW_ID;
	}


	public String getHQ_HW_FLNAME() {
		return HQ_HW_FLNAME;
	}


	public void setHQ_HW_FLNAME(String hQ_HW_FLNAME) {
		HQ_HW_FLNAME = hQ_HW_FLNAME;
	}
	

	public String getDELETE_FLAG() {
		return DELETE_FLAG;
	}


	public void setDELETE_FLAG(String dELETE_FLAG) {
		DELETE_FLAG = dELETE_FLAG;
	}


	@Override
	public String toString() {
		return "HqHwHwfl [HQ_HW_ID=" + HQ_HW_ID + ", HQ_HW_FLNAME=" + HQ_HW_FLNAME + ", DELETE_FLAG=" + DELETE_FLAG
				+ ", getHQ_HW_ID()=" + getHQ_HW_ID() + ", getHQ_HW_FLNAME()=" + getHQ_HW_FLNAME()
				+ ", getDELETE_FLAG()=" + getDELETE_FLAG() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
