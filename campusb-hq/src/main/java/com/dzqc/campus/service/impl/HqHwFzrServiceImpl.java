package com.dzqc.campus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwFzrDao;
import com.dzqc.campus.entity.HqHwFzr;
import com.dzqc.campus.service.HqHwFzrService;

@Service
public class HqHwFzrServiceImpl implements HqHwFzrService{
		@Autowired
		private HqHwFzrDao hqHwFzrDao;

		@Override
		public PageModel<Map<String, Object>> getListData(int pageSize, int currentPage) {
			 
			return hqHwFzrDao.getListData(pageSize,currentPage);
		}
		@Override
		public Integer deleteById(String id) {
			return hqHwFzrDao.deleteById(id);
		}
		@Override
		public void insert(HqHwFzr hqHwFzr) {
			hqHwFzrDao.insert(hqHwFzr);
			
		}
		/**
		 * 查询负责人
		 */
		@Override
		public List<Map<String, Object>> getfzr(String id) {
			// TODO Auto-generated method stub
			return hqHwFzrDao.getfzr(id);
		}
		
		
}
