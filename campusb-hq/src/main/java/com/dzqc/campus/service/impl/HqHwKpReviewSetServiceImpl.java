package com.dzqc.campus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwKpReviewSetDao;
import com.dzqc.campus.dao.HqHwLxDao;
import com.dzqc.campus.entity.HqHwLx;
import com.dzqc.campus.service.HqHwKpReviewSetService;


@Service
public class HqHwKpReviewSetServiceImpl implements HqHwKpReviewSetService {
	
	@Autowired
	private HqHwKpReviewSetDao hqHwKpReviewSetdao;
	
	@Autowired
	private HqHwLxDao hqHwLxDao;

	@Override
	public PageModel<Map<String, Object>> findHqHwKpCountPlace(String type, Integer fb, Integer kplx,
			Integer currentPage, Integer rowsInPage) throws Exception {
		// TODO Auto-generated method stub
		return hqHwKpReviewSetdao.findHqHwKpCountPlace(type, fb, kplx, currentPage, rowsInPage);
	}

	@Override
	public List<HqHwLx> findHqHwLxAll() throws Exception {
		// TODO Auto-generated method stub
		return hqHwLxDao.findAll();
	}

}
