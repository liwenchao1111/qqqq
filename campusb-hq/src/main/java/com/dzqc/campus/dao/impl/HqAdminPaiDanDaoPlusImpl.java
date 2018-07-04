package com.dzqc.campus.dao.impl;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.dao.HqAdminPaiDanDaopPlus;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public class HqAdminPaiDanDaoPlusImpl extends CustomBaseSqlDaoImpl implements HqAdminPaiDanDaopPlus {
    /*  8a2c5d7562db6cc40162e19ef1b60008*/
    @Override
    public List<Map<String, Object>> StudentMessage(String userid) {
        StringBuilder builder = new StringBuilder();

    /*    builder.append("SELECT " +
                "ORG_USER.REAL_NAME,HQ_WX_QD.HQ_WX_ADD,HQ_WX_QD.HQ_WX_RQ,HQ_WX_QD.HQ_XM_FL,HQ_WX_QD.HQ_USER_ID" +
                " FROM HQ_WX_QD,ORG_USER" +
                " WHERE HQ_WX_QD.HQ_USER_ID=ORG_USER.ID AND HQ_WX_QD.HQ_WX_STATUS=2 AND HQ_WX_QD.HQ_USER_ID=").append("'"+userid+"'");*/

        builder.append(" SELECT" +
                "        ORG_USER.REAL_NAME," +
                "        a.HQ_WX_ADD," +
                "        a.HQ_WX_RQ," +
                        "a.HQ_BX_RQ,"+
                "        a.HQ_XM_FL," +
                "        a.HQ_USER_ID " +
                "    FROM" +
                "        ORG_USER , " +
                "        (" +
                "        select  qd.hq_user_id, qd.Hq_Wx_Rq, qd.Hq_Xm_Fl, qd.hq_wx_add ,qd.HQ_BX_RQ From hq_wx_qd  qd  Where  qd.hq_wx_qd_id=").append("'" + userid + "'").append(" And qd.hq_wx_status=1 ")
                .append(") a  WHERE" +
                        "          ORG_USER.id=a.hq_user_id "+
                        "    and  Org_User.Delete_Flag=0 "
                );


        return this.querySqlObjects(builder.toString());
    }

    /*   @Override
       public List<Map<String, Object>> KongXianWeiXiuRenYuan(String working, LocalDateTime RiQi) {
           StringBuilder builder = new StringBuilder();
             builder.append(" Select  ORG_USER.REAL_NAME,HQ_USER_XQ.HQ_USER_GZXM,HQ_USER_XQ.HQ_ID,ORG_USER.ID" +
                     "  From ORG_USER,HQ_USER_XQ,HQ_WX_QD" +
                     "  Where ORG_USER.TYPE=3" +
                     "  And  HQ_USER_XQ.HQ_USER_MAXWORK>HQ_USER_XQ.HQ_USER_WORK" +
                     "  And  HQ_USER_XQ.USER_ID= ORG_USER.ID" +
                     "  And HQ_USER_XQ.HQ_USER_GZXM Like ").append("'%"+working+"%'").append(" And HQ_WX_QD.HQ_WX_RQ=").append("to_date ('"+RiQi+"','yyyy-MM-dd"+"\"T\""+"HH24:MI:SS' )");
           return  this.querySqlObjects(builder.toString());
       }*/
    @Override
    public List<Map<String, Object>> KongXianWeiXiuRenYuan(String working, LocalDateTime RiQi) {
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT" +
                "  u.REAL_NAME,uxq.HQ_USER_GZXM,u.ID" +
                " FROM" +
                " org_user u" +
                " LEFT JOIN Hq_User_Xq uxq ON uxq.user_id = u.id" +
                " LEFT JOIN Hq_Wx_Date wxd ON wxd.hq_wx_ry_id = u.id " +
                " WHERE" +
                " u.type = 3" +
                " AND( ( wxd.hq_wx_rq =").append(" to_date ('" + RiQi + "','yyyy-MM-dd" + "\"T\"" + "HH24:MI:SS' )")
                .append(" AND wxd.hq_user_work < uxq.hq_user_maxwork ) OR wxd.hq_wx_rq IS NULL) AND  u.Delete_Flag=0   AND  uxq.HQ_USER_GZXM LIKE ").append("'%" + working + "%'");
        return this.querySqlObjects(builder.toString());
    }


}
