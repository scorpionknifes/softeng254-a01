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
     * Setup global Timeout rule for all tests in this file.
     */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);

    // ================================================================================
    // Null, Zero Width, Negative Width
    // ================================================================================

    /**
     * Test a null input for a text input is considered illegal by the formatter and
     * the IllegalArgumentException is thrown with correct message "Invalid text
     * (null)".
     * 
     * Test if the user input null, it should throw expection as null is not a valid
     * input.
     */
    @Test
    public void TestNullInput() {
        try {
            Formatter.flushLeftText(null, 10);
            fail("Invalid text (null) exception did not throw!");
        } catch (IllegalArgumentException iae) {
            assertEquals("Invalid text (null)", iae.getMessage());
        }
    }

    /**
     * Test a empty input for a linewidth of zero will returns array with a single
     * element ""
     * 
     * Test if the user the input "" it returns [""] without an exception as the
     * every line is less than zero length
     */
    @Test
    public void TestZeroWidthEmptyInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("", 0));
    }

    /**
     * Test newline input for a linewidth of zero will returns array with a single
     * element ""
     * 
     * Test if the user input newline, \n is considered as empty and should return
     * [""] just like @TestZeroWidthEmptyInput
     */
    @Test
    public void TestZeroWidthNewLineInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\n", 0));
    }

    /**
     * Test space input for a linewidth of zero will returns array with a single
     * element ""
     * 
     * Test if the user input space is considered as empty and should return [""]
     * just like @TestZeroWidthEmptyInput
     */
    @Test
    public void TestZeroWidthSpaceInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText(" ", 0));
    }

    /**
     * Test tab input for a linewidth of zero will returns array with a single
     * element ""
     * 
     * Test if the user input tab, \t is considered as empty and should return [""]
     * just like @TestZeroWidthEmptyInput
     */
    @Test
    public void TestZeroWidthTabInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\t", 0));
    }

    /**
     * Test double newline input for a linewidth of zero will returns array with a
     * single element ""
     * 
     * Test if the user input double newline, \n\n is considered as empty and should
     * return [""] just like @TestZeroWidthEmptyInput
     */
    @Test
    public void TestZeroWidthDoubleNewLineInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\n\n", 0));
    }

    /**
     * Test double space input for a linewidth of zero will returns array with a
     * single element ""
     * 
     * Test if the user input double space, " " is considered as empty and should
     * return [""] just like @TestZeroWidthEmptyInput
     */
    @Test
    public void TestZeroWidthDoubleSpaceInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("  ", 0));
    }

    /**
     * Test double tab input for a linewidth of zero will returns array with a
     * single element ""
     * 
     * Test if the user input double tab, \t\t is considered as empty and should
     * return [""] just like @TestZeroWidthEmptyInput
     */
    @Test
    public void TestZeroWidthDoubleTabInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\t\t", 0));
    }

    /**
     * Test tab and newline input for a linewidth of zero will returns array with a
     * single element ""
     * 
     * Test if the user input tab and newline, \n\t is considered as empty and
     * should return [""] just like @TestZeroWidthEmptyInput. The formatter should
     * not return more inputs
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
     * 
     * Test if the user input a word that is longer than zero linewidth so an
     * exception should be thrown. Adding a hyphen will make the line length longer
     * than zero so an exception is thrown
     */
    @Test
    public void TestZeroWidthInput() {
        try {
            Formatter.flushLeftText("1", 0);
            fail("Constraints cannot be satisfied exception did not throw!");
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
        }
    }

    /**
     * Test that a negative linewidth is considered illegal by the formatter and the
     * IllegalArgumentException is thrown with correct message "Invalid text (null)"
     * 
     * Test if the exception with message "Invalid text(null)" is thrown and not
     * "Constraints cannot be satisfied" as text is null
     */
    @Test
    public void TestNegativeLineWidthNullInput() {
        try {
            Formatter.flushLeftText(null, -1);
            fail("Invalid text (null) exception did not throw!");
        } catch (IllegalArgumentException iae) {
            assertEquals("Invalid text (null)", iae.getMessage());
        }
    }

    /**
     * Test that a negative linewidth and non-empty input is still considered
     * illegal by the formatter and the IllegalArgumentException is thrown with
     * correct message "Constraints cannot be satisfied"
     * 
     * Test if the exception with message "Constraints cannot be satisfied" is
     * thrown as a negative line width is a constraint that cannot be satisfied by
     * formatter. This exception should be thrown even if the input text is empty.
     */
    @Test
    public void TestNegativeLineWidthInput() {
        try {
            Formatter.flushLeftText("", -1);
            fail("Constraints cannot be satisfied exception did not throw!");
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
        }
    }

    // ================================================================================
    // Single Width
    // ================================================================================

    /**
     * Test that a single letter with a single line width formats to an array with a
     * single element with the letter
     * 
     * Test the general case where constraints where line width is one and line has
     * a length of 1.
     */
    @Test
    public void TestSingleLetterInput() {
        List<String> actual = Formatter.flushLeftText("1", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with input with a \n in the front formats to an array with
     * a single element with the letter.
     * 
     * Test if a empty word would be added infront of the letter element and no
     * exception is thrown.
     */
    @Test
    public void TestSingleNewLineFrontInput() {
        List<String> actual = Formatter.flushLeftText("\n1", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with input with a \n in the back formats to an array with
     * a single element with the letter.
     * 
     * Test if a empty word would be added behind of the letter element and no
     * exception is thrown.
     */
    @Test
    public void TestSingleNewLineBackInput() {
        List<String> actual = Formatter.flushLeftText("1\n", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with input with a \n in the middle creates a split array
     * with both sides in different elements in the array
     * 
     * This test that \n is splits into two lines/elements in array and not in the
     * same element
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
     * Test one linewidth with input with a space in the front formats to an array
     * with a single element with the letter without the space.
     * 
     * Spaces infront of the letter is removed and not considered part of the word.
     */
    @Test
    public void TestSingleSpaceFrontInput() {
        List<String> actual = Formatter.flushLeftText(" 1", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with input with a space in the back formats to an array
     * with a single element with the letter without the space.
     * 
     * Spaces behind of the letter is removed and not considered part of the word.
     */
    @Test
    public void TestSingleSpaceBackInput() {
        List<String> actual = Formatter.flushLeftText("1 ", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test that a one linewidth would work with letters separated by space that has
     * a length of one formats to an array with each element is one letter.
     * 
     * The linewidth is one so each letter should be on a new line.
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
     * Test one linewidth with a input with a tab in the front. \t are consider as
     * spaces and should perform like @TestSingleSpaceFrontInput
     */
    @Test
    public void TestSingleTabFrontInput() {
        List<String> actual = Formatter.flushLeftText("\t1", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with a input with a tab in the back. \t are consider as
     * spaces and should perform like @TestSingleSpaceBackInput
     */
    @Test
    public void TestSingleTabBackInput() {
        List<String> actual = Formatter.flushLeftText("1\t", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test that a one linewidth would work with letters separated by tab that has a
     * length of one formats to an array with each element is one letter.
     * 
     * The linewidth is one so each letter should be on a new line.
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
     * Test words made up of multiple hyphens with single linewidth. Each hyphen
     * should be formatted to the next line as each line length should be one.
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
    @Test
    public void TestSingleWidthThrowInput() {
        try {
            Formatter.flushLeftText("12", 1);
            fail("Constraints cannot be satisfied exception did not throw!");
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
        }
    }

    /**
     * Test that a hyphen allows the word to goto the next line. The line width is
     * one so the hyphen should be the first line and the 2nd line the letter
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
     * Test that a hyphen allows the word to goto the next line. The line width is
     * one so the hyphen should be the first line and the 2nd line the letter.
     * 
     * This test is to test if the hyphen as a single word would be considered as
     * not as word and be removed. This test also test if the hyphen remains when
     * formatting
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
     * Test that a hyphen at the back of a letter is consider illegal with the
     * exception "Constraints cannot be satisfied"
     * 
     * Test if the letter followed by a hyphen is consider as a single word and
     * since the word is longer than one an exception is thrown as the linewidth is
     * one
     */
    @Test
    public void TestSingleHyphenBackInput() {
        try {
            Formatter.flushLeftText("1-", 1);
            fail("Constraints cannot be satisfied exception did not throw!");
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
        }
    }

    /**
     * Test that a hyphen at the middle of a word is consider illegal as the hyphen
     * in the middle does not make it into 3 words. throw exception "Constraints
     * cannot be satisfied"
     * 
     * Hyphens does not make it into three words. Since the condition
     * in @TestSingleHyphenBackInput applies in "1-" and will not become single
     * letter lines.
     */
    @Test
    public void TestSingleHyphenMiddleInput() {
        try {
            Formatter.flushLeftText("1-2", 1);
            fail("Constraints cannot be satisfied exception did not throw!");
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
        }
    }

    // ================================================================================
    // Words less than Line Width
    // ================================================================================

    /**
     * Test that an empty input would format to [""] with multiple lines
     * 
     * Test that an empty input regards less of different line width would still
     * format to [""]
     */
    @Test
    public void TestEmptyInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("", 10));
    }

    /**
     * Test that a short input that is less than linewidth does not change format
     * 
     * Test this with linewidth longer than one
     */
    @Test
    public void TestShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345", 10));
    }

    /**
     * Test that a newline front of short input does not effect output
     * 
     * Test this with linewidth longer than one
     */
    @Test
    public void TestNewLineFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\n12345", 10));
    }

    /**
     * Test that a space front of short input does not effect output
     * 
     * Test this with linewidth longer than one
     */
    @Test
    public void TestSpaceFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText(" 12345", 10));
    }

    /**
     * Test that a tab front of short input does not effect output
     * 
     * Test this with linewidth longer than one
     */
    @Test
    public void TestTabFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\t12345", 10));
    }

    /**
     * Test that a multiple newline front of short input does not effect output
     * 
     * Test that consecutive newlines is consider the same as a single newline
     */
    @Test
    public void TestMultipleNewLineFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\n\n12345", 10));
    }

    /**
     * Test that a multiple space front of short input does not effect output
     * 
     * Test that consecutive spaces is consider the same as one space
     */
    @Test
    public void TestMultipleSpaceFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("  12345", 10));
    }

    /**
     * Test that a multiple tab front of short input does not effect output
     * 
     * Test that consective tabs is consider the same as one space
     */
    @Test
    public void TestMultipleTabFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\t\t12345", 10));
    }

    /**
     * Test that a newline middle of short input makes a newline in input
     * 
     * Test that words on two different lines would format to two different lines
     * and not to a single line
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
     * 
     * Test that two words that is less than the linewidth will not format to two
     * different lines as both words can fit on the same line
     */
    @Test
    public void TestSpaceMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12 45");
        assertEquals(expected, Formatter.flushLeftText("12 45", 10));
    }

    /**
     * Test that a tab middle of short input is considered as a single space
     * 
     * Test that tabs can be considered as spaces and would act the same as
     * in @TestSpaceMiddleShortInput
     */
    @Test
    public void TestTabMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12 45");
        assertEquals(expected, Formatter.flushLeftText("12\t45", 10));
    }

    /**
     * Test that a multiple newline middle of short input makes a newline in input
     * 
     * Test that multiple newlines are considered as one single newline and would
     * act the same as in @TestNewLineMiddleShortInput
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
     * 
     * Test that multiple spaces are considered as one space and would act the same
     * as in @TestSpaceMiddleShortInput
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
     * 
     * Test that tab are consider as spaces and multiple spaces are considered as a
     * single space. It would act the same as in @TestSpaceMiddleShortInput
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
     * 
     * Test that tabs are consider as spaces, test that newlines creates newline.
     * Test if a mixture of tab, space and newline still works.
     */
    @Test
    public void TestTabSpaceNewLineMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12");
        expected.add("45");
        assertEquals(expected, Formatter.flushLeftText("12\t\n  \t45", 10));
    }

    /**
     * Test that a newline back of short input does not effect output.
     * 
     * Test that a newline at the end of the input does not create an empty line
     * after formatting
     */
    @Test
    public void TestNewLineBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345\n", 10));
    }

    /**
     * Test that a space back of short input does not effect output
     * 
     * Test that a space at the end of the input does not go into the line after
     * formatting.
     */
    @Test
    public void TestSpaceBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345 ", 10));
    }

    /**
     * Test that a tab back of short input does not effect output
     * 
     * Test that a tab is consider as a space and acts like
     * in @TestSpaceBackShortInput
     */
    @Test
    public void TestTabBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345\t", 10));
    }

    /**
     * Test that a multiple newline back of short input does not effect output.
     * 
     * Test that consecutive newlines at the end does not create any newlines at the
     * end after formatting.
     */
    @Test
    public void TestMultipleNewLineBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345\n\n", 10));
    }

    /**
     * Test that a multiple space front of short input does not effect output.
     * 
     * Test that consecutive spaces at the end does add any spaces to the line.
     */
    @Test
    public void TestMultipleSpaceBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345  ", 10));
    }

    /**
     * Test that a multiple tab front of short input does not effect output.
     * 
     * Test that tabs are considered as spaces and would act the same as
     * in @TestMultipleSpaceBackShortInput
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
     * 
     * Test that a word wraps with a hyphen without any letters lost.
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
     * 
     * Test that if the last line perfectly ends at the linewidth does not add an
     * extra hyphen.
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
     * 
     * If the words are exactly the length of the linewidth no hyphen would be added
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
     * 
     * Test that tabs are considered as spaces and acts as
     * in @TestWordLengthWidthInput
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
     * shouldn't be any spaces at the end of each line.
     * 
     * Test that if the length of the current line is less than linewidth and the
     * next word does not fit in the current line the word is formatted on the next
     * line.
     * 
     * Test that no spaces would be added at the end of a line even if the length is
     * not equal to linewidth.
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
     * 
     * Test that if the hyphen is exactly at the place which a hyphen should be
     * added to wrap the word to the next line. No hyphen should be added as a
     * hyphen already exist.
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
     * Test words with hyphen in the middle.
     * 
     * Test special case where the first hyphen is added by wrapping. The hyphen is
     * considered as a separater and would allow the next word to be able to move to
     * the next line.
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
     * 
     * Testing that words shorter than the line length and can be fit together would
     * be placed in the same line.
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
