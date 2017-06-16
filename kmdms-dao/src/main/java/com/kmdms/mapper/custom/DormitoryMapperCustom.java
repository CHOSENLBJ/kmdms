package com.kmdms.mapper.custom;

import java.util.List;

import com.kmdms.common.utils.PageBean;
import com.kmdms.mapper.DormitoryMapper;
import com.kmdms.pojo.custom.DormitoryCustom;

public interface DormitoryMapperCustom extends DormitoryMapper {

    /**
     * 根据宿舍Id查询宿舍所有信息包括所在大楼、宿舍成员
     * @param dormitoryId
     * @return
     * @throws Exception
     */
    DormitoryCustom selectDormitoryFullInfoByDormitoryId(String dormitoryId) throws Exception;

}