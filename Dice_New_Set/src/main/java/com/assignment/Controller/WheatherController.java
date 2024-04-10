package com.assignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.assignment.Exception.UserException;
import com.assignment.Model.User;
import com.assignment.Repository.UserRepository;

import jakarta.validation.Valid;

@RestController
public class WheatherController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;

    @GetMapping("/forecast-summary")
    public ResponseEntity<String> getForecastSummary(@RequestParam String city) {
        String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+city+"/summary/";
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hourly-forecast")
    public ResponseEntity<String> getHourlyForecast(@RequestParam String city) {
        String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+city+"/hourly/";
        
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
       
    @PostMapping("/register")
    public ResponseEntity<User> registerTheUser(@Valid @RequestBody User user) throws UserException {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	return new ResponseEntity<>(userRepository.save(user), HttpStatus.ACCEPTED);
    }
    
	
}


