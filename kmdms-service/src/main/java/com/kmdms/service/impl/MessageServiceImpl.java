package com.kmdms.service.impl;

import com.kmdms.mapper.MessageMapper;
import com.kmdms.mapper.custom.MessageMapperCustom;
import com.kmdms.pojo.Message;
import com.kmdms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JAMES on 2017/6/6.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapperCustom messageMapperCustom;

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
    public List<Message> findMessagesByStuId(String stuId) throws Exception {
        //获得所有stuId所有通知
        List<Message> messageList = messageMapperCustom.selectMessagesByStuId(stuId);
        //将stuId所有通知设置为已读
        this.updateMessageIsReadTrue(stuId);
        return messageList;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
    public void updateMessageIsReadTrue(String stuId) throws Exception {
        messageMapperCustom.updateMessageIsReadTrue(stuId);
    }


}
