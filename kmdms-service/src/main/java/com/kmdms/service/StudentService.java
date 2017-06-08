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

    /**
     * 编辑学生信息
     * @param studentCustom
     * @param session_stu
     * @throws Exception
     */
    void editStudentInfo(StudentCustom studentCustom, StudentCustom session_stu) throws Exception;
}
