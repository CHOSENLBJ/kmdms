package com.kmdms.service.impl;

import java.util.List;

import com.kmdms.common.utils.PageBean;
import com.kmdms.mapper.DormitoryMapper;
import com.kmdms.mapper.custom.DormitoryMapperCustom;
import com.kmdms.pojo.custom.DormitoryCustom;
import com.kmdms.pojo.custom.LabelCustom;
import com.kmdms.service.DormitoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by JAMES on 2017/6/11.
 */
@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryMapperCustom dormitoryMapperCustom;
    
    private final String pageRecord = "5";

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
    public DormitoryCustom findDormitoryFullInfoByDormitoryId(String dormitoryId) throws Exception {
        return dormitoryMapperCustom.selectDormitoryFullInfoByDormitoryId(dormitoryId);
    }

	@Override
	public PageBean<DormitoryCustom> selectAllDormitory(String pageCode)
			throws Exception {
		PageBean<DormitoryCustom> dormitoryPageBean = new PageBean<DormitoryCustom>();
		//查出数量
		int totalRecord = dormitoryMapperCustom.countByExample(null);
		//设置pageBean所需参数
		dormitoryPageBean.setPageCode(pageCode);
		dormitoryPageBean.setCondition(null);
		dormitoryPageBean.setPageRecord(pageRecord);
		dormitoryPageBean.setPagePosition(pageRecord, pageCode);
		dormitoryPageBean.setTotalPage(pageRecord, totalRecord);
		dormitoryPageBean.setTotalRecord(totalRecord);
		//执行查询语句
		List<DormitoryCustom> dormitoryCustomList = dormitoryMapperCustom.selectDormitoryToPage(dormitoryPageBean);
		dormitoryPageBean.setBeanList(dormitoryCustomList);
		return dormitoryPageBean;
	}
}
