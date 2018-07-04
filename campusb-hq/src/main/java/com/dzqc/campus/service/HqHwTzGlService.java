package com.dzqc.campus.service;

import java.util.List;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqNoticeNew;

public interface HqHwTzGlService {

	// 查询分页
			PageModel ByParams(int currentPage,int pageSize,String hqNoticeHeadline,Integer hqNoticePublish);

			// 根据修改状态码 公告是否发布,0未发布，1发布
			int STATUS(String hqNoticeId);
			// 修改状态码 公告删除，0未删除，1删除
			int NoticeDelete(String hqNoticeId);

			List<HqNoticeNew> List(String hqNoticeId);
}
