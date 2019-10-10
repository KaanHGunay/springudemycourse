package com.khg.learningspring.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  // Her çağırıldığında yeni instance oluşturulursun ( Def. Singleton - App. Context için 1 tane )
public class BinarySearchImpl {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("BubbleSort")  // Birden fazla implementasyon varsa isimlendirme çağırılabilir.
    private SortAlgorithm sortAlgorithm;

    public int binarySearch(int[] numbers, int numberToSearchFor) {
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println(Arrays.toString(sortedNumbers));
        return 3;
    }

    @PostConstruct  // Class oluştuktan sonra
    public void postConstrucy() {
        LOGGER.info("Post Construct Method Triggered");
    }

    @PreDestroy  // Class yok edilmeden önce
    public void preDestroy() {
        LOGGER.info("Pre destroy method triggered.");
    }
}
