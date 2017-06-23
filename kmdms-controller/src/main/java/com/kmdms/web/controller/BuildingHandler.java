package com.kmdms.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String toEditBuilding(HttpServletRequest request, String buildingId) throws Exception{
		if(buildingId != null && !"".equals(buildingId)) {
			BuildingCustom buildingCustom = buildingService.selectBuilding(buildingId);
			request.setAttribute("buildingCustom", buildingCustom);
		}
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
	public void EditBuilding(HttpServletResponse response, HttpServletRequest request, BuildingCustom buildingCustom) throws Exception{
		String msg = buildingService.editBuilding(buildingCustom);
		response.getWriter().print(msg);
	}
	/**
	 * 删除宿舍楼及宿舍楼中的宿舍
	 * @param response
	 * @param request
	 * @param buildingId
	 * @throws Exception
	 */
	@RequestMapping("deleteBuilding")
	public void deleteBuilding(HttpServletResponse response, HttpServletRequest request, String buildingId) throws Exception{
		String msg = buildingService.deleteBuilding(buildingId);
		response.getWriter().print(msg);
	}
	/**
	 * 得到所有宿舍，带分
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
