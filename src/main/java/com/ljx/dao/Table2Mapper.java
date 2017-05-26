package com.ljx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ljx.model.Table2;

@Mapper
public interface Table2Mapper {

	@Insert("insert into table2(name, money) values (#{name}, #{money})")
	int add(@Param("name") String name, @Param("money") double money);
	
	@Update("update table2 set name = #{name}, money = #{money} where id = #{id}")
	int update(@Param("name") String name, @Param("money") double money,
			@Param("id") int id);
	
	@Delete("delete from table2 where id = #{id}")
	int delete(int id);
	
	@Select("select id, name as name, money as money from table2 where id = #{id}")
	Table2 findTable2(@Param("id") int id);
	
	@Select("select id, name as name, money as money from table2")
	List<Table2> findTable2List();
}
