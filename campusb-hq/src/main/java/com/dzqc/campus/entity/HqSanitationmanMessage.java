package com.dzqc.campus.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HQ_SANITATIONMAN_MESSAGE")
public class HqSanitationmanMessage {
    @Id
    @Column(name = "HQ_SANITATIONMAN_ID", length = 32, nullable = true)
    @GenericGenerator(name = "sys_uuid", strategy = "uuid")
    @GeneratedValue(generator = "sys_uuid")
    private String hqSanitationmanId;  //环卫工信息表ID

    @Column(name = "HQ_SANITATIONMAN_NUMBER") // 环卫工编号
    private String hqSanitationmanNumber;

    @Column(name = "HQ_SANITATIONMAN_NAME") //环卫工姓名
    private String hqSanitationmanName;

    @Column(name = "HQ_SANITATIONMAN_SEX")//环卫工性别
    private String hqSanitationmanSex;

    @Column(name = "HQ_SANITATIONMAN_BIRTHDATE")// 环卫工出生日期
    private Date hqSanitationmanBirthdate;

    @Column(name = "HQ_SANITATIONMAN_TYPE") //环卫工类型
    private String hqSanitationmanType;

    @Column(name = "HQ_SANITATIONMAN_PHONE")//环卫工电话
    private String hqSanitationmanPhone;

    @Column(name = "HQ_SANITATIONMAN_BACKGROUND")  // 环卫工学历
    private String hqSanitationmanBackground;

    @Column(name = "HQ_SANITATIONMAN_IDCARD")  //环卫工身份证号码
    private String hqSanitationmanIdcard;

    @Column(name = "STATUS")  //状态码  0表示可用 1表示删除
    private Integer status;

    @Column(name = "HQ_SANITATIONMAN_IMGURL")  //环卫工头像
    private String hqSanitationmanImgUrl;

	public String getHqSanitationmanImgUrl() {
		return hqSanitationmanImgUrl;
	}

	public void setHqSanitationmanImgUrl(String hqSanitationmanImgUrl) {
		this.hqSanitationmanImgUrl = hqSanitationmanImgUrl;
	}

	public String getHqSanitationmanId() {
		return hqSanitationmanId;
	}

    public void setHqSanitationmanId(String hqSanitationmanId) {
        this.hqSanitationmanId = hqSanitationmanId;
    }


    public String getHqSanitationmanNumber() {
        return hqSanitationmanNumber;
    }

    public void setHqSanitationmanNumber(String hqSanitationmanNumber) {
        this.hqSanitationmanNumber = hqSanitationmanNumber;
    }


    public String getHqSanitationmanName() {
        return hqSanitationmanName;
    }

    public void setHqSanitationmanName(String hqSanitationmanName) {
        this.hqSanitationmanName = hqSanitationmanName;
    }


    public String getHqSanitationmanSex() {
        return hqSanitationmanSex;
    }

    public void setHqSanitationmanSex(String hqSanitationmanSex) {
        this.hqSanitationmanSex = hqSanitationmanSex;
    }


    public Date getHqSanitationmanBirthdate() {
        return hqSanitationmanBirthdate;
    }

    public void setHqSanitationmanBirthdate(Date hqSanitationmanBirthdate) {
        this.hqSanitationmanBirthdate = hqSanitationmanBirthdate;
    }


    public String getHqSanitationmanType() {
        return hqSanitationmanType;
    }

    public void setHqSanitationmanType(String hqSanitationmanType) {
        this.hqSanitationmanType = hqSanitationmanType;
    }


    public String getHqSanitationmanPhone() {
        return hqSanitationmanPhone;
    }

    public void setHqSanitationmanPhone(String hqSanitationmanPhone) {
        this.hqSanitationmanPhone = hqSanitationmanPhone;
    }


    public String getHqSanitationmanBackground() {
        return hqSanitationmanBackground;
    }

    public void setHqSanitationmanBackground(String hqSanitationmanBackground) {
        this.hqSanitationmanBackground = hqSanitationmanBackground;
    }


    public String getHqSanitationmanIdcard() {
        return hqSanitationmanIdcard;
    }

    public void setHqSanitationmanIdcard(String hqSanitationmanIdcard) {
        this.hqSanitationmanIdcard = hqSanitationmanIdcard;
    }


    public Integer getStatus() {
        return status;
    }

	public void setStatus(Integer status) {
		this.status = status;
	}
}
