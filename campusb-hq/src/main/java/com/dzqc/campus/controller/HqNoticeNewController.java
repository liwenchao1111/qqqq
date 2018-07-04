package com.dzqc.campus.controller;


import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwZqy;
import com.dzqc.campus.entity.HqNoticeNew;
import com.dzqc.campus.service.HqNoticeNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/gg")
public class HqNoticeNewController {

    @Autowired
    private HqNoticeNewService hqNoticeNewService;


    /**
     * 新建公告
     * @return
     */
//    @RequestMapping("/NewNotice")
//    @ResponseBody
//    public AjaxResult  NewNotice(String Area,
//                                 String Headline,
//                                 String Issuer,
//                                 String Content,
//                                 String Time,
//                                 String Root,
//                                 String keepAndSub
//                                ) throws ParseException {
//        HqNoticeNew   hqNoticeNew=new HqNoticeNew();
//           hqNoticeNew.setHqNoticeArea("南区");  //公告区域
//           hqNoticeNew.setHqNoticeHeadline("暑假通知"); //公告标题
//           hqNoticeNew.setHqNoticeIssuer("教务处"); //公告发布人
//           hqNoticeNew.setHqNoticeContent("南区于2018-06-06日放暑假，假期60天");//公告内容
//               /*字符串转换时间*/
//               DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//               Date date = null;
//               date = format1.parse("2018-06-01");
//           hqNoticeNew.setHqNoticeTime(date);//公告保存时间
//           hqNoticeNew.setHqNoticeRoot(1);//公告查看权限
//           if (keepAndSub.equals("保存")){
//                hqNoticeNew.setHqNoticePublish(0);
//           }else if(keepAndSub.equals("保存并发布")){
//               hqNoticeNew.setHqNoticePublish(1);
//           }
//          hqNoticeNewService.save(hqNoticeNew);
//
//        return AjaxResult.success(hqNoticeNew,"新建公告");
//    }


    
    
//  //分页查询
//  	 @RequestMapping("/list")
//  		@ResponseBody
//  		public AjaxResult chakan(String hqNoticeHeadline, Integer hqNoticePublish,Integer HQ_HW_FQY_ID,Integer currPage) {
//  			Integer pageSize=5;
//  			
//  			System.out.println("查看是否进来");
//  			
//  		//	List<HqWxQd> list=hqwxqdService.findBySTATUS(tid);
//  			
//  			PageModel<HqNoticeNew> hqNotice=hqNoticeNewService.findByParams(hqNoticeHeadline,currPage, pageSize,hqNoticePublish);
//  			System.out.println(hqNotice.toString());
//  			
//  			return AjaxResult.success(hqNotice);	
//  		}
//  	 
//  	 //删除，更改状态码0为1
//	 @RequestMapping("/shan")
//	    public String shanchu(String hqNoticeId) {
//		 Integer ticeid=hqNoticeNewService.updateSTATUS(hqNoticeId);
//	        return "houqin/";
//	    }
//    
//	 //发布，更改状态码0为1
//	 @RequestMapping("/fabu")
//	    public String fabu(String hqNoticeId) {
//		 Integer delete=hqNoticeNewService.updateNoticeDelete(hqNoticeId);
//	        return "houqin/";
//	    }
//	 
//	 
//	 //根据ID查看详情
//	 
//	 @RequestMapping("/xiangq")
//		@ResponseBody
//		public AjaxResult xiangq(String hqNoticeId) {
//			System.out.println("查看详情");
//			List<HqNoticeNew> hqnotice=hqNoticeNewService.findList(hqNoticeId);
//			System.out.println(hqnotice.toString());
//			return AjaxResult.success(hqnotice);	
//		}
}
