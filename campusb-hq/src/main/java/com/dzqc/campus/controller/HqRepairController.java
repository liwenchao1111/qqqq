package com.dzqc.campus.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dzqc.campus.org.entity.User;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqWxQd;
import com.dzqc.campus.org.util.WebHelper;
import com.dzqc.campus.service.HqRepairXqService;

@Controller
@RequestMapping("/hqwx") 
public class HqRepairController {
	
	@Autowired
	private HqRepairXqService hqRepairXqService;
	
	
	
	@RequestMapping("/Repair")
	public String Repair(Model model,String id) {
		System.out.println("Repair");
		System.out.println(id);
		model.addAttribute("id", id);
		return "houqin/wxxq";
	}
	
	@RequestMapping("/listes")
	public ModelAndView log1(HttpServletRequest req) {
		String id=((User)req.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER)).getId();
		System.out.println("维修员id："+id);
		Integer count=hqRepairXqService.count("0", id);
		ModelAndView view=new ModelAndView();
		view.setViewName("houqin/wxqdlb");
		view.addObject("count",count);
		return view;
	}
	
	@RequestMapping("/wxxq")
	@ResponseBody
	public AjaxResult wxxq(String id) throws ParseException{
		Map<String, Object> map=hqRepairXqService.queryRepair(id);
		Date day=(Date)map.get("HQ_BX_RQ");
        String userid=(String)map.get("HQ_GLY_RY_ID");
        Map<String, Object> user=hqRepairXqService.findUserbyId(userid);
        map.put("REAL_NAMEL", user.get("REAL_NAME"));
        map.put("MOBILE", user.get("MOBILE"));
        String s=(String)map.get("HQ_WX_GZTP");
        String[] sArray=s.split(",");
        List<Map<String, Object>> list1=new ArrayList<>();
        for(int i=0;i<sArray.length;i++) {
        	Map<String, Object> map1=new HashMap<>();
        	map1.put("img",sArray[0]);
        	list1.add(map1);
        }
        map.put("imgaes", list1);
        List<Map<String, Object>> list=new ArrayList<>();
        list.add(map);
		return AjaxResult.success(list, "成功");
	}

	@RequestMapping("/lists")
	@ResponseBody
	public AjaxResult getHqUserXq(HttpServletRequest request,Integer currentPage,Integer pageSize,String state) {
		User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
		System.out.println("lists");
		PageModel<HqWxQd> hqwxqd = null;
		hqwxqd=hqRepairXqService.queryRepairPageByUserName(user.getId(),currentPage,pageSize,state);
		return AjaxResult.success(hqwxqd);
	}

	
	@RequestMapping("/update1")
	@ResponseBody
	public AjaxResult update1(String id){
		hqRepairXqService.UpdateToweixiuzhong(id);
		return AjaxResult.success("成功");
	}
	
	
	@RequestMapping("/update2")
	@ResponseBody
	public AjaxResult update2(String id){
		hqRepairXqService.UpdateTojieshu(id);
		return AjaxResult.success("成功");
	}
	
	@RequestMapping("/count")
	@ResponseBody
	public AjaxResult count(HttpServletRequest re) {
		String id=((User)re.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER)).getId();
			System.out.println("count");
			System.out.println(id);
		 Integer count=hqRepairXqService.count("0", id);
		 System.out.println(count);
		 Integer count1=hqRepairXqService.count("2", id);
		 System.out.println(count1);
		 Integer count2=hqRepairXqService.count("3", id);
		 System.out.println(count2);
		 Integer count3=hqRepairXqService.count("4", id);
		 System.out.println(count3);
		 Integer count4=hqRepairXqService.count("5", id);
		 System.out.println(count4);
		 List<Map<String, Object>> list=new ArrayList<>();
		 Map<String, Object> map= new HashMap<>();
		 map.put("count", count);
		 map.put("count1", count1);
		 map.put("count2", count2);
		 map.put("count3", count3);
		 map.put("count4", count4);
		 list.add(map);
		return AjaxResult.success(list);
	}

	
	@RequestMapping("/judan")
	@ResponseBody
	public AjaxResult  getHqRepairQd(HttpServletRequest request,String wx_ry_id,String qd_id) {
		hqRepairXqService.rejectToOrder(wx_ry_id, qd_id);
		return AjaxResult.success("成功");
	}


	@RequestMapping("/jiedan")
	@ResponseBody
	public AjaxResult getHqRepairQd1(HttpServletRequest request,String qd_id) {
		hqRepairXqService.UpdateTojiedan(qd_id);
		return AjaxResult.success("成功");
	}
	

}
