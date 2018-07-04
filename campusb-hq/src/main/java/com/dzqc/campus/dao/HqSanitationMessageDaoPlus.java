package com.dzqc.campus.dao;

import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqSanitationmanMessage;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface HqSanitationMessageDaoPlus {

    /**
     * 查询所有环卫工人
     */
    PageModel queryMessage(Integer currentPage,Integer pageSize,String sanitationmantype,String seek);


    /**
     * 编辑环卫工人
     *
     * */
    Integer  updateMessage(String Name, String sex, Date birthdate, String type, String phone, String background, String ID);

/**
 * 查询环卫工人类型
 */
   List<Map<String, Object>>   InquireSanitationmanType();

    /**
     * 删除环卫工人
     */
    Integer   deleteMessage(String ID);
}
