package com.dzqc.campus.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;


import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqHwQyBDaoPlus;





import com.dzqc.campus.entity.HqHwBjBz;

import com.dzqc.campus.entity.HqHwZqy;


import com.dzqc.campus.entity.HqHwZqy;

public class HqHwQyBDaoImpl extends CustomBaseSqlDaoImpl implements HqHwQyBDaoPlus {

	@Override
	// 分页
	public PageModel findByParams(String HQ_HW_FQY_ID,Integer currentPage, Integer pageSize,Integer hw_zqy_name,Integer hq_hw_bjbz_name,Integer hw_zqy_code) {
		StringBuilder builder = new StringBuilder();
		builder.append("select zqy.hw_zqy_code,t.HQ_HW_MM,t.HQ_HW_JCGZ,t.hq_hw_wyfl,t.hq_hw_glfl,t.hq_hw_gzys,fqy.hq_hw_fqyname,zqy.hw_zqy_name,hwfl.hq_hw_flname,bjbz.hq_hw_bjbz_name \r\n" + 
				"       from HQ_HW_ZQY t \r\n" + 
				"       join HQ_HW_FQYGL fqy on t.HQ_HW_FQY_ID = fqy.HQ_HW_FQYID \r\n" + 
				"       join HQ_HW_ZQYGL zqy on t.hq_hw_zqy_id=zqy.hw_zqy_id \r\n" + 
				"       join HQ_HW_HWFL hwfl on hwfl.hq_hw_id=t.hq_hw_type_id \r\n" + 
				"       join HQ_HW_BJBZ bjbz on bjbz.hq_hw_bjbz_id=t.hq_hw_bjbz_id \r\n" + 
				"       where ");
		if(HQ_HW_FQY_ID!=null) {
			builder.append("t.hq_hw_fqy_id='").append(HQ_HW_FQY_ID).append("'").append(" ");
		if(hw_zqy_name!=null) {
			builder.append("and zqy.hw_zqy_name like '%").append(hw_zqy_name).append("%'").append(" ");
			
		if(hq_hw_bjbz_name!=null) {
			builder.append("and bjbz.hq_hw_bjbz_name like '%").append(hq_hw_bjbz_name).append("%'").append(" ");
		if(hw_zqy_code!=null) {
			builder.append("and zqy.hw_zqy_code like '%").append(hw_zqy_code).append("%'");
		}
		}
		}
		}
		PageModel<HqHwZqy> list = this.queryForPageBySql(builder.toString(), currentPage, pageSize);
		return list;

		

	}
	@Override
	public int insertHwQy(HqHwZqy hw) {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder();
		builder.append("insert into HQ_HW_ZQY(HQ_HW_ID,HQ_HW_FQY_ID,HQ_HW_ZQY_ID,HQ_HW_MM,HQ_HW_JCGZ,HQ_HW_WYFL,HQ_HW_GLFL,HQ_HW_GZYS,HQ_HW_TYPE_ID,HQ_HW_BJBZ_ID,HQ_HW_IMG)values(sys_guid(),?,?,?,?,?,?,?,?,?,?)");	
		List params = new ArrayList();
        params.add(hw.getHQ_HW_FQY_ID());
        params.add(hw.getHQ_HW_ZQY_ID());
        params.add(hw.getHQ_HW_MM());
        params.add(hw.getHQ_HW_JCGZ());
        params.add(hw.getHQ_HW_WYFL());
        params.add(hw.getHQ_HW_GLFL());
        params.add(hw.getHQ_HW_GZYS());
        params.add(hw.getHQ_HW_TYPE_ID());
        params.add(hw.getHQ_HW_BJBZ_ID());
        params.add(hw.getHQ_HW_IMG());
        int i=executeSql(builder.toString(),params);
        
        return i;
	}
	//标准
	@Override
	public List<HqHwBjBz> findHqHwBjBzList() {
		StringBuilder builder=new StringBuilder();
		builder.append("select l from HqHwBjBz l where l.status=0");
		List<HqHwBjBz> lx=this.queryForList(builder.toString());
		if (lx==null||lx.size()<1) {
			return null;
		}
		return lx;
	}


	@Override
	// 修改状态码
	public int updateSTATUS(Integer HQ_HW_ID) {
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE HQ_HW_ZQY  SET  STATUS ='1' WHERE  HQ_HW_ID= '").append(HQ_HW_ID).append("'");
		Integer i = this.executeSql(builder.toString(), null);
		return i;
	}




	@Override
	// 总数
	public Integer findCount() {
		StringBuilder builder = new StringBuilder();
		builder.append("select count(t.hq_hw_id)  from HQ_HW_ZQY t where t.status != 1");
		Map<String, Object> params = new HashMap<String, Object>();
		Integer count = this.queryCountBySql(builder.toString(), params);
		return count;
	}

	@Override
	public int update(String HQ_HW_FQY_ID, String HQ_HW_ZQY_ID, String HQ_HW_TYPE_ID, String HQ_HW_BJBZ_ID,
			Double HQ_HW_MM, Double HQ_HW_JCGZ, Double HQ_HW_WYFL, Double HQ_HW_GLFL, Double HQ_HW_GZYS,
			String HQ_HW_IMG) {
		String sql = "update HQ_HW_ZQY zqy set zqy.hq_hw_fqy_id =?,zqy.hq_hw_zqy_id=?,zqy.hq_hw_mm=?,zqy.hq_hw_jcgz=?,zqy.hq_hw_wyfl=?,zqy.hq_hw_glfl=?,zqy.hq_hw_gzys=?,zqy.hq_hw_type_id=?,zqy.hq_hw_bjbz_id=?,zqy.hq_hw_img=? where zqy.hq_hw_id=?";
		List<Object> newHwqy = new ArrayList<Object>();
		newHwqy.add(HQ_HW_FQY_ID);
		newHwqy.add(HQ_HW_ZQY_ID);
		newHwqy.add(HQ_HW_TYPE_ID);
		newHwqy.add(HQ_HW_BJBZ_ID);
		newHwqy.add(HQ_HW_MM);
		newHwqy.add(HQ_HW_JCGZ);
		newHwqy.add(HQ_HW_WYFL);
		newHwqy.add(HQ_HW_GLFL);
		newHwqy.add(HQ_HW_GZYS);
		newHwqy.add(HQ_HW_IMG);
		return executeSql(sql,newHwqy);
	}

	
	


}
