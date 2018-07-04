package com.dzqc.campus.dao.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqWxQdDaoPlus;
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

public class HqWxQdDaoImpl extends CustomBaseSqlDaoImpl implements HqWxQdDaoPlus {

/*
	 * 根据报修清单ID查询报修详情
	 */
	@Override
	public List<Map<String, Object>> queryBx(String id) {
		String sql = "select\r\n" + 
				"        hwq.*,\r\n" + 
				"        haw.hq_wx_ap_k_time,\r\n" + 
				"        haw.hq_wx_ap_g_time,\r\n" + 
				"        ou.real_name a,\r\n" + 
				"        ous.real_name b,\r\n" + 
				"        ouss.real_name c,\r\n" + 
				"        ouss.mobile  ma,\r\n" + 
				"        ous.mobile mb\r\n" + 
				"    from\r\n" + 
				"        Hq_Wx_Qd hwq\r\n" + 
				"         Left join  \r\n" + 
				"        Org_User ous\r\n" + 
				"        on\r\n" + 
				"        hwq.HQ_User_ID=ous.id \r\n" + 
				"          Left join  \r\n" + 
				"        Org_User ouss\r\n" + 
				"        on\r\n" + 
				"        hwq.HQ_GLY_RY_ID=ouss.id  \r\n" + 
				"       Left join  \r\n" + 
				"        Org_User ou \r\n" + 
				"        on\r\n" + 
				"        hwq.HQ_WX_RY_ID=ou.id \r\n" + 
				"         Left join\r\n" + 
				"        HQ_AP_WX haw\r\n" + 
				"     on\r\n" + 
				"      hwq.hq_wx_qd_id=haw.hq_wx_qd_id\r\n" + 
				"       \r\n" + 
				"    where\r\n" + 
				"         hwq.hq_wx_qd_id=?";  
		List<Object> list =new ArrayList<>();
		list.add(id);
		List<Map<String,Object>> listmap = this.querySqlObjects(sql,list);
		System.out.println(listmap);
		if(listmap == null || listmap.size() < 1) {
			return null;
		}
		return listmap;
	}

	@Override
	public Map<String, Object> orgUser(String id) {
		String sql = "select * from ORG_USER u where u.ID = ?";
		List<Object> list1 = new ArrayList<>();
		list1.add(id);
		List<Map<String,Object>> listmap1 = this.querySqlObjects(sql, list1);
		if(listmap1 == null || listmap1.size() < 1) {
			return null;
		}
		return listmap1.get(0);
	}

	
	@Override
	public PageModel<Map<String,Object>> findByUserIDWxQd(String id,Integer currentPage,
            Integer pageSize,String status) {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder();
		builder.append("select wq.*,u.real_name,bj.BJ_XQ from HQ_WX_QD wq LEFT JOIN  ORG_USER u on wq.HQ_WX_RY_ID=u.ID ");
		builder.append(" LEFT JOIN HQ_QD_BJ bj ON bj.ID=wq.HQ_WX_QD_ID ");
		builder.append(" where wq.HQ_USER_ID='"+id+"'  ");
		if(!status.equals("0")) {
			builder.append("  and  wq.hq_wx_status='"+status+"' ");
		}
		builder.append(" order by wq.HQ_BX_RQ desc ");
		PageModel<Map<String,Object>> pagemodel=null;
		pagemodel=this.queryForPageBySqlForBean(builder+"", currentPage, pageSize);
		Integer count = findCountById(id);
		System.out.println("总数"+count);
		pagemodel.setTotalCount(count);
		if (pagemodel==null) {
			return null;
		}
		return pagemodel;
	}

	@Override
	public Integer findCountById(String id) {
		StringBuilder builder1=new StringBuilder();
		builder1.append("select count(*) from HQ_WX_QD wq LEFT JOIN  ORG_USER u on wq.HQ_WX_RY_ID=u.ID LEFT JOIN HQ_QD_BJ bj ON bj.ID=wq.HQ_WX_QD_ID where wq.HQ_USER_ID=?1");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("1",id);
		Integer count=this.queryCountBySql(builder1+"",params);
		return count;
	}
	
	
	

	//添加报修信息

	@Override
	public int insertHqWxQd(HqWxQd hq) {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder();
		builder.append("insert into Hq_Wx_Qd(HQ_WX_QD_ID,HQ_USER_ID,HQ_XM_FL,HQ_WX_DH,HQ_WX_RQ,HQ_WX_GZTP,HQ_WX_GZMS,HQ_WX_ADD,HQ_BX_RQ,HQ_WX_STATUS)values(sys_guid(),?,?,?,?,?,?,?,?,?)");	
		List params = new ArrayList();
        params.add(hq.getHQ_USER_ID());
        params.add(hq.getHQ_XM_FL());
        params.add(hq.getHQ_WX_DH());
        params.add(hq.getHQ_WX_RQ());
        params.add(hq.getHQ_WX_GZTP());
        params.add(hq.getHQ_WX_GZMS());
        params.add(hq.getHQ_WX_ADD());
        params.add(new Date());
        params.add(hq.getHQ_WX_STATUS());
   
        int i=executeSql(builder.toString(),params);
        
        return i;
	}
	
	/**
	 * 查询维修员是否可以接单
	 * @param hq
	 */
	@Override
	public Integer insertHqWxJd(String hq,String date) {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder();
		List params = new ArrayList();
		
		builder.append("SELECT count(u.id) FROM org_user u " + 
				"    LEFT JOIN Hq_User_Xq uxq  ON uxq.user_id = u.id  LEFT JOIN" + 
				"    Hq_Wx_Date wxd  ON wxd.hq_wx_ry_id = u.id   WHERE " + 
				"    u.type = 3 AND (( wxd.hq_wx_rq = to_date ('"+date+"','yyyy-MM-dd' ) " + 
				"   AND wxd.hq_user_work < uxq.hq_user_maxwork " + 
				"  )OR wxd.hq_wx_rq IS NULL) AND  uxq.HQ_USER_GZXM LIKE '%"+hq+"%'");
		
		Integer i=this.executeSql(builder.toString(), params);
		return i;
	}
	
	public int insertPingjia(String id,String grade, String pinr,String status) {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder();
		builder.append("update HQ_WX_QD set HQ_WX_PJDJ=?,HQ_USER_PJNR=?,HQ_WX_STATUS=? where HQ_WX_QD_ID=?");
		List params = new ArrayList();
		params.add(grade);
	    params.add(pinr);
	    params.add(status);
	    params.add(id);
		int i=executeSql(builder.toString(),params);
		return i;
	}

	/*
	* 添加清单的维修人员id，和管理人员id
	* */
	@Override
	public int insertQD(String GLYID,String WXRYID,String QDID) {
		StringBuilder builder=new StringBuilder();
		/*builder.append("Update HQ_WX_QD t Set t.Hq_Gly_Ry_Id='"+GLYID+"',t.hq_wx_ry_id='"+WXRYID+"' Where t.hq_wx_qd_id='"+QDID+"'");*/
		builder.append("Update HQ_WX_QD t Set t.Hq_Gly_Ry_Id=?,t.hq_wx_ry_id=? Where t.hq_wx_qd_id=?");
		List params = new ArrayList();
		params.add(GLYID);
		params.add(WXRYID);
		params.add(QDID);
		 int i  =executeSql(builder.toString(),params);
		 return  i;
	}


	/**
	 * 查询每种状态的数量
	 */
	@Override
	public List<Map<String, Object>> findCountStatus(String id) {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder();
		builder.append("select HQ_WX_STATUS,count(HQ_WX_STATUS) count from HQ_WX_QD student  where HQ_USER_ID='"+id+"' group by HQ_WX_STATUS");
		List<Map<String, Object>> listmap=this.querySqlObjectsForBean(builder+"");
		if(listmap==null) {
			return null;
		}
		return listmap;
	}
	
	
	/**
	 * 修改状态信息
	 */
	@Override
	public int UpdateStatus(String id, String status) {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder();
		builder.append("update HQ_WX_QD set HQ_WX_STATUS=? where HQ_WX_QD_ID=?");
		List<Object> list = new ArrayList<>();
		list.add(status);
		list.add(id);
		int i=executeSql(builder.toString(),list);
		return i;
	}

	
	


	
}
