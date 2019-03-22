package com.qa.service;

import org.springframework.stereotype.Service;

import com.qa.entities.Account;
import com.qa.repository.AccountRepository;

@Service
public class AccountService {
	private AccountRepository repo;

	public AccountRepository getAccountRepository() {
		return repo;
	}

	public AccountService(AccountRepository repo) {
		this.repo = repo;
	}

	public String createAccount(Account account) {
		repo.save(account); 
		return "account created";
	}
}