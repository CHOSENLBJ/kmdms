package com.kmdms.pojo;

public class Building {
    private String buildingId;

    private String buildingName;

    private Integer floorcount;

    private Integer dcount;

    private Integer totaldcount;

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public Integer getFloorcount() {
        return floorcount;
    }

    public void setFloorcount(Integer floorcount) {
        this.floorcount = floorcount;
    }

    public Integer getDcount() {
        return dcount;
    }

    public void setDcount(Integer dcount) {
        this.dcount = dcount;
    }

    public Integer getTotaldcount() {
        return totaldcount;
    }

    public void setTotaldcount(Integer totaldcount) {
        this.totaldcount = totaldcount;
    }
}