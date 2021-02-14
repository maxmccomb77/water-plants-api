package com.application.waterplants.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<HealthStatus> getHealth() {return new ResponseEntity<>(new HealthStatus(), HttpStatus.OK);}

    class HealthStatus {
        private String status = "UP";

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
