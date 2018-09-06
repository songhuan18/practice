package com.sh;

import org.junit.Test;

public class ZaTest {

    @Test
    public void integerTest() {
        Integer a = 1;
        Integer b = 2;

        Long g = 3L;
        Long h = 2L;

        System.out.println(g.equals(a + b));
        System.out.println(g.equals(a + h));
    }
}
