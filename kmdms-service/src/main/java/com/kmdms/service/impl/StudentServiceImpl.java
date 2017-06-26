package com.kmdms.service.impl;

import com.kmdms.common.utils.PageBean;
import com.kmdms.mapper.custom.StudentMapperCustom;
import com.kmdms.pojo.StudentExample;
import com.kmdms.pojo.custom.StudentCustom;
import com.kmdms.common.exception.KMDMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kmdms.pojo.Student;
import com.kmdms.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapperCustom studentMapperCustom;

	private static StudentExample studentExample = new StudentExample();
	//每页记录数
	private final String pageRecord = "5";
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void addStudent(Student student){
		//studentMapper.addStudent(student);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
	public StudentCustom loginCheck(StudentCustom studentCustom) throws Exception{
		String stuId = studentCustom.getStuId();
		if(stuId == null || "".equals(stuId)){
			KMDMSException exception = new KMDMSException("学号不能为空！", "login");
			exception.getModel().put("studentCustom", studentCustom);
			throw exception;
		}
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

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
	public PageBean<StudentCustom> getStudentToPage(String pageCode, String stuId) throws Exception {
		stuId = stuId == null ? "" : stuId;
		PageBean<StudentCustom> studentPageBean = new PageBean<StudentCustom>();
		//带条件的标签数
		studentExample.clear();
		if(!"".equals(stuId)){
			studentExample.createCriteria().andStuIdEqualTo(stuId);
		}
		int totalRecord = studentMapperCustom.countByExample(studentExample);
		//设置pageBean所需参数
		StudentCustom condition = new StudentCustom();
		condition.setStuId(stuId);
		studentPageBean.setPageCode(pageCode);
		studentPageBean.setCondition(condition);
		studentPageBean.setPageRecord(pageRecord);
		studentPageBean.setPagePosition(pageRecord, pageCode);
		studentPageBean.setTotalPage(pageRecord, totalRecord);
		studentPageBean.setTotalRecord(totalRecord);
		//执行查询语句
		List<StudentCustom> studentCustomList = studentMapperCustom.selectStudentToPage(studentPageBean);
		studentPageBean.setBeanList(studentCustomList);
		return studentPageBean;
	}

    @Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
    public void editStuDormitory(String stuId, String dormitoryId, String bedNum) throws Exception {
        //创建一个学生
		Student student = new Student();
		//补全学生信息
		student.setStuId(stuId);
		student.setDormitoryId(dormitoryId);
		student.setBedNum(Integer.parseInt(bedNum));
		studentMapperCustom.updateByPrimaryKeySelective(student);
    }

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void quitStuDormitory(String stuId) throws Exception {
		//得到该学号的学生
		Student student = studentMapperCustom.selectByPrimaryKey(stuId);
		//将学生的宿舍及床号设为空
		student.setDormitoryId(null);
		student.setBedNum(null);
		studentMapperCustom.updateByPrimaryKey(student);
	}


}
