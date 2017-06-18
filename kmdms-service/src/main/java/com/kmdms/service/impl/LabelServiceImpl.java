package com.kmdms.service.impl;

import com.kmdms.common.utils.PageBean;
import com.kmdms.mapper.custom.LabelMapperCustom;
import com.kmdms.pojo.Label;
import com.kmdms.pojo.LabelExample;
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
    
    private static LabelExample labelExample = new LabelExample();
    //每页记录数
    private final String pageRecord = "5";

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

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
    public LabelCustom editLabel(LabelCustom labelCustom) throws Exception{
        if(labelCustom.getContent() != null && !"".equals(labelCustom.getContent())){
            labelMapperCustom.updateByPrimaryKeySelective(labelCustom);
        }
        return labelCustom;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
    public LabelCustom createOrEditLabel(LabelCustom labelCustom) throws Exception {
        if(labelCustom.getLabelId() != null && !"".equals(labelCustom.getLabelId())){
            return this.editLabel(labelCustom);
        } else {
            return this.createLabel(labelCustom.getContent());
        }
    }

    @Override
    public LabelCustom findLabelById(String labelId) throws Exception {
        return labelMapperCustom.selectLabelById(labelId);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
    public List<Label> findLabelsByStuId(String stuId) throws Exception {
        return labelMapperCustom.selectLabelsByStuId(stuId);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
    public void updateLabelsOfStudent(String[] labelId, String stuId) throws Exception {
        if(labelId != null && labelId.length == 3){
            //删除学生原来所选标签
            labelMapperCustom.deleteLabelsOfStudent(stuId);
            LabelCustom labelCustom = new LabelCustom();
            labelCustom.setStuId(stuId);
            //为学生添加新的标签
            for(int i = 0; i < labelId.length; i++){
                labelCustom.setLabelId(labelId[i]);
                labelCustom.setWeight(i + 1);
                labelMapperCustom.insertLabelsOfStudent(labelCustom);
            }
        }
    }

	@Override
	public PageBean<LabelCustom> getLabelToPage(String pageCode,String content) throws Exception {
		content = content == null ? "" : content;
        //对content乱码处理
        content = new String(content.getBytes("ISO-8859-1"), "utf-8");
		PageBean<LabelCustom> labelPageBean = new PageBean<LabelCustom>();
		//带条件的标签数
		labelExample.clear();
		labelExample.createCriteria().andContentLike("%"+content+"%");
		int totalRecord = labelMapperCustom.countByExample(labelExample);
		//设置pageBean所需参数
		LabelCustom condition = new LabelCustom();
		condition.setContent(content);
		labelPageBean.setPageCode(pageCode);
		labelPageBean.setCondition(condition);
		labelPageBean.setPageRecord(pageRecord);
		labelPageBean.setPagePosition(pageRecord, pageCode);
		labelPageBean.setTotalPage(pageRecord, totalRecord);
		labelPageBean.setTotalRecord(totalRecord);
		//执行查询语句
		List<LabelCustom> labelCustomList = labelMapperCustom.selectLabelToPage(labelPageBean);
		labelPageBean.setBeanList(labelCustomList);
		return labelPageBean;
	}

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteLabelById(String labelId) throws Exception {
        labelMapperCustom.deleteByPrimaryKey(labelId);
    }


}
