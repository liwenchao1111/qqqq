package com.dzqc.campus.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwFqyglDao;
import com.dzqc.campus.entity.HqHwFqygl;
import com.dzqc.campus.service.HqHwFqyglService;

@Service
public class HqHwFqyglServiceImpl implements HqHwFqyglService{
	@Autowired
	private HqHwFqyglDao fqyDao;

	@Override
	public PageModel<Map<String, Object>> findFqygl(String name, Integer currentPage, Integer pageSize) {
		return fqyDao.findFqygl(name,currentPage, pageSize);
	}

	@Override
	public Integer addfqy(HqHwFqygl fqy) {
		return fqyDao.addfqy(fqy);
	}

	@Override
	public Integer updatefqy(String id, String fname) {
		return fqyDao.updatefqy(id, fname);
	}

	@Override
	public Integer deletefqy(String id) {
		return fqyDao.deletefqy(id);
	}

	@Override
	public List<HqHwFqygl> findAll() {
		return fqyDao.findList();
	}

	@Override
	public List<HqHwFqygl> findList() {
		// TODO Auto-generated method stub
		return fqyDao.findList();
	}
}
