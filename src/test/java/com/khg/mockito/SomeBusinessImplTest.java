package com.khg.mockito;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomeBusinessImplTest {
    private SomeBusinessImpl someBusiness = new SomeBusinessImpl(new DataServiceStub());

    @Test
    public void findTheGreatestNumber() {
        int result = someBusiness.findTheGreatestNumber();
        assertEquals(6, result);
    }
}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1, 5, 6, 2};
    }
}