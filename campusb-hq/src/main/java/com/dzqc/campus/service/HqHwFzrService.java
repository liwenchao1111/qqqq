package com.dzqc.campus.service;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwFzr;

public interface HqHwFzrService {

	PageModel<Map<String, Object>> getListData(int pageSize, int currentPage);


	Integer deleteById(String id);

	void insert(HqHwFzr hqHwFzr);
	
	public List<Map<String, Object>> getfzr(String id);

}
