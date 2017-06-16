package com.kmdms.pojo.custom;

import com.kmdms.pojo.Building;

public class BuildingCustom extends Building {
	private Integer totalPeople; // 该宿舍楼总人数
	private Integer bedCount; // 每间宿舍床位数
	
	public Integer getBedCount() {
		return bedCount;
	}

	public void setBedCount(Integer bedCount) {
		this.bedCount = bedCount;
	}

	public Integer getTotalPeople() {
		return totalPeople;
	}

	public void setTotalPeople(Integer totalPeople) {
		this.totalPeople = totalPeople;
	}

}
