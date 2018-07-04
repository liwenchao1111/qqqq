package com.dzqc.campus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwLx;

public interface HqHwQyLxDaoPlus {
	
	/**
	 * 获取数据库的信息
	 * @param typeName==HQ_HW_HWLX_TYPE
	 * @return
	 */
	PageModel query(Integer currentPage,Integer pageSize);
	
	
	
	/**
	 * 根据类型名称查找数据
	 */
	PageModel findBytype(String typeNames,Integer currentPage,Integer pageSize);
	
	/**
	 * 添加类型
	 */
	void addType(Integer id,String typeName,String Comment);
	
	List<HqHwLx> queryList();
}
