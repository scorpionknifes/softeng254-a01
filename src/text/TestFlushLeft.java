package text; // DO NOT CHANGE THIS OR YOU WILL GET ZERO

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

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

    /**
     * Setup globalTimeout rule for all tests in this file.
     */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    /**
     * Test a null input for text is considered illegal by the formatter and the
     * IllegalArgumentException is thrown with correct message "Invalid text (null)"
     */
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

    /**
     * Test flushLeftText for zero LineWidth returns string array with [""]
     */
    @Test
    public void TestZeroWidthInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("", 0));
    }

    /**
     * Test that a zero linewidth and none empty text input is considered illegal by
     * the formatter and the IllegalArgumentException is thrown with correct message
     * "Constraints cannot be satisfied"
     */
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

    /**
     * Test that a negative linewidth is considered illegal by the formatter and the
     * IllegalArgumentException is thrown with correct message "Constraints cannot
     * be satisfied"
     */
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

    /**
     * Test that words with 2 letter are consider illegal by the formatter when
     * linewidth is 1 and the IllegalArgumentException is thrown with correct
     * message "Constraints cannot be satisfied"
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestSingleWidthThrowInput() {
        try {
            Formatter.flushLeftText("12 34", 1);
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
            throw iae;
        }
        fail("Constraints cannot be satisfied exception did not throw!");
    }

    /**
     * Test that a one linewidth would work with words that has a length of one.
     */
    @Test
    public void TestSingleWidthTwoLineInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("0");
        expected.add("1");
        assertEquals(expected, Formatter.flushLeftText("0 1", 1));
    }

    /**
     * Test that a newline separater makes the words into different elements in an
     * array.
     */
    @Test
    public void TestSingleMultipleLineInput() {
        List<String> actual = Formatter.flushLeftText("\n1\n2\n3", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        assertEquals(expected, actual);
    }

    /**
     * Test that spaces infront and behind the words are removed when the linewidth
     * is 1.
     */
    @Test
    public void TestSingleMultipleSpaceInput() {
        List<String> actual = Formatter.flushLeftText(" 1 2 3 ", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        assertEquals(expected, actual);
    }

    /**
     * Test that words that are one letter and with a hyphen infront of them when
     * the linewidth is one works
     */
    @Test
    public void TestSingleHyphenLetterInput() {
        List<String> actual = Formatter.flushLeftText("-1 -2 -3", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("-");
        expected.add("1");
        expected.add("-");
        expected.add("2");
        expected.add("-");
        expected.add("3");
        assertEquals(expected, actual);
    }

    /**
     * Test that words made up of multiple hyphens format to each hyphen is a word
     */
    @Test
    public void TestSingleMultipleHyphenInput() {
        List<String> actual = Formatter.flushLeftText("---", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("-");
        expected.add("-");
        expected.add("-");
        assertEquals(expected, actual);
    }

    /**
     * Test that an empty input would format to [""]
     */
    @Test
    public void TestEmptyInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("", 10));
    }

    /**
     * Test that a short input that is less than linewidth does not change format
     */
    @Test
    public void TestShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("sample");
        assertEquals(expected, Formatter.flushLeftText("sample", 10));
    }

    /**
     * Test that a long input that is longer than linewidth does go to new word with
     * hyphen by formatter
     */
    @Test
    public void TestExtraLongInput() {
        List<String> actual = Formatter.flushLeftText("12345678901234567890", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("123456789-");
        expected.add("012345678-");
        expected.add("90");
        assertEquals(expected, actual);
    }

    /**
     * Test that a long input that has a length of linewidth does not add hyphen at
     * the end if there is no other words at the end.
     */
    @Test
    public void TestLongInput() {
        List<String> actual = Formatter.flushLeftText("1234567890123456789", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("123456789-");
        expected.add("0123456789");
        assertEquals(expected, actual);
    }

    /**
     * Test that words made out of one letter formats correctly based on linewidth
     */
    @Test
    public void TestOneSpacesInput() {
        List<String> actual = Formatter.flushLeftText("1 2 3 4 5 6 7 8 9 0", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("1 2 3 4 5");
        expected.add("6 7 8 9 0");
        assertEquals(expected, actual);
    }

    /**
     * Test that words with multiple space infront is removed/trimmed when
     * formatting
     */
    @Test
    public void TestSpacesFrontInput() {
        List<String> actual = Formatter.flushLeftText("    1234567890", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("1234567890");
        assertEquals(expected, actual);
    }

    /**
     * Test that words with multiple space behind is removed/trimmed when formatting
     */
    @Test
    public void TestSpacesBehindInput() {
        List<String> actual = Formatter.flushLeftText("1234567890     ", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("1234567890");
        assertEquals(expected, actual);
    }

    /**
     * Test that words with multiple space in the middle is replaced with a single
     * space when formatting
     */
    @Test
    public void TestSpacesMiddleInput() {
        List<String> actual = Formatter.flushLeftText("12345    67890", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        expected.add("67890");
        assertEquals(expected, actual);
    }

    /**
     * Test that if the hyphen already exist at the correct location, another hyphen
     * is not added.
     */
    @Test
    public void TestHyphenNewLineInput() {
        List<String> actual = Formatter.flushLeftText("123456789-01234", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("123456789-");
        expected.add("01234");
        assertEquals(expected, actual);
    }

    /**
     * Test that new lines is also equal to a newline in the formatter
     */
    @Test
    public void TestNewLinesInput() {
        List<String> actual = Formatter.flushLeftText("\n1\n2\n3\n4\n5\n6\n", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("4");
        expected.add("5");
        expected.add("6");
        assertEquals(expected, actual);
    }

    /**
     * Test that double newlines are considered as a single newline in the formatter.
     */
    @Test
    public void TestDoubleNewLinesInput() {
        List<String> actual = Formatter.flushLeftText("1\n\n2\n\n3", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        assertEquals(expected, actual);
    }
}
