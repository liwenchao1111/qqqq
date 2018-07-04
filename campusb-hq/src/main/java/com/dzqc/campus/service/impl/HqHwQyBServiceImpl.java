package com.dzqc.campus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwQyBDao;
import com.dzqc.campus.entity.HqHwBjBz;
import com.dzqc.campus.entity.HqHwZqy;
import com.dzqc.campus.service.HqHwQyBService;
@Service
public class HqHwQyBServiceImpl implements HqHwQyBService {

	@Autowired
	private HqHwQyBDao hqhwqybdao;
	
	

	

	@Override
	public int updateSTATUS(Integer HQ_HW_ID) {
		// TODO Auto-generated method stub
		return hqhwqybdao.updateSTATUS(HQ_HW_ID);
	}



	@Override
	public Integer findCount() {
		// TODO Auto-generated method stub
		return hqhwqybdao.findCount();
	}



	@Override
	public PageModel findByParams(String HQ_HW_FQY_ID, Integer currentPage, Integer pageSize, Integer hw_zqy_name,
			Integer hq_hw_bjbz_name, Integer hw_zqy_code) {
		// TODO Auto-generated method stub
		return hqhwqybdao.findByParams(HQ_HW_FQY_ID, currentPage, pageSize, hw_zqy_name, hq_hw_bjbz_name, hw_zqy_code);
	}




	@Override
	public int update(String HQ_HW_FQY_ID, String HQ_HW_ZQY_ID, String HQ_HW_TYPE_ID, String HQ_HW_BJBZ_ID,
			Double HQ_HW_MM, Double HQ_HW_JCGZ, Double HQ_HW_WYFL, Double HQ_HW_GLFL, Double HQ_HW_GZYS,
			String HQ_HW_IMG) {
		// TODO Auto-generated method stub
		return hqhwqybdao.update(HQ_HW_FQY_ID, HQ_HW_ZQY_ID, HQ_HW_TYPE_ID, HQ_HW_BJBZ_ID, HQ_HW_MM, HQ_HW_JCGZ, HQ_HW_WYFL, HQ_HW_GLFL, HQ_HW_GZYS, HQ_HW_IMG);
	}


	@Override
	public int insertHwQy(HqHwZqy hw) {
		// TODO Auto-generated method stub
		return hqhwqybdao.insertHwQy(hw);
	}

	@Override
	public List<HqHwBjBz> findHqHwBjBzList() {
		// TODO Auto-generated method stub
		return hqhwqybdao.findHqHwBjBzList();
	}

}
