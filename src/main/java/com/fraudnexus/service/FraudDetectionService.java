package com.fraudnexus.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class FraudDetectionService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String mlApiUrl = "http://localhost:5000/predict";

    public Map<String, Object> getFraudPrediction(double amount, double locationScore, double deviceScore) {
        Map<String, Object> request = new HashMap<>();
        request.put("amount", amount);
        request.put("location_score", locationScore);
        request.put("device_score", deviceScore);

        Map<String, Object> response = restTemplate.postForObject(mlApiUrl, request, Map.class);
        return response;
    }
}
