package com.qa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.controller.CheckerController;
import com.qa.service.Checker;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountPrizeApiApplicationTests {
	
	@Autowired
	private Checker checker;
	
	@Autowired
	private CheckerController controller;

	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}
	
	@Test
	public void checkTest1() {
		int result = checker.checkAcc("c111111");
		assertEquals(100, result);
	}
	
	@Test
	public void checkTest2() {
		int result = checker.checkAcc("c11111111");
		assertEquals(750, result);
	}
	
	@Test
	public void checkTest3() {
		int result = checker.checkAcc("c1111111111");
		assertEquals(10000, result);
	}
	
	@Test
	public void getCheckerTest() {
		assertNotNull(controller.getChecker());
	}
	
	@Test
	public void checkPrizeTestPrize() {
		String result = controller.checkPrize("c111111");
		assertEquals("You have won a Prize! You have won - $100", result);
	}
	
	@Test
	public void checkPrizeTestNoPrize() {
		String result = controller.checkPrize("a111111");
		assertEquals("Unfortunately on this occasion you have not won a prize.", result);
	}
	
	@Test
	public void checkPrizeTestInvalid() {
		String result = controller.checkPrize("no");
		assertEquals("Invalid accounter number!", result);
	}

}
