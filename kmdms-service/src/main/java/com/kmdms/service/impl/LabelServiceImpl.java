package com.kmdms.service.impl;

import com.kmdms.mapper.custom.LabelMapperCustom;
import com.kmdms.pojo.custom.LabelCustom;
import com.kmdms.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by JAMES on 2017/5/25.
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapperCustom labelMapperCustom;

    @Override
    public List<LabelCustom> getAllLabel() throws Exception {
        return labelMapperCustom.selectAllLabel();
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
    public LabelCustom createLabel(String createLabel) throws Exception {
        //先判断数据库中是否有一样的标签，若有则直接返回null
        LabelCustom checkLabel = labelMapperCustom.selectIfExistsLabel(createLabel);
        if(checkLabel != null){
            return null;
        }

        //TODO 此处利用算法判断数据库中是否存在与该标签含义相近的标签，若不存在则创建。此处模拟创建

        LabelCustom labelCustom = new LabelCustom();
        String labelId = UUID.randomUUID().toString().replace("-", "");//为即将新创建的标签添加主键
        labelCustom.setLabelId(labelId);
        labelCustom.setContent(createLabel);
        labelMapperCustom.insert(labelCustom);

        return labelCustom;//若不创建则返回null！
    }
}
