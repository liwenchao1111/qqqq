package com.dzqc.campus.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqQdBj;
import com.dzqc.campus.entity.HqWxQd;
import com.dzqc.campus.service.HqQdBjAdminService;
import com.dzqc.campus.service.HqWxQdAdminService;


@Controller
@RequestMapping("/bxqd")
public class HqWxQdAdminController {
	
	//wuhao
	@Autowired
	private HqWxQdAdminService hqwxqdService;
	
	
	
	@Autowired
	private HqQdBjAdminService hqqdbjservice;
	
	
	@RequestMapping("/list")
	public ModelAndView findByUserIDWxQd01(HttpServletRequest re,ModelAndView view) throws Exception{
		Integer count = hqwxqdService.findCountById();
		System.out.println("0000000000000000000                  "+count);
		view.setViewName("houqin/admin_bxList");
		view.addObject("count", count);
		return view;
	}
	 
//	
//	@RequestMapping("/list")
//	public String findByUserIDWxQd01(Model model,String tid) throws Exception{
//		Integer count = hqwxqdService.findCountById();
//		System.out.println(count);
//		model.addAttribute("count",count);
//		
//		return "houqin/";
//	}
	
	@RequestMapping("/findCount")
	@ResponseBody
	public AjaxResult findCountStatus(HttpServletRequest request) throws Exception{
		List<Map<String, Object>> listmap=hqwxqdService.findCountStatus();
		if(listmap==null) {
			AjaxResult.fail("没有数据");
		}
		System.out.println("111111111111111                             "+listmap.size());
		return AjaxResult.success(listmap);
	}
	
	
	
	@RequestMapping("/wxdetail")
	public String detail(String id,Model model) {
	
		model.addAttribute("id",id);
		   System.out.println(id);
		return "houqin/wxdetail";
	}
	
	

	//wuhao
	
	@RequestMapping("/chakan")
	@ResponseBody
	public AjaxResult chakan(HttpServletRequest request,Integer currPage,String status,Model model) {
		Integer pageSize=5;
	//String	tid=request.getParameter("tid");
		System.out.println(status);
		System.out.println("查看是否进来");
		System.out.println(currPage+"nidaye");
	//	List<HqWxQd> list=hqwxqdService.findBySTATUS(tid);
		if(currPage==null) {
			currPage=1;
		}
		
		PageModel<HqWxQd> hqwxqd=hqwxqdService.findByParams(Integer.parseInt(status),currPage, pageSize);
		System.out.println(hqwxqd.toString());
		System.out.println(hqwxqd.getPageSize()+"000000000000000111111111111111111111");
		return AjaxResult.success(hqwxqd);	
	}
	
	@RequestMapping("/bohui")
	
	public ModelAndView bohui(HttpServletRequest request,Model model){
	String sid=request.getParameter("id");
	System.out.println("------------------------------");
		System.out.println(sid);
		System.out.println("---------------------------------------------");
		
	//int hqwxqd=hqwxqdService.update(sid);
		 return new ModelAndView("houqin/bohui","sid",sid);
			}
	
	//wuhao
	@RequestMapping("/alert")
	@ResponseBody
	public AjaxResult alert(String name,String id) {
		
		System.out.println("查看是否进来");
	//	List<HqWxQd> list=hqwxqdService.findBySTATUS(tid);
		System.out.println(name);
		System.out.println(id);
		int hqwxqd=hqwxqdService.update(id);
		HqQdBj hqb=new HqQdBj();
		hqb.setBJ_XQ(name);
		hqb.setHQ_QD_ID(id);
		Integer hqdbj=hqqdbjservice.insert(hqb);
		
		
		
		return AjaxResult.success(hqdbj);	
	}
	
	
	@RequestMapping("/xq")
	public String xq(String id,Model model){
		System.out.println(id);
       List<Map<String, Object>> hqwxqd=hqwxqdService.findBywxqdid(id);
		List<Map<String, Object>> hqbj=hqwxqdService.findByBjxq(id);
	
		System.out.println(hqwxqd.toString());
		System.out.println(hqwxqd.size());
		System.out.println(hqbj.toString());
		
		Map<String, Object> map=hqwxqd.get(0);
		Map<String, Object> map1=hqbj.get(0);
		model.addAttribute("map",map);
		model.addAttribute("map1",map1);
		System.out.println(map.toString());
		System.out.println(map1.toString());
		return "houqin/request_xq";
	}
	@RequestMapping("/qdxq")
	@ResponseBody
	public AjaxResult wxxq(String id) throws ParseException{
		System.out.println("维修清单************************************");
		System.out.println(id);
		Map<String, Object> map=hqwxqdService.findQdxqList(id);
		System.out.println(map);
		Map<String, Object> map1=new HashMap<>();
		Date day=(Date)map.get("HQ_BX_RQ");
		System.out.println("报修时间:"+day);
        Date day1=new Date();
        System.out.println("当前时间1"+day1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Date day2=df.parse(df.format(day1));
        System.out.println("当前时间2:"+day2);
        int time=(int)((day2.getTime()-day.getTime())/1000);
        System.out.println("多少时间分钟:"+time);
       
        System.out.println("gchdghb hjsgdhb hj"+map.get("HQ_WX_RQ"));
        String wxid=(String)map.get("HQ_WX_RY_ID");
        String sta=(String)map.get("HQ_WX_STATUS");
        
        if(sta.equals("2")||sta.equals("3")||sta.equals("4")||sta.equals("5")||sta.equals("6")||sta.equals("7")||sta.equals("8")) {
        	 Map<String, Object> wxry=hqwxqdService.findUserbyId(wxid);
        	 String WXRY_NAME=(String)wxry.get("WXRY_NAME");
        	 String MOBILE=(String)wxry.get("MOBILE");
        	 System.out.println(wxry.get("WXRY_NAME"));
             System.out.println(wxry.get("MOBILE"));
             map.put("WXRY_NAME", WXRY_NAME);
             map.put("MOBILE", MOBILE);
        }
//        if(sta.equals("2")||sta.equals("3")||sta.equals("4")||sta.equals("5")||sta.equals("6")||sta.equals("7")||sta.equals("8")){
//        	 Map<String, Object> wxap=hqwxqdService.findApbyId(id);
//        	Date HQ_WX_AP_K_TIME = (Date)wxap.get("HQ_WX_AP_K_TIME");
//        	 System.out.println(wxap.get("HQ_WX_AP_K_TIME"));
//             map.put("HQ_WX_AP_K_TIME", HQ_WX_AP_K_TIME);
//        }
        map.put("time",time);
        map1.put("map", map);
        System.out.println(map1);
        List<Map<String, Object>> list=new ArrayList<>();
        list.add(map);
 		return AjaxResult.success(list, "成功");

	}

	//wuhao
}
	
