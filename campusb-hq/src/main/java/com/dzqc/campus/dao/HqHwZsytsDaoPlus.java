package com.dzqc.campus.dao;

import java.util.List;
import com.dzqc.campus.entity.HqHwZqyGL;
import com.dzqc.campus.entity.HqHwZsyts;
import com.dzqc.campus.entity.HqSanitationmanMessage;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.dzqc.campus.common.entity.PageModel;
public interface HqHwZsytsDaoPlus {

	
	Integer insert(HqHwZsyts hqHwZsyts);

	List<HqHwZqyGL> findHqHwZqyGLList(String id);

	List<String> findHqHwFZR(String id, String ids);

	List<HqSanitationmanMessage> findHqSan(String id);

	List<String> findHqSans(String fzr);
	
	
	
	PageModel<Map<String, Object>> findZsyts(HttpServletRequest request,String id,String fqyname,String zqyname,Integer currentPage, Integer pageSize);

	/**
	 * 查询最新的三条赞赏与投诉
	 * @return
	 */
	List<Map<String, Object>> selectByzsyts();
}
