package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwFqyDaoPlus;
import com.dzqc.campus.entity.HqHwFqy;

public class HqHwFqyDaoImpl extends CustomBaseSqlDaoImpl implements HqHwFqyDaoPlus{
	@Override
	public PageModel<Map<String,Object>> findHwqy(String name,Integer currentPage, Integer pageSize) {
		StringBuilder builder=new StringBuilder();
		builder.append("select f.*,fgl.hq_hw_fqyname from HQ_HW_FQY f,HQ_HW_FQYGL fgl where f.hw_fqy_id=fgl.hq_hw_fqyid and f.status=0 and fgl.status=0");
		if(!StringUtils.isEmpty(name)) {
			builder.append(" and fgl.hq_hw_fqyname like '%").append(name).append("%'");
		}
		PageModel<Map<String,Object>> list = this.queryForPageBySql(builder.toString(), currentPage, pageSize);
		return list;
	}
	@Override
	public Integer addHwqy(HqHwFqy hwqy,String id) {
		String sql ="insert into HQ_HW_FQY(HW_ID,HW_FQY_ID,HW_JCGZ,HW_WYFL,HW_GLFL,HW_GZYS,STATUS)values(SYS_GUID(),?,?,?,?,?,?)";
		List<Object> hwqyxq = new ArrayList<Object>();
		hwqyxq.add(id);
		hwqyxq.add(hwqy.getHwJcgz());
		hwqyxq.add(hwqy.getHwWyfl());
		hwqyxq.add(hwqy.getHwGlfl());
		hwqyxq.add(hwqy.getHwGzys());
		hwqyxq.add(hwqy.getStatus());
		return this.executeSql(sql, hwqyxq);
	}
	@Override
	public Integer updateHwqy(String hwid,String jcgz,String wyfl,String glfl,String gzys,String fqyid) {
		String sql = "update HQ_HW_FQY f set f.hw_fqy_id = ?,f.hw_jcgz=?,f.hw_wyfl=?,f.hw_glfl=?,f.hw_gzys=? where HW_ID=?";
		List<Object> newHwqy = new ArrayList<Object>();
		newHwqy.add(fqyid);
		newHwqy.add(jcgz);
		newHwqy.add(wyfl);
		newHwqy.add(glfl);
		newHwqy.add(gzys);
		newHwqy.add(hwid);
		return executeSql(sql,newHwqy);
	}
	@Override
	public Integer deleteHwqy(String id) {
		String sql = "update HQ_HW_FQY set STATUS=1 where HW_ID=?";
		List<Object> hwqyid = new ArrayList<Object>();
		hwqyid.add(id);
		return executeSql(sql, hwqyid);
	}
}
