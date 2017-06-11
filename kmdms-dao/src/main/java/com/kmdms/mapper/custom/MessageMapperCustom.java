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

    /**
     * 将学号为stuId的学生的所有通知设置为已读
     * @param stuId
     * @throws Exception
     */
    void updateMessageIsReadTrue(String stuId) throws Exception;
}