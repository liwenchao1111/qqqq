package com.dzqc.campus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwFqygl;
import com.dzqc.campus.entity.HqHwZqyGL;
import com.dzqc.campus.service.HqHwFqyglService;
import com.dzqc.campus.service.HwZqyglService;

@Controller
@RequestMapping("/hw")
public class HqHwZqyGlController {
	@Autowired
	private HwZqyglService zqyservice;
	@Autowired
	private HqHwFqyglService fqyService;
	
	
	@RequestMapping("/zqygl")
	public String zqygl() {
		
		return  "houqin/hw/regional_management";
	}
	@RequestMapping("/zqycx")
	@ResponseBody
	public AjaxResult findall(HttpServletRequest request,String name,Integer bm,String fqy,Integer pageSize,Integer currentPage) {
		PageModel<Map<String, Object>> zqyxq;
		List<HqHwFqygl>hwfl = fqyService.findAll();
		
		try {
			zqyxq = zqyservice.findZqygl(name,bm,fqy, 1, 10);
			System.out.println(name);
			System.out.println(zqyxq.toString());
		
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return AjaxResult.fail("查询失败");
		}
		return AjaxResult.success(zqyxq);
		
	}
	
	@RequestMapping("/addzqy")
	@ResponseBody
	public AjaxResult addzqy(HttpServletRequest request,String zname,String fid) {
		 System.out.println(fid);
		 try {
			
			HqHwZqyGL zqy=new HqHwZqyGL();
			 zqy.setHW_ZQY_NAME(zname);
			 zqy.setHW_FQY_ID(fid);
			 zqy.setSTATUS(0);
			 System.out.println(zname);
			 zqyservice.addzqy(zqy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return AjaxResult.fail("失败");
		}
		return  AjaxResult.success("成功");
	}
	
	@RequestMapping("/deletezqy")
	@ResponseBody
	public AjaxResult deletezqy(HttpServletRequest request) {
	try {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		zqyservice.deletezqy(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return AjaxResult.fail("删除失败");
	}
		return AjaxResult.success("删除成功");
	}
	
	@RequestMapping("/change")
	@ResponseBody
	public AjaxResult change(HttpServletRequest request) {
		try {
			String newname = request.getParameter("newname");
			String id  = request.getParameter("id");
			String fid = request.getParameter("fid");
			id = id.trim();
			zqyservice.updatezqy(id,newname,fid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return AjaxResult.fail("修改失败");
		}
		return AjaxResult.success("成功");
	}
	@RequestMapping("/select")
	@ResponseBody
	public AjaxResult select() {
		
		List<HqHwFqygl>list = fqyService.findAll();
	System.out.println(list.toString());
		return AjaxResult.success(list);
		
	}
	
}
