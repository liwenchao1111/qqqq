package com.dzqc.campus.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwFqygl;
import com.dzqc.campus.service.HqHwFqyglService;
@Controller
@RequestMapping("/hw")
public class HqHwFqyglController {
	@Autowired
	private HqHwFqyglService fqyglService;
	
	@RequestMapping("/fqygl")
	public ModelAndView door(ModelAndView mv) {
		mv.setViewName("houqin/hw/fqygl");
		return mv;
	}
	@RequestMapping("/fqygls")
	@ResponseBody
	public AjaxResult getHqAdminXq(HttpServletRequest request,String name,Integer pageSize,Integer currentPage) {
		PageModel<Map<String,Object>> fqyxq;
		try {
			fqyxq=fqyglService.findFqygl(name,1, 10);
		} catch (Exception e) {
			return AjaxResult.fail("信息查询异常");
		}
		return AjaxResult.success(fqyxq);
	}
	@RequestMapping("/addfqy")
	@ResponseBody
	public AjaxResult addfqy(HttpServletRequest request,String fqyname) {
		  try {
	        	HqHwFqygl fqy = new HqHwFqygl();
	        	fqy.setFname(fqyname);
	        	System.out.println(fqyname);
	        	fqy.setStatus(0);
	        	fqyglService.addfqy(fqy);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return AjaxResult.fail("插入失败");
	        }
	        return AjaxResult.success("插入成功!");
	}
	@RequestMapping("/updatefqy")
	@ResponseBody
	public AjaxResult updatefqy(HttpServletRequest request,String fname) {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		fqyglService.updatefqy(id, fname);
		System.out.println(fname);
		return AjaxResult.success("修改成功");
	}
	@RequestMapping("/deletefqy")
	@ResponseBody
	public AjaxResult deletefqy(HttpServletRequest request) {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		fqyglService.deletefqy(id);
		return AjaxResult.success("删除成功");
	}
}
