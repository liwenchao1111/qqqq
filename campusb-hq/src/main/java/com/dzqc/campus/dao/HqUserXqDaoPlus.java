package com.dzqc.campus.dao;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqFxm;
import com.dzqc.campus.entity.HqUserXq;

public interface HqUserXqDaoPlus {

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
	
	/**
	 * 查询后勤管理员信息
	 * @param name 根据模糊查询
	 * @param xm   根据工作项目（xm）查询
	 * @param pageSize 每页条数
	 * @param currentPage 当前页数
	 * @return
	 */
	PageModel<Map<String, Object>> findAdminListbyType(String name,Integer pageSize,Integer currentPage);
	/**
	 * 查询下拉列表框模糊查询要用到的所有工作项目父级名称
	 * @return
	 */

	Integer insertGZXM(HqUserXq hqu);
	
	
	Integer AdminUpdateUser(String mobile, String id);
	
	Integer AdminUpdatePwd(String id);
	
	Integer AdminDeleteUser(String id);
	
	Integer findUserName(String username);
	
	Integer findGh(String gh);

	Integer findUserMobile(String mobile);

	
}
