package com.dzqc.campus.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HQ_AP_WX")
public class HqApWx {
	@Id
	@SequenceGenerator(name = "HQ_AP_WX_S", sequenceName = "HQ_AP_WX_SEQUENCE", allocationSize = 1)
	@Column(length = 32, nullable = true,name="HQ_WX_AP_ID")
	@GenericGenerator(name = "sys_uuid", strategy = "uuid")
	@GeneratedValue(generator = "sys_uuid")
	private String HQ_WX_AP_ID; // 管理员安排维修的表
	
	@Column(name = "ID")
	private String ID;// 管理员id
	
	@Column(name = "HQ_ID")
	private String HQ_ID;// 维修人员的id
	
	@Column(name = "HQ_WX_QD_ID")
    private String HQ_WX_QD_ID;// 清单id
	
	@Column(name = "HQ_WX_AP_K_TIME")
	private Date HQ_WX_AP_K_TIME;// 维修人员维修开始时间
	
	@Column(name = "HQ_WX_AP_G_TIME")
	private Date HQ_WX_AP_G_TIME;// 维修人员维修结束时间

	public HqApWx() {
	}

    @Override
    public String toString() {
        return "HqApWx{" +
                "HQ_WX_AP_ID='" + HQ_WX_AP_ID + '\'' +
                ", ID='" + ID + '\'' +
                ", HQ_ID='" + HQ_ID + '\'' +
                ", HQ_WX_QD_ID='" + HQ_WX_QD_ID + '\'' +
                ", HQ_WX_AP_K_TIME=" + HQ_WX_AP_K_TIME +
                ", HQ_WX_AP_G_TIME=" + HQ_WX_AP_G_TIME +
                '}';
    }

	public String getHQ_WX_AP_ID() {
		return HQ_WX_AP_ID;
	}

	public void setHQ_WX_AP_ID(String hQ_WX_AP_ID) {
		HQ_WX_AP_ID = hQ_WX_AP_ID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getHQ_ID() {
		return HQ_ID;
	}

	public void setHQ_ID(String hQ_ID) {
		HQ_ID = hQ_ID;
	}

	public String getHQ_WX_QD_ID() {
		return HQ_WX_QD_ID;
	}

	public void setHQ_WX_QD_ID(String hQ_WX_QD_ID) {
		HQ_WX_QD_ID = hQ_WX_QD_ID;
	}

	public Date getHQ_WX_AP_K_TIME() {
		return HQ_WX_AP_K_TIME;
	}

	public void setHQ_WX_AP_K_TIME(Date hQ_WX_AP_K_TIME) {
		HQ_WX_AP_K_TIME = hQ_WX_AP_K_TIME;
	}

	public Date getHQ_WX_AP_G_TIME() {
		return HQ_WX_AP_G_TIME;
	}

	public void setHQ_WX_AP_G_TIME(Date hQ_WX_AP_G_TIME) {
		HQ_WX_AP_G_TIME = hQ_WX_AP_G_TIME;
	}

}
