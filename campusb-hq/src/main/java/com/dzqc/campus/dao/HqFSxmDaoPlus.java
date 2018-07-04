package com.dzqc.campus.dao;

import java.util.List;

import com.dzqc.campus.entity.HqFxm;
import com.dzqc.campus.entity.HqSxm;

public interface HqFSxmDaoPlus {

	Integer insertWXXM(String xmname);

	Integer insertSWXXM(String xmname,String sid);

	List<HqSxm> selectSxm();

	Integer UpdateWXXM(String Hq_fxm_mc, String fid);
	
	Integer UpdateSWXXM(String HQ_SXM_MC, String sid);

}
