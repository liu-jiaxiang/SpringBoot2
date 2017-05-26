package com.ljx.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ljx.model.PersonForm;

@Controller("/person")
public class PersonWebController extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}
	
	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "form";
	}
	
	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		return "redirect:/results";
	}
}
