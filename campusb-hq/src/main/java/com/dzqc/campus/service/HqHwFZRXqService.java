package com.dzqc.campus.service;


import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqSanitationmanMessage;

public interface HqHwFZRXqService {
	HqSanitationmanMessage findFZRMessage(String fzr_id);
	PageModel<Map<String,Object>> queryHWXq(String hw_id,Integer currentPage,Integer pageSize);
	Integer findCountById(String fzr_id);
}
