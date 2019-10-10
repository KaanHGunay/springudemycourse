package com.khg.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListTest {

    @Test
    public void testSize() {
        List mockList = Mockito.mock(List.class);
        Mockito.when(mockList.size()).thenReturn(10);
        assertEquals(10, mockList.size());
    }

    @Test
    public void testSize_Multiple() {
        List mockList = Mockito.mock(List.class);
        Mockito.when(mockList.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, mockList.size());
        assertEquals(20, mockList.size());
    }

    @Test
    public void testGet() {
        List mockList = Mockito.mock(List.class);
        Mockito.when(mockList.get(0)).thenReturn("Some String");
        assertEquals("Some String", mockList.get(0));
    }

    @Test
    public void testGenericParam() {
        List mockList = Mockito.mock(List.class);
        Mockito.when(mockList.get(Mockito.anyInt())).thenReturn("Some String");
        assertEquals("Some String", mockList.get(0));
    }
}
