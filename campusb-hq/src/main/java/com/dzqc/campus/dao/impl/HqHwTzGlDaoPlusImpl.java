package com.dzqc.campus.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwTzGlDao;
import com.dzqc.campus.entity.HqHwZqy;
import com.dzqc.campus.entity.HqNoticeNew;

@Repository
public class HqHwTzGlDaoPlusImpl extends CustomBaseSqlDaoImpl implements HqHwTzGlDao{

	@Override
	
	public PageModel ByParams(int currentPage, int pageSize,String hqNoticeHeadline, Integer hqNoticePublish) {
		StringBuilder builder = new StringBuilder();
	
		builder.append("select t.* from HQ_NOTICE_NEW t").append(" ");
	
		System.out.println("000000000000000");
		if(hqNoticeHeadline!=null) {
			builder.append("where t.hq_notice_headline like '%").append(hqNoticeHeadline).append("%'").append(" ");
			if(hqNoticePublish!=null) {
				builder.append("and  t.HQ_NOTICE_PUBLISH='").append(hqNoticePublish).append("'");
		}
		}
		if(hqNoticePublish!=null) {
			builder.append("where t.HQ_NOTICE_PUBLISH='").append(hqNoticePublish).append("'");
		}
		
		System.out.println("1111111111111111");
		PageModel<HqHwZqy> list = this.queryForPageBySql(builder.toString(), currentPage, pageSize);
		System.out.println("22222222222222222");
		return list;
	}

	@Override
	public int STATUS(String hqNoticeId) {
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE HQ_NOTICE_NEW  SET  HQ_NOTICE_PUBLISH ='1' WHERE  HQ_NOTICE_ID= '").append(hqNoticeId).append("'");
		Integer i = this.executeSql(builder.toString(), null);
		return i;
	}

	@Override
	public int NoticeDelete(String hqNoticeId) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE HQ_NOTICE_NEW  SET  HHQ_NOTICE_DELETE ='1' WHERE  HQ_NOTICE_ID= '").append(hqNoticeId).append("'");
		Integer i = this.executeSql(builder.toString(), null);
		return i;
	}

	@Override
	public List<HqNoticeNew> List(String hqNoticeId) {
		StringBuilder builder=new StringBuilder();
		builder.append("select h.* from HQ_NOTICE_NEW h where h.HQ_NOTICE_ID='").append(hqNoticeId).append("'");
		List<HqNoticeNew> hqnotice=this.queryForList(builder.toString());
		return hqnotice;
	
	}


}
