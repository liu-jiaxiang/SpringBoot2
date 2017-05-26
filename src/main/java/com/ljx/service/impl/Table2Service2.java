package com.ljx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljx.dao.Table2Mapper2;

@Service
public class Table2Service2 {

	@Autowired(required = false)
	Table2Mapper2 table2Mapper2;
	
	@Transactional
	public void tansfer() throws RuntimeException {
		table2Mapper2.update(90, 1);
		@SuppressWarnings("unused")
		int i = 1/0;
		table2Mapper2.update(110, 2);
	}
}
