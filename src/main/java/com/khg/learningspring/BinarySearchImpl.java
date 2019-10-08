package com.khg.learningspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  // Her çağırıldığında yeni instance oluşturulursun ( Def. Singleton - App. Context için 1 tane )
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
