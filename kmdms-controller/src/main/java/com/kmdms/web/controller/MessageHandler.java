package com.kmdms.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.kmdms.pojo.Message;
import com.kmdms.pojo.custom.StudentCustom;
import com.kmdms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by JAMES on 2017/6/8.
 */
@Controller
@RequestMapping("/message")
public class MessageHandler {

    @Autowired
    private MessageService messageService;

    /**
     * ajax获得学生通知
     * @param session
     * @throws Exception
     */
    @RequestMapping("/getMessage")
    public void getMessage(HttpSession session, HttpServletResponse response) throws Exception{
        //获得当前学生id
        String stuId = ((StudentCustom)session.getAttribute("session_stu")).getStuId();
        List<Message> messageList = messageService.findMessagesByStuId(stuId);

        String messagesJson = JSONArray.toJSON(messageList).toString();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(messagesJson);
        pw.flush();
        pw.close();
    }

}
