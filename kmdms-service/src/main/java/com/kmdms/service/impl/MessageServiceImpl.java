package com.kmdms.service.impl;

import com.kmdms.mapper.custom.MessageMapperCustom;
import com.kmdms.mapper.custom.StudentMapperCustom;
import com.kmdms.pojo.Message;
import com.kmdms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by JAMES on 2017/6/6.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapperCustom messageMapperCustom;

    @Autowired
    private StudentMapperCustom studentMapperCustom;

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

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
    public void sendMessageToEveryone(String content) throws Exception {
        //获取所有学生id
        List<String> ids = studentMapperCustom.selectAllTheIds();
        if(ids != null && ids.size() > 0){
            //创建通知
            Message message = new Message();
            //补全通知信息
            String messageId = "";
            message.setContent(content);
            message.setIsRead(false);
            message.setMessageDate(new Date());
            for(String id : ids){
                //修改通知id
                messageId = UUID.randomUUID().toString().replace("-", "");
                message.setMessageId(messageId);
                //修改通知的持有者
                message.setStuId(id);
                //插入一条通知
                messageMapperCustom.insert(message);
            }
        }
    }


}
