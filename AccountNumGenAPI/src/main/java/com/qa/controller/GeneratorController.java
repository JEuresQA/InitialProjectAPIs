package com.qa.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.Generator;

@RestController
public class GeneratorController {
	
	private Generator gen;
	
	Random r = new Random();
	
	public Generator getGenerator() {
		return gen;
	}
	
	public GeneratorController(Generator gen) {
		this.gen = gen;
	}
	
	@GetMapping("/getAccNum")
	public String getAccNum() {
		String newNum = "";
		switch(r.nextInt(3)) {
		case 0:
			newNum = gen.sixDigits();
			break;
		case 1:
			newNum = gen.eightDigits();
			break;
		case 2:
			newNum = gen.tenDigits();
			break;
		}
		return newNum;
	}
}
