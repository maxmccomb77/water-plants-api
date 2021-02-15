package com.application.waterplants.api.service;

import com.application.waterplants.api.repository.WaterNowDao;

public class WaterNowService {

    WaterNowDao waterNowDao = new WaterNowDao();

    public void saveWateringData(String requestType, String timestamp) {waterNowDao.saveWateringData(requestType, timestamp);}
}
