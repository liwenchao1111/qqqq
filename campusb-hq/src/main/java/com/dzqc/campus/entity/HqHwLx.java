package com.dzqc.campus.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
/**
 * 环卫区域类型
 * @author Administrator
 *
 */
@Entity
@Table(name="HQ_HW_QYLX")
public class HqHwLx {
	
	 @Id
	 @Column(name = "HQ_HW_HWLX_ID", length = 32, nullable = true)
	 @GenericGenerator(name = "sys_uuid", strategy = "uuid")
	 @GeneratedValue(generator = "sys_uuid")
	 private String Id;//序号
	 
	 @Column(name="HQ_HW_HWLX_TYPE")
	 private String Type;//类型名称
	 
	 @Column(name="HQ_HW_HWLX_COMMENT")
	 private String Comment;//备注
	
	 @Column(name = "STATUS")
	 private Integer Status;// 状态

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "HqHwLx [Id=" + Id + ", Type=" + Type + ", Comment=" + Comment + ", Status=" + Status + "]";
	}

}
