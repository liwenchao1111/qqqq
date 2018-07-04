package com.dzqc.campus.dao.impl;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.dao.HqAdminHqUserXqDaoPlus;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public class HqAdminHqUserXqDaoPlusImpl extends CustomBaseSqlDaoImpl implements HqAdminHqUserXqDaoPlus {
    @Override
    public Integer jiedanshu(String USER_ID, LocalDateTime time) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT HQ_WX_DATE.HQ_USER_WORK FROM HQ_WX_DATE WHERE HQ_WX_DATE.HQ_WX_RY_ID=").append("'" + USER_ID + "'").append("AND HQ_WX_DATE.HQ_WX_RQ=")
                .append("to_date ('" + time + "','yyyy-MM-dd" + "\"T\"" + "HH24:MI:SS' )");
        List<Map<String, Object>> work = this.querySqlObjects(builder.toString());
        if (work == null || work.size() <= 0) {
            return null;
        } else {
            System.out.println(work.get(0));
            return Integer.valueOf((work.get(0).get("HQ_USER_WORK")) + "");
        }

    }
}
