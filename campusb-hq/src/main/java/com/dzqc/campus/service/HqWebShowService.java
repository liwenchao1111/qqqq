package com.dzqc.campus.service;

import java.util.List;
import java.util.Map;

import com.dzqc.campus.entity.HqNoticeNew;

public interface HqWebShowService {

	List<HqNoticeNew> selectByNoticeNew();

	List<Map<String, Object>> selectByzsyts();

}
