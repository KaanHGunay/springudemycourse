package com.khg.learningspring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("QuickSort")
public class QuickSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] numbers) {
        return numbers;
    }
}
