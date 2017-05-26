package com.ljx.dao;

import java.util.List;

import com.ljx.model.Account;

public interface AccountDao {

	int add(Account account);
	
	int update(Account account);
	
	int delete(int id);
	
	Account findAccountById(int id);
	
	List<Account> findAccountList();
}
