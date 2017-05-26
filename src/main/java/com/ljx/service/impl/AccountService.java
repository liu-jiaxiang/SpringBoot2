package com.ljx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljx.dao.AccountDao;
import com.ljx.model.Account;
import com.ljx.service.IAccountService;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	AccountDao accountDao;
	
	public int add(Account account) {
		return accountDao.add(account);
	}

	public int update(Account account) {
		return accountDao.update(account);
	}

	public int delete(int id) {
		return accountDao.delete(id);
	}

	public Account findById(int id) {
		return accountDao.findAccountById(id);
	}

	public List<Account> findAccountList() {
		return accountDao.findAccountList();
	}

}
