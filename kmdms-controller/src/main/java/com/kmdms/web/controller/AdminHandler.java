package com.kmdms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JAMES on 2017/6/6.
 */
@Controller
@RequestMapping("/admin")
public class AdminHandler {


    @RequestMapping("/login")
    public String login() throws Exception{
        return "redirect:index.action";
    }

    @RequestMapping("/index")
    public String index() throws Exception{
        return "admin/admin_index";
    }

}
