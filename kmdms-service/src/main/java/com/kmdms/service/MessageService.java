package com.kmdms.service;

import com.kmdms.pojo.Message;

import java.util.List;

/**
 * Created by JAMES on 2017/6/6.
 */
public interface MessageService {


    /**
     * 跟据学生Id查找相关消息
     * @param stuId
     * @return
     * @throws Exception
     */
    List<Message> findMessagesByStuId(String stuId) throws Exception;

    /**
     * 将学号为stuId的学生的所有通知设置为已读
     * @throws Exception
     */
    void updateMessageIsReadTrue(String stuId) throws Exception;

}
