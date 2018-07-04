package com.dzqc.campus.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.dao.HqHwZsytsDao;
import com.dzqc.campus.entity.HqHwZqyGL;
import com.dzqc.campus.entity.HqHwZsyts;
import com.dzqc.campus.entity.HqSanitationmanMessage;
import com.dzqc.campus.service.HqHwZsytsService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import com.dzqc.campus.common.entity.PageModel;
@Service
public class HqHwZsytsServiceImpl implements HqHwZsytsService{
	
	@Autowired
	private HqHwZsytsDao hqHwZsytsDao;
	
	@Override
	public Integer insert(HqHwZsyts hqHwZsyts) {
		// TODO Auto-generated method stub
		return hqHwZsytsDao.insert(hqHwZsyts);
	}
	@Autowired
	private HqHwZsytsDao zsytsDao ;
	
	@Override
	public PageModel<Map<String, Object>> findZsyts(HttpServletRequest request,String id,String fqyname,String zqyname,Integer currentPage, Integer pageSize) {
		return zsytsDao.findZsyts(request,id,fqyname,zqyname,currentPage, pageSize);
	}


	@Override
	public List<HqHwZqyGL> findHqHwZqyGLList(String id) {
		// TODO Auto-generated method stub
		return hqHwZsytsDao.findHqHwZqyGLList(id);
	}


	@Override
	public List<String> findHqHwFZR(String id, String ids) {
		// TODO Auto-generated method stub
		return hqHwZsytsDao.findHqHwFZR(id, ids);
	}


	@Override
	public List<HqSanitationmanMessage> findHqSan(String id) {
		// TODO Auto-generated method stub
		return hqHwZsytsDao.findHqSan(id);
	}


	@Override
	public List<String> findHqSans(String fzr) {
		// TODO Auto-generated method stub
		return hqHwZsytsDao.findHqSans(fzr);
	}



}
