package com.dzqc.campus.dao;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwFqygl;

public interface HqHwFqyglDaoPlus {
	PageModel<Map<String, Object>> findFqygl(String name, Integer currentPage, Integer pageSize);

	Integer addfqy(HqHwFqygl fqy);

	Integer updatefqy(String id, String fname);

	Integer deletefqy(String id);

	List<HqHwFqygl> findList();
	
	/**
	 * 查询负责人
	 */
	public List<Map<String, Object>> getfzr(String id);

}
