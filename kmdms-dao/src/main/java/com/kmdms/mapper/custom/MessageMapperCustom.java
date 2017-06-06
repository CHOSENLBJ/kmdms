package com.kmdms.mapper.custom;


import com.kmdms.pojo.Message;

import java.util.List;

public interface MessageMapperCustom {

    /**
     * 根据学生Id查找相关消息
     * @param stuId
     * @return
     * @throws Exception
     */
    List<Message> selectMessagesByStuId(String stuId) throws Exception;
}