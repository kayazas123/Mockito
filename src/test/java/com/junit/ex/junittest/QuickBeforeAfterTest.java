package com.junit.ex.junittest;


import com.junit.ex.junittest.basic.StringHelper;
import org.junit.*;

public class QuickBeforeAfterTest {

    public static StringHelper stringHelper;

    @BeforeClass
    public static void setup(){
        stringHelper = new StringHelper();
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After class");
    }

    @Before
    public void setUp(){
        System.out.println("Setup");
    }

    @After
    public void tearDown(){
        System.out.println("Tear down ");
    }

    @Test
    public void test(){
        System.out.println("Test1 executed\t"+stringHelper.hashCode());
    }

    @Test
    public void test2(){
        System.out.println("Test2 executed\t"+stringHelper.hashCode());
    }
}
