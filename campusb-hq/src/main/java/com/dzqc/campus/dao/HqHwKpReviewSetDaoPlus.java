package com.dzqc.campus.dao;

import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;

/**
 * 
 * 
 * 功能描述：热点考评设置功能的dao接口增强
 *
 * @Package: com.dzqc.campus.dao 
 * @ClassName: HqHwKpReviewSetDaoPlus.java
 * @author: 呆橘
 * @Email: ysx936@163.com
 * @date: 2018年6月28日 下午2:50:55
 */
public interface HqHwKpReviewSetDaoPlus {
	
	
	/**
	 * 
	 * 考评结果
	 * 
	 * @param type
	 * @param fb
	 * @param kplx
	 * @param currentPage
	 * @param rowsInPage
	 * @return
	 * @throws Exception
	 */
	PageModel<Map<String, Object>> findHqHwKpCountPlace(String type,Integer fb,Integer kplx,
			Integer currentPage,Integer rowsInPage) throws Exception;
	
}
