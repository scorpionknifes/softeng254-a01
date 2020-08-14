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

    // ================================================================================
    // Null, Zero Width, Negative Width
    // ================================================================================

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
    public void TestZeroWidthEmptyInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("", 0));
    }

    /**
     * Test flushLeftText with input \n for zero LineWidth returns string array with
     * [""]
     */
    @Test
    public void TestZeroWidthNewLineInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\n", 0));
    }

    /**
     * Test flushLeftText with input space for zero LineWidth returns string array
     * with [""]
     */
    @Test
    public void TestZeroWidthSpaceInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText(" ", 0));
    }

    /**
     * Test flushLeftText with input \t for zero LineWidth returns string array with
     * [""]
     */
    @Test
    public void TestZeroWidthTabInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\t", 0));
    }

    /**
     * Test flushLeftText with input \n\n for zero LineWidth returns string array
     * with [""]
     */
    @Test
    public void TestZeroWidthDoubleNewLineInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\n\n", 0));
    }

    /**
     * Test flushLeftText with input double space for zero LineWidth returns string
     * array with [""]
     */
    @Test
    public void TestZeroWidthDoubleSpaceInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("  ", 0));
    }

    /**
     * Test flushLeftText with input \t\t for zero LineWidth returns string array
     * with [""]
     */
    @Test
    public void TestZeroWidthDoubleTabInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\t\t", 0));
    }

    /**
     * Test flushLeftText with input \t, \n and space for zero LineWidth returns
     * string array with [""]
     */
    @Test
    public void TestZeroWidthTripleEmptyInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\n\t ", 0));
    }

    /**
     * Test that a zero linewidth and none empty text input is considered illegal by
     * the formatter and the IllegalArgumentException is thrown with correct message
     * "Constraints cannot be satisfied"
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestZeroWidthInput() {
        try {
            Formatter.flushLeftText("1", 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
            throw iae;
        }
        fail("Constraints cannot be satisfied exception did not throw!");
    }

    /**
     * Test that a negative linewidth is considered illegal by the formatter and the
     * IllegalArgumentException is thrown with correct message "Invalid text (null)"
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestNegativeLineWidthNullInput() {
        try {
            Formatter.flushLeftText(null, -1);
        } catch (IllegalArgumentException iae) {
            assertEquals("Invalid text (null)", iae.getMessage());
            throw iae;
        }
        fail("Invalid text (null) exception did not throw!");
    }

    /**
     * Test that a negative linewidth and empty input is still considered illegal by
     * the formatter and the IllegalArgumentException is thrown with correct message
     * "Constraints cannot be satisfied"
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestNegativeLineWidthInput() {
        try {
            Formatter.flushLeftText("", -1);
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
            throw iae;
        }
        fail("Constraints cannot be satisfied exception did not throw!");
    }

    /**
     * Test that a negative linewidth and null input is still considered illegal by
     * the formatter and the IllegalArgumentException is thrown with correct message
     * "Constraints cannot be satisfied"
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestNegativeLineWidthEmptyInput() {
        try {
            Formatter.flushLeftText("", -1);
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
            throw iae;
        }
        fail("Constraints cannot be satisfied exception did not throw!");
    }

    // ================================================================================
    // Single Width
    // ================================================================================

    /**
     * Test one linewidth with a single letter input
     */
    @Test
    public void TestSingleLetterInput() {
        List<String> actual = Formatter.flushLeftText("1", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with input with a \n in the front
     */
    @Test
    public void TestSingleNewLineFrontInput() {
        List<String> actual = Formatter.flushLeftText("\n1", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with input with a \n in the back
     */
    @Test
    public void TestSingleNewLineBackInput() {
        List<String> actual = Formatter.flushLeftText("1\n", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with input with a \n in the middle
     */
    @Test
    public void TestSingleNewLineMiddleInput() {
        List<String> actual = Formatter.flushLeftText("1\n2", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("2");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with input with a space in the front
     */
    @Test
    public void TestSingleSpaceFrontInput() {
        List<String> actual = Formatter.flushLeftText(" 1", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with input with a space in the back
     */
    @Test
    public void TestSingleSpaceBackInput() {
        List<String> actual = Formatter.flushLeftText("1 ", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test that a one linewidth would work with words that has a length of one.
     */
    @Test
    public void TestSingleSpaceMiddleInput() {
        List<String> actual = Formatter.flushLeftText("1 2", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("2");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with input with a tab in the front
     */
    @Test
    public void TestSingleTabFrontInput() {
        List<String> actual = Formatter.flushLeftText("\t1", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with input with a tab in the back
     */
    @Test
    public void TestSingleTabBackInput() {
        List<String> actual = Formatter.flushLeftText("1\t", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test that a one linewidth would work with words that has a length of one.
     */
    @Test
    public void TestSingleTabMiddleInput() {
        List<String> actual = Formatter.flushLeftText("1\t2", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("2");
        assertEquals(expected, actual);
    }

    /**
     * Test words with multiple hyphens with single linewidth
     */
    @Test
    public void TestMultipleHyphenInput() {
        List<String> actual = Formatter.flushLeftText("---", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("-");
        expected.add("-");
        expected.add("-");
        assertEquals(expected, actual);
    }

    /**
     * Test that words with 2 letter are consider illegal by the formatter when
     * linewidth is 1 and the IllegalArgumentException is thrown with correct
     * message "Constraints cannot be satisfied"
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestSingleWidthThrowInput() {
        try {
            Formatter.flushLeftText("12", 1);
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
            throw iae;
        }
        fail("Constraints cannot be satisfied exception did not throw!");
    }

    /**
     * Test that words that are one letter and with a hyphen infront of them when
     * the linewidth is one works
     */
    @Test
    public void TestSingleHyphenLetterInput() {
        List<String> actual = Formatter.flushLeftText("-1", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("-");
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test that words that are one letter and with a hyphen infront of them when
     * the linewidth is one works
     */
    @Test
    public void TestSingleHyphenSpaceLetterInput() {
        List<String> actual = Formatter.flushLeftText("- 1", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("-");
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test that a hyphen at the back of a letter is consider illegal as - is not
     * another word
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestSingleHyphenBackInput() {
        try {
            Formatter.flushLeftText("1-", 1);
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
            throw iae;
        }
        fail("Constraints cannot be satisfied exception did not throw!");
    }

    /**
     * Test that a hyphen at the middle of a word is consider illegal as the hyphen
     * in the middle does not make it into 3 words
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestSingleHyphenMiddleInput() {
        try {
            Formatter.flushLeftText("1-2", 1);
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
            throw iae;
        }
        fail("Constraints cannot be satisfied exception did not throw!");
    }

    /**
     * Test that words made up of multiple hyphens format to each hyphen is a word
     * without add more hyphens
     */
    @Test
    public void TestSingleMultipleHyphenInput() {
        List<String> actual = Formatter.flushLeftText("--", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("-");
        expected.add("-");
        assertEquals(expected, actual);
    }

    // ================================================================================
    // Words less than Line Width
    // ================================================================================

    /**
     * Test that an empty input would format to [""] with multiple lines
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
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345", 10));
    }

    /**
     * Test that a newline front of short input does not effect output
     */
    @Test
    public void TestNewLineFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\n12345", 10));
    }

    /**
     * Test that a space front of short input does not effect output
     */
    @Test
    public void TestSpaceFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText(" 12345", 10));
    }

    /**
     * Test that a tab front of short input does not effect output
     */
    @Test
    public void TestTabFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\t12345", 10));
    }

    /**
     * Test that a multiple newline front of short input does not effect output
     */
    @Test
    public void TestMultipleNewLineFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\n\n12345", 10));
    }

    /**
     * Test that a multiple space front of short input does not effect output
     */
    @Test
    public void TestMultipleSpaceFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("  12345", 10));
    }

    /**
     * Test that a multiple tab front of short input does not effect output
     */
    @Test
    public void TestMultipleTabFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\t\t12345", 10));
    }

    /**
     * Test that a newline middle of short input makes a newline in input
     */
    @Test
    public void TestNewLineMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12");
        expected.add("45");
        assertEquals(expected, Formatter.flushLeftText("12\n45", 10));
    }

    /**
     * Test that a space middle of short input does not make a newline
     */
    @Test
    public void TestSpaceMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12 45");
        assertEquals(expected, Formatter.flushLeftText("12 45", 10));
    }

    /**
     * Test that a tab middle of short input is considered as a single space
     */
    @Test
    public void TestTabMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12 45");
        assertEquals(expected, Formatter.flushLeftText("12\t45", 10));
    }

    /**
     * Test that a multiple newline middle of short input makes a newline in input
     */
    @Test
    public void TestMultipleNewLineMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12");
        expected.add("45");
        assertEquals(expected, Formatter.flushLeftText("12\n\n\n45", 10));
    }

    /**
     * Test that a multiple space middle of short input is considered as one space
     */
    @Test
    public void TestMultipleSpaceMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12 45");
        assertEquals(expected, Formatter.flushLeftText("12   45", 10));
    }

    /**
     * Test that a multiple tab middle of short input is considered as a single
     * space
     */
    @Test
    public void TestMultipleTabMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12 45");
        assertEquals(expected, Formatter.flushLeftText("12\t\t\t45", 10));
    }

    /**
     * Test that a tab, space and newline middle of short input is considered as a
     * single space
     */
    @Test
    public void TestTabSpaceNewLineMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12");
        expected.add("45");
        assertEquals(expected, Formatter.flushLeftText("12\t\n  \t45", 10));
    }

    /**
     * Test that a newline back of short input does not effect output
     */
    @Test
    public void TestNewLineBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345\n", 10));
    }

    /**
     * Test that a space front of short input does not effect output
     */
    @Test
    public void TestSpaceBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345 ", 10));
    }

    /**
     * Test that a tab front of short input does not effect output
     */
    @Test
    public void TestTabBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345\t", 10));
    }

    /**
     * Test that a multiple newline back of short input does not effect output
     */
    @Test
    public void TestMultipleNewLineBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345\n\n", 10));
    }

    /**
     * Test that a multiple space front of short input does not effect output
     */
    @Test
    public void TestMultipleSpaceBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345  ", 10));
    }

    /**
     * Test that a multiple tab front of short input does not effect output
     */
    @Test
    public void TestMultipleTabBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345\t\t", 10));
    }

    // ================================================================================
    // Inputs that are longer than Line Width
    // ================================================================================

    /**
     * Test that a long input that is longer than linewidth does go to new word and
     * adds a hyphen
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
     * Test words that is as long as linewidth with space between, no hyphens should
     * be added and line width is 10 or shorter
     */
    @Test
    public void TestWordLengthWidthInput() {
        List<String> actual = Formatter.flushLeftText("1234567890 1234567890", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("1234567890");
        expected.add("1234567890");
        assertEquals(expected, actual);
    }
    /**
     * Test words that is as long as linewidth with tab between, no hyphens should
     * be added and line width is 10 or shorter
     */
    @Test
    public void TestWordLengthWidthTabInput() {
        List<String> actual = Formatter.flushLeftText("1234567890\t1234567890", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("1234567890");
        expected.add("1234567890");
        assertEquals(expected, actual);
    }

    /**
     * Test words that is shorter than linewidth but cannot be on one line - there
     * shouldn't be any spaces at the end of each line
     */
    @Test
    public void TestBackSpacesInput() {
        List<String> actual = Formatter.flushLeftText("1234567 123456789 12345678", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("1234567");
        expected.add("123456789");
        expected.add("12345678");
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
     * Test words with hyphen in the middle
     */
    @Test
    public void TestHyphenWordsInput() {
        List<String> actual = Formatter.flushLeftText("1234567890-123456789", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("123456789-");
        expected.add("0-");
        expected.add("123456789");
        assertEquals(expected, actual);
    }

    /**
     * Test words with multiple different input lengths
     */
    @Test
    public void TestWordsMultipleLengthInput() {
        List<String> actual = Formatter.flushLeftText("1 23 456 7890 12345 678901 2345678", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("1 23 456");
        expected.add("7890 12345");
        expected.add("678901");
        expected.add("2345678");
        assertEquals(expected, actual);
    }
}
