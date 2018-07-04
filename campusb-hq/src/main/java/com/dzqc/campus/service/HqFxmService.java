package com.dzqc.campus.service;

import java.util.List;

import com.dzqc.campus.entity.HqFxm;

public interface HqFxmService {

	/**
	 * 根据ID查询报修项目父分类
	 * 
	 */
	List<HqFxm> findAll();
	
	
}
