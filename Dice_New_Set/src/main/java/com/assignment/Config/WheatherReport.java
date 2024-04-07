package com.assignment.Config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WheatherReport {
	
	@Bean
	public RestTemplate attachDetails() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setInterceptors(List.of((request, body, execution) -> {
			HttpHeaders headers = request.getHeaders();
			headers.set("X-RapidAPI-Host","forecast9.p.rapidapi.com");
			headers.set("X-RapidAPI-Key", "1cc8f8f5a5msh27840ca01e9ffccp1a03f6jsn139ffcd8762f");
			headers.setAccept(List.of(MediaType.APPLICATION_JSON));
			return execution.execute(request, body);
		}));
		return restTemplate;
	}
	
}