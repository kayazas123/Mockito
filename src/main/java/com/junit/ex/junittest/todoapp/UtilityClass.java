package com.junit.ex.junittest.todoapp;

public class UtilityClass {

    public static int staticMethod(long value){
        throw new RuntimeException("I dont want to be executed , I will anyway be mocked out.");
    }
}
