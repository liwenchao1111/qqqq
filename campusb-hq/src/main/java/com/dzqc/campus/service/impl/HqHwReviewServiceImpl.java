package com.dzqc.campus.service.impl;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.dao.HqHwReviewDao;
import com.dzqc.campus.entity.HqHwKp;
import com.dzqc.campus.service.HqHwReviewService;

@Service

public class HqHwReviewServiceImpl implements HqHwReviewService{
	@Autowired
	private HqHwReviewDao hhrd;

	@Override
	public void save(HqHwKp h) {
		hhrd.save(h);
	}

	
	
}
