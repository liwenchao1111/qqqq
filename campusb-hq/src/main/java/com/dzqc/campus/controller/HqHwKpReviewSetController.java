package com.dzqc.campus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwLx;
import com.dzqc.campus.service.HqHwKpReviewSetService;

@Controller
@RequestMapping("/hwset")
public class HqHwKpReviewSetController {

	@Autowired
	private HqHwKpReviewSetService hqHwKpReviewSetService;
	
	@RequestMapping("/Place")
	@ResponseBody
	public AjaxResult findHqHwKpCountPlace(String type,String fb,String kplx,
			Integer currentPage,Integer rowsInPage) throws Exception{
		if(currentPage!=null&& rowsInPage!=null) {
			//判断是否使用模糊查询,是否为赞赏
			Integer fbs=null;
			if(fb!=null) {
				if(fb.trim().equals("赞赏")) {
					fbs=0;
				}else {
					fbs=1;
				}
			}
			//判断是否使用模糊查询,是否已发布
			Integer kplxs=null;
			if(kplx!=null) {
				if(kplx.trim().equals("已发布")) {
					kplxs=0;
				}else {
					kplxs=1;
				}
			}
			PageModel<Map<String,Object>> findHqHwKpCountPlace = hqHwKpReviewSetService.findHqHwKpCountPlace(type, fbs, kplxs, currentPage, rowsInPage);
			if(findHqHwKpCountPlace==null) {
				return AjaxResult.success("请求成功,没有考评结果");
			}
			return AjaxResult.success(findHqHwKpCountPlace);
		}
		return AjaxResult.fail("数据请求失败");
	}
	
	@RequestMapping("/findLx")
	@ResponseBody
	public AjaxResult findLx() throws Exception{
		List<HqHwLx> findHqHwLxAll = hqHwKpReviewSetService.findHqHwLxAll();
		if(findHqHwLxAll!=null) {
			return AjaxResult.success(findHqHwLxAll);
		}
		return AjaxResult.fail("数据请求异常");
	}
	
}
