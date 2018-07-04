package com.dzqc.campus.dao;

import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqSanitationmanMessage;

/**
 * 
 * 
 * 功能描述：管理员详情
 *
 * @Package: com.dzqc.campus.dao 
 * @ClassName: HqSanitationMessageAdminDaoPlus.java
 * @author: 呆橘
 * @date: 2018年6月21日 上午11:52:10
 */
public interface HqSanitationMessageAdminDaoPlus {
	
	/**
	 * 管理员个人信息
	 * @param id
	 * @return
	 */
	HqSanitationmanMessage findHqSanitationMessageById(String id);
	
	/**
	 * 管理员的任务清单
	 * @param id
	 * @param currentPage
	 * @param rowsInPage
	 * @return
	 */
	PageModel<Map<String,Object>> findHqHwFQyById(String id,Integer currentPage,
            Integer rowsInPage);
	
	/**
	 * 管理员的任务清单总条数
	 * @param id
	 * @return
	 */
	Integer findCountById(String id);
	
}
