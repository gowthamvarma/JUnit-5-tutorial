package com.gowthamvarma.junit5.ch2_01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import example.util.Calculator;

//@Disabled
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("A special test case")
public class Annotations {
	
	private final Calculator calculator = new Calculator();
	
	@Test
	void myTest() {
		System.out.println("	myTest");
		assertEquals(2, calculator.add(1, 1));
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void myParameterizedTest(int argument) {
		System.out.println("	myParameterizedTest " + argument);
		assertTrue(argument > 0 && argument < 4);
	}
	
	@RepeatedTest(5)
	void myRepeatedTest() {
		System.out.println("	myRepeatedTest");
		assertEquals(2, calculator.add(1, 1));
	}
	
	@TestFactory
    DynamicTest[] dynamicTestsFromArray() {
        return new DynamicTest[] {
            dynamicTest("dynamic test 01", () -> {
            	System.out.println("dynamic test 01");
            	assertEquals(4, calculator.add(2, 2)); 
            	}),
            dynamicTest("dynamic test 02", () -> {
            	System.out.println("dynamic test 02");
            	assertEquals(4, calculator.add(2, 2)); 
            	})
        };
    }
	
	//@TestTemplate
	
	@Test
	@Order(1)
	void myOrderedTest() {
		System.out.println("	myOrderedTest");
		assertEquals(2, calculator.add(1, 1));
	}
	
	@Test
    @DisplayName("Custom test name containing spaces")
    void myDisplayNameTest() {
		System.out.println("	myDisplayNameTest");
		assertEquals(2, calculator.add(1, 1));
    }
	
	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class A_year_is_not_supported {

		@Test
		void if_it_is_zero() {
			System.out.println("	DisplayNameGeneratorTest");
			assertEquals(2, calculator.add(1, 1));
		}

	}
	
	@BeforeEach
	void connectToDatabase() {
		System.out.println("BeforeEach :: ");
	}

	@AfterEach
	void disconnectFromDatabase() {
		System.out.println("AfterEach :: ");
	}
	
	@BeforeAll
	static void createDatabase() {
		System.out.println("BeforeAll :: ");
	}

	@AfterAll
	static void destroyDatabase() {
		System.out.println("AfterAll :: ");
	}

	@Nested
	class NestedClass {

		@Test
		void myAddPositiveTest() {
			System.out.println("	myAddPositiveTest");
			assertEquals(2, calculator.add(1, 1));
			assertEquals(4, calculator.add(2, 2));
		}
		
		@Test
		void myAddNegativeTest() {
			System.out.println("	myAddNegativeTest");
			assertEquals(-3, calculator.add(-2, -1));
			assertEquals(-6, calculator.add(-4, -2));
		}

	}

	@Tag("simple")
	@Test
	void myTagTest() {
		System.out.println("	myTagTest");
		assertEquals(2, calculator.add(1, 1));
	}

	@Disabled
	@Test
	void myDisabledTest() {
		System.out.println("	myDisabledTest");
		assertEquals(2, calculator.add(1, 1));
	}

	@Timeout(3)
	//@Timeout((long) 0.0001)
	@Test
	void myTimeoutTest() {
		System.out.println("	myTimeoutTest");
		assertEquals(2, calculator.add(1, 1));
	}

	//@ExtendWith

	//@RegisterExtension

	//@TempDir

}
