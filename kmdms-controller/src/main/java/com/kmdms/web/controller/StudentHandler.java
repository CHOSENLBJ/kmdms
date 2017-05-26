package com.kmdms.web.controller;


import javax.servlet.http.HttpServletRequest;

import com.kmdms.pojo.Label;
import com.kmdms.pojo.custom.StudentCustom;
import com.kmdms.service.LabelService;
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
}
