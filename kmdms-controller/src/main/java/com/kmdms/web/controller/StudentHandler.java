package com.kmdms.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kmdms.pojo.Label;
import com.kmdms.pojo.Message;
import com.kmdms.pojo.custom.StudentCustom;
import com.kmdms.service.LabelService;
import com.kmdms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kmdms.pojo.Student;
import com.kmdms.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentHandler{
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private LabelService labelService;

	@Autowired
	private MessageService messageService;

	/**
	 * just for testing
	 * @param stu
	 * @param request
	 * @return
	 */
	@RequestMapping("/add")
	public String addStudent(Student stu,HttpServletRequest request){
		studentService.addStudent(stu);
		return "success";
	}

	/**
	 * 登陆
	 * @param studentCustom
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(StudentCustom studentCustom, HttpServletRequest request) throws Exception{
		studentCustom = studentService.loginCheck(studentCustom);
		//补充student选择的标签
		List<Label> labelList = labelService.findLabelsByStuId(studentCustom.getStuId());
		studentCustom.setLabelList(labelList);
		//补充student的通知
		List<Message> messageList = messageService.findMessagesByStuId(studentCustom.getStuId());
		studentCustom.setMessageList(messageList);
		//将studentCustom放入session中
		request.getSession().setAttribute("session_stu", studentCustom);
		return "redirect:index.action";
	}

	/**
	 * 跳转到主页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "index";
	}

    /**
     * 退出
     * @return
     */
	@RequestMapping("/quit")
	public String quit(HttpSession session){
        session.invalidate();
        return "redirect:toLogin.action";
    }

    /**
     * 去登陆页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/toLogin")
    public String toLogin() throws Exception{
        return "login";
    }

	/**
	 * 更新学生信息
	 * @param studentCustom
	 * @param session
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/editInfo")
    public String editInfo(StudentCustom studentCustom, HttpSession session) throws Exception{
		//获取当前学生
		StudentCustom session_stu = (StudentCustom) session.getAttribute("session_stu");
		studentService.editStudentInfo(studentCustom, session_stu);
		return "redirect:index.action";
	}
}
