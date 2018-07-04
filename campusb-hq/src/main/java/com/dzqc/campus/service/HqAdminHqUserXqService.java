package com.dzqc.campus.service;

import com.dzqc.campus.entity.HqWxDate;

import java.time.LocalDateTime;


public interface HqAdminHqUserXqService {

    Integer jiedanshu(String id, LocalDateTime time);   //查询维修人员今天接了多少单*/

    void gengxing(Integer jiedanshu, String id); //更新维修人员的接单数*/

    void   weixiuzhangtai(String qdid);//更改维修清单的状态码
    HqWxDate save(HqWxDate hqWxDate);//添加维修时间
}
