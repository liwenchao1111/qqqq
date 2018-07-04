package com.dzqc.campus.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqWxQd;

/**
 * 
 * 
 * 功能描述：
 *		接口
 * @Package: com.dzqc.campus.dao 
 * @ClassName: HqWxQdDaoPlus.java
 * @author: 呆橘  
 * @date: 2018年5月26日 下午6:15:19
 */
public interface HqWxQdDaoPlus {
	
	/**
	 * 根据学生ID查询清单
	 */
	PageModel<Map<String,Object>> findByUserIDWxQd(String id,Integer currentPage,
            Integer rowsInPage,String status);
	
	/**
	 * 添加保修信息
	 * @param hq
	 * @return 
	 */
	int insertHqWxQd(HqWxQd hq);
	
	
	Integer insertHqWxJd(String hq,String date);
	
	
	Integer findCountById(String id);
	
	/**
	 * 查询每种状态的数量
	 */
	List<Map<String, Object>> findCountStatus(String id);
	


	/**
	 * 根据报修清单ID查询报修详情
	 * @param id
	 * @return
	 * 
	 */
	List<Map<String, Object>> queryBx(String id);

	

	Map<String,Object> orgUser(String id);
	
	/**
	 * 修改状态信息
	 */
	int UpdateStatus(String id,String status);
	
	
	
	/**
	 * 添加评价信息
	 */
	int insertPingjia(String id,String grade,String pinr,String status);

	/**
	 * 添加维修清单中维修人员id和管理员id
	 */
	int   insertQD(String GLYID,String WXRYID,String QDID);

}
