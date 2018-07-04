package com.dzqc.campus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwFzr;
import com.dzqc.campus.service.HqHwFzrService;



@Controller
@RequestMapping("/hw")
public class HqHwFzrController {

	@Autowired
	private HqHwFzrService hqHwFzrService;
	
	@RequestMapping("/sdfzr")
    public String tosdfzr() {
        return "houqin/hw/sdfzr";
    }
	
	@ResponseBody
	@RequestMapping("/listData")
	public Object getListData(Integer pageSize,Integer currentPage
			,String text){
		AjaxResult result = new AjaxResult();
		PageModel<Map<String, Object>> pages = null;
		 
		try{
			pages = hqHwFzrService.getListData(1 , 10);
			result.setData(pages);
			result.setMsg("数据返回成功");
		}catch (Exception e) {
			result.setMsg("后台信息查询失败！！");
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 
	 * 删除操作
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public AjaxResult deleteById(String id) {
		AjaxResult result = new AjaxResult();
		try{
			
			hqHwFzrService.deleteById(id);
			result.setSuccess(true);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
 
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert(HqHwFzr hqHwFzr){
		AjaxResult result = new AjaxResult();
		try{
			hqHwFzrService.insert(hqHwFzr);
			result.setSuccess(true);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
