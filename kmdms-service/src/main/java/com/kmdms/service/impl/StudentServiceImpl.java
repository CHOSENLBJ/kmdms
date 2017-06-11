package com.kmdms.service.impl;

import com.kmdms.mapper.custom.StudentMapperCustom;
import com.kmdms.pojo.custom.StudentCustom;
import com.kmdms.common.exception.KMDMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kmdms.pojo.Student;
import com.kmdms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapperCustom studentMapperCustom;
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void addStudent(Student student){
		//studentMapper.addStudent(student);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
	public StudentCustom loginCheck(StudentCustom studentCustom) throws Exception{
		String stuId = studentCustom.getStuId();
		//根据id查询学生
		StudentCustom sc = studentMapperCustom.selectStudentById(stuId);
		if(sc != null){//若查询结果
			if(studentCustom.getPassword().equals(sc.getPassword())){//若密码匹配
				studentCustom = sc;
			} else {//密码不匹配
				KMDMSException exception = new KMDMSException("密码错误！", "login");
				exception.getModel().put("studentCustom", studentCustom);
				throw exception;
			}
		} else {//查不出结果
			KMDMSException exception = new KMDMSException("没有该学号的学生！", "login");
			exception.getModel().put("studentCustom", studentCustom);
			throw exception;
		}
		return studentCustom;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void editStudentInfo(StudentCustom studentCustom, StudentCustom session_stu) throws Exception {
		//将当前学生id给studentCustom
		studentCustom.setStuId(session_stu.getStuId());
		//更新学生
		studentMapperCustom.updateByPrimaryKeySelective(studentCustom);
		//将新信息给当前学生
		if(studentCustom.getQq() != null && !"".equals(studentCustom.getQq())){
			session_stu.setQq(studentCustom.getQq());
		}
		if(studentCustom.getAddress() != null && !"".equals(studentCustom.getAddress())){
			session_stu.setAddress(studentCustom.getAddress());
		}
		if(studentCustom.getNote() != null && !"".equals(studentCustom.getNote())){
			session_stu.setNote(studentCustom.getNote());
		}
	}


}
