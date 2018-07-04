package com.dzqc.campus.dao;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwGly;



public interface HqHwGlyXqDaoPlus {
	/**
	 * 查询所有父区域
	 * @return List<HqHwFqygl>
	 */
	public List<Map<String, Object>> findall();
	
	/**
	 * 查询所有负责人
	 */
	public List<Map<String, Object>> findallfzr();
	
	/**
	 * 分页查询所有管理员
	 */
	public PageModel<HqHwGly> hqhwglyall(String fqyid,String glyname,Integer currentPage, Integer pageSize);
	
	/**
	 *  三表查询单个管理员
	 */
	public List<Map<String, Object>> getone(String id);
	
}
