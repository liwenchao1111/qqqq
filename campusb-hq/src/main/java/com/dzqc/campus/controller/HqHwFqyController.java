package com.dzqc.campus.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwFqy;
import com.dzqc.campus.entity.HqHwFqygl;
import com.dzqc.campus.service.HqHwFqyService;
import com.dzqc.campus.service.HqHwFqyglService;
@Controller
@RequestMapping("/hw")
public class HqHwFqyController {
	@Autowired
	private HqHwFqyService hwqyService;
	@Autowired
	private HqHwFqyglService fqyglService;
	
	 @RequestMapping("/qqq")
	 public ModelAndView ceshi(ModelAndView mv) {
		List<HqHwFqygl> list = fqyglService.findAll();
		mv.addObject("list", list);
		mv.setViewName("houqin/hw/hwqyb2");
		return mv;
	}
	@RequestMapping("/hwqyb2")
	@ResponseBody
	public AjaxResult Hwqyb(HttpServletRequest request,String name,Integer pageSize,Integer currentPage) {
		PageModel<Map<String,Object>> hwqyxq;
		try {
			hwqyxq=hwqyService.findHwqy(name, currentPage, pageSize);
		} catch (Exception e) {
			return AjaxResult.fail("信息查询异常");
		}
		return AjaxResult.success(hwqyxq);
	}
	@RequestMapping("/addhwqy")
	@ResponseBody
	public AjaxResult addfqy(HttpServletRequest request,HqHwFqy hwfqy,String id) {
		  try {
			  	String jcgz = request.getParameter("jcgz");
			  	double hwjcgz=Double.parseDouble(jcgz);
			  	String wyfl = request.getParameter("wyfl");
			  	double hwwyfl=Double.parseDouble(wyfl);
			  	String glfl = request.getParameter("glfl");
			  	double hwglfl=Double.parseDouble(glfl);
			  	String gzys = request.getParameter("gzys");
			  	double hwgzys=Double.parseDouble(gzys);
			  	hwfqy.setFqyId(id);
			  	hwfqy.setHwJcgz(hwjcgz);
			  	hwfqy.setHwWyfl(hwwyfl);
			  	hwfqy.setHwGlfl(hwglfl);
			  	hwfqy.setHwGzys(hwgzys);
			  	hwfqy.setStatus(0);
			  	hwqyService.addHwqy(hwfqy, id);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return AjaxResult.fail("插入失败");
	        }
	        return AjaxResult.success("插入成功!");
	}
	@RequestMapping("/updatehwqy")
	@ResponseBody
	public AjaxResult updatefqy(HttpServletRequest request,String hwid,String jcgz,String wyfl,String glfl,String gzys,String fqyid) {
		hwid= request.getParameter("hwid");
		hwid = hwid.trim();
		hwqyService.updateHwqy(hwid, jcgz, wyfl, glfl, gzys, fqyid);
		return AjaxResult.success("修改成功");
	}
	@RequestMapping("/deletehwqy")
	@ResponseBody
	public AjaxResult deletefqy(HttpServletRequest request) {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		hwqyService.deleteHwqy(id);
		return AjaxResult.success("删除成功");
	}
}
