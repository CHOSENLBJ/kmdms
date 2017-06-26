package com.kmdms.service.impl;

import com.kmdms.mapper.custom.DormitoryMapperCustom;
import com.kmdms.pojo.Student;
import com.kmdms.pojo.custom.DormitoryCustom;
import com.kmdms.service.DormitoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAMES on 2017/6/11.
 */
@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryMapperCustom dormitoryMapperCustom;

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
    public DormitoryCustom findDormitoryFullInfoByDormitoryId(String dormitoryId) throws Exception {
        return dormitoryMapperCustom.selectDormitoryFullInfoByDormitoryId(dormitoryId);
    }

    @Override
    public List<DormitoryCustom> findDormitoryByBuildingId(String buildingId) throws Exception {
        return dormitoryMapperCustom.selectDormitoryByBuildingId(buildingId);
    }

    @Override
    public List<Integer> findEmptyBedByDormitoryId(String dormitoryId) throws Exception {
        //得到该宿舍所有信息
        DormitoryCustom dormitoryCustom = dormitoryMapperCustom.selectDormitoryFullInfoByDormitoryId(dormitoryId);
        List<Integer> emptyBed = new ArrayList<Integer>();
        //得到住在该宿舍的成员
        List<Student> students = dormitoryCustom.getStudentList();
        Boolean isEmptyBed = true;
        for(int i = 1; i <= dormitoryCustom.getBedCount(); i++){
            isEmptyBed = true;
            for(Student student: students){
                if(i == student.getBedNum()){
                    isEmptyBed = false;
                    break;
                }
            }
            if(isEmptyBed)emptyBed.add(i);
        }
        return emptyBed;
    }
}
