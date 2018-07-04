package com.dzqc.campus.dao;

import java.util.Map;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqWxQd;

public interface HqRepairXqDaoPlus {

	
	
	/**
	 * 根据用户信息查询分页信息
	 * @param userQueryDTO
	 * @return
	 */
	PageModel<HqWxQd> queryRepairPageByUserName(String username,Integer currentPage,Integer pageSize,String state);
	
	/**
	 * 更改接单状态待受理为已接单
	 */

	void update(String qd_id);

	

	

	
	/**
	 * 更改接单状态待受理为拒单
	 */

	void rejectToOrder(String qd_id, String wx_ry_id);
	
	
	/**
	 * 根据清单id查询清单详情
	 * @param id
	 * @return
	 */
	Map<String, Object> queryRepair(String id);
	
	
	/**
	 * 根据id查管理员
	 * @param id
	 * @return
	 */
	Map<String, Object> findUserbyId(String id);
	
	/**
	 * 更改接单状态已接单为维修中
	 * @param id
	 */
	void update1(String id);
	
	/**
	 * 更改接单状态维修中为已结束
	 * @param id
	 */
	void update2(String id);
	
	/**
	 * 查询总数
	 * @param state
	 * @param id
	 * @return
	 */
	Integer count(String state,String id);
}
