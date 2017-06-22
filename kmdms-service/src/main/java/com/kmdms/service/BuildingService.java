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
	/**
	 * 创建或修改宿舍
	 * @param buildingCustom
	 * @return
	 * @throws Exception
	 */
	String editBuilding(BuildingCustom buildingCustom) throws Exception;
	/**
	 * 删除宿舍楼
	 * @param buildingId
	 * @return
	 * @throws Exception
	 */
	String deleteBuilding(String buildingId) throws Exception;
	/**
	 * 查找宿舍
	 * @param buildingId
	 * @return
	 * @throws Exception
	 */
	BuildingCustom selectBuilding(String buildingId) throws Exception;
	
}
