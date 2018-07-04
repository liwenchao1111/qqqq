package com.dzqc.campus.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.dzqc.campus.common.util.DownloadUtil;
import com.dzqc.campus.common.util.ExcelUtils;
import com.dzqc.campus.entity.HqFxm;
import com.dzqc.campus.entity.HqUserXq;
import com.dzqc.campus.org.entity.Role;
import com.dzqc.campus.org.entity.User;
import com.dzqc.campus.org.service.RoleService;
import com.dzqc.campus.org.service.UserService;
import com.dzqc.campus.service.HqUserXqService;

@Controller
@RequestMapping("/hq")
public class HqUserController {
	public final static String ATTACH_SAVE_PATH = "attach";
	private static int i = 1;
	@Autowired
	private HqUserXqService huXqService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;

	/**
	 * 提交参数
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/hqlist")
	@ResponseBody
	public ModelAndView getHqFxm(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		List<HqFxm> UserFxm = huXqService.findGZXMList();
		modelAndView.addObject("UserFxm", UserFxm);
		modelAndView.setViewName("houqin/service");
		return modelAndView;
	}

	@RequestMapping("/hqUserlist")
	@ResponseBody
	public AjaxResult getHqUserXq(HttpServletRequest request, String name, String gzxm, Integer currentPage,
			Integer pageSize) {
		PageModel<Map<String, Object>> user;
		System.out.println(name + gzxm);
		try {
			user = huXqService.findUserListbyType(name, gzxm, currentPage, 10);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("信息查询异常");
		}
		return AjaxResult.success(user, "成功查询");
	}

	/*
	 * @RequestMapping("/addHqUser") public ModelAndView toAddUser() { ModelAndView
	 * modelAndView=new ModelAndView(); List<HqFxm>
	 * UserFxm=huXqService.findGZXMList();
	 * modelAndView.addObject("UserFxm",UserFxm);
	 * modelAndView.setViewName("houqin/addHqUser"); return modelAndView; }
	 */
	@RequestMapping("/NewinsertUser")
	@ResponseBody
	public AjaxResult getHqUserNewAdd(HttpServletRequest request) {
		String gh = request.getParameter("gh");
		int count = huXqService.findGh(gh);
		System.out.println(count);
		if(count>0) {
			return AjaxResult.fail("数据重复");
		}else {
		return AjaxResult.success("该工号可用");
		}
	}
	@RequestMapping("/NewinsertUsermobile")
	@ResponseBody
	public AjaxResult NewinsertUsermobile(HttpServletRequest request) {
		String mobile = request.getParameter("mobile");
		Integer count = huXqService.findUserMobile(mobile);
		if(count!=null&&count>0) {
			return AjaxResult.fail("手机号重复");
		}else {
			return AjaxResult.success("该手机号可用");
		}
	}
	@RequestMapping("/insertUser")
	@ResponseBody
	public AjaxResult insertUser(HttpServletRequest request, String name, String gzxm, Integer currentPage,
			Integer pageSize) {
		try {
			String realName = request.getParameter("name");
			String mobile = request.getParameter("moibleNumber");
			String hqUserGh = request.getParameter("gh");
			String hqUserGzxm = request.getParameter("gzxm");
			String hqUserMaxWork = request.getParameter("number");
			int maxWork = Integer.parseInt(hqUserMaxWork);
			User user = new User();
			Random ne = new Random();// 实例化一个random的对象ne
			String username; 
			int count=1;
			do {
				i = ne.nextInt(9999 - 1000 + 1) + 1000;// 为变量赋随机值1000-9999
				username= "dzqc" + (i);
				count = huXqService.findUserName(username);
			} while (count>=1);
			user.setMobile(mobile);
			user.setPassword("123456");
			user.setRealName(realName);
			user.setStatus(1);
			user.setUsername(username);
			user.setType(3);
			Role role = roleService.findByRoleName("后勤维修员");
			Set<Role> set = new HashSet<Role>();
			set.add(role);
			user.setRoles(set);
			userService.save(user);
			String id = user.getId();
			System.out.println(id);
			HqUserXq hqUserXq = new HqUserXq();
			hqUserXq.setUSER_ID(id);
			hqUserXq.setHQ_USER_AM_START(8);
			hqUserXq.setHQ_USER_AM_END(12);
			hqUserXq.setHQ_USER_GH(hqUserGh);
			hqUserXq.setHQ_USER_GZXM(hqUserGzxm);
			hqUserXq.setHQ_USER_MAXWORK(maxWork);
			hqUserXq.setHQ_USER_PM_END(18);
			hqUserXq.setHQ_USER_PM_START(14);
			huXqService.insertHqUserXq(hqUserXq);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("插入失败");
		}
		return AjaxResult.success("插入成功");
	}
	/*
	 * @RequestMapping("/editHqUse") public ModelAndView toEditUser(String
	 * id,HttpServletRequest request) { ModelAndView model1=new ModelAndView();
	 * List<HqFxm> UserFxm=huXqService.findGZXMList(); List<Object[]>
	 * UserList=huXqService.findUserXqByUserId(id); Map<String, Object> maps=new
	 * HashMap<>(); for(Object[] os:UserList) { for(int i=0;i<os.length;i++) {
	 * maps.put("s"+i, os[i]);
	 * 
	 * } }System.out.println(maps); request.setAttribute("maps",maps); //
	 * model1.addObject("maps",maps); model1.addObject("UserFxm",UserFxm);
	 * model1.setViewName("houqin/service"); return model1; }
	 */
	@RequestMapping("/updateUser")
	@ResponseBody
	public AjaxResult updateUser(HttpServletRequest request, String id) {
		try {
			System.out.println("进入方法");
			System.out.println(id);
			String mobile = request.getParameter("mobile");
			String hqUserGzxm = request.getParameter("gzxm");
			System.out.println(hqUserGzxm + mobile);
			HqUserXq hqUserXq = new HqUserXq();
			hqUserXq.setHQ_USER_GZXM(hqUserGzxm);
			huXqService.UpdateHqUserXq(id, hqUserGzxm);
			User user = new User();
			user.setMobile(mobile);
			huXqService.UpdateUserXq(id, mobile);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("修改失败");
		}
		return AjaxResult.success("修改成功");
	}

	@RequestMapping("/UpdateUserPassWord")
	@ResponseBody
	public AjaxResult UpdateUserPassWord(HttpServletRequest request) {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		User user = userService.find(id);
		System.out.println(user.getId());
		huXqService.UpdateUserPassWord(id);
		return AjaxResult.success("重置成功");
	}

	@RequestMapping("/deleteUser")
	@ResponseBody
	public AjaxResult getHqUserDelete(HttpServletRequest request) {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		User user = userService.find(id);
		System.out.println(user.getId());
		huXqService.DeleteUser(id);
		return AjaxResult.success("删除成功");
	}

	// 学生
	@RequestMapping("/list")
	public String toJsp() {
		return "houqin/student";
	}

	@RequestMapping("/chaxun")
	@ResponseBody
	public AjaxResult getHqstuUser(HttpServletRequest request, String name, String adminName, Integer currentPage,
			Integer pageSize) {
		PageModel<Map<String, Object>> PageModel;
		System.out.println(name + adminName);
		try {
			PageModel = huXqService.findStuListbyType(name, adminName, currentPage, 10);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return AjaxResult.fail("信息查询异常");
		}
		return AjaxResult.success(PageModel, "查询成功");
	}

	@RequestMapping("/charu")
	@ResponseBody
	public AjaxResult getHqAdminAdd(HttpServletRequest request) {
		try {
			// User信息
			String name = request.getParameter("realname");
			String mobile = request.getParameter("moibleNumber");
			User u = new User();
			Random ne = new Random();// 实例化一个random的对象ne
			String username; 
			int count=1;
			do {
				i = ne.nextInt(9999 - 1000 + 1) + 1000;// 为变量赋随机值1000-9999
				username= "dzqc" + (i);
				count = huXqService.findUserName(username);
			} while (count>=1);
			u.setRealName(name);
			u.setUsername(username);
			u.setPassword("123456");
			u.setMobile(mobile);
			u.setStatus(1);
			u.setType(2);
			Role role = roleService.findByRoleName("后勤学生");
			Set<Role> set = new HashSet();
			set.add(role);
			u.setRoles(set);
			userService.save(u);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("插入失败");
		}
		return AjaxResult.success("插入成功!");
	}

	@RequestMapping("/xiugai")
	@ResponseBody
	public AjaxResult getHqStuUpdateUser(HttpServletRequest request, String mobile) {
		String id = request.getParameter("id");
		System.out.println(id);
		id = id.trim();
		System.out.println(id);
		huXqService.UpdateUser(mobile, id);
		System.out.println(mobile);
		return AjaxResult.success("修改成功");
	}

	@RequestMapping("/sanchu")
	@ResponseBody
	public AjaxResult getHqAdminDelete(HttpServletRequest request) {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		User user = userService.find(id);
		System.out.println(user.getId());
		huXqService.DeleteUser(id);
		return AjaxResult.success("删除成功");
	}

	@RequestMapping("/xiugaimima")
	@ResponseBody
	public AjaxResult getHqAdminUpdatePwd(HttpServletRequest request) {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		User user = userService.find(id);
		System.out.println(user.getId());
		huXqService.UpdatePwd(id);
		return AjaxResult.success("修改成功");
	}

	@RequestMapping("/ajax/upload_file")
	@ResponseBody
	public AjaxResult ajaxUploadFile(HttpServletRequest request) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setSuccess(false);
		try {

			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
			MultipartFile multipartFile = null;
			String fileName = null;
			for (Map.Entry<String, MultipartFile> set : fileMap.entrySet()) {
				multipartFile = set.getValue();// 文件名
			}
			fileName = this.storeIOc(multipartRequest, multipartFile);

			ajaxResult.setData(fileName);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ajaxResult;
	}

	private String storeIOc(HttpServletRequest request, MultipartFile file) {
		String result = "";
		String realPath = request.getSession().getServletContext().getRealPath("/uploads");
		System.out.println(realPath);
		System.out.println("绝对路径：" + request.getSession().getServletContext().getRealPath("/uploads"));
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
				if (suffix.equalsIgnoreCase(".xls") || suffix.equalsIgnoreCase(".xlsx")) {
					// /**使用UUID生成文件名称**/
					logImageName = UUID.randomUUID().toString() + suffix;

					fileName = realPath + File.separator + ATTACH_SAVE_PATH + File.separator + logImageName;
					File restore = new File(fileName);
					try {
						file.transferTo(restore);
						result = fileName;
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
					// 学生导入 检验
					String operationType = request.getParameter("operationType");
					if (("insertExcl").equals(operationType) && (".xls".equals(suffix) || ".xlsx".equals(suffix))) {

					} else if (("xgBxInsertExcl").equals(operationType)
							&& (".xls".equals(suffix) || ".xlsx".equals(suffix))) {
						result = fileName;
					} else if (("ssInsertExcel").equals(operationType)
							&& (".xls".equals(suffix) || ".xlsx".equals(suffix))) {
						result = fileName;
					} else if (("qgzxinsertExcl").equals(operationType)
							&& (".xls".equals(suffix) || ".xlsx".equals(suffix))) {
						result = fileName;
					}
					//
				} else {
					result = "文件格式不对，只能上传ppt、ptx、doc、docx、xls、xlsx、pdf、png、jpg、jpeg、gif、bmp格式";
				}
			}
		}
		return result;
	}
	@RequestMapping("/importHqWxUser")
	@ResponseBody
	public AjaxResult importHqWxUser(String filePath) {
		StringBuffer error = new StringBuffer("");

		List<List<String>> dataList = ExcelUtils.readXlsx(filePath, 2);
		if (dataList != null && dataList.size() > 0) {
			List<String> nameList = new ArrayList<String>();
			List<String> simpleNameList = new ArrayList<String>();
			List<String> codeList = new ArrayList<String>();

			int i = 1;
			for (List<String> data : dataList) {
				String str = "第" + (i + 1) + "行";
				User user = new User();
				if (data.get(1) == null || data.get(1).length() == 0) {
					return AjaxResult.fail(error.append("用户姓名不能为空").toString());
				}
				user.setRealName(data.get(1));

				if (data.get(8) == null || data.get(8).length() == 0) {
					return AjaxResult.fail(error.append("用户手机号不能为空").toString());
				}
				Integer count = huXqService.findUserMobile(data.get(8));
				if(count!=null&&count>0) {
					return AjaxResult.fail("手机号重复");
				}
				user.setMobile(data.get(8));

				if (data.get(9) == null || data.get(9).length() == 0) {
					return AjaxResult.fail(error.append("用户名不能为空").toString());
				}
				user.setUsername(data.get(9));

				if (data.get(10) == null || data.get(10).length() == 0) {
					return AjaxResult.fail(error.append("用户密码不能为空").toString());
				}

				user.setPassword(data.get(10));

				user.setType(3);

				Role role = roleService.findByRoleName("后勤维修员");

				Set<Role> set = new HashSet<Role>();
				set.add(role);
				user.setRoles(set);
				userService.save(user);

				HqUserXq hqUserXq = new HqUserXq();
				if (data.get(0) == null || data.get(0).length() == 0) {
					return AjaxResult.fail(error.append("用户工号不能为空").toString());
				}
				Integer findGh = huXqService.findGh(data.get(0));
				if (findGh>0) {
					return AjaxResult.fail("数据重复");
				}
				
				hqUserXq.setHQ_USER_GH(data.get(0));

				if (data.get(2) == null || data.get(2).length() == 0) {
					return AjaxResult.fail(error.append("用户工作项目不能为空").toString());
				}
				hqUserXq.setHQ_USER_GZXM(data.get(2));

				if (data.get(3) == null || data.get(3).length() == 0) {
					return AjaxResult.fail(error.append("用户上午开始时间不能为空").toString());
				}
				hqUserXq.setHQ_USER_AM_START(Integer.valueOf(data.get(3)));

				if (data.get(4) == null || data.get(4).length() == 0) {
					return AjaxResult.fail(error.append("用户上午结束时间不能为空").toString());
				}
				hqUserXq.setHQ_USER_AM_END(Integer.valueOf(data.get(4)));

				if (data.get(5) == null || data.get(5).length() == 0) {
					return AjaxResult.fail(error.append("用户下午开始时间不能为空").toString());
				}
				hqUserXq.setHQ_USER_PM_START(Integer.valueOf(data.get(5)));

				if (data.get(6) == null || data.get(6).length() == 0) {
					return AjaxResult.fail(error.append("用户下午结束时间不能为空").toString());
				}
				hqUserXq.setHQ_USER_PM_END(Integer.valueOf(data.get(6)));

				if (data.get(7) == null || data.get(7).length() == 0) {
					return AjaxResult.fail(error.append("用户最大接单数不能为空").toString());
				}
				hqUserXq.setHQ_USER_MAXWORK(Integer.valueOf(data.get(7)));

				hqUserXq.setUSER_ID(user.getId());
				int xq = huXqService.insertHqUserXq(hqUserXq);

				i++;
			}
		}
		return AjaxResult.success("导入成功");

	}
	
	@RequestMapping("/importHqStuUser")
	@ResponseBody
	public AjaxResult importHqStuUser(String filePath) {
		System.out.println("+++++++++++++++++++importHqStuUser+++++++++++++++++++");
		System.out.println("filePath:"+filePath);
		StringBuffer error = new StringBuffer("");
		System.out.println("插入学生+++++++++++++++++++++++++++几句话");
		List<List<String>> dataList = ExcelUtils.readXlsx(filePath, 2);
		if (dataList != null && dataList.size() > 0) {
			List<String> nameList = new ArrayList<String>();
			List<String> simpleNameList = new ArrayList<String>();
			List<String> codeList = new ArrayList<String>();

			int i = 1;
			for (List<String> data : dataList) {
				String str = "第" + (i + 1) + "行";
				User user = new User();
				if (data.get(0) == null || data.get(0).length() == 0) {
					return AjaxResult.fail(error.append("用户姓名不能为空").toString());
				}
				user.setRealName(data.get(0));

				if (data.get(1) == null || data.get(1).length() == 0) {
					return AjaxResult.fail(error.append("用户手机号不能为空").toString());
				}
				Integer count = huXqService.findUserMobile(data.get(8));
				if(count!=null&&count>0) {
					return AjaxResult.fail("手机号重复");
				}
				user.setMobile(data.get(1));

				if (data.get(2) == null || data.get(2).length() == 0) {
					return AjaxResult.fail(error.append("用户名不能为空").toString());
				}
				user.setUsername(data.get(2));

				if (data.get(3) == null || data.get(3).length() == 0) {
					return AjaxResult.fail(error.append("用户密码不能为空").toString());
				}

				user.setPassword(data.get(3));

				user.setType(2);

				Role role = roleService.findByRoleName("后勤学生");

				Set<Role> set = new HashSet<Role>();
				set.add(role);
				user.setRoles(set);
				userService.save(user);
				i++;
			}
		}
		return AjaxResult.success("导入成功");

	}
	
	
	
	
	@RequestMapping("/listadmin")
	public ModelAndView toAdmin(ModelAndView model) {
		List<HqFxm> gzxm = huXqService.findGZXMList();
		model.addObject("gzxm", gzxm);
		model.setViewName("houqin/administrator");
		return model;
	}
	@RequestMapping("/listsadmin")
	@ResponseBody
	public AjaxResult getHqAdminXq(HttpServletRequest request,Integer pageSize,Integer currentPage) {
		PageModel<Map<String,Object>> admin;
		String name = request.getParameter("name");
		try {
			admin=huXqService.findAdminListbyType(name,10,currentPage);
		} catch (Exception e) {
			return AjaxResult.fail("信息查询异常");
		}
		return AjaxResult.success(admin);
	}
	@RequestMapping("/Newinsert")
	@ResponseBody
	public AjaxResult getHqAdminNewAdd(HttpServletRequest request) {
		String gh = request.getParameter("gh");
		int count = huXqService.findGh(gh);
		System.out.println(count);
		if(count>=1) {
			return AjaxResult.fail("数据重复");
		}
		return AjaxResult.success("该工号可用");
	}
	@RequestMapping("/insert")
	@ResponseBody
	public AjaxResult getHqAdminAdds(HttpServletRequest request) {
        try {
        	//User信息
        	String realName = request.getParameter("realname");
        	String mobile = request.getParameter("moibleNumber");
        	String gh = request.getParameter("gh");
        	User u = new User();
        	Random ne = new Random();// 实例化一个random的对象ne
			String username; 
			int count=1;
			do {
				i = ne.nextInt(9999 - 1000 + 1) + 1000;// 为变量赋随机值1000-9999
				username= "dzqc" + (i);
				count = huXqService.findUserName(username);
			} while (count>=1);
        	u.setUsername(username);
        	u.setPassword("123456");
        	u.setRealName(realName);
        	u.setMobile(mobile);
        	u.setStatus(1);
        	u.setType(1);
        	Role role = roleService.findByRoleName("后勤管理员");
        	Set<Role> set=new HashSet();
        	set.add(role);
        	u.setRoles(set);
        	userService.save(u);
        	HqUserXq hqu = new HqUserXq();
        	hqu.setUSER_ID(u.getId());
        	hqu.setHQ_USER_GH(gh);
//        	hqu.setHQ_USER_GZXM(gzxm);
        	System.out.println(hqu.toString());
            huXqService.insertGZXM(hqu);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.fail("插入失败");
        }
        return AjaxResult.success("插入成功!");
	}
	@RequestMapping("/importHqAdminUser")
	@ResponseBody
	public AjaxResult importHqAdminUser(String filePath) {
		StringBuffer error = new StringBuffer("");

		List<List<String>> dataList = ExcelUtils.readXlsx(filePath, 2);
		if (dataList != null && dataList.size() > 0) {
			List<String> nameList = new ArrayList<String>();
			List<String> simpleNameList = new ArrayList<String>();
			List<String> codeList = new ArrayList<String>();

			int i = 1;
			for (List<String> data : dataList) {
				String str = "第" + (i + 1) + "行";
				User user = new User();
				if (data.get(1) == null || data.get(1).length() == 0) {
					return AjaxResult.fail(error.append("用户姓名不能为空").toString());
				}
				user.setRealName(data.get(1));

				if (data.get(2) == null || data.get(2).length() == 0) {
					return AjaxResult.fail(error.append("用户手机号不能为空").toString());
				}
				Integer count = huXqService.findUserMobile(data.get(8));
				if(count!=null&&count>0) {
					return AjaxResult.fail("手机号重复");
				}
				user.setMobile(data.get(2)+"");

				if (data.get(3) == null || data.get(3).length() == 0) {
					return AjaxResult.fail(error.append("用户名不能为空").toString());
				}
				user.setUsername(data.get(3)+"");

				if (data.get(4) == null || data.get(4).length() == 0) {
					return AjaxResult.fail(error.append("用户密码不能为空").toString());
				}

				user.setPassword(data.get(4)+"");

				user.setType(1);

				Role role = roleService.findByRoleName("后勤管理员");

				Set<Role> set = new HashSet<Role>();
				set.add(role);
				user.setRoles(set);
				userService.save(user);

				HqUserXq hqUserXq = new HqUserXq();
				if (data.get(0) == null || data.get(0).length() == 0) {
					return AjaxResult.fail(error.append("用户工号不能为空").toString());
				}
				Integer count1 = huXqService.findGh(data.get(0));
				if(count1!=null&&count1>0) {
					return AjaxResult.fail("手机号重复");
				}
				hqUserXq.setHQ_USER_GH(data.get(0)+"");
				hqUserXq.setUSER_ID(user.getId());
				int xq = huXqService.insertGZXM(hqUserXq);
				i++;
			}
		}
		return AjaxResult.success("导入成功");
	}
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult getHqAdminUpdateUsers(HttpServletRequest request,String mobile) {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		huXqService.AdminUpdateUser(mobile, id);
		System.out.println(mobile);
		return AjaxResult.success("修改成功");
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult getHqAdminDeletes(HttpServletRequest request) {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		User user = userService.find(id);
		System.out.println(user.getId());
		huXqService.AdminDeleteUser(id);
		return AjaxResult.success("删除成功");
	}
	@RequestMapping("/updatePwd")
	@ResponseBody
	public AjaxResult getHqAdminUpdatePwds(HttpServletRequest request) {
		String id = request.getParameter("id");
		id = id.trim();
		System.out.println(id);
		User user = userService.find(id);
		System.out.println(user.getId());
		huXqService.AdminUpdatePwd(id);
		return AjaxResult.success("修改成功");
	}
	 /**
     * 下载模板
     */
    @RequestMapping("/downloadgly")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        String filePath = request.getRealPath("/") + "/static/后勤管理员.xlsx";
        DownloadUtil.download(response, filePath, "后勤管理员.xlsx");
    }
    
    /**
     * 下载模板
     */
    @RequestMapping("/downloadwxy")
    public void downloadwxy(HttpServletRequest request, HttpServletResponse response) {
        String filePath = request.getRealPath("/") + "/static/后勤维修员.xlsx";
        DownloadUtil.download(response, filePath, "后勤维修员.xlsx");
    }
    @RequestMapping("/downloadstu")
    public void downloadstu(HttpServletRequest request, HttpServletResponse response) {
        String filePath = request.getRealPath("/") + "/static/后勤学生.xlsx";
        DownloadUtil.download(response, filePath, "后勤学生.xlsx");
    }

}
