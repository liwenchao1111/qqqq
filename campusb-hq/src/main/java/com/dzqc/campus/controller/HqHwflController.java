package com.dzqc.campus.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqFxm;
import com.dzqc.campus.entity.HqHwHwfl;
import com.dzqc.campus.org.entity.Role;
import com.dzqc.campus.org.entity.User;
import com.dzqc.campus.service.HqFxmService;
import com.dzqc.campus.service.HqHwflService;

   
	@Controller
	@RequestMapping("/hw")
	public class HqHwflController {
		@Autowired
		private HqHwflService hqHwflService;
		public final static String ATTACH_SAVE_PATH = "attach";
		@Autowired
		private HqHwflService hqhwflService;
		
		@RequestMapping("/hwgfl")
		public String toJsp() {
			return "houqin/hw/hwgfl";
		}
		
		//模糊查询
		@RequestMapping("/chaxun")
		@ResponseBody
		public AjaxResult getHqHwflUser(HttpServletRequest request, String hwname, Integer currentPage,Integer pageSize) {
			PageModel<Map<String, Object>> PageModel;
			System.out.println(hwname);
			try {
				PageModel = hqhwflService.findUserListbyType(hwname, currentPage, 10);
			} catch (Exception e) {
				e.printStackTrace();
				return AjaxResult.fail("信息查询异常");
			}
			return AjaxResult.success(PageModel, "成功查询");
		}
		
		//插入分类
		@RequestMapping("/charu")
		@ResponseBody
		public AjaxResult getHqHwflAdd(HttpServletRequest request)throws Exception {
				String HQ_HW_FLNAME = request.getParameter("HQ_HW_FLNAME");
				HqHwHwfl hqhw = new HqHwHwfl();
				hqhw.setHQ_HW_FLNAME(HQ_HW_FLNAME);
		
				int i = hqHwflService.getHqHwflAdd(hqhw);
			return AjaxResult.success(i);
		}
		
		
		//修改
		@RequestMapping("/xiugai")
		@ResponseBody
		public AjaxResult getHqStuUpdateUser(HttpServletRequest request, String hwname) {
			System.out.println(hwname);
			String id = request.getParameter("id");
			id = id.trim();
			hqhwflService.UpdateHqHwHwfl(id,hwname);
			
			
			return AjaxResult.success("修改成功");
		}
		
		@RequestMapping("/deleteUser")
		@ResponseBody
		public AjaxResult getHqUserDelete(HttpServletRequest request) {
			String hwid = request.getParameter("hwid");
			hwid = hwid.trim();
			System.out.println(hwid);
			hqhwflService.DeletehqhwUser(hwid);
			return AjaxResult.success("删除成功");
		}

	}

