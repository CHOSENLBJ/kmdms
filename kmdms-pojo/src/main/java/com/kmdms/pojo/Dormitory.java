package com.kmdms.pojo;

public class Dormitory {
    private String dormitoryId;

    private String roomNum;

    private Integer bedCount;

    private Integer dormitorySort;

    private String buildingId;

    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId == null ? null : dormitoryId.trim();
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum == null ? null : roomNum.trim();
    }

    public Integer getBedCount() {
        return bedCount;
    }

    public void setBedCount(Integer bedCount) {
        this.bedCount = bedCount;
    }

    public Integer getDormitorySort() {
        return dormitorySort;
    }

    public void setDormitorySort(Integer dormitorySort) {
        this.dormitorySort = dormitorySort;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }
}