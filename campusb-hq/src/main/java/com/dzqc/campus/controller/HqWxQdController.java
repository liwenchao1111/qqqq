package com.dzqc.campus.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqFxm;
import com.dzqc.campus.entity.HqSxm;
import com.dzqc.campus.entity.HqWxQd;
import com.dzqc.campus.org.entity.User;
import com.dzqc.campus.org.util.WebHelper;
import com.dzqc.campus.service.HqFxmService;
import com.dzqc.campus.service.HqSxmService;
import com.dzqc.campus.service.HqWxQdService;

/**
 * 功能描述： 报修的Controller
 * 
 * @Package: com.dzqc.campus.controller
 * @ClassName: HqWxQdController.java+
 * @author: 呆橘
 * @date: 2018年5月26日 下午7:12:56
 */

@Controller
@RequestMapping("/hqwx")
public class HqWxQdController {

	public final static String ATTACH_SAVE_PATH1 = "img";
	@Autowired
	private HqFxmService hqFxmService;

	private static String imgurl = "";
	@Autowired
	private HqWxQdService hqwxqdservice;

	@Autowired
	private HqSxmService hqservice;

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
			System.out.println(multipartRequest.getFileMap().get("file").getSize());
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

	@RequestMapping("/find")
	public ModelAndView findByUserIDWxQd01(HttpServletRequest re, ModelAndView view) throws Exception {
		Integer count = hqwxqdservice.findCountById(((User) (re.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER))).getId());
		view.setViewName("houqin/stu_bxList");
		view.addObject("count", count);
		return view;
	}

	@RequestMapping("/insertHqWxQd")
	public String tolist() {
		return "houqin/stu_bx";
	}

	@RequestMapping("/HqBxXq")
	public ModelAndView findByHqBxXqIDWxXq(String id, ModelAndView view) {
		view.setViewName("houqin/hqb");
		view.addObject("id", id);
		return view;
	}

	// 判断是否可以接单
	@RequestMapping("/findhqsj")
	@ResponseBody
	public AjaxResult findhqsj(String HQ_XM_FL, String date) throws Exception {
		//输入的日期与当前日期相减 如果大于0就是合法日期,如果小于0,输入的就是过去的日期
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		//把输入的日期转成long格式
		Date date1 = simpleDateFormat.parse(date);
		long ts1 = date1.getTime(); 
		
		//把当前的日期转成Date格式再转成long格式
		Date datenew = new Date();
		String res2 = simpleDateFormat.format(datenew);
		Date date2 = simpleDateFormat.parse(res2);
		long ts2 = date2.getTime();
		//两日期进行相减
		long res = ts1 - ts2;
		if (res < 0) {
			return AjaxResult.fail("日期不合法");
		}
		//根据父类工作项目 判断该工作项目人员是否空闲
		Integer sum = hqwxqdservice.insertHqWxJd(HQ_XM_FL.split("/")[0], date);/// 拿到报修项目 进行项目分割 拿到分割的第一个
		System.err.println("sun=" + sum);
		if (sum <= 0) {
			return AjaxResult.fail("该天已经接满了！");
		}
		return AjaxResult.success("OK");
	}

	@RequestMapping("/finduserqd")
	@ResponseBody
	public AjaxResult findByUserIDWxQd(HttpServletRequest request, String currPage, String status) throws Exception {
		User user = (User) request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
		PageModel<Map<String, Object>> listmap = hqwxqdservice.findByUserIDWxQd(user.getId(),
				Integer.parseInt(currPage), 5, status);
		if (listmap == null) {
			return AjaxResult.fail("该学生没有报修情况");
		}
		return AjaxResult.success(listmap);
	}

	/**
	 * 修改状态信息
	 */

	@RequestMapping("/UpdataStatus")
	@ResponseBody
	public AjaxResult UpdateStatus(String id, String status) throws Exception {
		if (status.equals("4")) {
			status = "5";
		}
		int i = hqwxqdservice.UpdateStatus(id, status);
		if (i > 0) {
			return AjaxResult.success("确认修改成功!");
		}
		return AjaxResult.fail("修改失败!");
	}

	@RequestMapping("/findCount")
	@ResponseBody
	public AjaxResult findCountStatus(HttpServletRequest request) throws Exception {
		List<Map<String, Object>> listmap = hqwxqdservice
				.findCountStatus(((User) (request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER))).getId());
		if (listmap == null) {
			AjaxResult.fail("没有数据");
		}
		System.out.println(listmap.size());
		return AjaxResult.success(listmap);
	}

	@RequestMapping("/Pingjia")
	@ResponseBody
	public AjaxResult Pingjia(HttpServletRequest request, String id, String grade, String pinr) throws Exception {
		if ((!grade.equals("")) && grade != null && (!pinr.equals("")) && pinr != null) {
			int i = hqwxqdservice.insertPingjia(id, grade, pinr, "6");
			if (i >= 0) {
				return AjaxResult.success("ok");
			}
			return AjaxResult.fail("失败");
		}
		return AjaxResult.fail("失败");

	}

	// 把要保修的信息封装后保存到数据库
	@RequestMapping("/insertHqWxQd01")
	@ResponseBody
	public AjaxResult insertHqWxQd(HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);

		String HQ_USER_ID = user.getId();
		String HQ_XM_FL = request.getParameter("HQ_XM_FL");
		String HQ_WX_DH = request.getParameter("HQ_WX_DH");
		String HQ_WX_RQ1 = request.getParameter("HQ_WX_RQ");
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(HQ_WX_RQ1);//时间转成Date类型
		
		//输入的日期与当前日期相减 如果大于0就是合法日期,如果小于0,输入的就是过去的日期
		long ts1 = date.getTime();  //long类型  输入的日期
		// 检测维修日期  过去的日期不能选择  
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//日期格式转换
		Date datenew = new Date();
		String res2 = simpleDateFormat.format(datenew);
		Date date2 = simpleDateFormat.parse(res2);
		long ts2 = date2.getTime();//当前日期
		long res = ts1 - ts2;
		if (res < 0) {
			return AjaxResult.fail("日期不合法");
		}
		
		
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");//日期格式
		LocalDate wxdate = LocalDate.now();//取当前日期
		wxdate = LocalDate.parse(HQ_WX_RQ1, f);
		Integer sum = hqwxqdservice.insertHqWxJd(HQ_XM_FL.split("/")[0], HQ_WX_RQ1);// 拿到报修项目 进行项目分割 拿到分割的第一个
		System.err.println("sun=" + sum);
		if (sum <= 0) {
			return AjaxResult.fail("该天已经接满了！");
		}
		String HQ_WX_ADD = request.getParameter("HQ_WX_ADD");
		String HQ_WX_GZMS = request.getParameter("HQ_WX_GZMS");
		String HQ_WX_GZTP = request.getParameter("HQ_WX_GZTP");
		// 封装到对象里
		// HQ_WX_GZMS
		HqWxQd wxQd = new HqWxQd();
		wxQd.setHQ_USER_ID(HQ_USER_ID);
 		wxQd.setHQ_XM_FL(HQ_XM_FL);
		wxQd.setHQ_WX_DH(HQ_WX_DH);
		wxQd.setHQ_WX_RQ(date);
		wxQd.setHQ_WX_ADD(HQ_WX_ADD);
		wxQd.setHQ_WX_GZMS(HQ_WX_GZMS);
		
		imgurl = imgurl.substring(0, imgurl.length() - 1);//上传多张图片 末尾以逗号分隔,从第一个开始,最后一张图片不加逗号-1
		wxQd.setHQ_WX_GZTP(imgurl);//吧上传的图片的地址封装到数据库
		wxQd.setHQ_BX_RQ(new Date());
		wxQd.setHQ_WX_STATUS("1");
		int i = hqwxqdservice.insertHqWxQd(wxQd);
		imgurl = "";
		if (i > 0) {
			return AjaxResult.success("报修信息提交成功");
		}
		return AjaxResult.fail("报修信息提交失败");
	}

	// 加载Ajax时调用的url
	// 查询父类列表
	@RequestMapping("/insertFxm")
	@ResponseBody
	public AjaxResult insertFxm(HttpServletRequest request) throws Exception {
		List<HqFxm> list = hqFxmService.findAll();
		return AjaxResult.success(list);
	}

	// 根据父类ID查询子类
	@RequestMapping("/insertFxmId")
	@ResponseBody
	public AjaxResult insertFxmId(HttpServletRequest request) {
		String id = request.getParameter("id");
		List<HqSxm> list = hqservice.findHqFxm(id);
		if (list == null) {
			return AjaxResult.fail("没有查询到子类");
		}
		return AjaxResult.success(list);
	}

	@RequestMapping("/hqbxxqs")
	@ResponseBody
	public AjaxResult hqbxxq(String id) throws ParseException {
		List<Map<String, Object>> map = hqwxqdservice.queryBx(id);
		if (map == null) {
			return null;
		}
		System.out.println(map);
		return AjaxResult.success(map);
	}
}
