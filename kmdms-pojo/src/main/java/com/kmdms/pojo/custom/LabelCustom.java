package com.kmdms.pojo.custom;

import com.kmdms.pojo.Label;

public class LabelCustom extends Label{

    private String stuId;       //用于暂时存储哪位学生选择了该标签
    private Integer weight;      //用于暂时存储学生选择该标签的权重
    private Integer chooseCount; //用于统计该标签的选择人数

    public Integer getChooseCount() {
		return chooseCount;
	}

	public void setChooseCount(Integer chooseCount) {
		this.chooseCount = chooseCount;
	}

	public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}