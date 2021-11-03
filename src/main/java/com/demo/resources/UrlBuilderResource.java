package com.demo.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urlInfo")
public class UrlBuilderResource {
	
	@GetMapping("/getUrl")
	public ResponseEntity getFaceBookUrl() {
		String url ="https://www.facebook.com/";
		return new ResponseEntity(url, HttpStatus.OK);
		
	}

}
