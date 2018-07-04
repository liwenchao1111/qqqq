package com.dzqc.campus.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.service.HqHwQyLxService;

@Controller
@RequestMapping("/qylx")
public class HqHwQyLxController {
	@Autowired
	private HqHwQyLxService hqHwQyLxService;
	
	
	@RequestMapping("/qylxs")
	private String qylxs() {
		return "/huanwei/hwqylx";
	}
	
	@RequestMapping("/sousuo")
	@ResponseBody
	public AjaxResult getHqHwQyLx(Integer currentPage, Integer pageSize) {
		
		PageModel pagemodel = hqHwQyLxService.findBytype("1",currentPage,pageSize);
		
		return AjaxResult.success(pagemodel);
		
	}
	
	/**
	 * 添加数据
	 */
	public AjaxResult insertQyLx(Integer id, String typeName, String Comment) {
		hqHwQyLxService.addType(id, typeName, Comment);
		return AjaxResult.success("成功");
		
	}
	
	/**
	 * 查询数据
	 */
	@RequestMapping("/ajaxEmps")
	@ResponseBody
	public AjaxResult findMessage(Integer currentPage, Integer pageSize)throws ServletException,IOException{
		PageModel message  = hqHwQyLxService.query(currentPage, pageSize);
		return AjaxResult.success(message);
		
	}

}
