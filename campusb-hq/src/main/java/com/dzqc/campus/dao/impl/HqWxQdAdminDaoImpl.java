package com.dzqc.campus.dao.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqWxQdAdminDaoPlus;
import com.dzqc.campus.entity.HqWxQd;

/**
 * 
 * 功能描述：
 *
 * @Package: com.dzqc.campus.dao.impl 
 * @ClassName: HqWxQdDaoImpl.java
 * @author: 呆橘  
 * @date: 2018年5月26日 下午6:37:28
 */

public class HqWxQdAdminDaoImpl extends CustomBaseSqlDaoImpl implements HqWxQdAdminDaoPlus {


	@Override
	public PageModel findByParams(Integer HQ_WX_STATUS, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("select t.HQ_WX_QD_ID,t.HQ_USER_ID,t.HQ_XM_FL,t.HQ_WX_RQ,t.HQ_WX_GZTP,t.HQ_WX_GZMS,t.HQ_BX_RQ,t.HQ_WX_STATUS,t.HQ_WX_ADD,t.HQ_WX_BJCS,o.real_name  from HQ_WX_QD t,Org_User o where t.HQ_USER_ID=o.ID  and t.HQ_WX_STATUS!=8").append(" ");
		if(HQ_WX_STATUS!=0){
			builder.append("and HQ_WX_STATUS =").append(HQ_WX_STATUS);
			
	}
		System.out.println(builder.toString()+"执行了吗？");
		  PageModel<HqWxQd> list=this.queryForPageBySql(builder.toString(), currentPage, pageSize);    
          return list;
	}

	@Override
	public int update(String HQ_WX_QD_ID) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE HQ_WX_QD  SET  HQ_WX_STATUS ='8' WHERE  HQ_WX_QD_ID= '").append(HQ_WX_QD_ID).append("'");
		Integer i = this.executeSql(builder.toString(), null);
		return i;
		
	}

	@Override
	public List<Map<String, Object>> findBywxqdid(String HQ_WX_QD_ID) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("select h.HQ_WX_QD_ID,h.HQ_USER_ID,h.HQ_XM_FL,h.HQ_WX_ADD,h.HQ_WX_RQ,h.HQ_WX_GZTP,h.HQ_WX_GZMS,h.HQ_WX_STATUS,u.real_name from HQ_WX_QD h,Org_User u WHERE h.HQ_USER_ID=u.ID  and h.hq_wx_qd_id='").append(HQ_WX_QD_ID).append("'");
		List<Map<String, Object>> hqwxqd=this.querySqlObjectsForBean(builder.toString());
		return hqwxqd;
	}
	
	
	@Override
	public List<Map<String, Object>> findByBjxq(String HQ_WX_QD_ID) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("select u.mobile,u.real_name from HQ_WX_QD wxqd join org_user u on wxqd.hq_wx_ry_id=u.id and wxqd.hq_wx_bjcs>0 and wxqd.hq_wx_qd_id='").append(HQ_WX_QD_ID).append("'");
		List<Map<String, Object>> hqbj=this.querySqlObjectsForBean(builder.toString());
		return hqbj;
	}
	
	
	@Override
	public Map<String, Object> findQdxqList(String ID) {
		String sql="select hwq.*,ou.real_name from Hq_Wx_Qd hwq,Org_User ou where hwq.hq_user_id=ou.id and hwq.hq_wx_qd_id=?";

		List<Object> params=new ArrayList<>();
		params.add(ID);
		List<Map<String, Object>> list=this.querySqlObjects(sql, params);
		if(list==null||list.size()<1) {
			return null;
		}
		return list.get(0);

	}

	@Override
	public Map<String, Object> findUserbyId(String id) {
		String sql="select real_name as wxry_name,mobile from Org_User d where d.id=?";

		List<Object> params=new ArrayList<>();
		params.add(id);
		List<Map<String, Object>> list=this.querySqlObjects(sql, params);
		if(list==null||list.size()<1) {
			return null;
		}
		return list.get(0);
	}
//
//		@Override
//		public Integer findCountById() {
//			StringBuilder builder=new StringBuilder();
//			builder.append("select count(t.hq_wx_qd_id)  from HQ_WX_QD t where t.hq_wx_status != 8");
//			
//			Integer params=this.executeSql(builder.toString(), null);
//			return params;
//		}

	@Override
	public Integer findCountById() {
		StringBuilder builder=new StringBuilder();
		builder.append("select count(t.hq_wx_qd_id)  from HQ_WX_QD t where t.hq_wx_status != 8");
		Map<String, Object> params=new HashMap<String, Object>();
		Integer count=this.queryCountBySql(builder.toString(), params);
		return count;
		
	}
		
	
	@Override
	public List<Map<String, Object>> findCountStatus() {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder();
		builder.append("select HQ_WX_STATUS,count(HQ_WX_STATUS) count from HQ_WX_QD student   group by HQ_WX_STATUS");
		List<Map<String, Object>> listmap=this.querySqlObjectsForBean(builder+"");
		if(listmap==null) {
			return null;
		}
		return listmap;
	}

	@Override
	public Map<String, Object> findApbyId(String id) {
		String sql="select hq_wx_ap_k_time from HQ_AP_WX where hq_wx_qd_id=?";
		List<Object> params=new ArrayList<>();
		params.add(id);
		List<Map<String, Object>> list=this.querySqlObjects(sql, params);
		if(list==null||list.size()<1) {
			return null;
		}
		return list.get(0);

	}

	

	
}
