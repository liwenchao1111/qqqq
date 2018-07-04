package com.dzqc.campus.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HQ_WX_DATE")
public class HqWxDate {
    @Id
    @Column(name = "ID", length = 32, nullable = true)
    @GenericGenerator(name = "sys_uuid", strategy = "uuid")
    @GeneratedValue(generator = "sys_uuid")
    private String ID;  //后勤日期表

    @Column(name = "HQ_WX_RY_ID")
    private String HQWXRYID;  //后勤维修人员id
    @Column(name = "HQ_USER_WORK")
    private Integer HQUSERWORK;  //维修人员今天接单数
    @Column(name = "HQ_WX_RQ")
    private Date HQWXRQ; //维修日期

    public HqWxDate() {
    }

    @Override
    public String toString() {
        return "HqWxDate{" +
                "ID='" + ID + '\'' +
                ", HQWXRYID='" + HQWXRYID + '\'' +
                ", HQUSERWORK=" + HQUSERWORK +
                ", HQWXRQ=" + HQWXRQ +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHQWXRYID() {
        return HQWXRYID;
    }

    public void setHQWXRYID(String HQWXRYID) {
        this.HQWXRYID = HQWXRYID;
    }

    public Integer getHQUSERWORK() {
        return HQUSERWORK;
    }

    public void setHQUSERWORK(Integer HQUSERWORK) {
        this.HQUSERWORK = HQUSERWORK;
    }

    public Date getHQWXRQ() {
        return HQWXRQ;
    }

    public void setHQWXRQ(Date HQWXRQ) {
        this.HQWXRQ = HQWXRQ;
    }
}
