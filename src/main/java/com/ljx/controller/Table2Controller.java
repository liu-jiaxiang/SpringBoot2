package com.ljx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ljx.model.Table2;
import com.ljx.service.impl.Table2Service;

@RestController
@RequestMapping("/table2")
public class Table2Controller {

	@Autowired
	private Table2Service table2Service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Table2> getTable2List() {
		return table2Service.findTable2List();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Table2 getTable2ById(@PathVariable("id") int id) {
		return table2Service.findTable2(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateTable2(@PathVariable("id") int id,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "money", required = true) double money) {
		int t = table2Service.update(name, money, id);
		if (t == 1) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") int id) {
		int t = table2Service.delete(id);
		if (t == 1) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postTable2(@RequestParam("name") String name,
			@RequestParam("money") double money) {
		int t = table2Service.add(name, money);
		if (t == 1) {
			return "success";
		} else {
			return "fail";
		}
	}
} 
