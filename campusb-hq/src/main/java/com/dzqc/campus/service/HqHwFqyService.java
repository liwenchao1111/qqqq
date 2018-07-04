package com.dzqc.campus.service;

import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwFqy;

public interface HqHwFqyService {

	PageModel<Map<String, Object>> findHwqy(String name, Integer currentPage, Integer pageSize);
	
	Integer addHwqy(HqHwFqy hwqy, String id);
	
	Integer updateHwqy(String hwid, String jcgz, String wyfl, String glfl, String gzys, String fqyid);
	
	Integer deleteHwqy(String id);
}
