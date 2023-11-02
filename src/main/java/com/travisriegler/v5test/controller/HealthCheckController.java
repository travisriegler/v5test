package com.travisriegler.v5test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HealthCheckController {

    @GetMapping("/healthcheck")
    public ResponseEntity<String> checkHealth() {
        //testing github branches
        RestTemplate restTemplate = new RestTemplate();
        String instanceId;
        try {
            instanceId = restTemplate.getForObject("http://169.254.169.254/latest/meta-data/instance-id", String.class);
        } catch (Exception e) {
            instanceId = "Unknown";  // or handle exception in some other way
        }
        return ResponseEntity.ok("healthy, instance-id: " + instanceId);
    }

}
