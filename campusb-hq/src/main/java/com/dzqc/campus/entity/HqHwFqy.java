package com.dzqc.campus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HQ_HW_FQY")
public class HqHwFqy {
	@Id
	@Column(name = "HW_ID",length = 32, nullable = true)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	private String id;
	
	@Column(name = "HW_FQY_ID")
	private String fqyId;// 父区域id
	
	@Column(name = "HW_JCGZ")
	private Double hwJcgz;// 基础工资
	
	@Column(name = "HW_WYFL")
	private Double hwWyfl;// 物业费率
	
	@Column(name = "HW_GLFL")
	private Double hwGlfl;// 管理费率
	
	@Column(name = "HW_GZYS")
	private Double hwGzys;// 工资预算
	
	@Column(name = "STATUS")
	private Integer status;// 状态码 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFqyId() {
		return fqyId;
	}

	public void setFqyId(String fqyId) {
		this.fqyId = fqyId;
	}

	public Double getHwJcgz() {
		return hwJcgz;
	}

	public void setHwJcgz(Double hwJcgz) {
		this.hwJcgz = hwJcgz;
	}

	public Double getHwWyfl() {
		return hwWyfl;
	}

	public void setHwWyfl(Double hwWyfl) {
		this.hwWyfl = hwWyfl;
	}

	public Double getHwGlfl() {
		return hwGlfl;
	}

	public void setHwGlfl(Double hwGlfl) {
		this.hwGlfl = hwGlfl;
	}

	public Double getHwGzys() {
		return hwGzys;
	}

	public void setHwGzys(Double hwGzys) {
		this.hwGzys = hwGzys;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HqHwFqy [id=" + id + ", fqyId=" + fqyId + ", hwJcgz=" + hwJcgz + ", hwWyfl=" + hwWyfl + ", hwGlfl="
				+ hwGlfl + ", hwGzys=" + hwGzys + ", status=" + status + "]";
	}
	
	
	 
}
