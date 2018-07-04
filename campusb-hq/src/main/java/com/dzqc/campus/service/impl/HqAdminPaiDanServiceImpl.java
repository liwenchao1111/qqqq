package com.dzqc.campus.service.impl;

import com.dzqc.campus.dao.HqAdminPaiDanDao;
import com.dzqc.campus.dao.HqAdminPaiDanDaopPlus;
import com.dzqc.campus.entity.HqApWx;
import com.dzqc.campus.service.HqAdminPaiDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class HqAdminPaiDanServiceImpl implements HqAdminPaiDanService {
    @Autowired
    private HqAdminPaiDanDaopPlus hqAdminPaiDanDaopPlus;
    @Autowired
    private HqAdminPaiDanDao hqAdminPaiDanDao;

    /*查询去派单表头的学生报修信息*/
    @Override
    public List<Map<String, Object>> StudentMessage(String userid) {
        return hqAdminPaiDanDaopPlus.StudentMessage(userid);
    }

    /*查询空闲的维修人员*/
    @Override
    public List<Map<String, Object>> KongXianWeiXiuRenYuan(String working, LocalDateTime RiQi) {
        return hqAdminPaiDanDaopPlus.KongXianWeiXiuRenYuan(working, RiQi);
    }

    // 添加管理员安排
    @Override
    public HqApWx save(HqApWx hqApWx) {

        return hqAdminPaiDanDao.save(hqApWx);
    }


}
