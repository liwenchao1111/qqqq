package com.dzqc.campus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwPpDjDao;
import com.dzqc.campus.entity.HqHwPpDj;
import com.dzqc.campus.service.HqHwPpDjService;

@Service
public class HqHwPpDjServiceImpl implements HqHwPpDjService{
	
	@Autowired
	private	HqHwPpDjDao hqHwPpDjDao;

	@Override
	public PageModel<List<HqHwPpDj>> findHqHwPpDjAll(Integer currentPage, Integer rowsInPage) {
		// TODO Auto-generated method stub
		return hqHwPpDjDao.findHqHwPpDjAll(currentPage, rowsInPage);
	}

	@Override
	public Integer saveHqHwPpDj(HqHwPpDj pf) {
		// TODO Auto-generated method stub
		HqHwPpDj pfs=hqHwPpDjDao.save(pf);
		if(pfs!=null) {
			return 1;
		}
		return null;
	}

	@Override
	public Integer updatepf(HqHwPpDj pf) {
		// TODO Auto-generated method stub
		HqHwPpDj pfs=hqHwPpDjDao.saveAndFlush(pf);
		if(pfs!=null) {
			return 1;
		}
		return null;
	}

	@Override
	public Integer deletepf(HqHwPpDj pf) {
		// TODO Auto-generated method stub
		hqHwPpDjDao.delete(pf);
		return 1;
	}
	/**
	 * 查询所有考评等级
	 */
	@Override
	public List<Map<String, Object>> fingkpdj() {
		
		return hqHwPpDjDao.fingkpdj();
	}
	/**
	 * 查询单个考评等级
	 */
	@Override
	public HqHwPpDj findone(String id) {
		return hqHwPpDjDao.findOne(id);
	}
}
