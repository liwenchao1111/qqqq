package com.dzqc.campus.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqWxQdDao;
import com.dzqc.campus.entity.HqWxQd;
import com.dzqc.campus.service.HqWxQdService;

@Service
public class HqWxQdServiceImpl implements HqWxQdService {
	@Autowired
	private HqWxQdDao hqwxqddao;



	public PageModel<Map<String,Object>> findByUserIDWxQd(String id,Integer currentPage,
            Integer rowsInPage,String status) {
		// TODO Auto-generated method stub
		return hqwxqddao.findByUserIDWxQd(id,currentPage,
	             rowsInPage,status);
	}

	@Override
	public int  insertHqWxQd(HqWxQd hq) {
		// TODO Auto-generated method stub
		 return hqwxqddao.insertHqWxQd(hq);
	}

	@Override
	public Integer insertHqWxJd(String hq,String date) {
		// TODO Auto-generated method stub
		return hqwxqddao.insertHqWxJd(hq,date);
	}

	@Override
	public List<Map<String, Object>> queryBx(String id) {
		// TODO Auto-generated method stub
		return hqwxqddao.queryBx(id);
	}

	@Override
	public Map<String, Object> orgUser(String id) {
		// TODO Auto-generated method stub
		return hqwxqddao.orgUser(id);
	}

	@Override
	public Integer findCountById(String id) {
		// TODO Auto-generated method stub
		return hqwxqddao.findCountById(id);
	}
	@Override
	public List<Map<String, Object>> findCountStatus(String id) {
		// TODO Auto-generated method stub
		return hqwxqddao.findCountStatus(id);
	}
	
	@Override
	public int UpdateStatus(String id, String status) {
		// TODO Auto-generated method stub
		return hqwxqddao.UpdateStatus(id, status);
	}

	@Override
	public int insertQD(String GLYID,String WXRYID,String QDID) {
		  return hqwxqddao.insertQD(GLYID,WXRYID,QDID);
	}

	@Override
	public int insertPingjia(String id, String grade, String pinr,String status) {
		// TODO Auto-generated method stub
		int i=hqwxqddao.insertPingjia(id, grade, pinr,status);
		return i;
	}




}
