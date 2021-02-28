package com.application.waterplants.api.service;

import com.application.waterplants.api.domain.WateringData;
import com.application.waterplants.api.repository.GetWateringDataDao;

import java.util.List;



public class GetWaterDataService {

    GetWateringDataDao getWateringDataDao = new GetWateringDataDao();

    public List<WateringData> getWateringData(){
        return getWateringDataDao.fetchWateringData();
    }

}
