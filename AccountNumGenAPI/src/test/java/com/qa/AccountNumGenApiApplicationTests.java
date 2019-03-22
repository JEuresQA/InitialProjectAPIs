package com.qa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.controller.GeneratorController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountNumGenApiApplicationTests {
	
	@Autowired
	private GeneratorController controller;
	
	@Autowired
	private Generator gen;

	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}
	
	@Test
	public void getGenTest() {
		assertNotNull(controller.getGenerator());
	}
	
	@Test
	public void getNumTest() {
		assertNotNull(controller.getAccNum());
	}
	
	@Test
	public void generatorTest() {
		assertNotNull(gen.sixDigits());
	}

}
