package com.dzqc.campus.service;

import java.util.List;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwLx;

public interface HqHwQyLxService {

	
	//接收数据库信息
	PageModel query(Integer currentPage, Integer pageSize);
	
	//根据类型名称查询数据
	PageModel findBytype(String typeNames, Integer currentPage, Integer pageSize);

	//添加类型
	void addType(Integer id, String typeName, String Comment);
	
	List<HqHwLx> queryList();
	
}
