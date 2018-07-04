package com.dzqc.campus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 后勤环卫评判等级分值
 * @author 10528
 *
 */
@Entity
@Table(name = "HQ_HW_PPDJ")
public class HqHwPpDj {
	@Id
	@Column(name = "HQ_HW_PPDJFZ_ID",length = 32, nullable = true)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	private String id;//ID
	
	 @Column(name = "HQ_HW_PPDJFZ_GRADE")
	 private String grade;//评判等级
	 
	 @Column(name = "HQ_HW_PPDJFZ_REMARK")
	 private String remark;//评判等级分值备注
	 
	 @Column(name = "HQ_HW_PPDJFZ_TYPE")
	 private Integer type;//考评类型   0表示赞赏   1表示投诉
	
	 @Column(name = "STATUS")
	 private Integer status;//考评类型   0表示可用   1表示删除
	 
	 
	 public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HqHwPpDj [id=" + id + ", grade=" + grade + ", remark=" + remark + ", type=" + type + ", status="
				+ status + "]";
	}

	

	
	 
	 
	
}
