package com.dzqc.campus.dao;

import com.dzqc.campus.common.dao.CommonDao;
import com.dzqc.campus.entity.HqNoticeNew;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface HqNoticeNewDao extends CommonDao<HqNoticeNew, String>,HqNoticeNewDaoPlus{

    /**
     *  创建新的公告
     * @param hqNoticeNew
     * @return
     */
    HqNoticeNew save(HqNoticeNew hqNoticeNew);


    /**
     * 查询区域名称
     */
    @Query(value = "select  HW_ZQY_NAME,HW_ZQY_ID from  HQ_HW_ZQYGL where STATUS=0",nativeQuery = true)
    List<Map<String,Object>>  findreaAName();

/**
 *  查询登录人的名字
 *
 */
 @Query(value = "select  ORG_USER.REAL_NAME from  ORG_USER where ID=?1",nativeQuery = true)
  String  findName(String id);

/**
 * 
 * 查询最新的一条公告
 * @return
 */
 @Query(value="select * from HQ_NOTICE_NEW where HQ_NOTICE_TIME=(select max(HQ_NOTICE_TIME) from HQ_NOTICE_NEW ) AND HQ_NOTICE_DELETE!=1 AND HQ_NOTICE_PUBLISH =1",nativeQuery = true)
	List<HqNoticeNew> selectByNoticeNew();

}
