package com.gowthamvarma.junit5.ch2_06;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #99 has been fixed")
class DisabledClassDemo {

	@Test
	void testWillBeSkipped() {
		
	}

}
