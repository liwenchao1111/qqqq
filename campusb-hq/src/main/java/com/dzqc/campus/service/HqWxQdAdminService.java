package com.dzqc.campus.service;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;

public interface HqWxQdAdminService {

	
	
	PageModel findByParams(Integer HQ_WX_STATUS, int currentPage, int pageSize);
	
	 int update(String HQ_WX_QD_ID);
	 
   
    List<Map<String, Object>> findBywxqdid(String HQ_WX_QD_ID);
    
    List<Map<String, Object>> findByBjxq(String HQ_WX_QD_ID);
    
  


		Integer findCountById();
		
		List<Map<String, Object>> findCountStatus();
		
		 Map<String, Object> findQdxqList(String ID);
		 Map<String, Object> findUserbyId(String id);
		 Map<String, Object> findApbyId(String id);
}
