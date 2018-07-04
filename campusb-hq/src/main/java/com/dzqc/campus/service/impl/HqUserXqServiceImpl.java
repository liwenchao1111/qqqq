package com.dzqc.campus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqUserXqDao;
import com.dzqc.campus.entity.HqFxm;
import com.dzqc.campus.entity.HqUserXq;
import com.dzqc.campus.org.entity.User;
import com.dzqc.campus.service.HqUserXqService;

@Service
public class HqUserXqServiceImpl implements HqUserXqService{
	
	@Autowired
	private HqUserXqDao huxDao;


	@Override
	public PageModel<Map<String, Object>> findUserListbyType(String name,String xm,Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		return huxDao.findUserListbyType(name,xm,currentPage,pageSize);
	}

	@Override
	public List<HqFxm> findGZXMList() {
		// TODO Auto-generated method stub
		return huxDao.findGZXMList();
	}

	@Override
	public int insertHqUserXq(HqUserXq hqUserXq) {
		// TODO Auto-generated method stub
		return huxDao.insertHqUserXq(hqUserXq);
	}


	@Override
	public int UpdateHqUserXq(String id,String gzxm) {
		// TODO Auto-generated method stub
		return huxDao.UpdateHqUserXq(id,gzxm);
	}


	@Override
	public int UpdateUserXq(String id,String moblie) {
		// TODO Auto-generated method stub
		return huxDao.UpdateUserXq(id,moblie);
	}


	@Override
	public int UpdateUserPassWord(String id) {
		// TODO Auto-generated method stub
		return huxDao.UpdateUserPassWord(id);
	}


	@Override
	public Integer DeleteUser(String id) {
		// TODO Auto-generated method stub
		return huxDao.DeleteUser(id);
	}
	@Override
	public HqUserXq findUserXqByUserId(String id) {
		
		return huxDao.findUserXqByUserId(id);
	}

	@Override
	public Integer UpdatePwd(String id) {
		return huxDao.UpdatePwd(id);
	}

	@Override
	public Integer UpdateUser(String mobile, String id) {
		return huxDao.UpdateUser(mobile, id);
	}

	@Override
	public PageModel findStuListbyType(String realname, String username, Integer currentPage, Integer pageSize) {
		return huxDao.findStuListbyType(realname, username, currentPage, pageSize);
	}
	
	@Override
	public PageModel<Map<String, Object>> findAdminListbyType(String name, Integer pageSize,Integer currentPage) {
		return huxDao.findAdminListbyType(name,pageSize,currentPage);
	}

	@Override
	public Integer insertGZXM(HqUserXq hqu) {
		return huxDao.insertGZXM(hqu);
	} 
	@Override
	public Integer AdminUpdateUser(String mobile,String id) {
		return huxDao.AdminUpdateUser(mobile,id);
	}

	@Override
	public Integer AdminUpdatePwd(String id) {
		return huxDao.AdminUpdatePwd(id);
	}

	@Override
	public Integer AdminDeleteUser(String id) {
		return huxDao.AdminDeleteUser(id);
	}
	@Override
	public Integer findUserName(String username) {
		return huxDao.findUserName(username);
	}
	@Override
	public Integer findGh(String gh) {
		return huxDao.findGh(gh);
	}

	@Override
	public Integer findUserMobile(String mobile) {
		// TODO Auto-generated method stub
		return huxDao.findUserMobile(mobile);
	}

	

}
