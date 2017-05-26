package com.kmdms.mapper.custom;

import com.kmdms.mapper.LabelMapper;
import com.kmdms.pojo.Label;
import com.kmdms.pojo.custom.LabelCustom;

import java.util.List;

public interface LabelMapperCustom extends LabelMapper{

    /**
     * 查询所有标签
     * @return
     * @throws Exception
     */
    List<LabelCustom> selectAllLabel() throws Exception;

    /**
     * 查询是否存在内容一样的标签
     * @param createLabel
     * @return
     */
    LabelCustom selectIfExistsLabel(String createLabel) throws Exception;

    /**
     * 根据学生学号查询其选标签(默认按照标签权重大到小排序)
     * @param stuId
     * @return
     * @throws Exception
     */
    List<Label> selectLabelsByStuId(String stuId) throws Exception;
}