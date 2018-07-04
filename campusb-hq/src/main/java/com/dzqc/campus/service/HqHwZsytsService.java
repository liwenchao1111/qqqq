package com.dzqc.campus.service;

import java.util.List;
import com.dzqc.campus.entity.HqHwZqyGL;
import com.dzqc.campus.entity.HqHwZsyts;
import com.dzqc.campus.entity.HqSanitationmanMessage;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.dzqc.campus.common.entity.PageModel;

public interface HqHwZsytsService {
	PageModel<Map<String, Object>> findZsyts(HttpServletRequest request,String id,String fqyname,String zqyname,Integer currentPage, Integer pageSize);
	
	Integer insert(HqHwZsyts hqHwZsyts);
	List<String> findHqHwFZR(String id, String ids);
	List<HqHwZqyGL> findHqHwZqyGLList(String id );
	List<HqSanitationmanMessage> findHqSan(String id);
	List<String> findHqSans(String fzr);
}
