package com.ljx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljx.dao.Table1Dao;
import com.ljx.model.Table1;
import com.ljx.service.Table1Service;

@Service
public class Table1ServiceImpl implements Table1Service {

	@Autowired
	private Table1Dao tableDao;
	@Override
	public List<Table1> findAll() {
		return tableDao.findAll();
	}

	@Override
	public Table1 findOne(int id) {
		return tableDao.findOne(id);
	}

	@Override
	public Table1 saveAndFlush(Table1 table) {
		return tableDao.saveAndFlush(table);
	}

	@Override
	public Table1 save(Table1 table) {
		return tableDao.save(table);
	}

}
