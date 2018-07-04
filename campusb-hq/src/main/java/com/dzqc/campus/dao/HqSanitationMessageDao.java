package com.dzqc.campus.dao;


import com.dzqc.campus.common.dao.CommonDao;
import com.dzqc.campus.entity.HqSanitationmanMessage;
import org.springframework.data.jpa.repository.Query;


public interface HqSanitationMessageDao extends CommonDao<HqSanitationmanMessage,String>{

    /**
     * 查询环卫工人
     */
    HqSanitationmanMessage  findByhqSanitationmanId(String HQSANITATIONMANID);
    /**
     * 根据hqSanitationmanType查询环卫工类型
     */
    @Query(value = "SELECT HQ_HW_HWFL.HQ_HW_FLNAME FROM HQ_HW_HWFL WHERE HQ_HW_HWFL.HQ_HW_ID=?", nativeQuery = true)
     String findFLNAME(String id);

    /**
     * 添加环卫工人
     */
     HqSanitationmanMessage    save(HqSanitationmanMessage hqSanitationmanMessage);

    /**
     * 查看照片
     */

     String   findByhqSanitationmanImgUrl(String HQSANITATIONMANID);

}
