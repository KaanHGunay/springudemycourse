package com.khg.learningspring.basic;

import org.springframework.stereotype.Component;

@Component("BubbleSort")
public class BubbleSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] numbers) {
        return numbers;
    }
}
