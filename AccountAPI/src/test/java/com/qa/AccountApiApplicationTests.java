package com.qa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.controller.AccountController;
import com.qa.entities.Account;
import com.qa.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountApiApplicationTests {
	
//	@Autowired
//	private Account account;
	
	@Autowired
	private AccountController controller;
	
	@Autowired
	private AccountService service;

	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}
	
	@Test
	public void serviceCreateAccount() {
		Account account = new Account((long) 1, "");
		String result = service.createAccount(account);
		assertTrue(result.contentEquals("account created"));
	}
	
	@Test
	public void repoGrab() {
		assertNotNull(service.getAccountRepository());
	}
	
	@Test
	public void controllerCreateAccount() {
		Account account = new Account((long) 1, "");
		String result = controller.createAccount(account);
		assertTrue(result.contentEquals("account created"));
	}
	
	@Test
	public void getAndSetID() {
		Account account = new Account();
		account.setId((long) 1);
		long result = account.getId();
		assertEquals((long) 1, result);
	}
	
	@Test
	public void getAndSetNum() {
		Account account = new Account();
		account.setAccountNumber("a");
		String result = account.getAccountNumber();
		assertTrue(result.contentEquals("a"));
	}
	
	@Test
	public void stringTest() {
		Account account = new Account((long) 1, "a");
		String result = account.toString();
		assertTrue(result.contentEquals("Account[id=1, accountNumber=a]"));
	}

}
