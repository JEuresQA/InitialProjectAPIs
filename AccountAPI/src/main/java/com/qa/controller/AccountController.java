package com.qa.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.entities.Account;
import com.qa.service.AccountService;

@RestController
public class AccountController {

	private AccountService svc;
	
	private JmsTemplate template;

	public AccountController(AccountService svc, JmsTemplate template) {
		this.svc = svc;
		this.template = template;
	}

	@PostMapping("/createAccount")
	public String createAccount(Account account) {
		template.convertAndSend("Hello", account);
		return svc.createAccount(account);
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/getAccNum")
	public String getAccNum() {

		return restTemplate.exchange("http://localhost:8081/getAccNum", HttpMethod.GET, null, String.class).getBody();
	}

	@PostMapping(value = "/checkPrize/{accountNumber}")
	public String checkPrize(@PathVariable("accountNumber") String accountNumber) {
		return restTemplate
				.exchange("http://localhost:8082/checkPrize/" + accountNumber, HttpMethod.POST, null, String.class)
				.getBody();

	}
}