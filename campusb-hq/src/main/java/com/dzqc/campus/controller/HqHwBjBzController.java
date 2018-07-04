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
import com.dzqc.campus.entity.HqHwBjBz;
import com.dzqc.campus.entity.HqHwLx;
import com.dzqc.campus.service.HqHwBjBzService;

@Controller
@RequestMapping("/hw")
public class HqHwBjBzController {
	@Autowired
	private HqHwBjBzService hqHwBjBzService;
	@RequestMapping("/bjbz")
	@ResponseBody
	public ModelAndView getHqFxm(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		List<HqHwLx> HqHwLx = hqHwBjBzService.findHwLxList();
		modelAndView.addObject("HqHwLx", HqHwLx);
		modelAndView.setViewName("houqin/hw/clean_standard");
		return modelAndView;
	}

	@RequestMapping("/hwBjBzList")
	@ResponseBody
	public AjaxResult hwBjBzList(HttpServletRequest request, String mc, String lx, Integer currentPage,
			Integer pageSize) {
		PageModel<Map<String, Object>> user;
		System.out.println(mc + lx);
		try {
			user = hqHwBjBzService.findBjBzList(mc, lx, currentPage, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("信息查询异常");
		}
		return AjaxResult.success(user, "成功查询");
	}
	@RequestMapping("/insertBjBz")
	@ResponseBody
	public AjaxResult insertBjBz(HttpServletRequest request) {
		try {
			String mc = request.getParameter("mc");
			String lx = request.getParameter("lx");
			String xq = request.getParameter("xq");
			HqHwBjBz hqHwBjBz=new HqHwBjBz();
			hqHwBjBz.setBjBzName(mc);
			hqHwBjBz.setHwLxId(lx);
			hqHwBjBz.setBjBzXq(xq);
			hqHwBjBz.setStatus(0);
			hqHwBjBzService.insertBjBz(hqHwBjBz);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("插入失败");
		}
		return AjaxResult.success("插入成功");
	}
	@RequestMapping("/deleteBjBz")
	@ResponseBody
	public AjaxResult deleteBjBz(HttpServletRequest request) {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		hqHwBjBzService.DeleteBjBz(id);
		return AjaxResult.success("删除成功");
	}
	@RequestMapping("/updateBjBz")
	@ResponseBody
	public AjaxResult updateBjBz(HttpServletRequest request, String id) {
		try {
			System.out.println("进入方法");
			System.out.println(id);
			String mc = request.getParameter("mc");
			String hwId = request.getParameter("hwId");
			String xq = request.getParameter("xq");
			HqHwBjBz hqHwBjBz=new HqHwBjBz();
			hqHwBjBz.setBjBzName(mc);
			hqHwBjBz.setHwLxId(hwId);
			hqHwBjBz.setBjBzXq(xq);
			hqHwBjBzService.UpdateBjBz(id, mc, xq, hwId);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("修改失败");
		}
		return AjaxResult.success("修改成功");
	}
}
