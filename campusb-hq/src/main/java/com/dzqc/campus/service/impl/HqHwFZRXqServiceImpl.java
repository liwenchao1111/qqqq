package com.dzqc.campus.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwFZRXqDao;
import com.dzqc.campus.entity.HqSanitationmanMessage;
import com.dzqc.campus.service.HqHwFZRXqService;

@Service
public class HqHwFZRXqServiceImpl implements HqHwFZRXqService{

	@Autowired
	private HqHwFZRXqDao HqHwFZRXqDao;
	
	@Override
	public HqSanitationmanMessage findFZRMessage(String fzr_id) {
		return HqHwFZRXqDao.findFZRMessage(fzr_id);
	}

	@Override
	public PageModel<Map<String,Object>> queryHWXq(String hw_id, Integer currentPage, Integer pageSize) {
		return HqHwFZRXqDao.queryHWXq(hw_id, currentPage, pageSize);
	}

	@Override
	public Integer findCountById(String fzr_id) {
		return HqHwFZRXqDao.findCountById(fzr_id);
	}

}
