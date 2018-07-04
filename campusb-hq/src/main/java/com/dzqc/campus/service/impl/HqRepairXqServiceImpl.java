package com.dzqc.campus.service.impl;


import java.util.Map;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqRepairXqDao;
import com.dzqc.campus.entity.HqWxQd;
import com.dzqc.campus.service.HqRepairXqService;

@Service
public class HqRepairXqServiceImpl implements HqRepairXqService {
	
	
	@Autowired
	private HqRepairXqDao hrxDao;

	@Override
	public PageModel<HqWxQd> queryRepairPageByUserName(String id,Integer currentPage,Integer pageSize,String state) {
		return hrxDao.queryRepairPageByUserName(id,currentPage,pageSize,state);
	}


	@Override

	public Map<String, Object> queryRepair(String id) {
		
		return hrxDao.queryRepair(id);
	}

	@Override
	public void rejectToOrder(String qd_id,String wx_ry_id) {
		//维修员拒单后更改通过清单id更改状态
		hrxDao.rejectToOrder(qd_id,wx_ry_id);
		
	}

	/**
	 * 通过id查询管理员
	 */
	@Override
	public Map<String, Object> findUserbyId(String id) {
		// TODO Auto-generated method stub
		return hrxDao.findUserbyId(id);
	}

	@Override
	public void UpdateTojiedan(String id) {
		hrxDao.update(id);
		
	}

	@Override
	public void UpdateToweixiuzhong(String id) {
		hrxDao.update1(id);
		
	}
	@Override
	public void UpdateTojieshu(String id) {
		hrxDao.update2(id);
		
	}
	/**
	 * 查询总数
	 * @param state
	 * @param id
	 * @return
	 */
	@Override
	public Integer count(String state, String id) {
		
		return hrxDao.count(state, id);
	}
}
