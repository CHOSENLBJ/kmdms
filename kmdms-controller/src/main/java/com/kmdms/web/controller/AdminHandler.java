package com.kmdms.web.controller;

import com.kmdms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by JAMES on 2017/6/6.
 */
@Controller
@RequestMapping("/admin")
public class AdminHandler {

    @Autowired
    private AdminService adminService;


    /**
     * 后台登陆
     * @param adminName
     * @param password
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login(String adminName, String password, HttpSession session) throws Exception{
        adminService.loginCheck(adminName, password);//检查登陆账号
        //将当前管理者账号名存入session中
        session.setAttribute("session_admin", adminName);
        return "redirect:index.action";
    }

    /**
     * 跳转到登陆页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/toLogin")
    public String toLogin() throws Exception{
        return"admin/admin_login";
    }

    /**
     * 跳转到管理员主页
     * @return
     * @throws Exception
     */
    @RequestMapping("/index")
    public String index() throws Exception{
        return "admin/admin_index";
    }

}
