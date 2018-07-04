package com.dzqc.campus.service;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqSanitationmanMessage;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface HqSanitationmanMessageService {


    /**
     * 查询所有环卫工人
     */
    PageModel queryMessage(Integer currentPage,Integer pageSize,String sanitationmantype,String seek);




    /**
     * 查询环卫工人
     */
    HqSanitationmanMessage queryMessageAre(String HQSANITATIONMANID);


    /**
     * 根据hqSanitationmanType查询环卫工类型
     */
    String findFLNAME(String id);



    /**
     * 添加环卫工人
     */
    HqSanitationmanMessage    save(HqSanitationmanMessage hqSanitationmanMessage);
    /**
     * 查询环卫工人类型
     */
    List<Map<String, Object>> InquireSanitationmanType();

    /**
     * 编辑环卫工人
     *
     * */
    Integer  updateMessage(String Name, String sex, Date birthdate, String type, String phone, String background, String ID);


    /**
     * 删除环卫工人
     */
    Integer   deleteMessage(String ID);


    /**
     * 查看照片
     */

    String   findByhqSanitationmanImgUrl(String HQSANITATIONMANID);
}
