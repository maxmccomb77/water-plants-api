package com.application.waterplants.api.controller;

import com.application.waterplants.api.service.WaterNowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@RestController
public class WaterNow {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    WaterNowService waterNowService = new WaterNowService();

    @GetMapping(value = "/waterNow")
    public ResponseEntity handleWaterNow (){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(sdf.format(timestamp));
        waterNowService.saveWateringData("MANUAL", sdf.format(timestamp));

        return new ResponseEntity<>("Request Submitted", HttpStatus.OK);
    }
}
