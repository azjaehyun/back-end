package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	
	@RequestMapping(value = "/api/test",  method= RequestMethod.GET)
	public String test (@RequestParam(value="test",defaultValue = "test") String test ) {
		return test;
	}
	
	
	
}
