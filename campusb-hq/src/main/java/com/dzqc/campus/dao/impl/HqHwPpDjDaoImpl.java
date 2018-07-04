package com.dzqc.campus.dao.impl;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;

import com.dzqc.campus.dao.HqHwPpDjDaoPlus;
import com.dzqc.campus.entity.HqHwPpDj;

public class HqHwPpDjDaoImpl extends CustomBaseSqlDaoImpl implements HqHwPpDjDaoPlus{

	@Override
	public PageModel<List<HqHwPpDj>> findHqHwPpDjAll(Integer currentPage, Integer rowsInPage) {
		// TODO Auto-generated method stub
		if(currentPage!=null&&rowsInPage!=null) {
			String sql="select * from HQ_HW_PPDJ where STATUS=0";
			PageModel<List<HqHwPpDj>> pagemo=queryForPageBySqlForBean(sql,currentPage,rowsInPage);
			return pagemo;
		}
		return null;
	}
	/**
	 * 查询考评等级
	 */
	@Override
	public List<Map<String, Object>> fingkpdj() {
		String sql="select * from HQ_HW_PPDJ where STATUS=0";
		return this.querySqlObjects(sql);
	}
}
