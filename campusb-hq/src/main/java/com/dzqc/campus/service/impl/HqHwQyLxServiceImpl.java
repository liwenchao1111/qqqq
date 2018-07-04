package com.dzqc.campus.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwQyLxDao;
import com.dzqc.campus.entity.HqHwLx;
import com.dzqc.campus.service.HqHwQyLxService;
@Service
public class HqHwQyLxServiceImpl implements HqHwQyLxService{
	@Autowired
	private HqHwQyLxDao hqHwQyLxDao;
	
	
	//接收数据库数据
	@Override
	public PageModel query(Integer currentPage,Integer pageSize) {
		return hqHwQyLxDao.query(currentPage, pageSize);
	}


	//根据类型名称查询数据
	@Override
	public PageModel findBytype(String typeNames,Integer currentPage,Integer pageSize) {
		// TODO Auto-generated method stub
		 return hqHwQyLxDao.findBytype(typeNames, currentPage, pageSize);
	}


	//添加类型
	@Override
	public void addType(Integer id, String typeName, String Comment) {
		// TODO Auto-generated method stub
		hqHwQyLxDao.addType(id, typeName, Comment);
	}


	@Override
	public List<HqHwLx> queryList() {
		
		return hqHwQyLxDao.queryList();
	}

}
