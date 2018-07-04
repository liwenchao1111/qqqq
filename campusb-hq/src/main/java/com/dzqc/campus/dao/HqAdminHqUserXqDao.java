package com.dzqc.campus.dao;

import com.dzqc.campus.common.dao.CommonDao;
import com.dzqc.campus.entity.HqWxDate;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface HqAdminHqUserXqDao extends CommonDao<HqWxDate, String> {
    //查询维修人员今天接了多少单
    /*   @Query( value = "SELECT HQ_WX_DATE.HQ_USER_WORK FROM HQ_WX_DATE WHERE HQ_WX_DATE.HQ_WX_RY_ID =?1 AND HQ_WX_DATE.HQ_WX_RQ=to_date(?2,'yyyy-MM-dd\"T\"HH24:MI:SS')",nativeQuery = true)*/
    //更新维修人员的接单数
    @Modifying
    @Query(value = "update HQ_WX_DATE set HQ_WX_DATE.HQ_USER_WORK=?1 where HQ_WX_DATE.HQ_WX_RY_ID=?2", nativeQuery = true)
    void gengxing(Integer jiedanshu, String id);

    @Modifying
    @Query(value = "update HQ_WX_QD qd Set  qd.hq_wx_status=2  where     qd.hq_wx_qd_id=?1", nativeQuery = true)
    void   weixiuzhangtai(String qdid);//更改维修清单的状态码
    //  给维修人派单
    HqWxDate save(HqWxDate hqWxDate);//添加维修时间

}
