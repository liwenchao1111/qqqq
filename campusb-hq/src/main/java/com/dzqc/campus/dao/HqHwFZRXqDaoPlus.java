package com.dzqc.campus.dao;


import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqSanitationmanMessage;

public interface HqHwFZRXqDaoPlus {
	HqSanitationmanMessage findFZRMessage(String fzr_id);
	PageModel<Map<String,Object>> queryHWXq(String fzr_id,Integer currentPage,Integer pageSize);
	Integer findCountById(String fzr_id);
	
}
