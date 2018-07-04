package com.dzqc.campus.dao.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqRepairXqDaoPlus;
import com.dzqc.campus.org.entity.User;

public class HqRepairXqDaoImpl extends CustomBaseSqlDaoImpl implements HqRepairXqDaoPlus {

	
	/**
	 * 根据用户信息查询分页信息
	 * @param userQueryDTO
	 * @return
	 */
	
	@Override
	public PageModel queryRepairPageByUserName(String id,Integer currentPage,Integer pageSize,String state) {
		StringBuilder builder=new StringBuilder();
		System.out.println("dao:"+state);
		if(state.equals("0")) {
			builder.append("select hwq.*,haw.hq_wx_ap_k_time,haw.hq_wx_ap_g_time,ou.real_name from HQ_AP_WX haw,Hq_Wx_Qd hwq,Org_User ou where hwq.hq_wx_qd_id=haw.hq_wx_qd_id and hwq.hq_user_id=ou.id and hwq.hq_wx_ry_id="+"'"+id+"'"+"order by hwq.HQ_BX_RQ DESC");
		}else if(state.equals("5")) {
			builder.append("select hwq.*,haw.hq_wx_ap_k_time,haw.hq_wx_ap_g_time,ou.real_name from HQ_AP_WX haw,Hq_Wx_Qd hwq,Org_User ou where (hwq.hq_wx_qd_id=haw.hq_wx_qd_id and hwq.hq_user_id=ou.id and hwq.hq_wx_ry_id="+"'"+id+"'"+" and hwq.hq_wx_status="+"'"+state+"'"+") or (hwq.hq_wx_qd_id=haw.hq_wx_qd_id and hwq.hq_user_id=ou.id and hwq.hq_wx_ry_id="+"'"+id+"'"+" and hwq.hq_wx_status='6')   order by hwq.HQ_BX_RQ DESC");
		}
		else {
			builder.append("select hwq.*,haw.hq_wx_ap_k_time,haw.hq_wx_ap_g_time,ou.real_name from HQ_AP_WX haw,Hq_Wx_Qd hwq,Org_User ou where hwq.hq_wx_qd_id=haw.hq_wx_qd_id and hwq.hq_user_id=ou.id and hwq.hq_wx_ry_id="+"'"+id+"'"+" and hwq.hq_wx_status="+"'"+state+"'"+"order by hwq.HQ_BX_RQ DESC");
		}
		PageModel list = this.queryForPageBySql(builder.toString(), currentPage, pageSize);
		return list;
	}


	/**
	 * 根据清单id查询清单详情
	 * @param id
	 * @return
	 */
	@Override

	public Map<String, Object> queryRepair(String id) {
		String sql="select hwq.*,haw.hq_wx_ap_k_time,haw.hq_wx_ap_g_time,ou.real_name from HQ_AP_WX haw,Hq_Wx_Qd hwq,Org_User ou where hwq.hq_wx_qd_id=haw.hq_wx_qd_id and hwq.hq_user_id=ou.id and hwq.hq_wx_qd_id=?";
		List<Object> params=new ArrayList<>();
		params.add(id);
		List<Map<String, Object>> list=this.querySqlObjects(sql, params);
		if(list==null||list.size()<1) {
			return null;
		}
		return list.get(0);
	}


	/**
	 * 更改接单状态待受理为已接单
	 */
	public void update(String qd_id) {
		// 通过HQ_WX_QD_ID更改HQ_WX_STATUS状态
		String sql = "update HqWxQd set HQ_WX_STATUS = 3 where HQ_WX_QD_ID='"+qd_id+"'";
		this.executeCustomSql(sql);
	}

	/**
	 * 更改接单状态待受理为拒单
	 */
	@Override
	public void rejectToOrder(String wx_ry_id, String qd_id) {
		//转换格式为"yyyy-MM-dd hh:mm:ss"
		SimpleDateFormat simpl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//获取时间信息
		String time = simpl.format(new Date());
		List<Object> params=new ArrayList<>();
		//通过HQ_WX_QD_ID更改HQ_WX_STATUS状态
		System.out.println("1.qd_id="+qd_id);
		System.out.println("2.wx_ry_id="+wx_ry_id);
		String updatesql = "update HqWxQd set HQ_WX_STATUS = 7 where HQ_WX_QD_ID='"+qd_id+"'";
		
		
		//hql
		//String insertsql = "insert into HqQdBj(ID,HQ_USER_ID,QD_BJ_SJ,STATUS,HQ_QD_ID) values(SYS_GUID(),'"+wx_ry_id+"',to_date('"+time+"','yyyy-MM-dd HH24:mi:ss'),1,'"+qd_id+"')";
		
		String update2sql = "update HqWxQd set HQ_WX_BJCS = (HQ_WX_BJCS+1)  where HQ_WX_QD_ID='"+qd_id+"'";
		
		String updateQD_id = "update HqWxQd set HQ_WX_RY_ID = null where HQ_WX_QD_ID='"+qd_id+"'";
		//sql
		String insertsql = "insert into HQ_QD_BJ(ID,HQ_USER_ID,QD_BJ_SJ,STATUS,HQ_QD_ID) values(SYS_GUID(),?,to_date(?,'yyyy-MM-dd HH24:mi:ss'),?,?)";
		//executeCustomSql执行sql语句
		params.add(wx_ry_id);
		params.add(time);
		params.add(1);
		params.add(qd_id);
		this.executeCustomSql(updatesql);
		this.executeSql(insertsql,params);
		this.executeCustomSql(update2sql);
		this.executeCustomSql(updateQD_id);
	}
	
	/**
	 * 根据id查管理员
	 * @param id
	 * @return
	 */
	@Override
	public Map<String, Object> findUserbyId(String id) {
		String sql="select * from Org_User d where d.id=?";
		List<Object> params=new ArrayList<>();
		params.add(id);
		List<Map<String, Object>> list=this.querySqlObjects(sql, params);
		if(list==null||list.size()<1) {
			return null;
		}
		return list.get(0);
	}


	/**
	 * 更改接单状态已接单为维修中
	 * @param id
	 */
	@Override
	public void update1(String id) {
		String sql = "update HqWxQd set HQ_WX_STATUS='4' where HQ_WX_QD_ID="+"'"+id+"'";
		this.executeCustomSql(sql);
		
	}








	/**
	 * 更改接单状态维修中为已结束
	 * @param id
	 */
	@Override
	public void update2(String id) {
		String sql = "update HqWxQd set HQ_WX_STATUS='5' where HQ_WX_QD_ID="+"'"+id+"'";
		this.executeCustomSql(sql);
	}



	/**
	 * 查询总数
	 * @param state
	 * @param id
	 * @return
	 */

	@Override
	public Integer count(String state,String id) {
		StringBuilder sql=new StringBuilder();
		System.out.println("总数22222222222："+state);
		if(state.equals("0")){
			sql.append("select count(*) from HQ_WX_QD s where s.hq_wx_ry_id="+"'"+id+"'");
		}else if(state.equals("5")) {
			sql.append("select count(*) from HQ_WX_QD s where (s.hq_wx_ry_id="+"'"+id+"'"+" and s.hq_wx_status="+"'"+state+"'"+") or (s.hq_wx_ry_id="+"'"+id+"'"+" and s.hq_wx_status='6')");
		}else {
			sql.append("select count(*) from HQ_WX_QD s where s.hq_wx_ry_id="+"'"+id+"'"+"and s.hq_wx_status="+"'"+state+"'");
		}
		return this.querySingleResult(sql.toString());
	}
	








	




}
