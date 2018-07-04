package com.dzqc.campus.service.impl;


import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqNoticeNewDao;
import com.dzqc.campus.entity.HqNoticeNew;
import com.dzqc.campus.service.HqNoticeNewService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HqNoticeNewServiceImpl implements HqNoticeNewService {
    
	@Autowired
    private HqNoticeNewDao hqNoticeNewDao;
    /**
     *  创建新的公告
     * @param hqNoticeNew
     * @return
     */
//    @Override
//    public HqNoticeNew save(HqNoticeNew hqNoticeNew) {
//
//        return   hqNoticeNewDao.save(hqNoticeNew);
//
//    }
//	@Override
//	public PageModel findByParams(String hqNoticeHeadline, Integer hqNoticePublish, int currentPage, int pageSize) {
//		// TODO Auto-generated method stub
//		return hqNoticeNewDao.findByParams(hqNoticeHeadline, hqNoticePublish, currentPage, pageSize);
//	}
//	@Override
//	public int updateSTATUS(String hqNoticeId) {
//		// TODO Auto-generated method stub
//		return hqNoticeNewDao.updateSTATUS(hqNoticeId);
//	}
//	
//	@Override
//	public List<HqNoticeNew> findList(String hqNoticeId) {
//		// TODO Auto-generated method stub
//		return hqNoticeNewDao.findList(hqNoticeId);
//	}
//	@Override
//	public int updateNoticeDelete(String hqNoticeId) {
//		// TODO Auto-generated method stub
//		return hqNoticeNewDao.updateNoticeDelete(hqNoticeId);
//	}
}
