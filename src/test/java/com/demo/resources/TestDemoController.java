package com.demo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class TestDemoController {
	
	@org.junit.Test
	public void testGetTestInfo() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8090/bootRest/test/testInfo";
		
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
		
		ResponseEntity responseentity = restTemplate.exchange(url, HttpMethod.GET, entity, List.class);
		System.out.println(responseentity.getBody());
	}
	
	

}
