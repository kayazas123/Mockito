package com.junit.ex.junittest;

import com.junit.ex.junittest.basic.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    StringHelper stringHelper = new StringHelper();
    private String input;
    private String expectedOutput;

    public ParameterizedTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testCondition() {
        String expectedOutputs[][] =
                {
                    {"AACD", "CD"},
                    {"ACD", "CD"}
                };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testTrancateAInFirst2Positions_AInFirst2Pos() {
        assertEquals(expectedOutput, stringHelper.truncateAInFirst2Positions(input));
    }

    @Test
    public void test2TransactAInFirst2Positions_AInFirstPos() {
        assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));
    }

}
