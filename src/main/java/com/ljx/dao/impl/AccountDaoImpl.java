package com.ljx.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ljx.dao.AccountDao;
import com.ljx.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Account account) {
		return jdbcTemplate.update("insert into account(name, money) values(?, ?)",
				account.getName(), account.getMoney()); 
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from table account where id=?",
				id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Account findAccountById(int id) {
		List<Account> accounts = jdbcTemplate.query("select * from account where id = ?",
				new Object[]{id}, new BeanPropertyRowMapper(Account.class));
		if (accounts != null && accounts.size() > 0) {
			Account account = accounts.get(0);
			return account;
		}else {
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Account> findAccountList() {
		List<Account> accounts = jdbcTemplate.query("select * from account",
				new Object[]{}, new BeanPropertyRowMapper(Account.class));
		if (accounts != null && accounts.size() > 0) {
			return accounts;
		}else {
			return null;
		}
	}

	@Override
	public int update(Account account) {
		return jdbcTemplate.update("update account set name=?, money=? where id=?",
				account.getName(), account.getMoney(), account.getId());
	}
}
