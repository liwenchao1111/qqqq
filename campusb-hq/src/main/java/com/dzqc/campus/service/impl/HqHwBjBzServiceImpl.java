package com.dzqc.campus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwBjBzDao;
import com.dzqc.campus.entity.HqHwBjBz;
import com.dzqc.campus.entity.HqHwLx;
import com.dzqc.campus.service.HqHwBjBzService;

@Service
public class HqHwBjBzServiceImpl implements HqHwBjBzService{
	@Autowired
	private HqHwBjBzDao bjBzDao;
	@Override
	public PageModel<Map<String, Object>> findBjBzList(String mc, String lx, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		return bjBzDao.findBjBzList(mc, lx, currentPage, pageSize);
	}
	@Override
	public List<HqHwLx> findHwLxList() {
		// TODO Auto-generated method stub
		return bjBzDao.findHwLxList();
	}
	@Override
	public int insertBjBz(HqHwBjBz hqHwBjBz) {
		// TODO Auto-generated method stub
		return bjBzDao.insertBjBz(hqHwBjBz);
	}
	@Override
	public int DeleteBjBz(String id) {
		// TODO Auto-generated method stub
		return bjBzDao.DeleteBjBz(id);
	}
	@Override
	public int UpdateBjBz(String id, String mc, String xq, String hwId) {
		// TODO Auto-generated method stub
		return bjBzDao.UpdateBjBz(id, mc, xq, hwId);
	}

	
}
