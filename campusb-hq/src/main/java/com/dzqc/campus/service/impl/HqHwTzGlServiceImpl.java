package com.dzqc.campus.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwTzGlDao;
import com.dzqc.campus.dao.HqNoticeNewDao;
import com.dzqc.campus.entity.HqNoticeNew;
import com.dzqc.campus.service.HqHwTzGlService;


@Service
public class HqHwTzGlServiceImpl implements HqHwTzGlService{

	@Autowired
    private HqHwTzGlDao hqhwtz;
	
	@Override
	public PageModel ByParams(int currentPage,int pageSize,String hqNoticeHeadline,Integer hqNoticePublish) {
		
		return hqhwtz.ByParams(currentPage, pageSize,hqNoticeHeadline, hqNoticePublish);
	}
	@Override
	public int STATUS(String hqNoticeId) {
		// TODO Auto-generated method stub
		return hqhwtz.STATUS(hqNoticeId);
	}
	
	@Override
	public List<HqNoticeNew> List(String hqNoticeId) {
		// TODO Auto-generated method stub
		return hqhwtz.List(hqNoticeId);
	}
	@Override
	public int NoticeDelete(String HQ_NOTICE_ID) {
		// TODO Auto-generated method stub
		return hqhwtz.NoticeDelete(HQ_NOTICE_ID);
	}

}
