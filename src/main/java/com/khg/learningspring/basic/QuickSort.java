package com.khg.learningspring.basic;

import org.springframework.stereotype.Component;

@Component("QuickSort")
public class QuickSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] numbers) {
        return numbers;
    }
}
