package com.kmdms.service;

import com.kmdms.common.utils.PageBean;
import com.kmdms.pojo.Label;
import com.kmdms.pojo.custom.LabelCustom;

import java.util.List;

/**
 * Created by JAMES on 2017/5/25.
 */
public interface LabelService {

    /**
     * 获得所有标签
     * @return
     * @throws Exception
     */
    List<LabelCustom> getAllLabel() throws Exception;

    /**
     * 创建标签
     * @param createLabel
     * @return
     * @throws Exception
     */
    LabelCustom createLabel(String createLabel) throws Exception;

    /**
     * 根据学生学号查询其选标签
     * @param stuId
     * @return
     * @throws Exception
     */
    List<Label> findLabelsByStuId(String stuId) throws Exception;

    /**
     * 更新学生所选的标签
     * @param labelId
     * @param stuId
     * @throws Exception
     */
    void updateLabelsOfStudent(String[] labelId, String stuId) throws Exception;
    /**
     * 后台标签列表，带分页，带条件筛选
     * @param pageCode
     * @param content
     * @return
     */
	PageBean<LabelCustom> getLabelToPage(String pageCode,String content) throws Exception;

    /**
     * 根据id删除标签
     * @param labelId
     * @throws Exception
     */
    void deleteLabelById(String labelId) throws Exception;

    /**
     * 编辑标签
     * @param labelCustom
     * @return
     * @throws Exception
     */
    LabelCustom editLabel(LabelCustom labelCustom) throws Exception;

    /**
     * 创建或编辑标签
     * @param labelCustom
     * @return
     * @throws Exception
     */
    LabelCustom createOrEditLabel(LabelCustom labelCustom) throws Exception;

    /**
     * 根据id查找标签
     * @param labelId
     * @return
     * @throws Exception
     */
    LabelCustom findLabelById(String labelId) throws Exception;
}
