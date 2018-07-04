package com.dzqc.campus.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.dzqc.campus.entity.HqFxm;
import com.dzqc.campus.entity.HqSxm;
import com.dzqc.campus.service.HqFSxmService;
import com.dzqc.campus.service.HqUserXqService;

@Controller
@RequestMapping("/wxxm")
public class HqFSxmController {
	@Autowired
	private HqUserXqService huXqService;
	@Autowired
	private HqFSxmService fsxmService;
	
	@RequestMapping("/list")
	@ResponseBody
	public ModelAndView toAdmin(ModelAndView model) {
		List<HqFxm> gzxm = huXqService.findGZXMList();
		List<HqSxm> sgzxm = fsxmService.selectSxm();
		model.addObject("gzxm", gzxm);
		model.addObject("sgzxm", sgzxm);
		model.setViewName("houqin/WXXM");
		return model;
	}
	@RequestMapping("/insertfxm")
	@ResponseBody
	public AjaxResult InsertFxm(HttpServletRequest request,String xmname) {
		try {
			fsxmService.insertWXXM(xmname);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("插入失败");
		}
		return AjaxResult.success("插入成功");
	}
	@RequestMapping("/insertsxm")
	@ResponseBody
	public AjaxResult InsertSxm(HttpServletRequest request,String xmname,String sid) {
		try {
			fsxmService.insertSWXXM(xmname,sid);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("插入失败");
		}
		return AjaxResult.success("插入成功");
	}
	@RequestMapping("/updatefxm")
	@ResponseBody
	public AjaxResult Updatefxm(HttpServletRequest request,String Hq_fxm_mc,String fid) {
		try {
			fid = fid.trim();
			fsxmService.UpdateWXXM(Hq_fxm_mc,fid);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("修改失败");
		}
		return AjaxResult.success("修改成功");
	}
	@RequestMapping("/updatesxm")
	@ResponseBody
	public AjaxResult Updatesxm(HttpServletRequest request,String HQ_SXM_MC,String sid) {
		try {
			sid = sid.trim();
			fsxmService.UpdateSWXXM(HQ_SXM_MC,sid);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("修改失败");
		}
		return AjaxResult.success("修改成功");
	}
	
}
