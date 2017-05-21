package com.kmdms.pojo;

public class Dormitory {
    private String dormitoryId;

    private String roomnum;

    private Integer bedcount;

    private Integer dormitorySort;

    private String buildingId;

    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId == null ? null : dormitoryId.trim();
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum == null ? null : roomnum.trim();
    }

    public Integer getBedcount() {
        return bedcount;
    }

    public void setBedcount(Integer bedcount) {
        this.bedcount = bedcount;
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