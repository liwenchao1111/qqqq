package com.dzqc.campus.dao;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwFzr;

public interface HqHwFzrDaoPlus {
	
	PageModel<Map<String, Object>> getListData(int pageSize, int currentPage);
	
	Integer deleteById(String id);
	
	void insert(HqHwFzr hqHwFzr);
	
	public List<Map<String, Object>> getfzr(String id);
}
