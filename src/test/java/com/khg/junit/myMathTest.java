package com.khg.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class myMathTest {
    myMath myMath = new myMath();
    @Test
    public void sum_with_1_numbers() {
        assertEquals(1, myMath.sum(new int[] {1}));
    }

    @Test
    public void sum_with_3_numbers() {
        assertEquals(6, myMath.sum(new int[] {1,2,3}));
    }
}