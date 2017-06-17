package com.kmdms.service.impl;

import com.kmdms.mapper.custom.DormitoryMapperCustom;
import com.kmdms.pojo.custom.DormitoryCustom;
import com.kmdms.service.DormitoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
}
