package com.kmdms.service;

import com.kmdms.common.utils.PageBean;
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

    /**
     * 后台学生列表，带分页，带条件筛选
     * @param pc
     * @param stuId
     * @return
     * @throws Exception
     */
    PageBean<StudentCustom> getStudentToPage(String pc, String stuId) throws Exception;

    /**
     * 学生入宿
     * @param stuId
     * @param dormitoryId
     * @param bedNum
     * @throws Exception
     */
    void editStuDormitory(String stuId, String dormitoryId, String bedNum) throws Exception;

    /**
     * 学生退宿
     * @param stuId
     * @throws Exception
     */
    void quitStuDormitory(String stuId) throws Exception;
}
