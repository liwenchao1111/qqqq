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
	 * 父区域管理
	 * @author Administrator
	 *
	 */
	@Entity
	@Table(name = "HQ_HW_FQYGL")
	public class HqHwFqygl implements Serializable{

		@Id
		@Column(name = "HQ_HW_FQYID",length = 32, nullable = true)
		@GenericGenerator(name = "sys_uuid", strategy = "uuid")
		@GeneratedValue(generator = "sys_uuid")
		private String id;

		@Column(name = "HQ_HW_FQYNAME")
		private String fname;// 父区域名称

		@Column(name="STATUS")
		private Integer status;//删除时改变的状态码  0 为默认（未删除）  1为删除 

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "HqHwFqygl [id=" + id + ", fname=" + fname  + ", status=" + status + "]";
		}
		
}
