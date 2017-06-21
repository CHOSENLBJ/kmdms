package com.kmdms.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kmdms.common.utils.PageBean;
import com.kmdms.pojo.custom.BuildingCustom;
import com.kmdms.service.BuildingService;

@Controller
@RequestMapping("building")
public class BuildingHandler {
	
	@Autowired
	private BuildingService buildingService;
	/**
	 * 后台去创建或修改宿舍页面
	 * @param request
	 * @param dormitoryId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toEditBuilding")
	public String toEditBuilding(HttpServletRequest request, String dormitoryId) throws Exception{
		return "admin/admin_building_edit";
	}
	/**
	 * 创建或修改宿舍
	 * @param request
	 * @param buildingCustom
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("editBuilding")
	public void EditBuilding(HttpServletRequest request, BuildingCustom buildingCustom) throws Exception{
		buildingService.editBuilding(buildingCustom);
	}
	/**
	 * 得到所有宿舍，带分页
	 * @param request
	 * @param pageCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getBuildingList")
	public String getBuildingList(HttpServletRequest request,String pc) throws Exception{
		PageBean<BuildingCustom> buildingPageBean = buildingService.selectAllBuilding(pc);
		request.setAttribute("buildingPageBean", buildingPageBean);
		return "admin/admin_building_list";
	}
}
