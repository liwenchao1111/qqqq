package com.dzqc.campus.service.impl;

import java.util.List;
import java.util.Map;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqWxQdAdminDao;

import com.dzqc.campus.entity.HqWxQd;
import com.dzqc.campus.service.HqWxQdAdminService;



	
@Service
public class HqWxQdAdminServiceImpl implements HqWxQdAdminService {

	@Autowired
	private HqWxQdAdminDao hqwxqddao;





	@Override
	public PageModel findByParams(Integer HQ_WX_STATUS, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return hqwxqddao.findByParams(HQ_WX_STATUS, currentPage, pageSize);
	}



	@Override
	public int update(String HQ_WX_QD_ID) {
		// TODO Auto-generated method stub
		return hqwxqddao.update(HQ_WX_QD_ID);
	}



	@Override
	public List<Map<String, Object>> findBywxqdid(String HQ_WX_QD_ID) {
		// TODO Auto-generated method stub
		return hqwxqddao.findBywxqdid(HQ_WX_QD_ID);
	}



	@Override
	public Map<String, Object> findQdxqList(String ID) {
		// TODO Auto-generated method stub
		return hqwxqddao.findQdxqList(ID);
	}



	@Override
	public Map<String, Object> findUserbyId(String id) {
		// TODO Auto-generated method stub
		return hqwxqddao.findUserbyId(id);
	}

	@Override
	public Integer findCountById() {
		// TODO Auto-generated method stub
		return hqwxqddao.findCountById();
	}



	@Override
	public List<Map<String, Object>> findCountStatus() {
		// TODO Auto-generated method stub
		return hqwxqddao.findCountStatus();
	}



	@Override
	public List<Map<String, Object>> findByBjxq(String HQ_WX_QD_ID) {
		// TODO Auto-generated method stub
		return hqwxqddao.findByBjxq(HQ_WX_QD_ID);
	}



	@Override
	public Map<String, Object> findApbyId(String id) {
		// TODO Auto-generated method stub
		return hqwxqddao.findApbyId(id);
	}



	


	

}
