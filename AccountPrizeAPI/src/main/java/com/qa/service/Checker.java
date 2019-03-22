package com.qa.service;

import org.springframework.stereotype.Service;

@Service
public class Checker {

	public int checkAcc(String account) {
		int l = account.length();
		String first = account.substring(0, 1);
		if (l == 7) {
			if (first.contentEquals("a")) {
				return 0;
			} else if (first.contentEquals("b")) {
				return 50;
			} else if (first.contentEquals("c")) {
				return 100;
			}
		} else if (l == 9) {
			if (first.contentEquals("a")) {
				return 0;
			} else if (first.contentEquals("b")) {
				return 500;
			} else if (first.contentEquals("c")) {
				return 750;
			}
		} else if (l == 11) {
			if (first.contentEquals("a")) {
				return 0;
			} else if (first.contentEquals("b")) {
				return 5000;
			} else if (first.contentEquals("c")) {
				return 10000;
			}
		}
		return -1;
	}
}
