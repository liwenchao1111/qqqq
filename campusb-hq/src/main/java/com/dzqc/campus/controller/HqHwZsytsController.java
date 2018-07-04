package com.dzqc.campus.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.dzqc.campus.common.entity.PageModel;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.entity.HqHwFqygl;
import com.dzqc.campus.entity.HqHwZqyGL;
import com.dzqc.campus.entity.HqHwZsyts;
import com.dzqc.campus.entity.HqSanitationmanMessage;
import com.dzqc.campus.org.entity.User;
import com.dzqc.campus.org.service.UserService;
import com.dzqc.campus.org.util.WebHelper;
import com.dzqc.campus.service.HqHwFqyglService;
import com.dzqc.campus.service.HqHwZsytsService;


@Controller
@RequestMapping("/hw")
public class HqHwZsytsController {
	@Autowired
	private HqHwFqyglService fqyglService;
	@Autowired
	private HqHwZsytsService hqHwZsytsService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/zsyts")
	public ModelAndView door(ModelAndView mv) {
		List<HqHwFqygl> list = fqyglService.findAll();
		mv.addObject("list", list);
		mv.setViewName("houqin/hw/zsyts");
		return mv;
	}
	@RequestMapping("/pjxq")
	public ModelAndView pjxq(ModelAndView mv) {
		mv.setViewName("houqin/hw/pjxq");
		return mv;
	}
	@RequestMapping("/selectZsyts")
	@ResponseBody
	public AjaxResult getHqAdminXq(HttpServletRequest request,String fqyname,String zqyname,Integer pageSize,Integer currentPage) {
		PageModel<Map<String,Object>> zsyts;
		String id = request.getParameter("id");
		try {
			zsyts=hqHwZsytsService.findZsyts(request,id,fqyname,zqyname, 1, 10);
		} catch (Exception e) {
			return AjaxResult.fail("信息查询异常");
		}
		return AjaxResult.success(zsyts);
	}
	
	@RequestMapping("/wypj")
	@ResponseBody
	public ModelAndView g(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
	/*	List<HqHwFqygl> hqHwFqygl =fqyglService.findList();
		List<HqHwZqyGL> hqHwZqyGL=hqHwZsytsService.findHqHwZqyGLList();
		modelAndView.addObject("hqHwFqygl", hqHwFqygl);
		modelAndView.addObject("hqHwZqyGL", hqHwZqyGL);*/
		String id=((User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER)).getId();
		User user=userService.findUserById(id);
		System.out.println(user.getRealName());
		modelAndView.addObject("name", user.getRealName());
		modelAndView.addObject("id", id);
		modelAndView.setViewName("houqin/hw/wypj");
		return modelAndView;
	}
	@RequestMapping("/insertHqHwFqygl")
	@ResponseBody
	public AjaxResult insertHqHwFqygl(HttpServletRequest request) throws Exception {
		List<HqHwFqygl> list = fqyglService.findList();
		return AjaxResult.success(list);
	}
	// 根据父类ID查询子类
	@RequestMapping("/insertHqHwZqyGL")
	@ResponseBody
	public AjaxResult insertHqHwZqyGL(HttpServletRequest request) {
		System.out.println("jinqule ");
		String id = request.getParameter("id");
		System.out.println(id);
		List<HqHwZqyGL> list = hqHwZsytsService.findHqHwZqyGLList(id);
		for(HqHwZqyGL i: list) {
			System.out.println(i);
		}
		if (list == null) {
			return AjaxResult.fail("没有查询到子类");
		}
		return AjaxResult.success(list);
	}
	@RequestMapping("/insertHqHwFZR")
	@ResponseBody
	public AjaxResult insertHqHwFZR(HttpServletRequest request) {
		System.out.println("jinqule ");
		String id = request.getParameter("id");
		String ids = request.getParameter("ids");
		System.out.println(id+"asssssssssssssssssssss"+ids);
		List<String> list = hqHwZsytsService.findHqHwFZR(id, ids);
		String s="";
		for (int i = 0; i < list.size(); i++) {
		    if (s=="") {
		    s=list.get(i);
		    }else {
		    s=s+","+list.get(i);
		    }
		}
		System.out.println(s);
		List<HqSanitationmanMessage> lists=hqHwZsytsService.findHqSan(s);
		if (lists == null) {
			return AjaxResult.fail("没有查询到负责人");
		}
		return AjaxResult.success(lists);
	}
	
	@RequestMapping("/insertS")
	@ResponseBody
	public AjaxResult insert(HttpServletRequest request, String xq, String qy, String fz, String kp, String kpr,String nr,String ming) {
		try {
			System.out.println(ming);
			System.out.println(xq+qy+fz+kp+kpr+nr);
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date Kpsj=df.parse(df.format(date));
		List<String> fzr  =	hqHwZsytsService.findHqSans(fz);
		String s="";
		for (int i = 0; i < fzr.size(); i++) {
		    if (s=="") {
		    s=fzr.get(i);
		    }else {
		    s=s+","+fzr.get(i);
		    }
		}
		HqHwZsyts hqHwZsyts=new HqHwZsyts();
		if(ming==null||ming=="") {
			hqHwZsyts.setFqyid(xq);
			hqHwZsyts.setZqyid(qy);
			hqHwZsyts.setFzrid(s);
			hqHwZsyts.setType(kp);
			hqHwZsyts.setUserid(kpr);
			hqHwZsyts.setKpnr(nr);
			hqHwZsyts.setKpsj(Kpsj);
			hqHwZsyts.setStatus(0);
		}else {
			hqHwZsyts.setFqyid(xq);
			hqHwZsyts.setZqyid(qy);
			hqHwZsyts.setFzrid(s);
			hqHwZsyts.setType(kp);
			hqHwZsyts.setUserid("匿名");
			hqHwZsyts.setKpnr(nr);
			hqHwZsyts.setKpsj(Kpsj);
			hqHwZsyts.setStatus(0);
		}
			hqHwZsytsService.insert(hqHwZsyts);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("插入失败");
		}
		return AjaxResult.success("插入成功");
	}
}
