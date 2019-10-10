package com.khg.learningspring.cdi;

import javax.inject.Named;

// @Component
@Named
public class SomeCdiDao {

    public int[] getData() {
        return new int[] {5, 2, 6, 8};
    }
}
