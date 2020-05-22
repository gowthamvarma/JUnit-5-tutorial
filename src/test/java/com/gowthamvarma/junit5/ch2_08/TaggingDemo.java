package com.gowthamvarma.junit5.ch2_08;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fast")
@Tag("model")
class TaggingDemo {

	@Test
	@Tag("taxes")
	void testingTaxCalculation() {
	}

}
