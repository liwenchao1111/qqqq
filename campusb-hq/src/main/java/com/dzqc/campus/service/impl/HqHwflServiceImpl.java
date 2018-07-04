package com.dzqc.campus.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwflDao;
import com.dzqc.campus.entity.HqHwHwfl;
import com.dzqc.campus.org.entity.Role;
import com.dzqc.campus.service.HqHwflService;



@Service
public class HqHwflServiceImpl implements HqHwflService {
	

	@Autowired
	private HqHwflDao HwflDao;

	@Override
	public PageModel<Map<String, Object>> findUserListbyType(String hwid, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		return HwflDao.findHwflListbyType(hwid, currentPage, pageSize);
	}

	@Override
	public Integer insertHqHwfl(String hwname) {
		// TODO Auto-generated method stub
		return HwflDao.insertHqHwHwfl(hwname);
	}

	@Override
	public Integer AdminUpdateFl(String hwname) {
		// TODO Auto-generated method stub
		return HwflDao.AdminUpdateFl(hwname);
	}

	@Override
	public Integer DeletehqhwUser(String id) {
		// TODO Auto-generated method stub
		return HwflDao.DeleteHqHwHwfl(id);
	}


	
	@Override
	public Integer UpdateHqHwHwfl(String hwid, String hQ_HW_FLNAME) {
		// TODO Auto-generated method stub
		return HwflDao.UpdateHqHwHwfl(hwid,hQ_HW_FLNAME);
	}

	@Override
	public Role findhwname(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int getHqHwflAdd(HqHwHwfl hqhw) {
		// TODO Auto-generated method stub
		return HwflDao.getHqHwflAdd(hqhw);
	}

	@Override
	public PageModel<Map<String, Object>> findUserListbyType(String hwid, String hwname) {
		// TODO Auto-generated method stub
		return HwflDao.findUserListbyType(hwid,hwname);
	}

	


	
	
	
	

}
