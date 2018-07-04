package com.dzqc.campus.service;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwBjBz;
import com.dzqc.campus.entity.HqHwLx;

public interface HqHwBjBzService  {


	PageModel<Map<String, Object>> findBjBzList(String mc, String lx, Integer currentPage, Integer pageSize);
	List<HqHwLx> findHwLxList();
	int insertBjBz(HqHwBjBz hqHwBjBz);

	int UpdateBjBz(String id, String mc, String xq, String hwId);
	int DeleteBjBz(String id);
}
