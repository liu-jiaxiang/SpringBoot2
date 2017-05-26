package com.ljx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ljx.model.Table2;

public interface Table2Mapper2 {

	Table2 findOne(@Param("id") int id);
	
	List<Table2> findList();
	
	int update(@Param("money") double money, @Param("id") int id);
}
