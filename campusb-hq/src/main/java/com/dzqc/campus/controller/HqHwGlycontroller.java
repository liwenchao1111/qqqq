package com.dzqc.campus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwGly;
import com.dzqc.campus.service.HqHwGlyXqService;

@Controller
@RequestMapping("/hw")
public class HqHwGlycontroller {
	
	@Autowired
	private HqHwGlyXqService hhgxs;
	
	@RequestMapping("/sdgly")
	public String sdgly() {
		return "/houqin/hw/set_admin";
	}
	
	@RequestMapping("/fqys")
	@ResponseBody
	public AjaxResult fqy() {
		List<Map<String, Object>> listfqy=hhgxs.findall();
		System.out.println("listfqy:"+listfqy);
		List<Map<String, Object>> listfzr=hhgxs.findallfzr();
		System.out.println("listfzr:"+listfzr);
		List<Object> list= new ArrayList<>();
		list.add(listfqy);
		list.add(listfzr);
		System.out.println("????????????????????????????????????????????/");
		System.out.println(list);
		return AjaxResult.success(list);
	}
	
	@RequestMapping("/tiajia")
	@ResponseBody
	public AjaxResult tiajia(String fqy,String fzr) {
		System.out.println("tiajia");
		System.out.println("fqy"+fqy);
		System.out.println("fzr"+fzr);
		HqHwGly hh=new HqHwGly();
		hh.setHQ_HW_GLY_FQY(fqy);
		hh.setHQ_HW_GLY_FZR_ID(fzr);
		hh.setStatus(0);
		hhgxs.save(hh);
		return AjaxResult.success("成功");
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAll(Integer currentPage, Integer pageSize,String fqyid,String glyname) {
		System.out.println("findAll");
		System.out.println("currentPage:"+currentPage);
		System.out.println("pageSize:"+pageSize);
		System.out.println("fqyid"+fqyid);
		System.out.println("glyname"+glyname);
		PageModel<HqHwGly> list=hhgxs.hqhwglyall(fqyid, glyname, currentPage, pageSize);
		
		return AjaxResult.success(list);
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public AjaxResult del(String id) {
		System.out.println("_________del___________");
		System.out.println("id:"+id);
		HqHwGly hhg= hhgxs.findone(id);
		hhg.setStatus(1);
		hhgxs.updete(hhg);
		return AjaxResult.success("成功");
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public AjaxResult edit (String id) {
		System.out.println("======================edit=============");
		System.out.println(id);
		List<Map<String, Object>> list=hhgxs.getone(id);
		System.out.println(list);
		return AjaxResult.success(list);
	}
	
	@RequestMapping("/do_edit")
	@ResponseBody
	public AjaxResult do_edit(String id,String fqy,String fzr) {
		System.out.println("+++++++++++++++do_edit++++++++++++++++++++");
		System.out.println(id);
		System.out.println(fqy);
		System.out.println(fzr);
		HqHwGly hh=hhgxs.findone(id);
		hh.setHQ_HW_GLY_FQY(fqy);
		hh.setHQ_HW_GLY_FZR_ID(fzr);
		hhgxs.updete(hh);
		return AjaxResult.success("成功!");
	}
}
