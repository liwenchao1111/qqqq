package com.dzqc.campus.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

/**
 * 后勤清单被拒
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "HQ_QD_BJ")
public class HqQdBj {
	@Id
	// @Column(name = "ID", unique = true, nullable = false, precision = 0)
	// @GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "ID", length = 32, nullable = true)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")

	private String ID;// 后勤清单被拒id

	@Column(name = "HQ_USER_ID")
	private String HQ_USER_ID;// 状态为0时表示2管理员id,1时表示维修员id

	@Column(name = "QD_BJ_SJ")
	private Date QD_BJ_SJ;// 后勤被拒时间

	@Column(name = "BJ_XQ")
	private String BJ_XQ;// 被拒 详情

	@Column(name = "STATUS")
	private String STATUS;// 状态
	
	@Column(name = "HQ_QD_ID")
	private String HQ_QD_ID;// 后勤清单ID

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getHQ_USER_ID() {
		return HQ_USER_ID;
	}

	public void setHQ_USER_ID(String hQ_USER_ID) {
		HQ_USER_ID = hQ_USER_ID;
	}

	public Date getQD_BJ_SJ() {
		return QD_BJ_SJ;
	}

	public void setQD_BJ_SJ(Date qD_BJ_SJ) {
		QD_BJ_SJ = qD_BJ_SJ;
	}

	public String getBJ_XQ() {
		return BJ_XQ;
	}

	public void setBJ_XQ(String bJ_XQ) {
		BJ_XQ = bJ_XQ;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	
	public String getHQ_QD_ID() {
		return HQ_QD_ID;
	}

	public void setHQ_QD_ID(String hQ_QD_ID) {
		HQ_QD_ID = hQ_QD_ID;
	}

	@Override
	public String toString() {
		return "HqQdBj [ID=" + ID + ", HQ_USER_ID=" + HQ_USER_ID + ", QD_BJ_SJ=" + QD_BJ_SJ + ", BJ_XQ=" + BJ_XQ
				+ ", STATUS=" + STATUS + ", HQ_QD_ID=" + HQ_QD_ID + "]";
	}

	
}
