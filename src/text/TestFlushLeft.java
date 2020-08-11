package text; // DO NOT CHANGE THIS OR YOU WILL GET ZERO

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * SOFTENG 254 2020 Assignment 1 submission
 *
 * Author: (Cheng-Zhen Yang, cyan562)
 **/

public class TestFlushLeft {// DO NOT CHANGE THE CLASS NAME OR YOU WILL GET ZERO

    // Your tests here.
    @Test(expected = IllegalArgumentException.class)
    public void TestNullInput() {
        try {
            Formatter.flushLeftText(null, 10);
        } catch (IllegalArgumentException iae) {
            assertEquals("Invalid text (null)", iae.getMessage());
            throw iae;
        }
        fail("Invalid text (null) exception did not throw!");
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNegativeLineWidthInput() {
        try {
            Formatter.flushLeftText("example", -1);
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
            throw iae;
        }
        fail("Constraints cannot be satisfied exception did not throw!");
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestZeroLineWidthInput() {
        try {
            Formatter.flushLeftText("example", 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
            throw iae;
        }
        fail("Constraints cannot be satisfied exception did not throw!");
    }

    @Test
    public void TestEmptyInput() {
        assertEquals("[]", Formatter.flushLeftText("", 10).toString());
    }

    @Test
    public void TestGeneralInput() {
        String result = Formatter.flushLeftText("12345678901234567890", 10).toString();
        System.out.println(result);
    }

}
