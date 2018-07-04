package com.dzqc.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/qpdn")
public class HqAdminPaiDanControllerN {
    @RequestMapping("/list")
    public String QPDY() {
        return "houqin/pd_busy";/*跳转到去派单无空闲的页面(pd_busy.jsp)*/
    }


}
