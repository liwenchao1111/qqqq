package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwFqyglDaoPlus;
import com.dzqc.campus.entity.HqHwFqygl;


public class HqHwFqyglDaoImpl extends CustomBaseSqlDaoImpl implements HqHwFqyglDaoPlus{
	@Override
	public PageModel<Map<String,Object>> findFqygl(String name,Integer currentPage, Integer pageSize) {
		StringBuilder builder=new StringBuilder();
		builder.append("select f.hq_hw_fqyid id,f.hq_hw_fqyname fname,(select count(z.hw_zqy_id) from HQ_HW_ZQYGL z where z.status=0 and z.hw_fqy_id=f.hq_hw_fqyid group by z.hw_fqy_id) count from HQ_HW_FQYGL f where f.status=0");
		if(!StringUtils.isEmpty(name)) {
			builder.append(" and f.hq_hw_fqyname like '%").append(name).append("%'");
		}
		PageModel<Map<String,Object>> list = this.queryForPageBySql(builder.toString(), currentPage, pageSize);
		return list;
	}
	@Override
	public Integer addfqy(HqHwFqygl fqy) {
		String sql ="insert into HQ_HW_FQYGL(HQ_HW_FQYID,HQ_HW_FQYNAME,STATUS)values(SYS_GUID(),?,?)";
		List<Object> fqyxq = new ArrayList<Object>();
		fqyxq.add(fqy.getFname());
		fqyxq.add(fqy.getStatus());
		return this.executeSql(sql, fqyxq);
	}
	@Override
	public Integer updatefqy(String id,String fname) {
		String sql = "update HQ_HW_FQYGL set HQ_HW_FQYNAME = ? where HQ_HW_FQYID=?";
		List<Object> newfqy = new ArrayList<Object>();
		newfqy.add(fname);
		newfqy.add(id);
		return executeSql(sql,newfqy);
	}
	@Override
	public Integer deletefqy(String id) {
		String sql = "update HQ_HW_FQYGL set STATUS=1 where HQ_HW_FQYID=?";
		List<Object> fqyid = new ArrayList<Object>();
		fqyid.add(id);
		return executeSql(sql, fqyid);
	}
	@Override
	public List<HqHwFqygl> findList() {
		StringBuilder builder=new StringBuilder();
		builder.append("Select fgl from HqHwFqygl fgl where fgl.status=0");
		List<HqHwFqygl> list = this.queryForList(builder.toString());
		return list;
	}
	
	@Override
	public List<Map<String, Object>> getfzr(String id) {
		String sql="select s.hq_sanitationman_id,s.hq_sanitationman_name from HQ_HW_FZR f,HQ_SANITATIONMAN_MESSAGE s where s.hq_sanitationman_id=f.hq_hw_fzr_id and f.status=0 and s.status=0 and f.hq_hw_zqygl_id="+"'"+id+"'";
		return this.querySqlObjects(sql);
	}
}
