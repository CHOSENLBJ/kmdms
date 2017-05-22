package com.kmdms.pojo;

public class Building {
    private String buildingId;

    private String buildingName;

    private Integer floorCount;

    private Integer dCount;

    private Integer totalDCount;

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

    public Integer getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Integer floorCount) {
        this.floorCount = floorCount;
    }

    public Integer getdCount() {
        return dCount;
    }

    public void setdCount(Integer dCount) {
        this.dCount = dCount;
    }

    public Integer getTotalDCount() {
        return totalDCount;
    }

    public void setTotalDCount(Integer totalDCount) {
        this.totalDCount = totalDCount;
    }
}