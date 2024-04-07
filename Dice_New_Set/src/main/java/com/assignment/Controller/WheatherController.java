package com.assignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WheatherController {
	
	@Autowired
    private RestTemplate restTemplate;

    @GetMapping("/forecast-summary")
    public ResponseEntity<?> getForecastSummary(@RequestParam String city) {
        String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+city+"/summary/";
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hourly-forecast")
    public ResponseEntity<?> getHourlyForecast(@RequestParam String city) {
        String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+city+"/hourly/";
        
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
	
}


