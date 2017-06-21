package com.kmdms.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kmdms.common.utils.PageBean;
import com.kmdms.mapper.custom.BuildingMapperCustom;
import com.kmdms.mapper.custom.DormitoryMapperCustom;
import com.kmdms.pojo.Dormitory;
import com.kmdms.pojo.custom.BuildingCustom;
import com.kmdms.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingMapperCustom buildingMapperCustom;
	@Autowired
	private DormitoryMapperCustom dormitoryMapperCustom;
	
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

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
    public String editBuilding(BuildingCustom buildingCustom) throws Exception {
		if(buildingCustom.getBuildingId() != null && !buildingCustom.getBuildingId().equals("")){
			//修改宿舍楼
			return "修改成功";
		}else{
			//创建宿舍楼
			String uuid = UUID.randomUUID().toString().replace("-", "");
			buildingCustom.setBuildingId(uuid);
			buildingCustom.setTotalDCount(buildingCustom.getFloorCount() * buildingCustom.getdCount());
			buildingMapperCustom.insert(buildingCustom);
			//创建宿舍
			
			for (int i = 0; i < buildingCustom.getFloorCount(); i++) {
				for (int j = 0; j < buildingCustom.getdCount(); j++) {
					Dormitory dormitory = new Dormitory();
					dormitory.setBuildingId(uuid);
					dormitory.setBedCount(buildingCustom.getBedCount());
					dormitory.setDormitoryId(UUID.randomUUID().toString().replace("-", ""));
					//设置宿舍位置
					dormitory.setDormitorySort(i * 100 + j);
					//设置房号
					dormitory.setRoomNum((i + 1) * 10 + j + 1 + "");
					dormitoryMapperCustom.insert(dormitory);
				}
			}
			return "创建成功";
		}
		
	}
	
	
}
