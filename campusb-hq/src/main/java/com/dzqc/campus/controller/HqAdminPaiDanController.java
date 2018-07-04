package com.dzqc.campus.controller;


import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.entity.HqApWx;
import com.dzqc.campus.entity.HqWxDate;
import com.dzqc.campus.org.entity.User;
import com.dzqc.campus.org.util.WebHelper;
import com.dzqc.campus.service.HqAdminHqUserXqService;
import com.dzqc.campus.service.HqAdminPaiDanService;
import com.dzqc.campus.service.HqWxQdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/qpdy")/*去派单，有空闲*/
public class HqAdminPaiDanController {
    @Autowired
    private HqAdminPaiDanService hqAdminPaiDanService;
    @Autowired
    private HqAdminHqUserXqService hqAdminHqUserXqService;
    @Autowired
    private HqWxQdService hqWxQdService;
    @RequestMapping("/list")
    public String QPDY() {
        return "houqin/pd_free";/*跳转到去派单有空闲的页面(pd_free.jsp)*/
    }

    @RequestMapping("/wkx")
    public String WKX() {
        return "houqin/aaa";
    }

    /**
     * 哪个学生保修的,他的信息
     *
     * @return
     */
    @RequestMapping("/BaoXuiRen")
    @ResponseBody
    public AjaxResult BaoXuiRenMessage(String userid) {
        List<Map<String, Object>> StudentMessage = hqAdminPaiDanService.StudentMessage(userid);
        System.out.println("----------" + StudentMessage);
        return AjaxResult.success(StudentMessage, "学生保修的信息");
    }

    /**
     * 空闲的维修员的信息,并且维修员能维修学生报修的问题
     *
     * @return
     */
    @RequestMapping("/KongXiangRenYuan")
    @ResponseBody
    public AjaxResult KongXiangRenYuan(String working, String RiQi) {

        System.out.println("维修项目" + working);
        System.out.println("日期" + RiQi);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //时间转为字符串
        LocalDateTime date = LocalDateTime.now();
        //String str = date.format(RiQi);  // 2014-11-07 14:10:36
        //字符串转为时间
        System.out.println("这个时间是" + RiQi);
        date = LocalDateTime.parse(RiQi, f);
        List<Map<String, Object>> KXWXY = hqAdminPaiDanService.KongXianWeiXiuRenYuan(working, date);
        System.out.println("----------" + KXWXY);
        return AjaxResult.success(KXWXY, "空闲的维修员");
    }

    /**
     * 提交指派的维修员
     *
     * @return
     */
    @RequestMapping("/designate")
    @ResponseBody
    public AjaxResult designate(HttpServletRequest Request, String[] shuzu, String ID, String RQ, String QDID) throws ParseException {
        for (int i = 0; i < shuzu.length; i++) {
            System.out.println("数组中的值是:" + shuzu[i]);
        }
        System.out.println("维修人员的ID" + ID);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟
        //字符串转日期
        Date date1 = sdf.parse(shuzu[0]);
        Date date2 = sdf.parse(shuzu[1]);
        //获取管理员的id
        User user = (User) Request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
        String SessionID = user.getId();
        //持久化数据
        HqApWx hqApWx = new HqApWx();
        hqApWx.setID(SessionID);//管理员id
        hqApWx.setHQ_ID(ID);//维修人员的id
        hqApWx.setHQ_WX_QD_ID(QDID);//清单id
        hqApWx.setHQ_WX_AP_K_TIME(date1);//开始时间
        hqApWx.setHQ_WX_AP_G_TIME(date2);//结束时间
        hqAdminPaiDanService.save(hqApWx);
        if (hqApWx != null) {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime date = LocalDateTime.now();
            //字符串转为时间
            date = LocalDateTime.parse(RQ, f);
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date zhuandate = null;
            zhuandate = format1.parse(RQ);
            Integer jieduanshu = hqAdminHqUserXqService.jiedanshu(ID, date);
            System.out.println("结果集是" + jieduanshu);
            if (jieduanshu == null) {
                System.out.println("是否执行");
                Integer JDS = 1;
                System.out.println("时间为空的时候：" + jieduanshu);
                /*hqAdminHqUserXqService.gengxing(JDS,ID);*/
                HqWxDate hqWxDate = new HqWxDate();
                hqWxDate.setHQUSERWORK(JDS);
                hqWxDate.setHQWXRYID(ID);
                hqWxDate.setHQWXRQ(zhuandate);
                hqAdminHqUserXqService.save(hqWxDate);
                hqAdminHqUserXqService.weixiuzhangtai(QDID);
                 int i =hqWxQdService.insertQD(SessionID,ID,QDID);
                System.out.println("我是几"+i);
            } else {
                System.out.println("今天接了：" + jieduanshu);
                Integer JDS = jieduanshu + 1;
                if (JDS > 0 && JDS < 5) {
                    hqAdminHqUserXqService.gengxing(JDS, ID);
                    hqAdminHqUserXqService.weixiuzhangtai(QDID);
                    hqWxQdService.insertQD(SessionID,ID,QDID);
                }
            }
        }
        return AjaxResult.success(hqApWx, "确定派单");
    }
}


