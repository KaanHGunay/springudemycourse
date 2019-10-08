package com.khg.learningspring;

import org.springframework.stereotype.Component;

@Component("BubbleSort")
public class BubbleSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] numbers) {
        return numbers;
    }
}
