package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>{
	Account findAccountByAccountName(String accountName); 
}
