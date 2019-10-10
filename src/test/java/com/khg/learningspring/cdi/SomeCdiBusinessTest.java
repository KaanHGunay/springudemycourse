package com.khg.learningspring.cdi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

    @InjectMocks
    SomeCdiBusiness someCdiBusiness;

    @Mock
    SomeCdiDao someCdiDao;

    @Test
    public void testBasicScenario() {
        Mockito.when(someCdiDao.getData()).thenReturn(new int[] {2, 4});
        int result = someCdiBusiness.findGreatest();
        assertEquals(4, result);
    }

    @Test
    public void testBasicScenario_EqualNumbers() {
        Mockito.when(someCdiDao.getData()).thenReturn(new int[] {2, 2});
        int result = someCdiBusiness.findGreatest();
        assertEquals(2, result);
    }

    @Test
    public void testBasicScenario_NoNumber() {
        Mockito.when(someCdiDao.getData()).thenReturn(new int[] {});
        int result = someCdiBusiness.findGreatest();
        assertEquals(Integer.MIN_VALUE, result);
    }
}