package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;

import com.dzqc.campus.dao.HqQdBjDaoPlus;

import com.dzqc.campus.entity.HqQdBj;



public class HqQdBjDaoImpl extends CustomBaseSqlDaoImpl implements HqQdBjDaoPlus{

	
	@Override
	public Integer insert(HqQdBj hqb) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO HQ_QD_BJ (id,BJ_XQ,HQ_QD_ID) VALUES (sys_guid(),?,?)";
		List<Object> qhqdbj=new ArrayList<Object>();
		qhqdbj.add(hqb.getBJ_XQ());
		qhqdbj.add(hqb.getHQ_QD_ID());
		return executeSql(sql, qhqdbj);
	}



	

	
}
