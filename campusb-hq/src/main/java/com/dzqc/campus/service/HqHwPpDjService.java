package com.dzqc.campus.service;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwPpDj;

public interface HqHwPpDjService {
	PageModel<List<HqHwPpDj>> findHqHwPpDjAll(Integer currentPage, Integer rowsInPage);

	Integer saveHqHwPpDj(HqHwPpDj ppdj);

	Integer updatepf(HqHwPpDj ppdj);

	Integer deletepf(HqHwPpDj ppdj);
	
	List<Map<String, Object>> fingkpdj();
	
	HqHwPpDj findone(String id);
}
