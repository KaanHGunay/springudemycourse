package com.khg.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class SomeBusinessImplMockTest {

    @Test
    public void findTheGreatestNumber() {
        DataService dataService = Mockito.mock(DataService.class);
        Mockito.when(dataService.retrieveAllData()).thenReturn(new int[] {2, 6, 8, 4, 12, 1});
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataService);
        int result = someBusiness.findTheGreatestNumber();
        assertEquals(12, result);
    }
}
