package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;

public interface AccountService {
	List<Account> findAllAccount();

	Account findAccountByAccountName(String accountName);

	Account saveAccount(Account account);
	
	boolean deleteAccount(int idAccount);
}
