package com.ljx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ljx.model.Greeting;

@Controller
public class GreetingContorller {

	@GetMapping("/greeting")
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "greeting";
	}
	
	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting) {
		return "result";
	}
}
