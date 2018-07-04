package com.dzqc.campus.dao.impl;

import com.dzqc.campus.common.dao.CustomBaseSqlDaoImpl;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.dao.HqSanitationMessageDaoPlus;
import com.dzqc.campus.entity.HqSanitationmanMessage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class HqSanitationMessageDaoPlusImpl extends CustomBaseSqlDaoImpl implements HqSanitationMessageDaoPlus {


    /**
     *    查询环卫工人 分页
     * @return
     */
    @Override
    public PageModel<Map<Object,String>>  queryMessage(Integer currentPage,Integer pageSize,String sanitationmantype,String seek) {
        StringBuilder builder = new StringBuilder();
        System.out.println("类型::"+sanitationmantype);
        System.out.println("内容:::"+seek);

         if(sanitationmantype.equals("请选择类型")&&seek == ""){
             String sql="SELECT HQ_SANITATIONMAN_MESSAGE.*,HQ_HW_HWFL.HQ_HW_FLNAME FROM HQ_SANITATIONMAN_MESSAGE,HQ_HW_HWFL WHERE HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_TYPE=HQ_HW_HWFL.HQ_HW_ID And HQ_SANITATIONMAN_MESSAGE.STATUS=0  ORDER BY  HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_NUMBER DESC ";
             builder.append(sql);
         }else if(sanitationmantype==""&&seek == ""){
              String sql="SELECT HQ_SANITATIONMAN_MESSAGE.*,HQ_HW_HWFL.HQ_HW_FLNAME FROM HQ_SANITATIONMAN_MESSAGE,HQ_HW_HWFL WHERE HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_TYPE=HQ_HW_HWFL.HQ_HW_ID And HQ_SANITATIONMAN_MESSAGE.STATUS=0 ORDER BY  HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_NUMBER DESC";
              builder.append(sql);
          }else if(sanitationmantype==""){
              String sql="SELECT HQ_SANITATIONMAN_MESSAGE.*,HQ_HW_HWFL.HQ_HW_FLNAME FROM HQ_SANITATIONMAN_MESSAGE,HQ_HW_HWFL WHERE HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_TYPE=HQ_HW_HWFL.HQ_HW_ID And HQ_SANITATIONMAN_MESSAGE.STATUS=0  ORDER BY  HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_NUMBER DESC" +
                      " And HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_NAME like";
               builder.append(sql).append("'%"+seek+"%'");
          }
          else if (seek==""){
              String sql="SELECT HQ_SANITATIONMAN_MESSAGE.*,HQ_HW_HWFL.HQ_HW_FLNAME FROM HQ_SANITATIONMAN_MESSAGE,HQ_HW_HWFL WHERE HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_TYPE=HQ_HW_HWFL.HQ_HW_ID And HQ_SANITATIONMAN_MESSAGE.STATUS=0  ORDER BY  HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_NUMBER DESC" +
                      " And  HQ_HW_HWFL.HQ_HW_ID=";
              builder.append(sql).append("'"+sanitationmantype+"'");
          }
          else{
              String sql="SELECT HQ_SANITATIONMAN_MESSAGE.*,HQ_HW_HWFL.HQ_HW_FLNAME FROM HQ_SANITATIONMAN_MESSAGE,HQ_HW_HWFL WHERE HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_TYPE=HQ_HW_HWFL.HQ_HW_ID And HQ_SANITATIONMAN_MESSAGE.STATUS=0  ORDER BY  HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_NUMBER DESC" +
                      " And HQ_SANITATIONMAN_MESSAGE.HQ_SANITATIONMAN_NAME like";
              builder.append(sql).append("'%"+seek+"%'").append(" And  HQ_HW_HWFL.HQ_HW_ID=").append("'"+sanitationmantype+"'");
          }
        PageModel<Map<Object,String>> list = queryForPageBySql(builder.toString(), currentPage, pageSize);
        return list;

    }


    /**
     * 编辑环卫工人信息
     * @return
     */
    @Override
    public Integer updateMessage(String Name,String sex,Date birthdate,String type,String phone,String background,String ID) {
        StringBuilder builder =new StringBuilder();
        String sql="\tUPDATE \n" +
                "HQ_SANITATIONMAN_MESSAGE  a\n" +
                "\tSET \n" +
                "\ta.HQ_SANITATIONMAN_NAME=?,\n" +
                "\ta.HQ_SANITATIONMAN_SEX=?,\n" +
                "  a.HQ_SANITATIONMAN_BIRTHDATE=TO_DATE('2018-01-01','yyyy-mm-dd'),\n" +
                "\ta.HQ_SANITATIONMAN_TYPE=?,\n" +
                "\ta.HQ_SANITATIONMAN_PHONE=?,\n" +
                "\ta.HQ_SANITATIONMAN_BACKGROUND=?\n" +
                "\tWHERE\n" +
                "\ta.HQ_SANITATIONMAN_ID=?";
        List<Object> params=new ArrayList<>();
           params.add(Name);
           params.add(sex);
           params.add(type);
           params.add(phone);
           params.add(background);
           params.add(ID);
          builder.append(sql);
        Integer  list =executeSql(builder.toString(),params);
        return list;
    }
/*
* 查询环卫工的所有类型
* */
    @Override
    public List<Map<String, Object>> InquireSanitationmanType() {
        StringBuilder builder = new StringBuilder();
           String sql="SELECT HQ_HW_HWFL.HQ_HW_ID,HQ_HW_HWFL.HQ_HW_FLNAME FROM HQ_HW_HWFL";
           builder.append(sql);
          List<Map<String, Object>>  list =querySqlObjects(builder.toString());
         return   list;
    }

    @Override
    public Integer deleteMessage(String ID) {
        StringBuilder builder = new StringBuilder();
        String sql="UPDATE HQ_SANITATIONMAN_MESSAGE a SET   a.STATUS=1 WHERE a.HQ_SANITATIONMAN_ID=?";
        List<Object> params=new ArrayList<>();
        builder.append(sql);
        params.add(ID);
        Integer  i =executeSql(builder.toString(),params);
        return i;
    }


}
