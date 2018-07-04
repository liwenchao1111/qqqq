package com.dzqc.campus.service;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwGly;

public interface HqHwGlyXqService {
	
	public List<Map<String, Object>> findall();
	
	
	public List<Map<String, Object>> findallfzr();
	
	public void save(HqHwGly hhg);
	
	public PageModel<HqHwGly> hqhwglyall(String fqyid,String glyname,Integer currentPage, Integer pageSize);
	
	public void updete(HqHwGly hhg);
	
	public HqHwGly findone(String id);
	
	public List<Map<String, Object>> getone(String id);

}
