package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HwZqyglDaoPlus;
import com.dzqc.campus.entity.HqHwFqygl;
import com.dzqc.campus.entity.HqHwZqyGL;

public class HwZqyglDaoImpl extends CustomBaseSqlDaoImpl implements HwZqyglDaoPlus{

	@Override
	public PageModel<Map<String, Object>> findZqygl(String name,Integer bm,String fqy, Integer currentPage, Integer pageSize) {
		StringBuilder builder=new StringBuilder();
		builder.append("SELECT HW_ZQY_ID,HW_ZQY_CODE,HW_ZQY_NAME,HQ_HW_FQYNAME from HQ_HW_ZQYGL,HQ_HW_FQYGL WHERE HW_FQY_ID = HQ_HW_FQYID AND HQ_HW_ZQYGL.STATUS = 0 ");
		if(!StringUtils.isEmpty(name)) {
			builder.append(" and hw_zqy_name like '%").append(name).append("%'");
		}
	   if(bm!=null) {
		   builder.append(" and hw_zqy_code like '%").append(bm).append("%'");
	   }
	   if(!StringUtils.isEmpty(fqy)) {
		   builder.append(" and hq_hw_fqyname like '%").append(fqy).append("%'");
	   }
		PageModel<Map<String,Object>> list = this.queryForPageBySql(builder.toString(), currentPage, pageSize);
		return list;
	}

	@Override
	public Integer addzqy(HqHwZqyGL zqy) {
		String sql = "insert into HQ_HW_ZQYGL(HW_ZQY_ID,HW_ZQY_NAME,HW_FQY_ID,HW_ZQY_CODE,STATUS)values(SYS_GUID(),?,?,HW_ZQY_CODE.nextval,?)";
		List<Object> zqyxq = new ArrayList<Object>();
		zqyxq.add(zqy.getHW_ZQY_NAME());
		zqyxq.add(zqy.getHW_FQY_ID());
		zqyxq.add(zqy.getSTATUS());
		return this.executeSql(sql, zqyxq);
		
	}

	@Override
	public Integer deletezqy(String id) {
		String sql = "update HQ_HW_ZQYGL set STATUS=1 where HW_FQY_ID=?";
		List<Object> zqyid = new ArrayList<Object>();
		zqyid.add(id);
		return executeSql(sql, zqyid);
	}

	@Override
	public Integer updatezqy(String id,String zname,String fid) {
		String sql = "update HQ_HW_ZQYGL set HW_ZQY_NAME = ? ,HW_FQY_ID = ? WHERE HW_ZQY_ID = ?";
		List<Object> change = new ArrayList<Object>();
		change.add(zname);
		change.add(fid);
		change.add(id);
		
		return executeSql(sql, change);
	}

	@Override
	public List<HqHwZqyGL> fuqy(String id) {
		StringBuilder builder = new StringBuilder();
		builder.append("select z.HW_ZQY_NAME,z.HW_ZQY_ID from HQ_HW_ZQYGL z where  STATUS = 0 and z.HW_FQY_ID='"+id+"'");
		List<HqHwZqyGL> list = this.queryForList(builder.toString());
		return list;
	}

	/**
	 * 查询所有父区域
	 */
	public List<Map<String, Object>> list(String id){
		String sql="select z.HW_ZQY_NAME,z.HW_ZQY_ID from HQ_HW_ZQYGL z where  STATUS = 0 and z.HW_FQY_ID='"+id+"'";
		return this.querySqlObjects(sql);
	}
	
	

}
