package com.ljx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ljx.model.Table1;
import com.ljx.service.Table1Service;

@RestController
@RequestMapping("/table")
public class Table1Controller {

	@Autowired
	private Table1Service table1Service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Table1> getTableList() {
		return table1Service.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getOne(@PathVariable("id") int id) {
		Table1 table = table1Service.findOne(id);
		return table.toString();
	}
	
}
