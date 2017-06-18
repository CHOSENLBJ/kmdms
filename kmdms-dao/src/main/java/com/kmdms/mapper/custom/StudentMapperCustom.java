package com.kmdms.mapper.custom;

import com.kmdms.mapper.StudentMapper;
import com.kmdms.pojo.Student;
import com.kmdms.pojo.StudentExample;
import com.kmdms.pojo.custom.StudentCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StudentMapperCustom extends StudentMapper {

    /**
     * 根据id查询学生
     * @param stuId
     * @return
     */
    StudentCustom selectStudentById(String stuId) throws Exception;

    /**
     * 得到所有学生id
     * @return
     * @throws Exception
     */
    List<String> selectAllTheIds() throws Exception;
}