package com.dzqc.campus.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.dao.HqFSxmDaoPlus;
import com.dzqc.campus.entity.HqSxm;

public class HqFSxmDaoImpl extends CustomBaseSqlDaoImpl implements HqFSxmDaoPlus{
	@Override
	public Integer insertWXXM(String xmname) {
		String sql ="insert into Hq_Fxm(hq_fxm_id,Hq_fxm_mc,hq_fxm_ct,hq_fxm_cjr,hq_Fxm_ut,hq_fxm_xgr)values(SYS_GUID(),?,to_date(?,'yyyy-mm-dd'),?,to_date(?,'yyyy-mm-dd'),?)";
		List<Object> fxm = new ArrayList<Object>();
		SimpleDateFormat simpl = new SimpleDateFormat("yyyy-MM-dd");
		String ftime = simpl.format(new Date());
		fxm.add(xmname);
		fxm.add(ftime);
		fxm.add("testadmin");  //创建人
		fxm.add(ftime);
		fxm.add("testadmin");  //修改人
		return executeSql(sql,fxm);
	}
	@Override
	public Integer insertSWXXM(String xmname,String sid) {
		String sql = "insert into Hq_Sxm(HQ_SXM_ID,HQ_SXM_FXM_ID,Hq_sxm_mc,hq_sxm_ct,hq_sxm_cjr,hq_sxm_ut,hq_sxm_xgr)values(SYS_GUID(),?,?,to_date(?,'yyyy/mm/dd'),?,to_date(?,'yyyy/mm/dd'),?)";
		List<Object> sxm = new ArrayList<Object>();
		SimpleDateFormat simpl = new SimpleDateFormat("yyyy-MM-dd");
		String stime = simpl.format(new Date());
		sxm.add(sid);
		sxm.add(xmname);
		sxm.add(stime);
		sxm.add("testadmin");
		sxm.add(stime);
		sxm.add("testadmin");
		return executeSql(sql, sxm);
	}
	@Override
	public List<HqSxm> selectSxm() {
		StringBuilder builder=new StringBuilder();
		builder.append("select s from HqSxm s ORDER BY s.HQ_SXM_CT");
		List<HqSxm> sgzxm = this.queryForList(builder.toString());
		return sgzxm;
	}
	@Override
	public Integer UpdateWXXM(String Hq_fxm_mc,String fid) {
		String sql = "update Hq_Fxm set Hq_fxm_mc=? where hq_fxm_id=?";
		List<Object> fxm = new ArrayList<Object>();
		fxm.add(Hq_fxm_mc);
		fxm.add(fid);
		return executeSql(sql,fxm);
	}
	@Override
	public Integer UpdateSWXXM(String HQ_SXM_MC,String sid) {
		String sql = "update Hq_Sxm set HQ_SXM_MC=? where HQ_SXM_ID=?";
		List<Object> sxm = new ArrayList<Object>();
		sxm.add(HQ_SXM_MC);
		sxm.add(sid);
		return executeSql(sql,sxm);
	}
}
