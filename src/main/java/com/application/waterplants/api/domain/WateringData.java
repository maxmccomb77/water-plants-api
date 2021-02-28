package com.application.waterplants.api.domain;

public class WateringData {

    String wateringType;
    String wateringTimestamp;

    public String getWateringType() {
        return wateringType;
    }

    public void setWateringType(String wateringType) {
        this.wateringType = wateringType;
    }

    public String getWateringTimestamp() {
        return wateringTimestamp;
    }

    public void setWateringTimestamp(String wateringTimestamp) {
        this.wateringTimestamp = wateringTimestamp;
    }
}
