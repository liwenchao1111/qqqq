package com.dzqc.campus.service.impl;

import com.dzqc.campus.dao.HqAdminHqUserXqDao;
import com.dzqc.campus.dao.HqAdminHqUserXqDaoPlus;
import com.dzqc.campus.entity.HqWxDate;
import com.dzqc.campus.service.HqAdminHqUserXqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class HqAdminHqUserXqServiceImpl implements HqAdminHqUserXqService {
    @Autowired
    private HqAdminHqUserXqDao hqAdminHqUserXqDao;
    @Autowired
    private HqAdminHqUserXqDaoPlus hqAdminHqUserXqDaoPlus;

    //  查询维修人员的接单数
    @Override
    public Integer jiedanshu(String id, LocalDateTime time) {

        return hqAdminHqUserXqDaoPlus.jiedanshu(id, time);
    }

    //更新维修人员的接单数
    @Override
    public void gengxing(Integer jiedanshu, String id) {
        hqAdminHqUserXqDao.gengxing(jiedanshu, id);
    }
    
    //更改维修人员状态
    @Override
    public void weixiuzhangtai(String qdid) {
        hqAdminHqUserXqDao.weixiuzhangtai(qdid);
    }

    @Override
    public HqWxDate save(HqWxDate hqWxDate) {
        return hqAdminHqUserXqDao.save(hqWxDate);
    }
}
