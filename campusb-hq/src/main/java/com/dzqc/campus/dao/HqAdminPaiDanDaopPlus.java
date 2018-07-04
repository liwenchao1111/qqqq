package com.dzqc.campus.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface HqAdminPaiDanDaopPlus {
    List<Map<String, Object>> StudentMessage(String userid);/*查询去派单表头的学生报修信息*/

    List<Map<String, Object>> KongXianWeiXiuRenYuan(String working, LocalDateTime RiQi);/*查询空闲的维修人员*/

}
