package com.dzqc.campus.service.impl;


import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqSanitationMessageDao;
import com.dzqc.campus.dao.HqSanitationMessageDaoPlus;
import com.dzqc.campus.entity.HqSanitationmanMessage;
import com.dzqc.campus.service.HqSanitationmanMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class HqSanitationmanMessageServiceImpl implements HqSanitationmanMessageService {
   @Autowired
   private HqSanitationMessageDaoPlus hqSanitationMessageDaoPlus;
   @Autowired
   private HqSanitationMessageDao hqSanitationMessageDao;
    /**
     * 查询环卫工
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageModel queryMessage(Integer currentPage,Integer pageSize,String sanitationmantype,String seek) {
        return hqSanitationMessageDaoPlus.queryMessage(currentPage,pageSize,sanitationmantype,seek) ;
    }

    /**
     * 查询环卫工人
     * @param HQSANITATIONMANID
     * @return
     */
    @Override
    public HqSanitationmanMessage queryMessageAre(String HQSANITATIONMANID) {

        return hqSanitationMessageDao.findByhqSanitationmanId(HQSANITATIONMANID);
    }


    /**
     * 根据hqSanitationmanType查询环卫工类型
     */

    @Override
    public String findFLNAME(String id) {

        return hqSanitationMessageDao.findFLNAME(id);
    }

    @Override
    public HqSanitationmanMessage save(HqSanitationmanMessage hqSanitationmanMessage) {

        return hqSanitationMessageDao.save(hqSanitationmanMessage);
    }


    /**查询环卫工的所有类型
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> InquireSanitationmanType() {
        return hqSanitationMessageDaoPlus.InquireSanitationmanType();
    }

    @Override
    public Integer updateMessage(String Name, String sex, Date birthdate, String type, String phone, String background, String ID) {
        return hqSanitationMessageDaoPlus.updateMessage(Name,sex,birthdate,type,phone,background,ID);
    }

    @Override
    public Integer deleteMessage(String ID) {

        return hqSanitationMessageDaoPlus.deleteMessage(ID);
    }

    @Override
    public String findByhqSanitationmanImgUrl(String HQSANITATIONMANID) {

        return    hqSanitationMessageDao.findByhqSanitationmanImgUrl(HQSANITATIONMANID);
    }


}
