package com.dzqc.campus.dao.impl;



import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwGlyXqDaoPlus;
import com.dzqc.campus.entity.HqHwGly;





public class HqHwGlyXqDaoImpl extends CustomBaseSqlDaoImpl implements HqHwGlyXqDaoPlus{
	
	/**
	 * 查询所有的父区域
	 */
	@Override
	public List<Map<String, Object>> findall() {
		String sql="select * from HQ_HW_FQYGL v where v.status=0";
		 
		return this.querySqlObjects(sql);
	}
	
	/**
	 * 查询所有负责人
	 */
	@Override
	public List<Map<String, Object>> findallfzr() {
		String sql="select g.hq_sanitationman_id,g.hq_sanitationman_name from HQ_SANITATIONMAN_MESSAGE g,(select HQ_HW_ID from HQ_HW_HWFL t where t.hq_hw_flname=N'管理员'and t.delete_flag='0') f where g.hq_sanitationman_type=f.hq_hw_id";
		return this.querySqlObjects(sql);
	}
	
	/**
	 * 分页查询管理员
	 */
	@Override
	public PageModel<HqHwGly> hqhwglyall(String fqyid,String glyname, Integer currentPage, Integer pageSize) {
		StringBuffer  buffer=new StringBuffer();
		buffer.append("select v.hq_hw_gly_id, b.hq_hw_fqyname,s.hq_sanitationman_name from HQ_HW_GLY v,HQ_HW_FQYGL b,HQ_SANITATIONMAN_MESSAGE s where b.hq_hw_fqyid=v.hq_hw_gly_fqy and s.hq_sanitationman_id=v.hq_hw_gly_fzr_id and b.status=0 and s.status=0 and v.status=0");
		if(!StringUtils.isEmpty(fqyid)) {
			buffer.append(" and v.hq_hw_gly_fqy= '").append(fqyid).append("'");
		}
		if(!StringUtils.isEmpty(glyname)) {
			buffer.append(" and s.hq_sanitationman_name like  '%").append(glyname).append("%'");
		}
		return this.queryForPageBySql(buffer.toString(), currentPage, pageSize);
	}
	
	/**
	 *  三表查询单个管理员
	 */
	@Override
	public List<Map<String, Object>> getone(String id) {
		String sql="select t.*,g.hq_hw_fqyname,z.hq_sanitationman_name from HQ_HW_GLY t,HQ_HW_FQYGL g,HQ_SANITATIONMAN_MESSAGE z where g.hq_hw_fqyid=t.hq_hw_gly_fqy and z.hq_sanitationman_id=t.hq_hw_gly_fzr_id and  t.hq_hw_gly_id="+"'"+id+"'";
		return this.querySqlObjects(sql);
	}

	

}
