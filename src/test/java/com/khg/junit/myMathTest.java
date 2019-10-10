package com.khg.junit;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class myMathTest {
    myMath myMath = new myMath();

    @Before  // Her Test ten önce çalıştırılacacak kodlar
    public void before() {
        System.out.println("Before method triggered.");
    }

    @After  // Her Test ten sonra çalıştırılacacak kodlar
    public void after() {
        System.out.println("After method triggered.");
    }

    @BeforeClass  // Tüm tessten önce çalışacak kodlar
    public static void beforeClass() {
        System.out.println("Before Class triggered.");
    }

    @AfterClass  // Tüm tessten sonra çalışacak kodlar
    public static void afterClass() {
        System.out.println("After Class triggered.");
    }

    @Test
    public void sum_with_1_numbers() {
        assertEquals(1, myMath.sum(new int[] {1}));
    }

    @Test
    public void sum_with_3_numbers() {
        assertEquals(6, myMath.sum(new int[] {1,2,3}));
    }
}