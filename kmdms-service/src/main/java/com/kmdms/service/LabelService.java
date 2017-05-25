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
}
