package com.kmdms.service;

import com.kmdms.pojo.custom.DormitoryCustom;

import java.util.List;

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

    /**
     * 根据buildingId查找宿舍
     * @param buildingId
     * @return
     * @throws Exception
     */
    List<DormitoryCustom> findDormitoryByBuildingId(String buildingId) throws Exception;

    /**
     * 根据宿舍id查找空床位
     * @param dormitoryId
     * @return
     * @throws Exception
     */
    List<Integer> findEmptyBedByDormitoryId(String dormitoryId) throws Exception;
}
