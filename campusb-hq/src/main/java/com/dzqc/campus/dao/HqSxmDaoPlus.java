package com.dzqc.campus.dao;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.entity.HqSxm;

public interface HqSxmDaoPlus {
	/**
	 * 根据子类的id查询他所属的父分类和子分类
	 * @param id
	 * @return 返回一个父类和子类的的list
	 */
	List<Map<String,Object>> findIDFxm(String id);
	
	List<HqSxm> findHqFxm(String id);
	
}
