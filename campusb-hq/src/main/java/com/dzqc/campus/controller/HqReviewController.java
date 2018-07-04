package com.dzqc.campus.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzqc.campus.common.dto.AjaxResult;

import com.dzqc.campus.entity.HqHwKp;
import com.dzqc.campus.entity.HqHwPpDj;
import com.dzqc.campus.org.entity.User;
import com.dzqc.campus.org.service.UserService;
import com.dzqc.campus.org.util.WebHelper;
import com.dzqc.campus.service.HqHwFzrService;
import com.dzqc.campus.service.HqHwGlyXqService;
import com.dzqc.campus.service.HqHwPpDjService;
import com.dzqc.campus.service.HqHwReviewService;
import com.dzqc.campus.service.HwZqyglService;

@Controller
@RequestMapping("/hw")
public class HqReviewController {
	@Autowired
	private HqHwReviewService hhrs;
	
	@Autowired
	private HqHwGlyXqService hhgxs;
	
	@Autowired
	private HwZqyglService hzs;
	
	@Autowired
	private HqHwFzrService hfzs;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private HqHwPpDjService hhpds;
	
	@RequestMapping("/wykp")
	public String wykp(HttpServletRequest req,Model model) {
		System.out.println("+++++++++++wyKp++++++++++");
		String id=((User)req.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER)).getId();
		User user=us.findUserById(id);
		System.out.println(user.getRealName());
		model.addAttribute("name", user.getRealName());
		model.addAttribute("id", id);
		return "houqin/hw/Review";
	}
	
	@RequestMapping("/fqy")
	@ResponseBody
	public AjaxResult fqy() {
		System.out.println("-----------------fqy------------");
		List<Map<String, Object>> list=hhgxs.findall();
		System.out.println(list);
		return AjaxResult.success(list);
	}
	
	@RequestMapping("/zqygls")
	@ResponseBody
	public AjaxResult zqygl(String id) {
		System.out.println("==================zqgl======================");
		List<Map<String, Object>> list=hzs.list(id);
		System.out.println(list);
		return AjaxResult.success(list);
	}
	
	@RequestMapping("/Reviewfzr")
	@ResponseBody
	public AjaxResult Reviewfzr(String id) {
		System.out.println("===--------Reviewfzr------========");
		List<Map<String, Object>> list=hfzs.getfzr(id);
		System.out.println(list);
		return AjaxResult.success(list);
	}
	
	@RequestMapping("/Reviewkpdj")
	@ResponseBody
	public AjaxResult Reviewkpdj() {
		System.out.println("_____+++)__++_)__+__Reviewkpdj+++++____________________+");
		List<Map<String,Object>> list=hhpds.fingkpdj();
		System.out.println("SDFGHJKL:SDFGHJKL:jkdnij nkojkojkpkklpkpo");
		System.out.println(list);
		return AjaxResult.success(list);
	}
	
	@RequestMapping("/Reviewbaocun")
	@ResponseBody
	public  AjaxResult Reviewbaocun(HttpServletRequest request) throws ParseException {
		System.out.println("GHHHHHHJKJJKLKLJKHHJKHJJKHJKHHKJLJKJKJJJI++++Reviewbaocun=======");
		String fqy=request.getParameter("fqy");
		System.out.println("fqy:"+fqy);
		String zqy=request.getParameter("zqy");
		System.out.println("zqy:"+zqy);
		String fzrid = request.getParameter("fzrid");
		System.out.println("fzrid:"+fzrid);
		String kpr=request.getParameter("kpr");
		System.out.println("kpr:"+kpr);
		String kpdj=request.getParameter("kpdj");
		System.out.println("kpdj:"+kpdj);
		String kpnr=request.getParameter("kpnr");
		System.out.println("kpnr:"+kpnr);
		String nm=request.getParameter("nm");
		System.out.println("nm:"+nm);
		HqHwKp h=new HqHwKp();
		h.setHQ_HW_FB_ZT(1);
		h.setHQ_HW_FQYGL_ID(fqy);
		h.setHQ_HW_FZR_ID(fzrid);
		h.setHQ_HW_KPDJ_ID(kpdj);
		HqHwPpDj p=hhpds.findone(kpdj);
		if(p.getGrade().equalsIgnoreCase("D") || p.getGrade().equalsIgnoreCase("E")) {
			System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
			h.setHQ_HW_KPLX(1);
		}else {
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			h.setHQ_HW_KPLX(0);
		}
		h.setHQ_HW_KPNR(kpnr);
		h.setHQ_HW_KPR_ID(kpr);
		if(nm!=null) {
			h.setHQ_HW_KPR_ID(nm);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
		Date date = df.parse(df.format(new Date()));
		h.setHQ_HW_KPSJ(date);
		h.setHQ_HW_KY_ZT(0);
		h.setHQ_HW_ZQYGL_ID(zqy);
		hhrs.save(h);
		return AjaxResult.success("保存成功!");
	}
	
	@RequestMapping("/Reviewfabu")
	@ResponseBody
	public  AjaxResult Reviewfabu(HttpServletRequest request) throws ParseException {
		System.out.println("GHHHHHHJKJJKLKLJKHHJKHJJKHJKHHKJLJKJKJJJI++++Reviewfabu=======");
		String fqy=request.getParameter("fqy");
		System.out.println("fqy:"+fqy);
		String zqy=request.getParameter("zqy");
		System.out.println("zqy:"+zqy);
		String fzrid = request.getParameter("fzrid");
		System.out.println("fzrid:"+fzrid);
		String kpr=request.getParameter("kpr");
		System.out.println("kpr:"+kpr);
		String kpdj=request.getParameter("kpdj");
		System.out.println("kpdj:"+kpdj);
		String kpnr=request.getParameter("kpnr");
		System.out.println("kpnr:"+kpnr);
		String nm=request.getParameter("nm");
		System.out.println("nm:"+nm);
		HqHwKp h=new HqHwKp();
		h.setHQ_HW_FB_ZT(0);
		h.setHQ_HW_FQYGL_ID(fqy);
		h.setHQ_HW_FZR_ID(fzrid);
		h.setHQ_HW_KPDJ_ID(kpdj);
		HqHwPpDj p=hhpds.findone(kpdj);
		if(p.getGrade().equalsIgnoreCase("D") || p.getGrade().equalsIgnoreCase("E")) {
			System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
			h.setHQ_HW_KPLX(1);
		}else {
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			h.setHQ_HW_KPLX(0);
		}
		h.setHQ_HW_KPNR(kpnr);
		h.setHQ_HW_KPR_ID(kpr);
		if(nm!=null) {
			h.setHQ_HW_KPR_ID(nm);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
		Date date = df.parse(df.format(new Date()));
		h.setHQ_HW_KPSJ(date);
		h.setHQ_HW_KY_ZT(0);
		h.setHQ_HW_ZQYGL_ID(zqy);
		hhrs.save(h);
		return AjaxResult.success("发布成功!");
	}
}
