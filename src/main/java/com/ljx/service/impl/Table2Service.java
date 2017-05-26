package com.ljx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljx.dao.Table2Mapper;
import com.ljx.model.Table2;

@Service
public class Table2Service {

	@Autowired
	private Table2Mapper table2Mapper;
	
	public int add(String name, double money) {
		return table2Mapper.add(name, money);
	}
	
	public int update(String name,  double money, int id) {
		return table2Mapper.update(name, money, id);
	}
	
	public int delete(int id) {
		return table2Mapper.delete(id);
	}
	
	public Table2 findTable2(int id) {
		return table2Mapper.findTable2(id);
	}
	
	public List<Table2> findTable2List() {
		return table2Mapper.findTable2List();
	}
}
