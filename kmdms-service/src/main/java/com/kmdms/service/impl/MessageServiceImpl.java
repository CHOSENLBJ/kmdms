package com.kmdms.service.impl;

import com.kmdms.mapper.MessageMapper;
import com.kmdms.mapper.custom.MessageMapperCustom;
import com.kmdms.pojo.Message;
import com.kmdms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JAMES on 2017/6/6.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapperCustom messageMapperCustom;

    @Override
    public List<Message> findMessagesByStuId(String stuId) throws Exception {
        return messageMapperCustom.selectMessagesByStuId(stuId);
    }
}
