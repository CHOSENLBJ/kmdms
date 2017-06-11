package com.kmdms.service;

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
}
