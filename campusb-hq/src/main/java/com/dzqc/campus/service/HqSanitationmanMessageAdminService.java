package com.dzqc.campus.service;

import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqSanitationmanMessage;

/**
 * 
 * 
 * 功能描述：管理员详情使用的Service
 *
 * @Package: com.dzqc.campus.service 
 * @ClassName: HqSanitationmanMessageAdminService.java
 * @author: 呆橘
 * @date: 2018年6月21日 下午2:49:01
 */
public interface HqSanitationmanMessageAdminService {

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
