package com.dzqc.campus.controller;


import com.dzqc.campus.common.dto.AjaxResult;
import com.dzqc.campus.common.entity.PageModel;
import com.dzqc.campus.entity.HqSanitationmanMessage;
import com.dzqc.campus.service.HqSanitationmanMessageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dzqc.campus.service.HqHwFZRXqService;
import com.dzqc.campus.service.HqSanitationmanMessageAdminService;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/hw")
public class HqSanitationMessageController {
    public final static String ATTACH_SAVE_PATH1 = "img";
    private static String imgurl = "";
    @Autowired
    HqSanitationmanMessageService hqSanitationmanMessageService;

	@Autowired
	private HqHwFZRXqService hqHwFZRXqService;
	
	@Autowired
	private HqSanitationmanMessageAdminService hqSanMeAdminService;
	
	
	@RequestMapping("/hwgxxb")
	public String hwgxxb() {
		return "houqin/hw/SANITATIONMAN_MESSAGE";
	}

	/**
	 * 管理员详情--个人信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/glyxq")
	@ResponseBody
	public AjaxResult glyxq(String id) throws Exception {
		if (id != null) {
			HqSanitationmanMessage hqSanitationmanMessage = hqSanitationmanMessageService.queryMessageAre(id);
			return AjaxResult.success(hqSanitationmanMessage);
		}
		return AjaxResult.fail("数据请求失败,无法获得指定的id");
	}

	/**
	 * 管理员详情--任务分区
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/glyxqrw")
	@ResponseBody
	public AjaxResult findHqHwFQyById(String id, Integer currentPage, Integer rowsInPage) throws Exception {
		if (id != null) {
			PageModel<Map<String, Object>> pagemodel = hqSanMeAdminService.findHqHwFQyById(id, currentPage, rowsInPage);
			return AjaxResult.success(pagemodel);
		}
		return AjaxResult.fail("数据请求失败,无法获得指定的id");
	}

    /**
     * 查询环卫工并分页
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/qusetMessage")
    @ResponseBody
    public AjaxResult qusetMessage(Integer currentPage, Integer pageSize, String sanitationmantype, String seek) {
        System.out.println("搜索框中的内容" + seek);
        System.out.println("选择的类型" + sanitationmantype);
        PageModel<HqSanitationmanMessage> pageModel = hqSanitationmanMessageService.queryMessage(currentPage, pageSize, sanitationmantype, seek);
        return AjaxResult.success(pageModel, "环卫工分页查询");
    }

    /**
     * 查询单个环卫工类型
     *
     * @param request
     * @param ID
     * @return
     */
    @RequestMapping("/qusetMessageOne")
    @ResponseBody
    public AjaxResult qusetMessageOne(HttpServletRequest request, String ID) {
        System.out.println("ID是" + ID);
        HqSanitationmanMessage hqSanitationmanMessage = hqSanitationmanMessageService.queryMessageAre(ID);
        return AjaxResult.success(hqSanitationmanMessage, "环卫工单个查询");

    }
    
    /**
     * 负责人详情--个人信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/fzrxq")
    @ResponseBody
    public AjaxResult findFZRMessage(String fzr_id) throws Exception{
    	if(fzr_id!=null) {
    		HqSanitationmanMessage  fzrxq = hqHwFZRXqService.findFZRMessage(fzr_id);
    		return AjaxResult.success(fzrxq);
    	}
    	return AjaxResult.fail("数据请求失败,无法获得指定的id");
    }
    /**
     * 负责人详情--任务分区
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/fzrxqrw")
    @ResponseBody
    public AjaxResult queryHWXq(String fzr_id,Integer currentPage,Integer pageSize) throws Exception{
    	if(fzr_id!=null) {
    		PageModel<Map<String, Object>> fzrxqjl=hqHwFZRXqService.queryHWXq(fzr_id, currentPage, pageSize);
    		return AjaxResult.success(fzrxqjl);
    	}
    	return AjaxResult.fail("数据请求失败,无法获得指定的id");
    }
    
    /**
     * 负责人负责区域的总数
     */
    @RequestMapping("/fzrcount")
    @ResponseBody
    public AjaxResult findFZRCount(String fzr_id) {
    	if(fzr_id!=null) {
    		Integer count = hqHwFZRXqService.findCountById(fzr_id);
    		return AjaxResult.success(count);
    	}
    	return AjaxResult.fail("数据请求失败,无法获得指定的id");
    }



    /**
     * 根据环卫工信息表中的hqSanitationmanType查询环卫工类型
     */
    @RequestMapping("/SelectType")
    @ResponseBody
    public AjaxResult selecttype(String ID) {

        String name = hqSanitationmanMessageService.findFLNAME(ID);
        return AjaxResult.success(name, "环卫工类型");
    }

    @RequestMapping("/InquireSanitationmanType")
    @ResponseBody
    public AjaxResult InquireSanitationmanType() {
        List<Map<String, Object>> list = hqSanitationmanMessageService.InquireSanitationmanType();
        return AjaxResult.success(list, "环卫工全部类型");
    }


    /**
     * 添加环卫工人
     *
     * @param addnames
     * @param addIDNumbers
     * @param addBirthdays
     * @param addtypes
     * @param addsexs
     * @param addxuelis
     * @param addphones
     * @return
     * @throws ParseException
     */
    @RequestMapping("/AddSanitationman")
    @ResponseBody
    public AjaxResult AddSanitationman(String addnames, String addIDNumbers, String addBirthdays, String addtypes, String addsexs, String addxuelis, String addphones) throws ParseException {

        HqSanitationmanMessage hqSanitationmanMessage = new HqSanitationmanMessage();
        hqSanitationmanMessage.setHqSanitationmanName(addnames);//姓名
        hqSanitationmanMessage.setHqSanitationmanSex(addsexs);//性别
        hqSanitationmanMessage.setHqSanitationmanIdcard(addIDNumbers);//身份证号码
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date zhuandate = null;
        zhuandate = format1.parse(addBirthdays);
        hqSanitationmanMessage.setHqSanitationmanBirthdate(zhuandate);//生日
        hqSanitationmanMessage.setHqSanitationmanPhone(addphones);//手机号
        hqSanitationmanMessage.setHqSanitationmanType(addtypes);//工作类型
        hqSanitationmanMessage.setHqSanitationmanBackground(addxuelis);//学历
        hqSanitationmanMessage.setHqSanitationmanImgUrl(imgurl);//添加头像
         hqSanitationmanMessage.setStatus(0);//添加状态
        hqSanitationmanMessageService.save(hqSanitationmanMessage);
        return AjaxResult.success(hqSanitationmanMessage, "添加");
    }

    /**
     * 异步上传图爿
     */
    @RequestMapping("/uploadImg")
    @ResponseBody
    public AjaxResult ajaxUploadFile3(MultipartHttpServletRequest request) {
        System.out.println("入口");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        System.out.println("1号" + multipartRequest);
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        try {
            Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
            System.out.println("2号" + multipartRequest.getFileMap().get("file").getSize());
            MultipartFile multipartFile = null;
            String fileName = null;
            for (Map.Entry<String, MultipartFile> set : fileMap.entrySet()) {
                multipartFile = set.getValue();// 文件名
                System.out.println("3号" + multipartFile.isEmpty());

            }
            fileName = this.storeIOc3(multipartRequest, multipartFile);
            ajaxResult.setData(fileName);
            ajaxResult.setSuccess(true);
            imgurl =fileName;
            System.out.println("四号" + imgurl);
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
                } else {
                    result = "文件格式不对，只能上传、png、jpg、gif格式";
                }
            }
        }
        return result;
    }


    /**
     * 编辑环卫工人
     */
    @RequestMapping("/updateMessage")
    @ResponseBody
    public AjaxResult UpdataMessage(
            @RequestParam(value = "Name",defaultValue = "测试二十二号" ) String Name,
            @RequestParam(value = "sex",defaultValue = "女") String sex,
                 Date birthdate,
            @RequestParam(value = "type",defaultValue="123" ) String type,
            @RequestParam(value = "phone" ,defaultValue="181") String phone,
            @RequestParam(value = "background" ,defaultValue="999999") String background,
            @RequestParam(value = "ID",defaultValue = "402881016436e22d016436e35d500000") String ID
    ) throws ParseException {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date zhuandate = null;
        zhuandate = format1.parse("2018-01-01");
       Integer UpdateMessage = hqSanitationmanMessageService.updateMessage(Name, sex, zhuandate, type, phone, background, ID);
        return AjaxResult.success(UpdateMessage, "修改环卫工");
    }

    /**
     * 删除环卫工人
     */
    @RequestMapping("/DeleteMessage")
    @ResponseBody
    public AjaxResult DeleteMessage(String ID) {
        Integer list = hqSanitationmanMessageService.deleteMessage(ID);
        return AjaxResult.success(list, "删除环卫工");
    }

    /**
     * 查看照片
     */
    @RequestMapping("/LookPicture")
    @ResponseBody
    public AjaxResult LookPicture(String id) {

        String i = hqSanitationmanMessageService.findByhqSanitationmanImgUrl(id);
            return AjaxResult.success(i, "查看照片");

    }
}