package com.kmdms.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.kmdms.pojo.custom.DormitoryCustom;
import com.kmdms.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by JAMES on 2017/6/25.
 */
@Controller
@RequestMapping("/dormitory")
public class DormitoryHandler {

    @Autowired
    private DormitoryService dormitoryService;

    /**
     * 根据buildingId查找宿舍
     * @param buildingId
     * @param response
     * @throws Exception
     */
    @RequestMapping("/getDormitoryByBuildingId")
    public void getDormitoryByBuildingId(String buildingId, HttpServletResponse response) throws Exception{
        List<DormitoryCustom> dormitorys = dormitoryService.findDormitoryByBuildingId(buildingId);
        String dormitorysJson = JSONArray.toJSONString(dormitorys);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(dormitorysJson);
        pw.flush();
        pw.close();
    }

    /**
     * 根据宿舍号查找床位
     * @param dormitoryId
     * @param response
     * @throws Exception
     */
    @RequestMapping("/getEmptyBedByDormitoryId")
    public void getEmptyBedByDormitoryId(String dormitoryId, HttpServletResponse response) throws Exception{
        List<Integer> emptyBed = dormitoryService.findEmptyBedByDormitoryId(dormitoryId);
        String emptyBedJson = JSONArray.toJSONString(emptyBed);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(emptyBedJson);
        pw.flush();
        pw.close();
    }

}
