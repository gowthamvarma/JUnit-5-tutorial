package com.gowthamvarma.junit5.ch2_12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(RandomParametersExtension.class)
public class MyRandomParametersTest {

    @Test
    void injectsInteger(@Random int i, @Random int j) {
        assertNotEquals(i, j);
    }

    @Test
    void injectsDouble(@Random double d) {
        assertEquals(0.0, d, 1.0);
    }

}