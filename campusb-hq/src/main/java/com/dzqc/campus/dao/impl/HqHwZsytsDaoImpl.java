package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwZsytsDaoPlus;
import com.dzqc.campus.entity.HqHwZqyGL;
import com.dzqc.campus.entity.HqHwZsyts;
import com.dzqc.campus.entity.HqSanitationmanMessage;
import com.dzqc.campus.org.entity.User;
import com.dzqc.campus.org.util.WebHelper;

public class HqHwZsytsDaoImpl extends CustomBaseSqlDaoImpl implements HqHwZsytsDaoPlus{
	@Override
	public PageModel<Map<String,Object>> findZsyts(HttpServletRequest request,String id,String fqyname,String zqyname,Integer currentPage, Integer pageSize) {
		StringBuilder builder=new StringBuilder();
		builder.append("select distinct f.hq_hw_fqyname fname,"+
				"s.hw_zqy_name sname,"+
				"(select HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_NAME from HQ_SANITATIONMAN_MESSAGE WHERE fzr.hq_hw_fzr_id=Hq_Sanitationman_Message.Hq_Sanitationman_Id) fzr,"+
				"z.hq_hw_zsyts_type type,"+
				"u.real_name realname,"+
				"z.hq_hw_zsyts_id id,"+
				"z.hq_hw_zsyts_kpnr kpnr,"+
				"z.hq_hw_zsyts_kpsj kpsj,"+
				"z.status from HQ_HW_ZSYTS z,"+
				"HQ_HW_FQYGL f,HQ_HW_ZQYGL s,"+
				"HQ_HW_FZR fzr,"+
				"org_user u where "+
				"f.status=0 and "+
				"s.status=0 and "+
				"fzr.status=0 and "+ 
				"u.status=0 and "+
				"f.hq_hw_fqyid = z.hq_hw_zsyts_fqyid and "+
				"s.hw_zqy_id = z.hq_hw_zsyts_zqyid and "+
				"fzr.hq_hw_fzr_id = z.hq_hw_zsyts_fzrid and "+
				"u.id = z.hq_hw_zsyts_userid");
		if(!StringUtils.isEmpty(fqyname)) {
			builder.append(" and f.hq_hw_fqyname like '%").append(fqyname).append("%'");
		}
		if(!StringUtils.isEmpty(zqyname)) {
			builder.append(" and s.hw_zqy_name like '%").append(zqyname).append("%'");
		}
		if(!StringUtils.isEmpty(id)) {
			builder.append(" and z.hq_hw_zsyts_id like '%").append(id).append("%'");
		}
		User user = (User) request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
		HqHwZsyts zsyts = new HqHwZsyts();
		zsyts.setUserid(user.getId());
		PageModel<Map<String,Object>> list = this.queryForPageBySql(builder.toString(), currentPage, pageSize);
		return list;
	}

	@Override
	public Integer insert(HqHwZsyts hqHwZsyts) {
		// TODO Auto-generated method stub
		String sql="insert into HQ_HW_ZSYTS (hq_hw_zsyts_id,hq_hw_zsyts_fqyid,hq_hw_zsyts_zqyid,hq_hw_zsyts_fzrid,HQ_HW_ZSYTS_TYPE,hq_hw_zsyts_userid,hq_hw_zsyts_kpnr,hq_hw_zsyts_kpsj,status ) values(SYS_GUID(),?,?,?,?,?,?,?,?)";
		List<Object> param=new ArrayList<Object>();
		param.add(hqHwZsyts.getFqyid());
		param.add(hqHwZsyts.getZqyid());
		param.add(hqHwZsyts.getFzrid());
		param.add(hqHwZsyts.getType());
		param.add(hqHwZsyts.getUserid());
		param.add(hqHwZsyts.getKpnr());
		param.add(hqHwZsyts.getKpsj());
		param.add(hqHwZsyts.getStatus());
		return executeSql(sql, param);
	}

	@Override
	public List<HqHwZqyGL> findHqHwZqyGLList(String id ) {
		StringBuilder builder=new StringBuilder();
		builder.append("select l from HqHwZqyGL l where  l.STATUS=0 and l.HW_FQY_ID='"+id+"'");
		List<HqHwZqyGL> list=this.queryForList(builder.toString());
		if (list==null||list.size()<1) {
			return null;
		}
		return list;
	}
	@Override
	public List<String> findHqHwFZR(String id,String ids ) {
		StringBuilder builder=new StringBuilder();
		builder.append("select t.HQ_HW_FZR_ID from HqHwFzr t  where t.HQ_HW_FQYGL_ID='"+id+"' and t.HQ_HW_ZQYGL_ID='"+ids+"'and t.STATUS=0");
		List<String> list=this.queryForList(builder.toString());
		if (list==null||list.size()<1) {
			return null;
		}
		return list;
	}
	@Override
	public List<HqSanitationmanMessage> findHqSan(String id ) {
		StringBuilder builder=new StringBuilder();
		builder.append("select t.hqSanitationmanName from HqSanitationmanMessage t  where t.hqSanitationmanId= '"+id+"'and t.status=0");
		List<HqSanitationmanMessage> list=this.queryForList(builder.toString());
		if (list==null||list.size()<1) {
			return null;
		}
		return list;
	}
	@Override
	public List<String> findHqSans(String fzr ) {
		StringBuilder builder=new StringBuilder();
		builder.append("select t.hqSanitationmanId from HqSanitationmanMessage t  where t.hqSanitationmanName= '"+fzr+"'and t.status=0");
		List<String> list=this.queryForList(builder.toString());
		if (list==null||list.size()<1) {
			return null;
		}
		return list;
	}
	/**
	 * 
	 * 查询最新的三条赞赏与投诉
	 */
	@Override
	public List<Map<String, Object>> selectByzsyts() {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder();
		builder.append("select * from(select z.HW_ZQY_NAME,f.HQ_SANITATIONMAN_NAME,a.HQ_HW_ZSYTS_KPNR,a.HQ_HW_ZSYTS_KPSJ from HQ_HW_ZSYTS a\r\n" + 
				"left join HQ_SANITATIONMAN_MESSAGE f on a.hq_hw_zsyts_fzrid=f.hq_sanitationman_id\r\n" + 
				"left join HQ_HW_ZQYGL z on a.hq_hw_zsyts_zqyid=z.hw_zqy_id order by a.hq_hw_zsyts_kpsj desc)\r\n" + 
				"where rownum<=3 ");
		List<Map<String, Object>> listmap=this.querySqlObjects(builder.toString());
		return listmap;
	}
	
}
