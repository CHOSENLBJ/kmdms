package com.kmdms.mapper.custom;

import java.util.List;

import com.kmdms.common.utils.PageBean;
import com.kmdms.mapper.BuildingMapper;
import com.kmdms.pojo.custom.BuildingCustom;

public interface BuildingMapperCustom extends BuildingMapper {

	/**
	 * 根据分页情况获取宿舍楼列表
	 * @param buildingPageBean
	 * @return
	 * @throws Exception
	 */
	List<BuildingCustom> selectBuildingToPage(
			PageBean<BuildingCustom> buildingPageBean) throws Exception;

	/**
	 * 查找所有宿舍的粗略信息
	 * @return
	 * @throws Exception
	 */
    List<BuildingCustom> selectBuildingRoughInfo() throws Exception;
}