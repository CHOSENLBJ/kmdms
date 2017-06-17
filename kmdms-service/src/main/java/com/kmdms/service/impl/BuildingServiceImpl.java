package com.kmdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmdms.common.utils.PageBean;
import com.kmdms.mapper.custom.BuildingMapperCustom;
import com.kmdms.pojo.custom.BuildingCustom;
import com.kmdms.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingMapperCustom buildingMapperCustom;
	
	private final String pageRecord = "5";

	@Override
	public PageBean<BuildingCustom> selectAllBuilding(String pageCode)
			throws Exception {
		PageBean<BuildingCustom> buildingPageBean = new PageBean<BuildingCustom>();
		//查出数量
		int totalRecord = buildingMapperCustom.countByExample(null);
		//设置pageBean所需参数
		buildingPageBean.setPageCode(pageCode);
		buildingPageBean.setCondition(null);
		buildingPageBean.setPageRecord(pageRecord);
		buildingPageBean.setPagePosition(pageRecord, pageCode);
		buildingPageBean.setTotalPage(pageRecord, totalRecord);
		buildingPageBean.setTotalRecord(totalRecord);
		//执行查询语句
		List<BuildingCustom> buildingCustomList = buildingMapperCustom.selectBuildingToPage(buildingPageBean);
		buildingPageBean.setBeanList(buildingCustomList);
		return buildingPageBean;
	}
	
	
}
