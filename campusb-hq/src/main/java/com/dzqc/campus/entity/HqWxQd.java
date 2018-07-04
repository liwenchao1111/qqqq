package com.dzqc.campus.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Entity
@Table(name = "HQ_WX_QD")
public class HqWxQd {

	@Id
	@Column(name = "HQ_WX_QD_ID",length = 32, nullable = true)
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
    private  String HQ_WX_QD_ID;//后勤维修清单id

    @Column(name = "HQ_USER_ID")
    private  String HQ_USER_ID;//后勤学生的id

    @Column(name = "HQ_XM_FL")
    private  String HQ_XM_FL;//后勤维修项目分类

    @Column(name = "HQ_WX_DH")
    private  String  HQ_WX_DH;//后勤维修学生电话

    @Column(name = "HQ_WX_RQ")
    private   Date HQ_WX_RQ;//后勤维修日期
    
    @Column(name = "HQ_BX_RQ")
    private   Date HQ_BX_RQ;//学生报修时间

    @Column(name = "HQ_WX_GZTP")
    private  String HQ_WX_GZTP;//后勤维修故障图片

    @Column(name = "HQ_WX_GZMS")
    private  String HQ_WX_GZMS;//后勤维修故障描述

    /**
     * 
     * 
     *	形式：如：（管理员显示--学生显示--维修员）
     *
     *	1.待派单--待受理
     *	2.已派单--已受理--待接单
     *	3.已接单--已接单--已接单
     *	4.维修中--维修中--维修中
     *	5.已结束--待评价--已结束
     *	6.已评价--已完成--已评价
     *	7.被拒单--被拒单--拒单
     * 	8.被驳回--不显示
     */
    @Column(name = "HQ_WX_STATUS")
    private  String HQ_WX_STATUS;//当前故障维修状态

    
    

    public Date getHQ_BX_RQ() {
		return HQ_BX_RQ;
	}


	public void setHQ_BX_RQ(Date hQ_BX_RQ) {
		HQ_BX_RQ = hQ_BX_RQ;
	}


	@Column(name = "HQ_WX_PJDJ")
    private  String HQ_WX_PJDJ;//后勤维修评价等级


    @Column(name = "HQ_GLY_RY_ID")
    private  String HQ_GLY_RY_ID;//后勤 管理员的id

    @Column(name = "HQ_WX_RY_ID")
    private  String HQ_WX_RY_ID;//后勤维修员的id

    @Column(name = "HQ_WX_ADD")
    private  String HQ_WX_ADD;//后勤维修地址

    @Column(name = "HQ_USER_PJNR")
    private  String HQ_USER_PJNR;//后勤维修评价内容
    
    @Column(name = "HQ_WX_QR")
    private   Date HQ_WX_QR;//后勤维修确认结束时间
    
    @Column(name = "HQ_WX_BJCS")
    private   Date HQ_WX_BJCS;//维修清单被拒单次数


	public String getHQ_WX_QD_ID() {
		return HQ_WX_QD_ID;
	}


	public void setHQ_WX_QD_ID(String hQ_WX_QD_ID) {
		HQ_WX_QD_ID = hQ_WX_QD_ID;
	}


	public String getHQ_USER_ID() {
		return HQ_USER_ID;
	}



	public void setHQ_USER_ID(String hQ_USER_ID) {
		HQ_USER_ID = hQ_USER_ID;
	}



	public String getHQ_XM_FL() {
		return HQ_XM_FL;
	}



	public void setHQ_XM_FL(String hQ_XM_FL) {
		HQ_XM_FL = hQ_XM_FL;
	}



	public String getHQ_WX_DH() {
		return HQ_WX_DH;
	}



	public void setHQ_WX_DH(String hQ_WX_DH) {
		HQ_WX_DH = hQ_WX_DH;
	}

	public Date getHQ_WX_RQ() {
		return HQ_WX_RQ;
	}


	public void setHQ_WX_RQ(Date hQ_WX_RQ) {
		HQ_WX_RQ = hQ_WX_RQ;
	}


	public String getHQ_WX_GZTP() {
		return HQ_WX_GZTP;
	}


	public void setHQ_WX_GZTP(String hQ_WX_GZTP) {
		HQ_WX_GZTP = hQ_WX_GZTP;
	}


	public String getHQ_WX_GZMS() {
		return HQ_WX_GZMS;
	}


	public void setHQ_WX_GZMS(String hQ_WX_GZMS) {
		HQ_WX_GZMS = hQ_WX_GZMS;
	}


	public String getHQ_WX_STATUS() {
		return HQ_WX_STATUS;
	}


	public void setHQ_WX_STATUS(String hQ_WX_STATUS) {
		HQ_WX_STATUS = hQ_WX_STATUS;
	}


	public String getHQ_WX_PJDJ() {
		return HQ_WX_PJDJ;
	}


	public void setHQ_WX_PJDJ(String hQ_WX_PJDJ) {
		HQ_WX_PJDJ = hQ_WX_PJDJ;
	}


	public String getHQ_GLY_RY_ID() {
		return HQ_GLY_RY_ID;
	}


	public void setHQ_GLY_RY_ID(String hQ_GLY_RY_ID) {
		HQ_GLY_RY_ID = hQ_GLY_RY_ID;
	}


	public String getHQ_WX_RY_ID() {
		return HQ_WX_RY_ID;
	}


	public void setHQ_WX_RY_ID(String hQ_WX_RY_ID) {
		HQ_WX_RY_ID = hQ_WX_RY_ID;
	}


	public String getHQ_WX_ADD() {
		return HQ_WX_ADD;
	}


	public void setHQ_WX_ADD(String hQ_WX_ADD) {
		HQ_WX_ADD = hQ_WX_ADD;
	}


	public String getHQ_USER_PJNR() {
		return HQ_USER_PJNR;
	}

	public void setHQ_USER_PJNR(String hQ_USER_PJNR) {
		HQ_USER_PJNR = hQ_USER_PJNR;
	}

	public Date getHQ_WX_QR() {
		return HQ_WX_QR;
	}


	public void setHQ_WX_QR(Date hQ_WX_QR) {
		HQ_WX_QR = hQ_WX_QR;
	}
	
	
	public Date getHQ_WX_BJCS() {
		return HQ_WX_BJCS;
	}


	public void setHQ_WX_BJCS(Date hQ_WX_BJCS) {
		HQ_WX_BJCS = hQ_WX_BJCS;
	}


	@Override
	public String toString() {
		return "HqWxQd [HQ_WX_QD_ID=" + HQ_WX_QD_ID + ", HQ_USER_ID=" + HQ_USER_ID + ", HQ_XM_FL=" + HQ_XM_FL
				+ ", HQ_WX_DH=" + HQ_WX_DH + ", HQ_WX_RQ=" + HQ_WX_RQ + ", HQ_WX_GZTP=" + HQ_WX_GZTP + ", HQ_WX_GZMS="
				+ HQ_WX_GZMS + ", HQ_WX_STATUS=" + HQ_WX_STATUS + ", HQ_WX_PJDJ=" + HQ_WX_PJDJ + ", HQ_GLY_RY_ID="
				+ HQ_GLY_RY_ID + ", HQ_WX_RY_ID=" + HQ_WX_RY_ID + ", HQ_WX_ADD=" + HQ_WX_ADD + ", HQ_USER_PJNR="
				+ HQ_USER_PJNR + ", HQ_WX_QR=" + HQ_WX_QR + ", HQ_WX_BJCS=" + HQ_WX_BJCS + "]";
	}


	

}
