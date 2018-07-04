package com.dzqc.campus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzqc.campus.dao.HqFSxmDao;
import com.dzqc.campus.entity.HqSxm;
import com.dzqc.campus.service.HqFSxmService;

@Service
public class HqFSxmServiceImpl implements HqFSxmService{

	@Autowired
	private HqFSxmDao FSxmDao;
	


	@Override
	public List<HqSxm> selectSxm() {
		return FSxmDao.selectSxm();
	}

	@Override
	public Integer UpdateWXXM(String Hq_fxm_mc, String fid) {
		return FSxmDao.UpdateWXXM(Hq_fxm_mc, fid);
	}

	@Override
	public Integer UpdateSWXXM(String HQ_SXM_MC, String sid) {
		return FSxmDao.UpdateSWXXM(HQ_SXM_MC, sid);
	}

	@Override
	public Integer insertWXXM(String xmname) {
		return FSxmDao.insertWXXM(xmname);
	}

	@Override
	public Integer insertSWXXM(String xmname, String sid) {
		return FSxmDao.insertSWXXM(xmname, sid);
	}

}
