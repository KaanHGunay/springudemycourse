package com.khg.learningspring;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class BinarySearchImpl {

    private SortAlgorithm sortAlgorithm;

    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int binarySearch(int[] numbers, int numberToSearchFor) {
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println(Arrays.toString(sortedNumbers));
        return 3;
    }
}
