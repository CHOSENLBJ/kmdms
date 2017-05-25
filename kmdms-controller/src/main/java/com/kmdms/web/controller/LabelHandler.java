package com.kmdms.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.kmdms.pojo.custom.LabelCustom;
import com.kmdms.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by JAMES on 2017/5/25.
 */

@Controller
@RequestMapping("/label")
public class LabelHandler {

    @Autowired
    private LabelService labelService;

    /**
     * 转到标签选择页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/chooseLabel")
    public String toChooseLabel(HttpServletRequest request) throws Exception {
        //获得所有标签
        List<LabelCustom> labelList = labelService.getAllLabel();
        //将标签放入request域
        request.setAttribute("labelList", labelList);
        return "labelChoose";
    }

    @RequestMapping("/createLabel")
    public void createLabel(String createLabel, HttpServletResponse response) throws Exception{
        //创建标签
        LabelCustom lc = labelService.createLabel(createLabel);
        String labelJson = "EXISTS";
        if(lc != null){//创建成功
            labelJson = JSONArray.toJSONString(lc);
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(labelJson);
        pw.flush();
        pw.close();
    }

}
