package com.dzqc.campus.service;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqFxm;
import com.dzqc.campus.entity.HqUserXq;

public interface HqUserXqService {
	PageModel<Map<String, Object>> findUserListbyType(String name, String xm, Integer currentPage, Integer pageSize);

	List<HqFxm> findGZXMList();

	int insertHqUserXq(HqUserXq hqUserXq);

	int UpdateHqUserXq(String id, String gzxm);

	int UpdateUserXq(String id, String moblie);

	int UpdateUserPassWord(String id);

	Integer DeleteUser(String id);

	HqUserXq findUserXqByUserId(String id);

	PageModel findStuListbyType(String realname, String username, Integer currentPage, Integer pageSize);

	Integer UpdatePwd(String id);


	Integer UpdateUser(String mobile, String id);
	

	PageModel<Map<String, Object>> findAdminListbyType(String name, Integer pageSize,Integer currentPage);
	

	Integer insertGZXM(HqUserXq hqu);
	
	Integer AdminUpdateUser(String id,String HQ_HW_FLNAME);
	
	
	Integer AdminUpdatePwd(String id);

	Integer AdminDeleteUser(String id);
	
	Integer findUserName(String username);
	
	Integer findGh(String gh);

	Integer findUserMobile(String mobile);
}
