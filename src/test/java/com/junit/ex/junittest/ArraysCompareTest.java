package com.junit.ex.junittest;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ArraysCompareTest {

    @Test
    public void testArraySorts(){
        int[] actual = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(actual);
        assertArrayEquals(expected,actual);
    }
}
