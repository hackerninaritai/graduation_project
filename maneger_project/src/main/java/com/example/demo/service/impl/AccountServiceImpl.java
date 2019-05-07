package com.example.demo.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Role;
import com.example.demo.repository.AccountRepo;
import com.example.demo.repository.RoleRepo;
import com.example.demo.service.AccountService;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Account findAccountByAccountName(String accountName) {

		return accountRepo.findAccountByAccountName(accountName);
	}

	@Override
	public Account saveAccount(Account account) {
		account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		Role accountRole = roleRepo.findByRoleName("ADMIN");
		account.setRoleId(accountRole);
		return accountRepo.save(account);
	}

	@Override
	public List<Account> findAllAccount() {
		return accountRepo.findAll();
	}

	@Override
	public boolean deleteAccount(int idAccount) {
		Account account = accountRepo.getOne(idAccount);
		if (account.equals(null) || account == null) {
			return false;
		}
		accountRepo.deleteById(idAccount);
		return true;
	}

}
