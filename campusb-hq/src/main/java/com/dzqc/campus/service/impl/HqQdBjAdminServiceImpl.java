package com.dzqc.campus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqQdBjAdminDao;
import com.dzqc.campus.entity.HqQdBj;
import com.dzqc.campus.entity.HqWxQd;
import com.dzqc.campus.service.HqQdBjAdminService;


@Service
public class HqQdBjAdminServiceImpl implements HqQdBjAdminService{
	@Autowired
	private HqQdBjAdminDao hqqdbjdao;

	
	@Override
	public Integer insert(HqQdBj hqb) {
		// TODO Auto-generated method stub
		return hqqdbjdao.insert(hqb);
	}

	
	
	
}
