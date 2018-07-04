package com.dzqc.campus.dao;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.dao.CommonDao;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwFzr;

public interface HqHwFzrDao extends CommonDao<HqHwFzr, String>,HqHwFzrDaoPlus{

	void insert(HqHwFzr hqHwFzr);

	
	
}
