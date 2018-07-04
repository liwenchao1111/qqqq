package com.dzqc.campus.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqSanitationMessageAdminDao;
import com.dzqc.campus.entity.HqSanitationmanMessage;
import com.dzqc.campus.service.HqSanitationmanMessageAdminService;


@Service
public class HqSanitationmanMessageAdminServiceImpl implements HqSanitationmanMessageAdminService {

	@Autowired
	private HqSanitationMessageAdminDao hqsanmedao;
	
	@Override
	public HqSanitationmanMessage findHqSanitationMessageById(String id) {
		// TODO Auto-generated method stub
		HqSanitationmanMessage hqSanitationmanMessage = hqsanmedao.findHqSanitationMessageById(id);
		return hqSanitationmanMessage;
	}

	@Override
	public PageModel<Map<String, Object>> findHqHwFQyById(String id, Integer currentPage, Integer rowsInPage) {
		// TODO Auto-generated method stub
		PageModel<Map<String, Object>> page= hqsanmedao.findHqHwFQyById(id, currentPage, rowsInPage);
		return page;
	}

	@Override
	public Integer findCountById(String id) {
		// TODO Auto-generated method stub
		Integer count=hqsanmedao.findCountById(id);
		return count;
	}

}
