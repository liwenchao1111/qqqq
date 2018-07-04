package com.dzqc.campus.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwFqyDao;
import com.dzqc.campus.entity.HqHwFqy;
import com.dzqc.campus.service.HqHwFqyService;
@Service
public class HqHwFqyServiceImpl implements HqHwFqyService{
	@Autowired
	private HqHwFqyDao hwqydao;

	@Override
	public PageModel<Map<String, Object>> findHwqy(String name, Integer currentPage, Integer pageSize) {
		return hwqydao.findHwqy(name, currentPage, pageSize);
	}
	@Override
	public Integer addHwqy(HqHwFqy hwqy,String id) {
		return hwqydao.addHwqy(hwqy,id);
	}
	@Override
	public Integer updateHwqy(String hwid, String jcgz, String wyfl, String glfl, String gzys, String fqyid) {
		return hwqydao.updateHwqy(hwid, jcgz, wyfl, glfl, gzys, fqyid);
	}
	@Override
	public Integer deleteHwqy(String id) {
		return hwqydao.deleteHwqy(id);
	}

	

}
