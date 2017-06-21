package com.kmdms.service;

import com.kmdms.common.utils.PageBean;
import com.kmdms.pojo.custom.BuildingCustom;

public interface BuildingService {
	/**
	 * 得到宿舍楼列表，带分页
	 * @param pageCode
	 * @return
	 * @throws Exception
	 */
	PageBean<BuildingCustom> selectAllBuilding(String pageCode) throws Exception;

	String editBuilding(BuildingCustom buildingCustom) throws Exception;
	
}
