package com.mockito.ex;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void hamcrestMatchersTest() {
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(99, 100));
        assertThat(scores, everyItem(greaterThan(90)));
        assertThat(scores, everyItem(lessThan(106)));

        //String
        assertThat("", isEmptyString());
        assertThat(null, isEmptyOrNullString());


        //Arrays
        Integer[] marks = {1, 2, 3};

        assertThat(marks, arrayWithSize(3));
        //With order
        assertThat(marks, arrayContaining(1, 2, 3));
        //In any order
        assertThat(marks, arrayContainingInAnyOrder(3, 2, 1));
    }
}
