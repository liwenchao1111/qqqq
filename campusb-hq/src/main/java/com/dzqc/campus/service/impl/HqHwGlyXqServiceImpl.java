package com.dzqc.campus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwGlyXqDao;
import com.dzqc.campus.entity.HqHwGly;
import com.dzqc.campus.service.HqHwGlyXqService;
@Service
public class HqHwGlyXqServiceImpl implements HqHwGlyXqService{
	
	@Autowired
	private HqHwGlyXqDao hhgxd;
	
	/**
	 * 查询所有区域
	 */
	@Override
	public List<Map<String, Object>> findall() {
		
		return hhgxd.findall();
	}
	
	/**
	 * 查询所有负责人
	 */
	@Override
	public List<Map<String, Object>> findallfzr() {
		
		return hhgxd.findallfzr();
	}
	
	/**
	 * 保存管理员
	 */
	@Override
	public void save(HqHwGly hhg) {
		hhgxd.save(hhg);
	}
	
	/**
	 * 分页查询管理员
	 */
	@Override
	public PageModel<HqHwGly> hqhwglyall(String fqyid,String glyname,Integer currentPage, Integer pageSize) {
		
		return hhgxd.hqhwglyall( fqyid,glyname,currentPage, pageSize);
	}
	
	
	/**
	 * 单表查询单个管理员
	 */
	@Override
	public HqHwGly findone(String id) {
		return hhgxd.findOne(id);
	}
	
	/**
	 * 三表查询单个管理员
	 */
	@Override
	public List<Map<String, Object>> getone(String id) {
		
		return hhgxd.getone(id);
	}
	/**
	 * 修改管理员
	 */
	@Override
	public void updete(HqHwGly hhg) {
		hhgxd.saveAndFlush(hhg);
	}
	
	
}
