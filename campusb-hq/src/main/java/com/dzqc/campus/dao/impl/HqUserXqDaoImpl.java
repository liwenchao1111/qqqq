package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqUserXqDaoPlus;
import com.dzqc.campus.entity.HqFxm;
import com.dzqc.campus.entity.HqUserXq;


public class HqUserXqDaoImpl extends CustomBaseSqlDaoImpl implements HqUserXqDaoPlus{

	@Override
	public PageModel<Map<String,Object>> findUserListbyType(String name,String gzxm,Integer currentPage, Integer pageSize) {
		StringBuilder builder=new StringBuilder();
		builder.append("select t.id,t.realName,t.mobile,q.HQ_USER_GZXM,q.HQ_USER_MAXWORK,q.HQ_USER_GH,q.HQ_USER_AM_START,q.HQ_USER_AM_END,q.HQ_USER_PM_START,q.HQ_USER_PM_END,t.username,t.password from  User t,HqUserXq q where t.id=q.USER_ID and t.type=3 and t.deleteFlag=0");
		if(!StringUtils.isEmpty(name)) {
			builder.append(" and t.realName like '%").append(name).append("%'");
		}
		if(!StringUtils.isEmpty(gzxm)) {
			builder.append(" and q.HQ_USER_GZXM like '%").append(gzxm).append("%'");
		}
		PageModel<Map<String,Object>> list = this.queryForPage(builder.toString(), currentPage, pageSize);
		return list;
	}
	@Override
	public List<HqFxm> findGZXMList(){
		StringBuilder builder=new StringBuilder();
		builder.append("select f from HqFxm f");
		List<HqFxm> gzxm = this.queryForList(builder.toString());
		if (gzxm==null||gzxm.size()<1) {
			return null;
		}
		return gzxm;
	}
	
	@Override
	public int insertHqUserXq(HqUserXq hqUserXq){
		
		String sql="insert into HQ_USER_XQ(HQ_ID,USER_ID,HQ_USER_GZXM,HQ_USER_MAXWORK,HQ_USER_GH,HQ_USER_AM_START,HQ_USER_AM_END,HQ_USER_PM_START,HQ_USER_PM_END) values(SYS_GUID(),?,?,?,?,?,?,?,?)";
		List<Object> param=new ArrayList<Object>();
		param.add(hqUserXq.getUSER_ID());
		param.add(hqUserXq.getHQ_USER_GZXM());
		param.add(hqUserXq.getHQ_USER_MAXWORK());
		param.add(hqUserXq.getHQ_USER_GH());
		param.add(hqUserXq.getHQ_USER_AM_START());
		param.add(hqUserXq.getHQ_USER_AM_END());
		param.add(hqUserXq.getHQ_USER_PM_START());
		param.add(hqUserXq.getHQ_USER_PM_END());
		return executeSql(sql, param);
	}
	@Override
	public int UpdateHqUserXq(String id,String gzxm){
		String sql="update HQ_USER_XQ t set t.hq_user_gzxm=? where t.user_id=?";
		List<Object> param=new ArrayList<Object>();
		param.add(gzxm);
		param.add(id);
		return executeSql(sql, param);
	}
	@Override
	public int UpdateUserXq(String id,String moblie){
		String sql="update org_user t set t.mobile=? where t.id=?";
		List<Object> param=new ArrayList<Object>();
		param.add(moblie);
		param.add(id);
		return executeSql(sql, param);
	}
	@Override
	public int UpdateUserPassWord(String id){
		String sql="update org_user t set t.password=123456 where t.id=?";
		List<Object> param=new ArrayList<Object>();
		param.add(id);
		return executeSql(sql, param);
	}
	@Override
	public Integer DeleteUser(String id) {
		String sql = "update org_user set DELETE_Flag=1 where id=?";
		List<Object> userid = new ArrayList<Object>();
		userid.add(id);
		return executeSql(sql, userid);
	}
	
	
	
	@Override
	public HqUserXq findUserXqByUserId(String id) {
		StringBuilder builder=new StringBuilder();
		builder.append("select * from HQ_USER_QX uq where uq.user_id=?");
		List<HqUserXq> list = this.querySqlObjects(builder+"",HqUserXq.class);
		if (list==null||list.size()<1) {
			return null;
		}
		return list.get(0);
	}
	//模糊查询
	@Override
	public PageModel findStuListbyType(String realname,String username,Integer currentPage,Integer pageSize) {
		StringBuilder builder=new StringBuilder();
		builder.append("select u from User u where u.type=2 and u.deleteFlag=0");
		if(!StringUtils.isEmpty(realname)) {
			builder.append(" and u.realName like '%").append(realname).append("%'");
		}
		if(!StringUtils.isEmpty(username)) {
			builder.append(" and u.username like '%").append(username).append("%'");
		}
		PageModel list = this.queryForPage(builder.toString(),currentPage,pageSize);
		return list;

	}
	//修改操作
	@Override
	public Integer UpdateUser(String mobile,String id) {
		String sql = "update org_user set MOBILE = ? where id=?";
		List<Object> user = new ArrayList<Object>();
		user.add(mobile);
		user.add(id);
		return executeSql(sql,user);
	}

	//密码重置
	@Override
	public Integer UpdatePwd(String id) {
		String sql="update org_user set password=123456 where id=?";
		List<Object> param=new ArrayList<Object>();
		param.add(id);
		return executeSql(sql, param);
	}
	@Override
	public PageModel<Map<String, Object>> findAdminListbyType(String name,Integer pageSize,Integer currentPage) {
		StringBuilder builder=new StringBuilder();
		builder.append("select u,hqu.HQ_USER_GH from User u ,HqUserXq hqu where hqu.USER_ID=u.id and u.type=1 and u.deleteFlag=0");
		if(!StringUtils.isEmpty(name)) {
			builder.append(" and u.realName like '%").append(name).append("%'");
			System.out.println(builder.toString());
		}
		PageModel<Map<String, Object>> list =this.queryForPage(builder.toString(), currentPage, pageSize);
		return list;
	}

	@Override
	public Integer insertGZXM(HqUserXq hqu) {
		String sql ="insert into Hq_User_xq(HQ_ID,USER_ID,HQ_USER_GH)values(SYS_GUID(),?,?)";
		List<Object> ghParams = new ArrayList<Object>();
		ghParams.add(hqu.getUSER_ID());
		ghParams.add(hqu.getHQ_USER_GH());
		return executeSql(sql,ghParams);
	}
	@Override
	public Integer AdminUpdateUser(String mobile,String id) {
		String sql = "update org_user set MOBILE = ? where id=?";
		List<Object> user = new ArrayList<Object>();
		user.add(mobile);
		user.add(id);
		return executeSql(sql,user);
	}
	@Override
	public Integer AdminDeleteUser(String id) {
		String sql = "update org_user set DELETE_Flag=1 where id=?";
		List<Object> userid = new ArrayList<Object>();
		userid.add(id);
		return executeSql(sql, userid);
	}
	@Override
	public Integer AdminUpdatePwd(String id) {
		String sql = "update org_user set password=123456 where id=?";
		List<Object> pwdid = new ArrayList<Object>();
		pwdid.add(id);
		return executeSql(sql, pwdid);
	}
	/**
	 * 查询用户名是否重复
	 */
	@Override
	public Integer findUserName(String username) {
		String sql="select count(username) count from org_user where username like '%"+username+"%'";
		List<Map<String, Object>> list = this.querySqlObjects(sql);
		return Integer.valueOf(list.get(0).get("COUNT")+"");
	}
	/**
	 * 查询手机号是否重复
	 */
	@Override
	public Integer findUserMobile(String mobile) {
		String sql="select count(MOBILE) count from org_user where mobile= '"+mobile+"'";
		List<Map<String, Object>> list = this.querySqlObjects(sql);
		return Integer.valueOf(list.get(0).get("COUNT")+"");
	}
	/**
	 * 查询工号是否重复
	 */
	@Override
	public Integer findGh(String gh) {
		String sql="select count(HQ_USER_GH) count from HQ_USER_XQ where HQ_USER_GH = '"+gh+"'";
		List<Map<String, Object>> list = this.querySqlObjects(sql);
		return Integer.valueOf(list.get(0).get("COUNT")+"") ;
	}
}
