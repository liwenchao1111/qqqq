package com.dzqc.campus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HwZqyglDao;
import com.dzqc.campus.entity.HqHwZqyGL;
import com.dzqc.campus.service.HwZqyglService;
@Service
public class HwZqyglServiceImpl implements HwZqyglService {
	@Autowired
	private HwZqyglDao zqygldao;
	@Override
	public PageModel<Map<String, Object>> findZqygl(String name,Integer bm,String fqy, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		return zqygldao.findZqygl(name,bm,fqy, currentPage, pageSize);
	}

	@Override
	public Integer addzqy(HqHwZqyGL zqy) {
		// TODO Auto-generated method stub
		return zqygldao.addzqy(zqy);
	}

	@Override
	public Integer deletezqy(String id) {
		// TODO Auto-generated method stub
		return zqygldao.deletezqy(id);
	}

	@Override
	public Integer updatezqy(String id, String zname,String fid) {
		// TODO Auto-generated method stub
		return zqygldao.updatezqy(id, zname,fid);
	}

	@Override
	public List<HqHwZqyGL> fuqy(String id) {
		// TODO Auto-generated method stub
		return zqygldao.fuqy(id);
	}
	
	/**
	 * 查询所有父区域
	 */
	@Override
	public List<Map<String, Object>> list(String id) {
		// TODO Auto-generated method stub
		return zqygldao.list(id);
	}
	
	


}
