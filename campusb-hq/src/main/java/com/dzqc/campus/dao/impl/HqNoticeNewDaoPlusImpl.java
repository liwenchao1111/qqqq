package com.dzqc.campus.dao.impl;

import java.util.List;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqNoticeNewDaoPlus;
import com.dzqc.campus.entity.HqHwBjBz;
import com.dzqc.campus.entity.HqHwZqy;
import com.dzqc.campus.entity.HqNoticeNew;

public class HqNoticeNewDaoPlusImpl extends CustomBaseSqlDaoImpl implements HqNoticeNewDaoPlus {

//	@Override
//	public PageModel findByParams(String hqNoticeHeadline, Integer hqNoticePublish, int currentPage, int pageSize) {
//		StringBuilder builder = new StringBuilder();
//		builder.append("select t.* from HQ_NOTICE_NEW t  where ");
//		if(hqNoticeHeadline!=null) {
//			builder.append("t.HQ_NOTICE_PUBLISH='").append(hqNoticePublish).append("'").append(" ");
//		if(hqNoticePublish!=null) {
//			builder.append("and t.hq_notice_headline like '%").append(hqNoticeHeadline).append("%'");
//		}
//		}
//		PageModel<HqHwZqy> list = this.queryForPageBySql(builder.toString(), currentPage, pageSize);
//		return list;
//	}
//
//	@Override
//	public int updateSTATUS(String hqNoticeId) {
//		StringBuilder builder = new StringBuilder();
//		builder.append("UPDATE HQ_NOTICE_NEW  SET  HQ_NOTICE_PUBLISH ='1' WHERE  HQ_NOTICE_ID= '").append(hqNoticeId).append("'");
//		Integer i = this.executeSql(builder.toString(), null);
//		return i;
//	}
//
//	@Override
//	public int updateNoticeDelete(String hqNoticeId) {
//		// TODO Auto-generated method stub
//		StringBuilder builder = new StringBuilder();
//		builder.append("UPDATE HQ_NOTICE_NEW  SET  HHQ_NOTICE_DELETE ='1' WHERE  HQ_NOTICE_ID= '").append(hqNoticeId).append("'");
//		Integer i = this.executeSql(builder.toString(), null);
//		return i;
//	}
//
//	@Override
//	public List<HqNoticeNew> findList(String hqNoticeId) {
//		StringBuilder builder=new StringBuilder();
//		builder.append("select h.* from HQ_NOTICE_NEW h where h.HQ_NOTICE_ID='").append(hqNoticeId).append("'");
//		List<HqNoticeNew> hqnotice=this.queryForList(builder.toString());
//		return hqnotice;
//	
//	}
//

}
