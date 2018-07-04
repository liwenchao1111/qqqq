package com.dzqc.campus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.entity.HqNoticeNew;
import com.dzqc.campus.service.HqWebShowService;

@Controller
@RequestMapping("/hw")
public class HqWebShowController {
		@Autowired
		private HqWebShowService hqWebShowService;
		
		@RequestMapping("/wzglzs")
	    public String towzglzs() {
	        return "houqin/hw/wzglzs";
	    }
		/**
		 * 查询最新的一条公告
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("/selectwzglzs")
		@ResponseBody
		public AjaxResult getNoticeNew()throws Exception{
			System.out.println("nime");
			List<HqNoticeNew> list=hqWebShowService.selectByNoticeNew();
			if (list==null) {
				AjaxResult.fail("没有数据");
			}
			System.out.println(""+list);
			return AjaxResult.success(list);
		}
		/**
		 * 
		 * 查询最新的三条赞赏与投诉
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("/selectzsyts")
		@ResponseBody
		public AjaxResult getzsyts()throws Exception{
			List<Map<String, Object>> listmap=hqWebShowService.selectByzsyts();
			if (listmap==null) {
				AjaxResult.fail("没有数据");
			}
			System.out.println(listmap);
			return AjaxResult.success(listmap);
		}
		
}
