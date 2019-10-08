package com.khg.learningspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BinarySearchImpl {

    @Autowired
    @Qualifier("BubbleSort")  // Birden fazla implementasyon varsa isimlendirme çağırılabilir.
    private SortAlgorithm sortAlgorithm;

    public int binarySearch(int[] numbers, int numberToSearchFor) {
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println(Arrays.toString(sortedNumbers));
        return 3;
    }
}
