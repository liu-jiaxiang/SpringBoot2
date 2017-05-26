package com.ljx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesFileController {

	@Value("${my.name}")
	private String name;
	
	@Value("${my.age}")
	private int age;
	
	@RequestMapping("/my")
	public String replayMe() {
		return "name:" + name + "\n" + "age:" + age;
	}
}
