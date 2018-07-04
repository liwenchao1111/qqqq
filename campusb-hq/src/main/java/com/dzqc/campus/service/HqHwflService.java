package com.dzqc.campus.service;

import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;import com.dzqc.campus.entity.HqHwHwfl;
import com.dzqc.campus.org.entity.Role;
import com.dzqc.campus.org.entity.User;

public interface HqHwflService {
	
	
PageModel<Map<String, Object>> findUserListbyType(String hwid, Integer currentPage,Integer pageSize);
	
	
	Integer insertHqHwfl(String hwname);
	
	Integer AdminUpdateFl(String hwname);
	
	Integer DeletehqhwUser(String id);
	
	Role findhwname(String username);

	PageModel<Map<String, Object>> findUserListbyType(String hwid, String hwname);


	Integer UpdateHqHwHwfl(String hwid, String hQ_HW_FLNAME);



//添加
	int getHqHwflAdd(HqHwHwfl hqhw);


	


}
