package com.dzqc.campus.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqHwBjBz;
import com.dzqc.campus.entity.HqHwFqygl;
import com.dzqc.campus.entity.HqHwLx;
import com.dzqc.campus.entity.HqHwZqy;
import com.dzqc.campus.entity.HqHwZqyGL;
import com.dzqc.campus.entity.HqWxQd;
import com.dzqc.campus.service.HqHwBjBzService;
import com.dzqc.campus.service.HqHwFqyglService;
import com.dzqc.campus.service.HqHwQyBService;
import com.dzqc.campus.service.HqHwQyLxService;
import com.dzqc.campus.service.HwZqyglService;

@Controller
@RequestMapping("/hw")
public class HqHwQyBController {

	public final static String ATTACH_SAVE_PATH1 = "img";

	private static String imgurl = "";
	@Autowired
	private HqHwQyBService hqhwqybservice;
	@Autowired
	private HqHwFqyglService HqHwFqyglService;
	@Autowired
	private HqHwQyLxService hqHwQyLxService;
	@Autowired
	private HqHwBjBzService hqHwBjBzService;
	@Autowired
	private HwZqyglService hwZqyglService;

//	@RequestMapping("/hwqyb")
//	public String ceshi() {
//
//		return "houqin/hqhwqyb";/* 跳转到去派单有空闲的页面(pd_free.jsp) */
//	}
	
	@RequestMapping("/hwqy")
	 public ModelAndView findByUserIDWxQd01(HttpServletRequest re,ModelAndView view) throws Exception{
			Integer count = hqhwqybservice.findCount();
			System.out.println("0000000000000000000                  "+count);
			view.setViewName("houqin/hw/hqhwqyb");
			view.addObject("count", count);
			return view;
	    }
	
	 //分页查询
	 @RequestMapping("/qulist")
		@ResponseBody
		public AjaxResult chakan(String HQ_HW_FQY_ID,Integer currPage,Model model,Integer hw_zqy_name,Integer hq_hw_bjbz_name,Integer hw_zqy_code) {
			Integer pageSize=5;
			String HQ_HW_FQY_ID1="DEEF83ACF1F74B5A8AE7033879B4997F";
			System.out.println("查看是否进来");
			System.out.println(currPage+"nidaye");
		//	List<HqWxQd> list=hqwxqdService.findBySTATUS(tid);
			if(currPage==null) {
				currPage=1;
			}
			PageModel<HqHwZqy> hqhwqyb=hqhwqybservice.findByParams(HQ_HW_FQY_ID1,currPage, pageSize,hw_zqy_name,hq_hw_bjbz_name,hw_zqy_code);
			System.out.println(hqhwqyb.toString());
			System.out.println(hqhwqyb.getPageSize()+"000000000000000111111111111111111111");
			return AjaxResult.success(hqhwqyb);	
		}
	
	 
	
	//删除，更改状态码0为1
	 @RequestMapping("/jsc")
	    public String WKX(Integer HQ_HW_ID) {
		 Integer hqhw=hqhwqybservice.updateSTATUS(HQ_HW_ID);
	        return "houqin/aaa";
	    }
	 //编辑修改
	 @RequestMapping("/xg")
		@ResponseBody
		public AjaxResult  xiugai(String HQ_HW_FQY_ID,String HQ_HW_ZQY_ID,String HQ_HW_TYPE_ID,String HQ_HW_BJBZ_ID,Double HQ_HW_MM,Double HQ_HW_JCGZ,Double HQ_HW_WYFL,Double HQ_HW_GLFL,Double HQ_HW_GZYS,String HQ_HW_IMG) {
		 hqhwqybservice.update(HQ_HW_FQY_ID, HQ_HW_ZQY_ID, HQ_HW_TYPE_ID, HQ_HW_BJBZ_ID, HQ_HW_MM, HQ_HW_JCGZ, HQ_HW_WYFL, HQ_HW_GLFL, HQ_HW_GZYS, HQ_HW_IMG);
		 return AjaxResult.success("修改成功");
	 }

	 
	 
	
//////////////////////////////////////////////
	/**
	 * 文件异步上传Controller
	 * 
	 * @author
	 * @since 2016-03-14
	 */
	@RequestMapping("/ajax/upload_img")
	@ResponseBody
	public AjaxResult ajaxUploadFile3(MultipartHttpServletRequest request) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		System.out.println(multipartRequest);
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setSuccess(false);
		try {
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
			MultipartFile multipartFile = null;
			String fileName = null;
			for (Map.Entry<String, MultipartFile> set : fileMap.entrySet()) {
				multipartFile = set.getValue();// 文件名
				System.out.println(multipartFile.isEmpty());
			}
			fileName = this.storeIOc3(multipartRequest, multipartFile);
			ajaxResult.setData(fileName);
			ajaxResult.setSuccess(true);
			imgurl += fileName + ",";
			System.out.println(imgurl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ajaxResult;
	}

	// 接受图片，返回文件地址
	public String storeIOc3(MultipartHttpServletRequest request, MultipartFile file) {
		String result = "";
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		if (file == null) {
			return null;
		}
		String fileName = "";
		String logImageName = "";
		if (file.isEmpty()) {
			result = "文件未上传";
		} else {
			String _fileName = file.getOriginalFilename();
			String suffix = _fileName.substring(_fileName.lastIndexOf("."));
			if (StringUtils.isNotBlank(suffix)) {
				if (suffix.equalsIgnoreCase(".png") || suffix.equalsIgnoreCase(".gif")
						|| suffix.equalsIgnoreCase(".jpg")) {
					// /**使用UUID生成文件名称**/
					logImageName = UUID.randomUUID().toString() + suffix;
					fileName = realPath + File.separator + ATTACH_SAVE_PATH1 + File.separator + logImageName;
					File restore = new File(fileName);
					try {
						file.transferTo(restore);
						result = "/upload/img/" + logImageName;
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
					//
				} else {
					result = "文件格式不对，只能上传、png、jpg、gif格式";
				}
			}
		}

		return result;
	}

	// 添加区域
	@RequestMapping("/insertHwQy01")
	@ResponseBody
	public AjaxResult insertHwQy01(HttpServletRequest request, MultipartHttpServletRequest request1, MultipartFile file)
			throws Exception {
		String HQ_HW_ID = request.getParameter("HQ_HW_ID");
		String HQ_HW_FQY_ID = request.getParameter("HQ_HW_FQY_ID");
		String HQ_HW_ZQY_ID = request.getParameter("HQ_HW_ZQY_ID");
		String HQ_HW_MM = request.getParameter("HQ_HW_MM");
		String HQ_HW_JCGZ = request.getParameter("HQ_HW_JCGZ");
		String HQ_HW_WYFL = request.getParameter("HQ_HW_WYFL");
		String HQ_HW_GLFL = request.getParameter("HQ_HW_GLFL");
		String HQ_HW_GZYS = request.getParameter("HQ_HW_GZYS");
		String HQ_HW_TYPE_ID = request.getParameter("HQ_HW_TYPE_ID");
		String HQ_HW_BJBZ_ID = request.getParameter("HQ_HW_BJBZ_ID");
		String HQ_HW_IMG = request.getParameter("HQ_HW_IMG");

		String img = storeIOc3(request1, file);
		HqHwZqy hqhwqy = new HqHwZqy();
		hqhwqy.setHQ_HW_ID(HQ_HW_ID);
		hqhwqy.setHQ_HW_FQY_ID(HQ_HW_FQY_ID);
		hqhwqy.setHQ_HW_ZQY_ID(HQ_HW_ZQY_ID);
		hqhwqy.setHQ_HW_MM(Double.valueOf(HQ_HW_MM));
		hqhwqy.setHQ_HW_JCGZ(Double.valueOf(HQ_HW_JCGZ));
		hqhwqy.setHQ_HW_WYFL(Double.valueOf(HQ_HW_WYFL));
		hqhwqy.setHQ_HW_GLFL(Double.valueOf(HQ_HW_GLFL));
		hqhwqy.setHQ_HW_GZYS(Double.valueOf(HQ_HW_GZYS));
		hqhwqy.setHQ_HW_TYPE_ID(HQ_HW_TYPE_ID);
		hqhwqy.setHQ_HW_BJBZ_ID(HQ_HW_BJBZ_ID);
		hqhwqy.setHQ_HW_IMG(img);
		int i = hqhwqybservice.insertHwQy(hqhwqy);

		if (i > 0) {
			return AjaxResult.success(i);
		}
		return AjaxResult.fail("添加失败");// 跳转添加页面
	}

	// 查询父区域
	@RequestMapping("/fuqy")
	@ResponseBody
	public AjaxResult fuqy(HttpServletRequest request) throws Exception {
		List<HqHwFqygl> list = HqHwFqyglService.findList();
		System.out.println(list.get(0).toString());
		return AjaxResult.success(list);
	}

	// 根据父类ID查询子区域
	@RequestMapping("/zuqy")
	@ResponseBody
	public AjaxResult zuqy(HttpServletRequest request,String id) throws Exception {

		System.out.println(id);
		List<HqHwZqyGL> listzq = hwZqyglService.fuqy(id);
		System.out.println(listzq.get(0).toString());
		if (listzq == null) {
			return AjaxResult.fail("没有查询到子类");
		}
		return AjaxResult.success(listzq);
	} 

	// 查询类型
	@RequestMapping("/leixing")
	@ResponseBody
	public AjaxResult leixing() {
		List<HqHwLx> listlx = hqHwQyLxService.queryList();

		return AjaxResult.success(listlx);
	}

	// 查询标准
	@RequestMapping("/biaozhun")
	@ResponseBody
	public AjaxResult biaozhun() {
		List<HqHwBjBz> listbz = hqhwqybservice.findHqHwBjBzList();
		return AjaxResult.success(listbz);
	}

}
