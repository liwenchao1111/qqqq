package com.dzqc.campus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwPpDj;
import com.dzqc.campus.service.HqHwPpDjService;


@Controller
@RequestMapping("/hw")
public class HqHwPpDjController {
	@Autowired
	private HqHwPpDjService hqhwppdjservice;
	
	@RequestMapping("/ppdzfz")
	public ModelAndView door(ModelAndView mv) {
		mv.setViewName("houqin/hw/ppdjfz");
		return mv;
	}
	
	@RequestMapping("/ppdj")
	@ResponseBody
	public AjaxResult getHqAdminXq(Integer currentPage, Integer rowsInPage)throws Exception {
		PageModel<List<HqHwPpDj>> findPpDj = hqhwppdjservice.findHqHwPpDjAll(currentPage, rowsInPage);
		if(findPpDj==null) {
			return AjaxResult.fail("没有数据");
		}
		return AjaxResult.success(findPpDj);
	}
	
	@RequestMapping("/addppdj")
	@ResponseBody
	public AjaxResult addppdj(String grade,String remark,String type) {
		  try {
			  HqHwPpDj ppdj = new HqHwPpDj();
			  ppdj.setGrade(grade);	
			  ppdj.setStatus(0);
			  ppdj.setRemark(remark);
			  if(!type.trim().equals("投诉")) {
				  ppdj.setType(0); 
			  }else {         
				  ppdj.setType(1);
			  }
			  Integer i = hqhwppdjservice.saveHqHwPpDj(ppdj);
			  if(i==1) {
				  return AjaxResult.success("插入成功!");
			  }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return AjaxResult.fail("插入失败");
	        }
	        return AjaxResult.success("插入成功!");
	}
	@RequestMapping("/updateppdj")
	@ResponseBody
	public AjaxResult updateppdj(String id) {
		 HqHwPpDj ppdj = new HqHwPpDj();
		 ppdj.setId(id);
		 Integer updatepf = hqhwppdjservice.updatepf(ppdj);
		 if(updatepf==1) {
			 return AjaxResult.success("修改成功");
		 }
		return AjaxResult.fail("失败");
	}
	@RequestMapping("/deleteppdj")
	@ResponseBody
	public AjaxResult deleteppdj(String id) {
		 HqHwPpDj ppdj = new HqHwPpDj();
		 ppdj.setId(id);
		 Integer updatepf = hqhwppdjservice.deletepf(ppdj);
		 if(updatepf==1) {
			 return AjaxResult.success("删除成功");
		 }
		return AjaxResult.fail("失败");
	}	
}
