package com.example.appspringlearning;

import com.example.testing.Demo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JTest {

    @Test
    public void testSum() {
        Demo demo = new Demo();
        int sum = demo.calculateSum(new int[]{1, 2, 3, 4});

        assertEquals(10, sum);
    }
}
