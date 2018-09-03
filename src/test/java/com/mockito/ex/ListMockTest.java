package com.mockito.ex;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {


    @Test
    public void testListSizeMethod_testSize() {
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());
    }


    @Test
    public void testListSizeMethod_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());
        assertEquals(4,listMock.size());
    }


    @Test
    public void listMock_GetMethod() {
        List<String> listMock = mock(List.class);

        //Argument matcher
        when(listMock.get(anyInt())).thenReturn("Ayaz Ahmed");

        String firstElement = listMock.get(0);

        assertThat(firstElement,is("Ayaz Ahmed"));
    }

   /* @Test(expected = RuntimeException.class)
    public void listMock_throwException() {
        List listMock = mock(List.class);
        when(listMock.get(any())).thenThrow(new RuntimeException("Some Exception"));
    }*/
}
