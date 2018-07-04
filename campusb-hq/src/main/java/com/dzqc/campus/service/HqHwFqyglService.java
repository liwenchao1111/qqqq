package com.dzqc.campus.service;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwFqygl;

public interface HqHwFqyglService {
	/**
	 * 查询父区域信息
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageModel<Map<String, Object>> findFqygl(String name, Integer currentPage, Integer pageSize);
	/**
	 * 添加新的父区域
	 * @param fqy
	 * @return
	 */
	Integer addfqy(HqHwFqygl fqy);
	/**
	 * 修改父区域name
	 * @param id
	 * @param fqyname
	 * @return
	 */
	Integer updatefqy(String id, String fname);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Integer deletefqy(String id);
	
	List<HqHwFqygl> findAll();
	List<HqHwFqygl> findList();
}
