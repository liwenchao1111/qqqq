package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwflDaoPlus;
import com.dzqc.campus.dao.HqUserXqDaoPlus;
import com.dzqc.campus.entity.HqHwHwfl;
import com.dzqc.campus.entity.HqUserXq;

public class HqHwflDaoImpl extends CustomBaseSqlDaoImpl implements HqHwflDaoPlus {
	//模糊查询
		@Override
		public PageModel<Map<String,Object>> findHwflListbyType(String hwname,Integer currentPage,Integer pageSize) {
			StringBuilder builder=new StringBuilder();
			builder.append("select u from HqHwHwfl u where u.DELETE_FLAG=0");
			if(!StringUtils.isEmpty(hwname)) {
				builder.append(" and u.HQ_HW_FLNAME like '%").append(hwname).append("%'");
			}
			PageModel list = this.queryForPage(builder.toString(),currentPage,pageSize);
			return list;

		}
		//插入
		@Override
		public int getHqHwflAdd(HqHwHwfl hqhwhwfl){
			
			String sql="insert into HQ_HW_HWFL(HQ_HW_ID,HQ_HW_FLNAME) values(SYS_GUID(),?)";
			List<Object> param=new ArrayList<Object>();
			
			param.add(hqhwhwfl.getHQ_HW_FLNAME());
			return executeSql(sql, param);
		}
		//修改操作
		@Override
		public Integer UpdateHqHwHwfl(String hwid, String hQ_HW_FLNAME) {
			String sql = "update HQ_HW_HWFL set HQ_HW_FLNAME = ? where HQ_HW_ID=?";
			List<Object> user = new ArrayList<Object>();
			user.add(hQ_HW_FLNAME);
			user.add(hwid);
			return executeSql(sql,user);
		}
		@Override
		public Integer DeleteHqHwHwfl(String hwid) {
			String sql = "update HQ_HW_HWFL l set l.DELETE_FLAG=1 where l.HQ_HW_ID=?";
			List<Object> Hwflid = new ArrayList<Object>();
			Hwflid.add(hwid);
			return executeSql(sql, Hwflid);
		}
		@Override
		public Integer AdminUpdateFl(String hwname) {
			// TODO Auto-generated method stub
			String sql="update HQ_HW_HWFL set hwname = ?";
			List<Object> user = new ArrayList<Object>();
			user.add(hwname);
			return executeSql(sql,user);
		}
		@Override
		public int insertHqHwHwfl(String hqhwhwfl) {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public PageModel<Map<String, Object>> findUserListbyType(String hwid, String hwname) {
			// TODO Auto-generated method stub
			return null;
		}

}
