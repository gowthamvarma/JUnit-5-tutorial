package com.gowthamvarma.junit5.ch2_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import example.util.Calculator;

public class MyFastTest {
	
	private final Calculator calculator = new Calculator();
	
	@Fast
	@Test
	void myFastTest01() {
		System.out.println("	myFastTest01");
		assertEquals(2, calculator.add(1, 1));
	}
	
	@FastTest
	void myFastTest02() {
		System.out.println("	myFastTest01");
		assertEquals(2, calculator.add(1, 1));
	}
}
