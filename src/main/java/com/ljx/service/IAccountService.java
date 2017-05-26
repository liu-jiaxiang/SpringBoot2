package com.ljx.service;

import java.util.List;

import com.ljx.model.Account;

public interface IAccountService {

	int add(Account account);
	
	int update(Account account);
	
	int delete(int id);
	
	Account findById(int id);
	
	List<Account> findAccountList();
}
