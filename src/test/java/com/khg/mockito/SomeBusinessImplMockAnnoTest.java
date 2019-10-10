package com.khg.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockAnnoTest {

    @Mock
    DataService dataService;

    @InjectMocks
    SomeBusinessImpl someBusiness;

    @Test
    public void findTheGreatestNumber() {
        Mockito.when(dataService.retrieveAllData()).thenReturn(new int[] {2, 6, 8, 4, 12, 1});
        int result = someBusiness.findTheGreatestNumber();
        assertEquals(12, result);
    }

    @Test
    public void findTheGreatestNumber_2() {
        Mockito.when(dataService.retrieveAllData()).thenReturn(new int[] {2, 6, 1});
        int result = someBusiness.findTheGreatestNumber();
        assertEquals(6, result);
    }
}
