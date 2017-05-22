package com.kmdms.pojo.custom;

import com.kmdms.pojo.Dormitory;
import com.kmdms.pojo.Label;
import com.kmdms.pojo.Message;
import com.kmdms.pojo.Student;

import java.util.List;

/**
 * Created by JAMES on 2017/5/22.
 */
public class StudentCustom extends Student {

    private Dormitory dormitory;            //所在宿舍
    private List<Label> labelList;          //所选标签
    private List<Message> messageList;      //学生消息

    public Dormitory getDormitory() {
        return dormitory;
    }
    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    public List<Label> getLabelList() {
        return labelList;
    }
    public void setLabelList(List<Label> labelList) {
        this.labelList = labelList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }
    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
