package com.dzqc.campus.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwKpReviewSetDaoPlus;

@Repository
public class HqHwKpReviewSetDaoImpl extends CustomBaseSqlDaoImpl implements HqHwKpReviewSetDaoPlus {

	@Override
	public PageModel<Map<String, Object>> findHqHwKpCountPlace(String type, Integer fb, Integer kplx,
			Integer currentPage, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		if (currentPage != null && pageSize != null) {
			builder.append("select ks.* from\r\n"
					+ "       (select  lx.hq_hw_hwlx_type,zqygl.hw_zqy_name,s.hq_sanitationman_name,ppdj.hq_hw_ppdjfz_remark,ppdj.hq_hw_ppdjfz_grade,k.sum\r\n"
					+ "        from  (select  kp.HQ_HW_ZQYGL_ID,kp.hq_hw_kpdj_id,count(kp.hq_hw_kp_id) as sum\r\n"
					+ "               from HQ_HW_KP kp\r\n" + "where kp.hq_hw_ky_zt=0  ");
			if (fb != null) {
				builder.append(" and kp.hq_hw_fb_zt=").append(fb.toString());
			}
			if (kplx != null) {
				builder.append(" and kp.HQ_HW_KPLX=").append(kplx.toString());
			}
			builder.append("  Group by kp.HQ_HW_ZQYGL_ID,kp.hq_hw_kpdj_id) k\r\n"
					+ "left join HQ_HW_FZR fzr  on fzr.hq_hw_zqygl_id=k.HQ_HW_ZQYGL_ID\r\n"
					+ "left join HQ_SANITATIONMAN_MESSAGE s on fzr.hq_hw_fzr_id=s.hq_sanitationman_id\r\n"
					+ "left join HQ_HW_ZQYGL zqygl on k.HQ_HW_ZQYGL_ID=zqygl.hw_zqy_id\r\n"
					+ "left join HQ_HW_ZQY zqy on zqy.hq_hw_zqy_id=k.HQ_HW_ZQYGL_ID\r\n"
					+ "left join HQ_HW_PPDJ ppdj on ppdj.hq_hw_ppdjfz_id=k.hq_hw_kpdj_id\r\n"
					+ "left join HQ_HW_QYLX lx on lx.hq_hw_hwlx_id=zqy.hq_hw_type_id ) ks\r\n");
			if (type != null) {
				builder.append("where ks.hq_hw_hwlx_type like '%" + type + "%'\r\n");
			}
			builder.append(" order by ks.sum DESC,ks.hq_hw_ppdjfz_grade ASC");
			PageModel<Map<String, Object>> pagemodel = null;
			pagemodel = this.queryForPageBySqlForBean(builder + "", currentPage, pageSize);
			if (pagemodel != null) {
				return pagemodel;
			}
			return null;
		}

		return null;
	}

}
