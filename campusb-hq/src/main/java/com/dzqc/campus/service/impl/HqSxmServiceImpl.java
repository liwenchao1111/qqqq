package com.dzqc.campus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.dao.HqSxmDao;
import com.dzqc.campus.entity.HqSxm;
import com.dzqc.campus.service.HqSxmService;

@Service
public class HqSxmServiceImpl implements HqSxmService {
	
	@Autowired
	private HqSxmDao hqsxmdao;

	@Override
	public List<Map<String, Object>> findIDFxm(String id) {
		// TODO Auto-generated method stub
		return hqsxmdao.findIDFxm(id);
	}

	@Override
	public List<HqSxm> findHqFxm(String id) {
		// TODO Auto-generated method stub
		return hqsxmdao.findHqFxm(id);
	}

	

	
}
