package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwBjBzDaoPlus;
import com.dzqc.campus.entity.HqHwBjBz;
import com.dzqc.campus.entity.HqHwLx;

public class HqHwBjBzDaoImpl extends CustomBaseSqlDaoImpl implements HqHwBjBzDaoPlus {

	@Override
	public PageModel<Map<String,Object>> findBjBzList(String mc,String lx,Integer currentPage, Integer pageSize) {
		StringBuilder builder=new StringBuilder();
		builder.append("select w.bjBzId, w.bjBzName,w.bjBzXq,l.Type from HqHwBjBz w,HqHwLx l where w.hwLxId=l.Id and w.status=0 and l.Status=0");
		if(!StringUtils.isEmpty(mc)) {
			builder.append(" and w.bjBzName like '%").append(mc).append("%'");
		}
		if(!StringUtils.isEmpty(lx)) {
			builder.append(" and l.Type like '%").append(lx).append("%'");
		}
		PageModel<Map<String,Object>> list = this.queryForPage(builder.toString(), currentPage, pageSize);
		return list;
	}
	@Override
	public List<HqHwLx> findHwLxList() {
		StringBuilder builder=new StringBuilder();
		builder.append("select l from HqHwLx l where l.Status=0");
		List<HqHwLx> lx=this.queryForList(builder.toString());
		if (lx==null||lx.size()<1) {
			return null;
		}
		return lx;
	}
	@Override
	public int insertBjBz(HqHwBjBz hqHwBjBz){
		String sql="insert into Hq_Hw_BjBz(HQ_HW_BJBZ_ID,HQ_HW_BJBZ_NAME,HQ_HW_BJBZ_XQ,HQ_HW_HWLX_ID,STATUS) values(SYS_GUID(),?,?,?,?)";
		List<Object> param=new ArrayList<Object>();
		param.add(hqHwBjBz.getBjBzName());
		param.add(hqHwBjBz.getBjBzXq());
		param.add(hqHwBjBz.getHwLxId());
		param.add(hqHwBjBz.getStatus());
		return executeSql(sql, param);
	}

	@Override
	public int UpdateBjBz(String id, String mc, String xq,String hwId) {
		// TODO Auto-generated method stub
		String sql="update Hq_Hw_BjBz t set t.HQ_HW_BJBZ_NAME=?,t.HQ_HW_BJBZ_XQ=?,t.HQ_HW_HWLX_ID=? where t.HQ_HW_BJBZ_ID=?";
		List<Object> param=new ArrayList<Object>();
		param.add(mc);
		param.add(xq);
		param.add(hwId);
		param.add(id);
		return executeSql(sql, param);
	}


	@Override
	public int DeleteBjBz(String id) {
		// TODO Auto-generated method stub
		String sql = "update Hq_Hw_BjBz s set status=1 where s.HQ_HW_BJBZ_ID=?";
		List<Object> bjbzid = new ArrayList<Object>();
		bjbzid.add(id);
		return executeSql(sql, bjbzid);
	}
	
	
	
}
