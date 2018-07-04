package com.dzqc.campus.dao;

import com.dzqc.campus.common.dao.CommonDao;
import com.dzqc.campus.entity.HqApWx;

public interface HqAdminPaiDanDao extends CommonDao<HqApWx, String> {
    HqApWx save(HqApWx hqApWx); //添加后勤维修人员的安排


}
