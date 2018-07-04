package com.dzqc.campus.dao;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwFqygl;
import com.dzqc.campus.entity.HqHwZqyGL;

public interface HwZqyglDaoPlus {
	PageModel<Map<String, Object>> findZqygl(String name,Integer bm,String fqy, Integer currentPage, Integer pageSize);
	
	Integer addzqy(HqHwZqyGL zqy);

	Integer deletezqy(String id);
	
	Integer updatezqy(String fid,String id,String zname);
	
/*	List<HqHwZqyGL> findzqylist(String id);*/

	List<HqHwZqyGL> fuqy(String id);
	
	List<Map<String, Object>> list(String id);
}
