package com.kmdms.mapper.custom;

import com.kmdms.mapper.DormitoryMapper;
import com.kmdms.pojo.custom.DormitoryCustom;

import java.util.List;

public interface DormitoryMapperCustom extends DormitoryMapper {

    /**
     * 根据宿舍Id查询宿舍所有信息包括所在大楼、宿舍成员
     * @param dormitoryId
     * @return
     * @throws Exception
     */
    DormitoryCustom selectDormitoryFullInfoByDormitoryId(String dormitoryId) throws Exception;

    /**
     * 根据buildingId查找宿舍
     * @param buildingId
     * @return
     * @throws Exception
     */
    List<DormitoryCustom> selectDormitoryByBuildingId(String buildingId) throws Exception;
}