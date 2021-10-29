package com.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	
	@GetMapping("/wish/{name}")
	public String sayHello(@PathVariable String name,@RequestParam ("lastname") String lastname) {
		return "hello "+name +" "+lastname;
	}
	
	@GetMapping("/testInfo")
	public List<Test> getTestInfo() {
	
		Test test1 = new Test(1, "sample");
		Test test2 = new Test(2, "sample1");
		List<Test> list = new ArrayList();
		list.add(test1);
		list.add(test2);
		return list;
	}

}
