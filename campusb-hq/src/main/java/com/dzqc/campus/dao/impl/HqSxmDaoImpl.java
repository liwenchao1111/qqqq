package com.dzqc.campus.dao.impl;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.dao.HqSxmDaoPlus;
import com.dzqc.campus.entity.HqSxm;

/**
 * 
 * 
 * 功能描述：
 *		
 * @Package: com.dzqc.campus.dao.impl 
 * @ClassName: HqSxmDao.java
 * @author: Administrator 
 * @date: 2018年5月28日 下午1:56:43
 */
public class HqSxmDaoImpl extends CustomBaseSqlDaoImpl implements HqSxmDaoPlus {

	@Override
	public List<Map<String, Object>> findIDFxm(String id) {
		StringBuilder builder = new StringBuilder();
		builder.append("select hs.HQ_SXM_MC,hf.mc  from HqFxm hf,HqSxm hs where hs.HQ_SXM_FXM_ID=hf.id");
		if(id!=null || id!="") {
			builder.append("and hs.HQ_SXM_ID=").append(id);
		}
		List<Map<String,Object>> listmap=this.querySqlObjectsForBean(builder+"");
		if(listmap==null || listmap.size()<1 ) {
			return null;
		}
		return listmap;
	}
	
	
	//项目报修：通过父类查询它下的 所有子类
	@Override
	public List<HqSxm> findHqFxm(String id) {
		StringBuilder builder = new StringBuilder();
		builder.append("select * from Hq_Sxm hs where HQ_SXM_FXM_ID='"+id+"'");
		
		List<HqSxm> list=this.querySqlObjects(builder+"",HqSxm.class);
		if(list==null || list.size()<1 ) {
			return null;
		}
		return list;
	}

}
