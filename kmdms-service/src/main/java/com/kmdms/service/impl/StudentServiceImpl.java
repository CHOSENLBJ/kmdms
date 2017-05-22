package com.kmdms.service.impl;

import com.kmdms.mapper.StudentMapper;
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
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addStudent(Student student){
		//studentMapper.addStudent(student);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
	@Override
	public StudentCustom loginCheck(StudentCustom studentCustom) throws Exception{
		String stuId = studentCustom.getStuId();
		//根据id查询学生
		StudentCustom sc = studentMapperCustom.selectStudentById(stuId);
		if(sc != null){//若查询结果
			if(studentCustom.getPassword().equals(sc.getPassword())){//若密码匹配
				studentCustom = sc;
			} else {//密码不匹配
				KMDMSException exception = new KMDMSException("密码错误！", "index");
				exception.getModel().put("studentCustom", studentCustom);
				throw exception;
			}
		} else {//查不出结果
			KMDMSException exception = new KMDMSException("没有该学号的学生！", "index");
			exception.getModel().put("studentCustom", studentCustom);
			throw exception;
		}
		return studentCustom;
	}


}
