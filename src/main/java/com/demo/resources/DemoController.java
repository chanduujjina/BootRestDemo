package com.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {
	
	
	@GetMapping("/wish/{name}")
	public  ResponseEntity<String> sayHello(@PathVariable String name,@RequestParam ("lastname") String lastname,@RequestParam(name="middle",required=true) String middle) {
		String value = "hello "+name +" "+middle+" "+lastname ;
	   ResponseEntity<String> entity = new ResponseEntity<String>(value, HttpStatus.OK);
		return entity;
	}
	
	@GetMapping("/wish_v1/{name}")
	public  ResponseEntity<String> sayHello(@PathVariable String name,@RequestParam MultiValueMap<String, String> map) {
		String middelName = map.getFirst("middle");
		 ResponseEntity<String> entity = null;
		if(middelName != null) {
		String value = "hello "+name +" "+map.getFirst("middle")+" "+map.getFirst("lastname") ;
		entity  = new ResponseEntity<String>(value, HttpStatus.OK);
		}
		else {
			entity  = new ResponseEntity<String>("middle name is require to proceed further", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/testInfo")
	public ResponseEntity<List<Test>> getTestInfo() {
		Test test1 = new Test(1, "sample");
		Test test2 = new Test(2, "sample1");
		List<Test> list = new ArrayList();
		list.add(test1);
		list.add(test2);
	ResponseEntity<List<Test>> entity = new ResponseEntity<List<Test>>(list, HttpStatus.OK);
		return entity;
	}
	
	@PostMapping("/create")
	public ResponseEntity saveTestInfo(@RequestBody Test test) {
		ResponseEntity<Test> entity = new ResponseEntity(test, HttpStatus.CREATED);
		return entity;
	}

}
