package com.kmdms.service;

import com.kmdms.pojo.Student;
import com.kmdms.pojo.custom.StudentCustom;

public interface StudentService{
	void addStudent(Student stu);

    /**
     * 登陆验证
     * @param studentCustom
     */
    StudentCustom loginCheck(StudentCustom studentCustom) throws Exception;
}
