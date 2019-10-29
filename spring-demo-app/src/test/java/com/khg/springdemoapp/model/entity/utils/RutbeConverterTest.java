package com.khg.springdemoapp.model.entity.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RutbeConverterTest {

    private RutbeConverter rutbeConverter;

    @Before
    public void before() {
        rutbeConverter = new RutbeConverter();
    }

    @Test
    public void stringToRutbe() {
        assertEquals(Rutbe.POLIS_MEMURU, rutbeConverter.convertToEntityAttribute("Polis Memuru"));
    }

    @Test
    public void rutbeToString() {
        assertEquals("Polis Memuru", rutbeConverter.convertToDatabaseColumn(Rutbe.POLIS_MEMURU));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionToAttribute() {
        rutbeConverter.convertToEntityAttribute("None");
    }

}
