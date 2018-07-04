package com.dzqc.campus.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

	@Entity
	@Table(name = "HQ_HW_ZSYTS")
	public class HqHwZsyts{

		@Id
		@Column(name = "HQ_HW_ZSYTS_ID",length = 32, nullable = true)
		@GenericGenerator(name = "sys_uuid", strategy = "uuid")
		@GeneratedValue(generator = "sys_uuid")
		private String id;

		@Column(name = "HQ_HW_ZSYTS_FqyID")
		private String fqyid;//校区名称（父区域ID）

		@Column(name="HQ_HW_ZSYTS_ZqyID")
		private String zqyid;//区域名称（子区域ID）
		
		@Column(name="HQ_HW_ZSYTS_FzrID")
		private String fzrid;//负责人
		
		@Column(name="HQ_HW_ZSYTS_TYPE")
		private String type;//类型
		
		@Column(name="HQ_HW_ZSYTS_UserID")
		private String userid;//考评人（USER表ID）
		
		@Column(name="HQ_HW_ZSYTS_KPNR")
		private String kpnr;//考评内容
		
		@Column(name="HQ_HW_ZSYTS_KPSJ")
		private Date kpsj;//考评时间
		
		@Column(name="STATUS")
		private Integer status;//考评人是否匿名		默认为0	匿名为1

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFqyid() {
			return fqyid;
		}

		public void setFqyid(String fqyid) {
			this.fqyid = fqyid;
		}

		public String getZqyid() {
			return zqyid;
		}

		public void setZqyid(String zqyid) {
			this.zqyid = zqyid;
		}

		public String getFzrid() {
			return fzrid;
		}

		public void setFzrid(String fzrid) {
			this.fzrid = fzrid;
		}

		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getKpnr() {
			return kpnr;
		}

		public void setKpnr(String kpnr) {
			this.kpnr = kpnr;
		}

		public Date getKpsj() {
			return kpsj;
		}

		public void setKpsj(Date kpsj) {
			this.kpsj = kpsj;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "HqHwZsyts [id=" + id + ", fqyid=" + fqyid + ", zqyid=" + zqyid + ", fzrid=" + fzrid + ", type="
					+ type + ", userid=" + userid + ", kpnr=" + kpnr + ", kpsj=" + kpsj + ", status=" + status + "]";
		}
		
}
