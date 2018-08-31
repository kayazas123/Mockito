package com.junit.ex.junittest;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestExceptions {

    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        int[] actual = null;
        Arrays.sort(actual);
    }
}
