package com.dzqc.campus.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="HQ_NOTICE_NEW")
public class HqNoticeNew {
    @Id
    @Column(name = "HQ_NOTICE_ID", length = 32, nullable = true)
    @GenericGenerator(name = "sys_uuid", strategy = "uuid")
    @GeneratedValue(generator = "sys_uuid")
    private String hqNoticeId;

    @Column(name = "HQ_NOTICE_AREA")
    private String hqNoticeArea;  //公告的区域

    @Column(name = "HQ_NOTICE_HEADLINE")
    private String hqNoticeHeadline;  //公告标题


    @Column(name = "HQ_NOTICE_ISSUER")
    private String hqNoticeIssuer; //公告发布人


    @Column(name = "HQ_NOTICE_CONTENT")
    private String hqNoticeContent;  //公告内容

    @Column(name = "HQ_NOTICE_TIME")
    private Date hqNoticeTime; //公告发布时间


    @Column(name = "HQ_NOTICE_ROOT")
    private Integer hqNoticeRoot; //有权限查看公告的人  1所有人，2特定部门，3特定人员，4不给谁看


    @Column(name = "HQ_NOTICE_READING")
    private Integer hqNoticeReading;//公告阅读量


    @Column(name = "HQ_NOTICE_DELETE")
    private Integer hqNoticeDelete;  //公告删除，0未删除，1删除


    @Column(name = "HQ_NOTICE_PUBLISH")
    private Integer hqNoticePublish; //公告是否发布,0未发布，1发布

    public HqNoticeNew() {
    }


    @Override
    public String toString() {
        return "HqNoticeNew{" +
                "hqNoticeId='" + hqNoticeId + '\'' +
                ", hqNoticeArea='" + hqNoticeArea + '\'' +
                ", hqNoticeHeadline='" + hqNoticeHeadline + '\'' +
                ", hqNoticeIssuer='" + hqNoticeIssuer + '\'' +
                ", hqNoticeContent='" + hqNoticeContent + '\'' +
                ", hqNoticeTime=" + hqNoticeTime +
                ", hqNoticeRoot='" + hqNoticeRoot + '\'' +
                ", hqNoticeReading='" + hqNoticeReading + '\'' +
                ", hqNoticeDelete='" + hqNoticeDelete + '\'' +
                ", hqNoticePublish='" + hqNoticePublish + '\'' +
                '}';
    }

    public String getHqNoticeId() {
        return hqNoticeId;
    }

    public void setHqNoticeId(String hqNoticeId) {
        this.hqNoticeId = hqNoticeId;
    }

    public String getHqNoticeArea() {
        return hqNoticeArea;
    }

    public void setHqNoticeArea(String hqNoticeArea) {
        this.hqNoticeArea = hqNoticeArea;
    }

    public String getHqNoticeHeadline() {
        return hqNoticeHeadline;
    }

    public void setHqNoticeHeadline(String hqNoticeHeadline) {
        this.hqNoticeHeadline = hqNoticeHeadline;
    }

    public String getHqNoticeIssuer() {
        return hqNoticeIssuer;
    }

    public void setHqNoticeIssuer(String hqNoticeIssuer) {
        this.hqNoticeIssuer = hqNoticeIssuer;
    }

    public String getHqNoticeContent() {
        return hqNoticeContent;
    }

    public void setHqNoticeContent(String hqNoticeContent) {
        this.hqNoticeContent = hqNoticeContent;
    }

    public Date getHqNoticeTime() {
        return hqNoticeTime;
    }

    public void setHqNoticeTime(Date hqNoticeTime) {
        this.hqNoticeTime = hqNoticeTime;
    }

    public Integer getHqNoticeRoot() {
        return hqNoticeRoot;
    }

    public void setHqNoticeRoot(Integer hqNoticeRoot) {
        this.hqNoticeRoot = hqNoticeRoot;
    }

    public Integer getHqNoticeReading() {
        return hqNoticeReading;
    }

    public void setHqNoticeReading(Integer hqNoticeReading) {
        this.hqNoticeReading = hqNoticeReading;
    }

    public Integer getHqNoticeDelete() {
        return hqNoticeDelete;
    }

    public void setHqNoticeDelete(Integer hqNoticeDelete) {
        this.hqNoticeDelete = hqNoticeDelete;
    }

    public Integer getHqNoticePublish() {
        return hqNoticePublish;
    }

    public void setHqNoticePublish(Integer hqNoticePublish) {
        this.hqNoticePublish = hqNoticePublish;
    }
}



