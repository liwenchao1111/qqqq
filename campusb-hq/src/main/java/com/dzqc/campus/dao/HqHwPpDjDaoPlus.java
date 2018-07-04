package com.dzqc.campus.dao;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwPpDj;

public interface HqHwPpDjDaoPlus {
	PageModel<List<HqHwPpDj>> findHqHwPpDjAll(Integer currentPage, Integer rowsInPage);
	
	List<Map<String, Object>> fingkpdj();
}
