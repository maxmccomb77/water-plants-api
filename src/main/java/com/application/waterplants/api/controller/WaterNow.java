package com.application.waterplants.api.controller;

import com.application.waterplants.api.domain.WaterNowInput;
import com.application.waterplants.api.service.WaterNowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@RestController
public class WaterNow {
    WaterNowService waterNowService = new WaterNowService();

    @PostMapping (value = "/waterNow")
    public ResponseEntity handleWaterNow (@RequestBody WaterNowInput input) {

        waterNowService.saveWateringData("MANUAL", input.getTimestamp());
        return new ResponseEntity<>("Request Submitted", HttpStatus.OK);
    }
}
