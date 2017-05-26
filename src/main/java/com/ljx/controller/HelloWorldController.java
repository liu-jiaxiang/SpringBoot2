package com.ljx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljx.model.MyInformation;
import com.ljx.model.User;

@RestController
@EnableConfigurationProperties({MyInformation.class})
public class HelloWorldController {
	
	@RequestMapping("/")
	public String index() {
		return "Hello World from SpringBoot!";
	}
	
	@Autowired
	private MyInformation information;
	
	@RequestMapping("/me")
	public String showInformation() {
		return information.getName() + ">>>" + information.getId() + ">>>" 
				+ information.getAge() + ">>>" + information.getGreeting();
	}
	
	@Autowired
	private User user;
	@RequestMapping("/user")
	public String user() {
		return user.getName() + "\n" + user.getAge() + "\n" + user.getId();
	}
}
