package com.junit.ex.junittest;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TerPerformance {

    @Test(timeout = 500)
    public void testPerformance(){
        int array [] = {12,2323,232,12};
        for(int i=0;i<10000000;i++){
            array[0] = i;
            Arrays.sort(array);
        }
    }
}
