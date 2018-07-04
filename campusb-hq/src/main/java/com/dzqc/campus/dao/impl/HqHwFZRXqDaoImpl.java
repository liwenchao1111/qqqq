package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwFZRXqDaoPlus;
import com.dzqc.campus.entity.HqSanitationmanMessage;

public class HqHwFZRXqDaoImpl  extends CustomBaseSqlDaoImpl implements HqHwFZRXqDaoPlus{

	@Override
	public HqSanitationmanMessage findFZRMessage(String fzr_id) {
		String hql = "select hq from HqSanitationmanMessage hq where HQ_SANITATIONMAN_ID = '"+fzr_id+"'";
		List<HqSanitationmanMessage> messagesList =  this.queryForList(hql);
		return messagesList.get(0);
	}

	@Override
	public PageModel<Map<String,Object>> queryHWXq(String hw_id, Integer currentPage, Integer pageSize) {
		StringBuilder builder=new StringBuilder();
		builder.append("select zqy.*,fgl.hq_hw_fqyname,zgl.hw_zqy_name,lx.hq_hw_hwlx_type,bz.hq_hw_bjbz_name,zgl.hw_zqy_code from HQ_HW_ZQY zqy,HQ_HW_BJBZ bz,HQ_HW_QYLX lx,HQ_HW_FQYGL fgl,HQ_HW_ZQYGL zgl,"
				+ "(select * from HQ_HW_FZR hq where hq.hq_hw_fzr_id='"+hw_id+"') fzr "
				+ " where 1=1 and fzr.hq_hw_zqygl_id = zgl.hw_zqy_id and fzr.hq_hw_bjlx_id = lx.hq_hw_hwlx_id and fzr.hq_hw_bjbz_id = bz.hq_hw_bjbz_id "
				+ "and fzr.hq_hw_zqygl_id = zgl.hw_zqy_id and fzr.hq_hw_fqygl_id=fgl.hq_hw_fqyid "
				+ "and fzr.hq_hw_zqygl_id = zqy.hq_hw_zqy_id and zqy.hq_hw_fqy_id = fzr.hq_hw_fqygl_id "
				+ "and zgl.hw_fqy_id = fgl.hq_hw_fqyid and fzr.hq_hw_id = zqy.hq_hw_id order by zgl.hw_zqy_code"  );
		PageModel<Map<String,Object>> list = this.queryForPageBySql(builder.toString(), currentPage, pageSize);
		return list;
	}

	@Override
	public Integer findCountById(String fzr_id) {
		StringBuilder builder=new StringBuilder();
		builder.append("select count(*) from "
				+ "(select zqy.*,fgl.hq_hw_fqyname,zgl.hw_zqy_name,lx.hq_hw_hwlx_type,bz.hq_hw_bjbz_name,zgl.hw_zqy_code "
				+ "from HQ_HW_ZQY zqy,HQ_HW_BJBZ bz,HQ_HW_QYLX lx,HQ_HW_FQYGL fgl,HQ_HW_ZQYGL zgl,"
				+ "(select * from HQ_HW_FZR hq where hq.hq_hw_fzr_id='"+fzr_id+"')  fzr  "
				+ "where 1=1 and fzr.hq_hw_zqygl_id = zgl.hw_zqy_id and fzr.hq_hw_bjlx_id = lx.hq_hw_hwlx_id "
				+ "and fzr.hq_hw_bjbz_id = bz.hq_hw_bjbz_id and fzr.hq_hw_zqygl_id = zgl.hw_zqy_id "
				+ "and fzr.hq_hw_fqygl_id=fgl.hq_hw_fqyid and fzr.hq_hw_zqygl_id = zqy.hq_hw_zqy_id and"
				+ " zqy.hq_hw_fqy_id = fzr.hq_hw_fqygl_id and zgl.hw_fqy_id = fgl.hq_hw_fqyid and"
				+ " fzr.hq_hw_id = zqy.hq_hw_id order by zgl.hw_zqy_code)" );
		return this.querySingleResult(builder.toString());
	}

	

}
