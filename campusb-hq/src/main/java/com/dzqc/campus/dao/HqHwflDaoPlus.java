package com.dzqc.campus.dao;

import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwHwfl;


public interface HqHwflDaoPlus {
	PageModel<Map<String, Object>> findHwflListbyType(String HQ_HW_ID, Integer currentPage, Integer pageSize);
	
	
	Integer AdminUpdateFl(String hwname);


	int insertHqHwHwfl(String hqhwhwfl);


	Integer DeleteHqHwHwfl(String hwid);
	

	int getHqHwflAdd(HqHwHwfl hqhw);

	PageModel<Map<String, Object>> findUserListbyType(String hwid, String hwname);


	Integer UpdateHqHwHwfl(String hwid, String hQ_HW_FLNAME);
}
