package com.application.waterplants.api.controller;

import com.application.waterplants.api.domain.WateringData;
import com.application.waterplants.api.service.GetWaterDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetWaterData {
    GetWaterDataService getWaterDataService = new GetWaterDataService();

    @GetMapping (value = "/getWateringData")
    public ResponseEntity handleWaterNow () {

        List <WateringData> wateringData = getWaterDataService.getWateringData();


        return new ResponseEntity<>(wateringData, HttpStatus.OK);
    }
}
