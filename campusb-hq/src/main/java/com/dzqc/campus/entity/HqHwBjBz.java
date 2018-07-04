package com.dzqc.campus.entity;

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
@Table(name = "HQ_HW_BJBZ")
public class HqHwBjBz {

		@Id
		@Column(name = "HQ_HW_BJBZ_ID",length = 32, nullable = true)
		@GenericGenerator(name = "sys_uuid", strategy = "uuid")
		@GeneratedValue(generator = "sys_uuid")
		private  String bjBzId;// 保洁标准设定id

		@Column(name = "HQ_HW_BJBZ_NAME")
		private String bjBzName;// 保洁标准设定名称
		
		@Column(name = "HQ_HW_HWLX_ID")
		private String hwLxId;// 环卫区域类型id
		
		@Column(name = "HQ_HW_BJBZ_XQ")
		private String bjBzXq;// 保洁标准设定详细信息
		
		@Column(name="STATUS")
		private Integer status;//状态码       0表示可用  1表示删除


		public String getBjBzId() {
			return bjBzId;
		}

		public void setBjBzId(String bjBzId) {
			this.bjBzId = bjBzId;
		}
		
		public String getBjBzName() {
			return bjBzName;
		}

		public void setBjBzName(String bjBzName) {
			this.bjBzName = bjBzName;
		}

		public String getHwLxId() {
			return hwLxId;
		}

		public void setHwLxId(String hwLxId) {
			this.hwLxId = hwLxId;
		}

		public String getBjBzXq() {
			return bjBzXq;
		}

		public void setBjBzXq(String bjBzXq) {
			this.bjBzXq = bjBzXq;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "HqHwBjBz [bjBzId=" + bjBzId + ", bjBzName=" + bjBzName + ", hwLxId=" + hwLxId + ", bjBzXq=" + bjBzXq
					+ ", status=" + status + "]";
		}

		

		
}
