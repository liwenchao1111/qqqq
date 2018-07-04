package com.dzqc.campus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HQ_HW_ZQYGL")
public class HqHwZqyGL {
	@Id
	@Column(name = "HW_ZQY_ID", length = 32, nullable = true)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	private String HW_ZQY_ID;

	@Column(name = "HW_ZQY_CODE")
	private String HW_ZQY_CODE;// 子区域编码

	@Column(name = "HW_ZQY_NAME")
	private String HW_ZQY_NAME;// 子区域名称

	@Column(name = "STATUS")
	private Integer STATUS;// 子区域状态码

	@Column(name = "HW_FQY_ID")
	private String HW_FQY_ID;// 父区域id
	
	@Column(name = "HW_KP_COUNT")
	private Integer HW_KP_COUNT;// 考评计数

	public String getHW_ZQY_ID() {
		return HW_ZQY_ID;
	}

	public void setHW_ZQY_ID(String hW_ZQY_ID) {
		HW_ZQY_ID = hW_ZQY_ID;
	}

	public String getHW_ZQY_CODE() {
		return HW_ZQY_CODE;
	}

	public void setHW_ZQY_CODE(String hW_ZQY_CODE) {
		HW_ZQY_CODE = hW_ZQY_CODE;
	}

	public String getHW_ZQY_NAME() {
		return HW_ZQY_NAME;
	}

	public void setHW_ZQY_NAME(String hW_ZQY_NAME) {
		HW_ZQY_NAME = hW_ZQY_NAME;
	}

	public Integer getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(Integer sTATUS) {
		STATUS = sTATUS;
	}

	public String getHW_FQY_ID() {
		return HW_FQY_ID;
	}

	public void setHW_FQY_ID(String hW_FQY_ID) {
		HW_FQY_ID = hW_FQY_ID;
	}

	public Integer getHW_KP_COUNT() {
		return HW_KP_COUNT;
	}

	public void setHW_KP_COUNT(Integer hW_KP_COUNT) {
		HW_KP_COUNT = hW_KP_COUNT;
	}

	@Override
	public String toString() {
		return "HqHwZqyGL [HW_ZQY_ID=" + HW_ZQY_ID + ", HW_ZQY_CODE=" + HW_ZQY_CODE + ", HW_ZQY_NAME=" + HW_ZQY_NAME
				+ ", STATUS=" + STATUS + ", HW_FQY_ID=" + HW_FQY_ID + ", HW_KP_COUNT=" + HW_KP_COUNT + "]";
	}

	

}
