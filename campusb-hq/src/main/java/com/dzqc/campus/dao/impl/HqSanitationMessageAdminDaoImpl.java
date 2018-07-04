package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqSanitationMessageAdminDaoPlus;
import com.dzqc.campus.entity.HqSanitationmanMessage;

public class HqSanitationMessageAdminDaoImpl extends CustomBaseSqlDaoImpl implements HqSanitationMessageAdminDaoPlus {

	@Override
	public HqSanitationmanMessage findHqSanitationMessageById(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from HQ_SANITATIONMAN_MESSAGE  HqSanitationmanMessage where HqSanitationmanMessage.HQ_SANITATIONMAN_ID = ? ";
		if(id!=null && id!="") {
			List<Object> list1 = new ArrayList<>();
			list1.add(id);
			List<HqSanitationmanMessage> list = this.querySqlObjects(sql, list1, HqSanitationmanMessage.class);
			return list.get(0);
		}
		return null;
	}

	@Override
	public PageModel<Map<String, Object>> findHqHwFQyById(String id, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		if(id!=null && id!="" && currentPage!=null && pageSize!=null) {
			StringBuilder builder=new StringBuilder();
			builder.append("select   fqy.*,f.HQ_HW_FQYNAME from HQ_HW_FQY  fqy,(\r\n" + 
					" select HQ_HW_GLY_FQY from HQ_HW_GLY where HQ_HW_GLY_FZR_ID='"+id+"') gly,HQ_HW_FQYGL f\r\n" + 
					" \r\n" + 
					" where fqy.HW_FQY_ID=gly.HQ_HW_GLY_FQY and f.HQ_HW_FQYID=fqy.HW_FQY_ID  and fqy.STATUS=0");
			PageModel<Map<String,Object>> pagemodel=null;
			pagemodel=this.queryForPageBySqlForBean(builder+"", currentPage, pageSize);
			Integer count = findCountById(id);
			System.out.println("总数"+count);
			pagemodel.setTotalCount(count);
			if (pagemodel!=null) {
				return pagemodel;
			}
		}
		return null;
	}

	@Override
	public Integer findCountById(String id) {
		// TODO Auto-generated method stub
		if(id!=null && id!="") {
			StringBuilder builder=new StringBuilder();
			builder.append("select  count(*) from HQ_HW_FQY  fqy,(\r\n" + 
					" select HQ_HW_GLY_FQY from HQ_HW_GLY where HQ_HW_GLY_FZR_ID=?1) gly,HQ_HW_FQYGL f\r\n" + 
					" \r\n" + 
					" where fqy.HW_FQY_ID=gly.HQ_HW_GLY_FQY and f.HQ_HW_FQYID=fqy.HW_FQY_ID");
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("1",id);
			Integer count=this.queryCountBySql(builder+"",params);
		return count;
		}
		return null;
	}

}
