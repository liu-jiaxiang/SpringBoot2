package com.ljx.service;

import java.util.List;

import com.ljx.model.Table1;

public interface Table1Service {

	List<Table1> findAll();
	
	Table1 findOne(int id);
	
	Table1 saveAndFlush(Table1 table);
	
	Table1 save(Table1 table);
}
