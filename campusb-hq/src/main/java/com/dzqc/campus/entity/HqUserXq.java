package com.dzqc.campus.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "HQ_USER_XQ")
public class HqUserXq {
	@Id
	@Column(name = "HQ_ID",length = 32, nullable = true)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	private String HQ_ID;// 后勤编号
	
	@Column(name = "HQ_USER_GZXM")
	private String HQ_USER_GZXM;// 后勤用户中存的是工作项目的字符串id
	
	@Column(name = "HQ_USER_MAXWORK")
	private Integer HQ_USER_MAXWORK;// 后勤用户最大接单数
	
	@Column(name = "HQ_USER_STATUS")
	private Integer HQ_USER_STATUS;// 后勤用户状态0表示在职1表示离职
	
	@Column(name = "USER_ID")
	private String USER_ID;// 关联用户基础表
	
	@Column(name = "HQ_USER_GH")
	private String HQ_USER_GH;// 后勤用户工号
	
	@Column(name = "HQ_USER_AM_START")
	private Integer HQ_USER_AM_START;// 后勤用户上午开始工作时间
	
	@Column(name = "HQ_USER_AM_END")
	private Integer HQ_USER_AM_END;// 后勤用户上午结束工作时间
	
	@Column(name = "HQ_USER_PM_START")
	private Integer HQ_USER_PM_START;// 后勤用户下午开始工作时间
	
	@Column(name = "HQ_USER_PM_END")
	private Integer HQ_USER_PM_END;// 后勤用户下午结束工作时间
	
	@Column(name = "HQ_USER_JDCOUNT")
	private Integer HQ_USER_JDCOUNT;// 后勤用户拒单次数
	
	@Column(name = "HQ_USER_WORK")
    private Integer HQ_USER_WORK;// 后勤用户接单次数

	public Integer getHQ_USER_WORK() {
		return HQ_USER_WORK;
	}

	public void setHQ_USER_WORK(Integer hQ_USER_WORK) {
		HQ_USER_WORK = hQ_USER_WORK;
	}

	public HqUserXq() {

	}

	@Override
	public String toString() {
		return "HQ_USER_XQ{" + "HQ_ID=" + HQ_ID + ", HQ_USER_GZXM='" + HQ_USER_GZXM + '\'' + ", HQ_USER_MAXWORK="
				+ HQ_USER_MAXWORK + ", HQ_USER_STATUS=" + HQ_USER_STATUS + ", USER_ID='" + USER_ID + '\''
				+ ", HQ_USER_GH='" + HQ_USER_GH + '\'' + ", HQ_USER_AM_START=" + HQ_USER_AM_START + ", HQ_USER_AM_END="
				+ HQ_USER_AM_END + ", HQ_USER_PM_START=" + HQ_USER_PM_START + ", HQ_USER_PM_END=" + HQ_USER_PM_END
				+ ", HQ_USER_JDCOUNT=" + HQ_USER_JDCOUNT + '}';
	}

	public String getHQ_ID() {
		return HQ_ID;
	}

	public void setHQ_ID(String HQ_ID) {
		this.HQ_ID = HQ_ID;
	}

	public String getHQ_USER_GZXM() {
		return HQ_USER_GZXM;
	}

	public void setHQ_USER_GZXM(String HQ_USER_GZXM) {
		this.HQ_USER_GZXM = HQ_USER_GZXM;
	}

	public Integer getHQ_USER_MAXWORK() {
		return HQ_USER_MAXWORK;
	}

	public void setHQ_USER_MAXWORK(Integer HQ_USER_MAXWORK) {
		this.HQ_USER_MAXWORK = HQ_USER_MAXWORK;
	}

	public Integer getHQ_USER_STATUS() {
		return HQ_USER_STATUS;
	}

	public void setHQ_USER_STATUS(Integer HQ_USER_STATUS) {
		this.HQ_USER_STATUS = HQ_USER_STATUS;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}

	public String getHQ_USER_GH() {
		return HQ_USER_GH;
	}

	public void setHQ_USER_GH(String HQ_USER_GH) {
		this.HQ_USER_GH = HQ_USER_GH;
	}

	public Integer getHQ_USER_AM_START() {
		return HQ_USER_AM_START;
	}

	public void setHQ_USER_AM_START(Integer HQ_USER_AM_START) {
		this.HQ_USER_AM_START = HQ_USER_AM_START;
	}

	public Integer getHQ_USER_AM_END() {
		return HQ_USER_AM_END;
	}

	public void setHQ_USER_AM_END(Integer HQ_USER_AM_END) {
		this.HQ_USER_AM_END = HQ_USER_AM_END;
	}

	public Integer getHQ_USER_PM_START() {
		return HQ_USER_PM_START;
	}

	public void setHQ_USER_PM_START(Integer HQ_USER_PM_START) {
		this.HQ_USER_PM_START = HQ_USER_PM_START;
	}

	public Integer getHQ_USER_PM_END() {
		return HQ_USER_PM_END;
	}

	public void setHQ_USER_PM_END(Integer HQ_USER_PM_END) {
		this.HQ_USER_PM_END = HQ_USER_PM_END;
	}

	public Integer getHQ_USER_JDCOUNT() {
		return HQ_USER_JDCOUNT;
	}

	public void setHQ_USER_JDCOUNT(Integer HQ_USER_JDCOUNT) {
		this.HQ_USER_JDCOUNT = HQ_USER_JDCOUNT;
	}
}
