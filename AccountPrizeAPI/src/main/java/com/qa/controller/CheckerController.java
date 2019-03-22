package com.qa.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.Checker;

@RestController
public class CheckerController {
	private Checker check;
	
	public Checker getChecker() {
		return check;
	}
	
	public CheckerController(Checker checker) {
		check = checker;
	}
	
	@PostMapping("/checkPrize/{accountNumber}")
	public String checkPrize(@PathVariable String accountNumber) {
		int prize = check.checkAcc(accountNumber);
		String result = "";
		if (prize < 0) {
			result = "Invalid accounter number!";
		} else if (prize == 0) {
			result = "Unfortunately on this occasion you have not won a prize.";
		} else {
			result = "You have won a Prize! You have won - $" + prize;
		}
		return result;
	}

}
