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
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("", 10));
    }

    @Test
    public void TestShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("sample");
        assertEquals(expected, Formatter.flushLeftText("sample", 10));
    }

    @Test
    public void TestExtraLongInput() {
        List<String> actual = Formatter.flushLeftText("12345678901234567890", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("123456789-");
        expected.add("012345678-");
        expected.add("90");
        assertEquals(expected, actual);
    }
    
    @Test
    public void TestLongInput(){
        List<String> actual = Formatter.flushLeftText("1234567890123456789", 10);
        System.out.println(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("123456789-");
        expected.add("0123456789");
        assertEquals(expected, actual);
    }

    @Test
    public void TestOneSpacesInput(){
        List<String> actual = Formatter.flushLeftText("1 2 3 4 5 6 7 8 9 0", 10);
        System.out.println(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("1 2 3 4 5");
        expected.add("6 7 8 9 0");
        assertEquals(expected, actual);
    }

    /* 
        TestSpaceFrontInput

        Fails:
        - badA.jar check for string.trim()
    */
    @Test
    public void TestSpacesFrontInput(){
        List<String> actual = Formatter.flushLeftText("   1234567890", 10);
        System.out.println(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("1234567890");
        assertEquals(expected, actual);
    }

    @Test
    public void TestSpacesBehindInput(){
        List<String> actual = Formatter.flushLeftText("1234567890    ", 10);
        System.out.println(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("1234567890");
        assertEquals(expected, actual);
    }

    @Test
    public void TestSpacesMiddleInput(){
        List<String> actual = Formatter.flushLeftText("12345   67890", 10);
        System.out.println(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        expected.add("67890");
        assertEquals(expected, actual);
    }

    @Test
    public void TestNewLinesInput(){
        List<String> actual = Formatter.flushLeftText("\n1\n2\n3\n4\n5\n6\n", 10);
        System.out.println(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("4");
        expected.add("5");
        expected.add("6");
        assertEquals(expected, actual);
    }

    @Test
    public void TestDoubleNewLinesInput(){
        List<String> actual = Formatter.flushLeftText("1\n\n2\n\n3", 10);
        System.out.println(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        assertEquals(expected, actual);
    }
}
