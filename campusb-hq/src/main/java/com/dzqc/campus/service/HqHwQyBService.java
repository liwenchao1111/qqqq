package com.dzqc.campus.service;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwBjBz;
import com.dzqc.campus.entity.HqHwFqygl;
import com.dzqc.campus.entity.HqHwZqy;

public interface HqHwQyBService {

	//查询分页
	PageModel findByParams(String HQ_HW_FQY_ID, Integer currentPage, Integer pageSize,Integer hw_zqy_name,Integer hq_hw_bjbz_name,Integer hw_zqy_code);
	
	//查询总数
	Integer findCount ();
	
	//修改状态码
	 int updateSTATUS(Integer HQ_HW_ID);
	 
	 int update(String HQ_HW_FQY_ID,String HQ_HW_ZQY_ID,String HQ_HW_TYPE_ID,String HQ_HW_BJBZ_ID,Double HQ_HW_MM,Double HQ_HW_JCGZ,Double HQ_HW_WYFL,Double HQ_HW_GLFL,Double HQ_HW_GZYS,String HQ_HW_IMG);
	 //添加区域
	int insertHwQy(HqHwZqy hw);
	
	List<HqHwBjBz> findHqHwBjBzList();
}
