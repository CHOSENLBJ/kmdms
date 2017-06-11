package com.kmdms.pojo.custom;

import com.kmdms.pojo.Building;
import com.kmdms.pojo.Dormitory;
import com.kmdms.pojo.Student;

import java.util.List;

/**
 * Created by JAMES on 2017/6/11.
 */
public class DormitoryCustom extends Dormitory {

    private Building building;          //所属宿舍楼

    private List<Student> studentList;  //宿舍成员

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
