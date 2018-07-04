package com.dzqc.campus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.dao.HqFxmDao;
import com.dzqc.campus.entity.HqFxm;
import com.dzqc.campus.service.HqFxmService;
@Service
public class HqFxmServiceImpl implements HqFxmService {

	
	@Autowired
	private HqFxmDao hqfxmDao;
	
	@Override
	public List<HqFxm> findAll() {
		// TODO Auto-generated method stub
		return hqfxmDao.findAll();
	}

}
