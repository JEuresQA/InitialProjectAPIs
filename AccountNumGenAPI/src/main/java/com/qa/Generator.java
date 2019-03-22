package com.qa;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Generator {
	private Random r = new Random();
	private char letter;
	
	private String generate(int digits) {
		switch(r.nextInt(3)) {
		case 0:
			letter = 'a';
			break;
		case 1:
			letter = 'b';
			break;
		case 2:
			letter = 'c';
			break;
		}
		String account = "" + letter;
		for (int i = 0; i < digits; i++) {
			account += r.nextInt(10);
		}
		return account;
	}
	
	@Bean
	public String sixDigits() {
		return generate(6);
	}
	
	@Bean
	public String eightDigits() {
		return generate(8);
	}
	
	@Bean
	public String tenDigits() {
		return generate(10);
	}
}
