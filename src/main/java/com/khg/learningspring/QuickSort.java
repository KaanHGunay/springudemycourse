package com.khg.learningspring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // Birden fazla bean olması durumunda öncelikli olanı tanımlamaj için kullanılır.
public class QuickSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] numbers) {
        return numbers;
    }
}
