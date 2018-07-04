package com.dzqc.campus.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.dao.HqQdBjDao;
import com.dzqc.campus.entity.HqQdBj;
import com.dzqc.campus.service.HqQdBjService;

@Service
public class HqQdBjServiceImpl implements HqQdBjService{
	@Autowired
	private HqQdBjDao hqqdbjdao;

	
	@Override
	public Integer insert(HqQdBj hqb) {
		// TODO Auto-generated method stub
		return hqqdbjdao.insert(hqb);
	}


	
	
}
