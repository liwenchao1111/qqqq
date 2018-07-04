package com.dzqc.campus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.dao.HqHwZsytsDao;
import com.dzqc.campus.dao.HqNoticeNewDao;
import com.dzqc.campus.entity.HqHwZsyts;
import com.dzqc.campus.entity.HqNoticeNew;
import com.dzqc.campus.service.HqWebShowService;

@Service
public class HqWebShowServiceImpl implements HqWebShowService{

	@Autowired
	private HqNoticeNewDao hqNoticeNewDao;
	@Autowired
	private HqHwZsytsDao hqHwZsytsDao;
	
	/**
	 * 
	 * 查询最新的公告
	 */
	@Override
	public List<HqNoticeNew> selectByNoticeNew() {
		// TODO Auto-generated method stub
		return hqNoticeNewDao.selectByNoticeNew();
	}
	/**
	 * 
	 * 查询最新的三条赞赏与投诉
	 */
	@Override
	public List<Map<String, Object>> selectByzsyts() {
		// TODO Auto-generated method stub
		return hqHwZsytsDao.selectByzsyts();
	}
	
}
