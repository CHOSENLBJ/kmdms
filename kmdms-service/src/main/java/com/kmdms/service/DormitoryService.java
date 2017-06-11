package com.kmdms.service;

import com.kmdms.pojo.custom.DormitoryCustom;

/**
 * Created by JAMES on 2017/6/11.
 */
public interface DormitoryService {

    /**
     * 根据宿舍id查找宿舍详细信息
     * @param dormitoryId
     * @return
     * @throws Exception
     */
    DormitoryCustom findDormitoryFullInfoByDormitoryId(String dormitoryId) throws Exception;
}
