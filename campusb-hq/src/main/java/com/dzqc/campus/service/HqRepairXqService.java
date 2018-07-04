package com.dzqc.campus.service;

import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqWxQd;

public interface HqRepairXqService {


	Map<String, Object> queryRepair(String id);


	Map<String, Object> findUserbyId(String id);


	
	PageModel<HqWxQd> queryRepairPageByUserName(String id,Integer currentPage,Integer pageSize,String state);
	/**
	 * 
	 * 通过Integer id 声明 更新sql方法
	 * @param id
	 */
	void UpdateTojiedan(String qd_id);
	/**
	 * 通过Integer id,Intege r wx_ry_id声明更新方法拒单
	 * @param id
	 * @param wx_ry_id
	 */
	void rejectToOrder(String qd_id,String wx_ry_id);
	

	void UpdateToweixiuzhong(String id);

	void UpdateTojieshu(String id);

	Integer count(String state, String id);

}
