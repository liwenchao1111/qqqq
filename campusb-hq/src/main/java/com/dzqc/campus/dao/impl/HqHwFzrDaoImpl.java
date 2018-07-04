package com.dzqc.campus.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwFzrDaoPlus;
import com.dzqc.campus.entity.HqHwFzr;

public class HqHwFzrDaoImpl extends CustomBaseSqlDaoImpl implements HqHwFzrDaoPlus{

	@Override
	public PageModel<Map<String, Object>> getListData(int pageSize, int currentPage) {
		
		String sql = "select  fzr.HQ_HW_ID ,"
		        +"f.hq_hw_fqyname,"
		        +"t.HQ_SANITATIONMAN_NAME ,"
		        +"fzr.hq_hw_bjbz_mj,"
		        +"b.hq_hw_bjbz_name,"
		        +"x.hq_hw_hwlx_type,"
		        +"fzr.status"
		        +"from  HQ_HW_FZR fzr "
		        +"Left join HQ_HW_ZQYGL z on fzr.HQ_HW_ZQYGL_ID = z.HW_ZQY_ID"
		        +"left join HQ_HW_FQYGL f on fzr.HQ_HW_FQYGL_ID = f.HQ_HW_FQYID"
		        +"left join HQ_HW_BJBZ  b on fzr.HQ_HW_BJBZ_ID = b.HQ_HW_BJBZ_ID"
		        +"left join HQ_SANITATIONMAN_MESSAGE t on fzr.HQ_HW_FZR_ID = t.HQ_SANITATIONMAN_ID"
		        +"left join HQ_HW_QYLX x on fzr.hq_hw_bjlx_id=x.hq_hw_hwlx_id";
		
		PageModel<Map<String, Object>> pm = this.queryForPageBySql(sql, currentPage, pageSize);
		return pm;
	}
	
	@Override
	public Integer deleteById(String id) {
		String sql="update HQ_HW_FZR set STATUS=1 where HQ_HW_ID=?";
		List<Object> fzrid = new ArrayList<Object>();
		fzrid.add(id);
		return executeSql(sql, fzrid);
	}

	@Override
	public void insert(HqHwFzr hqHwFzr) {
		insert(hqHwFzr);
	}

	@Override
	public List<Map<String, Object>> getfzr(String id) {
		String sql="select s.hq_sanitationman_id,s.hq_sanitationman_name from HQ_HW_FZR f,HQ_SANITATIONMAN_MESSAGE s where s.hq_sanitationman_id=f.hq_hw_fzr_id and f.status=0 and s.status=0 and f.hq_hw_zqygl_id="+"'"+id+"'";
		return this.querySqlObjects(sql);
	}

	
	
}
