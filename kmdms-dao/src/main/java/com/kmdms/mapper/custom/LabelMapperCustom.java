package com.kmdms.mapper.custom;

import java.util.List;

import com.kmdms.common.utils.PageBean;
import com.kmdms.mapper.LabelMapper;
import com.kmdms.pojo.Label;
import com.kmdms.pojo.custom.LabelCustom;

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

    /**
     * 删除学生原来所选标签
     * @param stuId
     * @throws Exception
     */
    void deleteLabelsOfStudent(String stuId) throws Exception;

    /**查询后台标签列表
     * 插入学生所选标签
     * @param labelCustom
     * @throws Exception
     */
    void insertLabelsOfStudent(LabelCustom labelCustom) throws Exception;
    /**
     * 后台标签类别
     * @param labelPageBean
     * @return
     * @throws Exception
     */
	List<LabelCustom> selectLabelToPage(PageBean<LabelCustom> labelPageBean) throws Exception;
}