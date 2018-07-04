package com.dzqc.campus.service;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwLx;


/**
 * 
 * 功能描述：热点考评设置Service
 *
 * @Package: com.dzqc.campus.service 
 * @ClassName: HqHwKpReviewSetService.java
 * @author: 呆橘
 * @Email: ysx936@163.com
 * @date: 2018年6月28日 下午4:49:14
 */
public interface HqHwKpReviewSetService {

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
	
	
	/**
	 * 
	 * 区域类型下拉框的数据
	 * 
	 * @return
	 * @throws Exception
	 */
	List<HqHwLx> findHqHwLxAll() throws Exception;
	
}
