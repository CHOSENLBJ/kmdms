package com.kmdms.web.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.kmdms.common.utils.PageBean;
import com.kmdms.pojo.Label;
import com.kmdms.pojo.custom.LabelCustom;
import com.kmdms.pojo.custom.StudentCustom;
import com.kmdms.service.LabelService;

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
    @RequestMapping("/toChooseLabel")
    public String toChooseLabel(HttpServletRequest request) throws Exception {
        //获得所有标签
        List<LabelCustom> labelList = labelService.getAllLabel();
        //将标签放入request域
        request.setAttribute("labelList", labelList);
        return "labelChoose";
    }

    /**
     * ajax创建标签
     * @param createLabel
     * @param response
     * @throws Exception
     */
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

    /**
     * 学生选择/重选标签
     * @param labelId
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/chooseLabel")
    public String chooseLabel(String[] labelId, HttpSession session) throws Exception{
        //得到当前学生
        StudentCustom studentCustom = (StudentCustom) session.getAttribute("session_stu");
        //更新学生所选的标签
        labelService.updateLabelsOfStudent(labelId, studentCustom.getStuId());
        //查询学生最新的标签选择并存入session_stu中
        List<Label> labelList = labelService.findLabelsByStuId(studentCustom.getStuId());
        studentCustom.setLabelList(labelList);
        return "redirect:/student/index.action";
    }
    /**
     * 后台得到指定页码的标签
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getLabelList")
    public String getLabelList(HttpServletRequest request,String pc,String content) throws Exception {
        //获得所有标签
        PageBean<LabelCustom> labelPageBean = labelService.getLabelToPage(pc,content);
        //将标签放入request域
        request.setAttribute("labelPageBean", labelPageBean);
        return "admin/admin_label_list";
    }
    /**
     * 后台跳转到标签创建页面
     * @param labelId
     * @return
     * @throws Exception
     */
    @RequestMapping("toEditLabel")
    public String toEditLabel(String labelId) throws Exception{
    	return "admin/admin_label_edit";
    }
    /**
     * 后台创建或修改标签
     * @return
     * @throws Exception 
     */
    @RequestMapping("editLabel")
    public void editLabel(HttpServletResponse response,HttpServletRequest request,LabelCustom labelCustom) throws Exception{
    	LabelCustom label = labelService.createLabel(labelCustom.getContent());
    	if(label != null) response.getWriter().print("success");
    	else response.getWriter().print("fail");
    }
}
