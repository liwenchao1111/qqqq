package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.apache.xmlbeans.impl.tool.Extension.Param;
import org.springframework.stereotype.Repository;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwQyLxDaoPlus;
import com.dzqc.campus.entity.HqFxm;
import com.dzqc.campus.entity.HqHwLx;
import com.dzqc.campus.service.HqHwQyLxService;
@Repository
public class HqHwQyLxDaoImpl extends CustomBaseSqlDaoImpl implements HqHwQyLxDaoPlus{
	
	//读取数据库信息
	@Override
	public PageModel query(Integer currentPage,Integer pageSize) {
		String sql = "select * from HQ_HW_QYLX where status=0";
		PageModel hqhwlxList = this.queryForPageBySql(sql,currentPage,pageSize);
		return hqhwlxList;
	}
	
	
	
	/**
	 * 根据类型名称查询该类型数据
	 * 
	 */
	@Override
	public PageModel findBytype(String typeNames, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from HQ_HW_QYLX hq where hq.HQ_HW_HWLX_TYPE  like '%"+typeNames+"%'";
		PageModel hqhwbytype = this.queryForPageBySql(sql,currentPage,pageSize);
		return hqhwbytype;
	}


	/***
	 * 添加类型
	 */
	@Override
	public void addType(Integer id, String typeName, String Comment) {
		// TODO Auto-generated method stub
		String sql = "insert into HqHwLx (Id,TypeName,Comment) values (SYS_GUID(),'"+typeName+"','"+Comment+"')";
		List<Object> param = new ArrayList<Object>();
		this.executeSql(sql, param);
		
	}



	@Override
	public List<HqHwLx> queryList() {
		String sql = "select * from HQ_HW_QYLX where status=0";
		List<HqHwLx> list = this.querySqlObjects(sql, HqHwLx.class);
		return list;
	}






}
