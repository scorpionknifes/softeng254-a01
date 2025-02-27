package text; // DO NOT CHANGE THIS OR YOU WILL GET ZERO

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * SOFTENG 254 2020 Assignment 1 submission.
 * 
 * Check Java Doc for Formatter for Constraints and definitions. Constraints 1
 * and 2 is satisfied by each case by asserting the actual output with the
 * expected output with every character and characters adjacent to each other.
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
    public void testNullInput() {
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
     * every line is less than zero length. Test if constraint 4 is satisfied when
     * linewidth is zero.
     */
    @Test
    public void testZeroWidthEmptyInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("", 0));
    }

    /**
     * Test newline input for a linewidth of zero will returns array with a single
     * element ""
     * 
     * Test if the user input newline, \n is considered as empty and should return
     * [""] just like @testZeroWidthEmptyInput. Test if constraint 9 is satisfied
     * when linewidth is zero.
     */
    @Test
    public void testZeroWidthNewLineInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\n", 0));
    }

    /**
     * Test space input for a linewidth of zero will returns array with a single
     * element ""
     * 
     * Test if the user input space is considered as empty and should return [""]
     * just like @testZeroWidthEmptyInput. Test if constraint 5 is satisfied when
     * linewidth is zero.
     */
    @Test
    public void testZeroWidthSpaceInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText(" ", 0));
    }

    /**
     * Test tab input for a linewidth of zero will returns array with a single
     * element ""
     * 
     * Test if the user input tab, \t is considered as non printable and should
     * return [""] just like @testZeroWidthEmptyInput. Test if constraint 6 is
     * satisfied.
     */
    @Test
    public void testZeroWidthTabInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\t", 0));
    }

    /**
     * Test double newline input for a linewidth of zero will returns array with a
     * single element ""
     * 
     * Test if the user input double newline, \n\n is considered as empty and should
     * return [""] just like @testZeroWidthEmptyInput. Test if constraint 9 is
     * satisfied when linewidth is zero.
     */
    @Test
    public void testZeroWidthDoubleNewLineInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\n\n", 0));
    }

    /**
     * Test double space input for a linewidth of zero will returns array with a
     * single element ""
     * 
     * Test if the user input double space, " " is considered as non printable
     * whitespace and should return [""] just like @testZeroWidthEmptyInput. Test if
     * constraint 5 and 7 is satisfied when linewidth is zero.
     */
    @Test
    public void testZeroWidthDoubleSpaceInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("  ", 0));
    }

    /**
     * Test double tab input for a linewidth of zero will returns array with a
     * single element ""
     * 
     * Test if the user input double tab, \t\t is considered as non printable just
     * like space and should return [""] just like @testZeroWidthEmptyInput. Test if
     * constraint 6 is satisfied.
     */
    @Test
    public void testZeroWidthDoubleTabInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("\t\t", 0));
    }

    /**
     * Test tab and newline input for a linewidth of zero will returns array with a
     * single element ""
     * 
     * Test if the user input consecutive tab and newline, "\n\t " every non
     * printable is considered by the formatter and should return [""] just
     * like @testZeroWidthEmptyInput. The formatter should not return more inputs.
     * Test if constraint 6 is satisfied.
     */
    @Test
    public void testZeroWidthTripleEmptyInput() {
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
     * than zero so an exception is thrown. Test if constraint 8 and 4 is satisfied
     * when linewidth is zero.
     */
    @Test
    public void testZeroWidthInput() {
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
     * "Constraints cannot be satisfied" as text is null. Text null is not a
     * constraint that can be satisfied so a different message should be thrown.
     */
    @Test
    public void testNegativeLineWidthNullInput() {
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
     * Test if constraint 4 is satisfied.
     */
    @Test
    public void testNegativeLineWidthInput() {
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
     * a length of 1. Test if constraint 4 is satisfied.
     */
    @Test
    public void testSingleLetterInput() {
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
     * exception is thrown. Test if constraint 9 is satisfied.
     */
    @Test
    public void testSingleNewLineFrontInput() {
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
     * exception is thrown. Test if constraint 9 is satisfied.
     */
    @Test
    public void testSingleNewLineBackInput() {
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
     * same element. Test if constraint 9 is satisfied.
     */
    @Test
    public void testSingleNewLineMiddleInput() {
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
     * Test if constraint 5 is satisfied.
     */
    @Test
    public void testSingleSpaceFrontInput() {
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
     * Test if constraint 5 is satisfied.
     */
    @Test
    public void testSingleSpaceBackInput() {
        List<String> actual = Formatter.flushLeftText("1 ", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test that a one linewidth would work with letters separated by space that has
     * a length of one formats to an array with each element is one letter.
     * 
     * The linewidth is one so each letter should be on a new line. Test if
     * constraint 4 is satisfied with linewidth of one.
     */
    @Test
    public void testSingleSpaceMiddleInput() {
        List<String> actual = Formatter.flushLeftText("1 2", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("2");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with a input with a tab in the front. \t are consider as
     * spaces and should perform like @testSingleSpaceFrontInput.
     * 
     * Test if constraint 6 is satisfied.
     */
    @Test
    public void testSingleTabFrontInput() {
        List<String> actual = Formatter.flushLeftText("\t1", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test one linewidth with a input with a tab in the back. \t are consider as
     * spaces and should perform like @testSingleSpaceBackInput.
     * 
     * Test if constraint 6 is satisfied.
     */
    @Test
    public void testSingleTabBackInput() {
        List<String> actual = Formatter.flushLeftText("1\t", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    /**
     * Test that a one linewidth would work with letters separated by tab that has a
     * length of one formats to an array with each element is one letter.
     * 
     * The linewidth is one so each letter should be on a new line and should
     * perform like @testSingleSpaceMiddleInput.
     */
    @Test
    public void testSingleTabMiddleInput() {
        List<String> actual = Formatter.flushLeftText("1\t2", 1);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("2");
        assertEquals(expected, actual);
    }

    /**
     * Test words made up of multiple hyphens with single linewidth. Each hyphen
     * should be formatted to the next line as each line length should be one.
     * 
     * Test if constraint 8 and 4 is satisfied with linewidth of one.
     */
    @Test
    public void testMultipleHyphenInput() {
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
     * message "Constraints cannot be satisfied".
     * 
     * Test when constraint 4 is not satisfied with linewidth of one an exception is
     * thrown.
     */
    @Test
    public void testSingleWidthThrowInput() {
        try {
            Formatter.flushLeftText("12", 1);
            fail("Constraints cannot be satisfied exception did not throw!");
        } catch (IllegalArgumentException iae) {
            assertEquals("Constraints cannot be satisfied", iae.getMessage());
        }
    }

    /**
     * Test that a hyphen allows the word to goto the next line. The line width is
     * one so the hyphen should be the first line and the 2nd line the letter.
     * 
     * Test if constraint 8 is satisfied with linewidth of one.
     */
    @Test
    public void testSingleHyphenLetterInput() {
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
     * formatting. Test if constraint 8 is satisfied if there is a word with only a
     * single hyphen.
     */
    @Test
    public void testSingleHyphenSpaceLetterInput() {
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
     * one. Test if constraint 4 and 8 cannot be satisfied in this case with
     * linewidth of one.
     */
    @Test
    public void testSingleHyphenBackInput() {
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
     * in @testSingleHyphenBackInput applies in "1-" and will not become single
     * letter lines. Test if constraint 9 is satisfied in this case with linewidth
     * of one.
     */
    @Test
    public void testSingleHyphenMiddleInput() {
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
     * format to [""].
     */
    @Test
    public void testEmptyInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("");
        assertEquals(expected, Formatter.flushLeftText("", 10));
    }

    /**
     * Test that a short input that is less than linewidth does not change format
     * 
     * Test this with linewidth longer than one. Test if constraint 1 and 2 is
     * satisfied.
     */
    @Test
    public void testShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345", 10));
    }

    /**
     * Test that a newline front of short input does not effect output.
     * 
     * Test this with linewidth longer than one. Test if constraint 9 is satisfied.
     */
    @Test
    public void testNewLineFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\n12345", 10));
    }

    /**
     * Test that a space front of short input does not effect output.
     * 
     * Test this with linewidth longer than one. Test if constraint 5 is satisfied.
     */
    @Test
    public void testSpaceFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText(" 12345", 10));
    }

    /**
     * Test that a tab front of short input does not effect output.
     * 
     * Test tabs are consider the same as one non printable separater and should act
     * like @testSpaceFrontShortInput. Test if constraint 6 is satisfied.
     */
    @Test
    public void testTabFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\t12345", 10));
    }

    /**
     * Test that a multiple newline front of short input does not effect output
     * 
     * Test that consecutive newlines is consider the same as a single newline. Test
     * if contraint 9 is satisfied.
     */
    @Test
    public void testMultipleNewLineFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\n\n12345", 10));
    }

    /**
     * Test that a multiple space front of short input does not effect output
     * 
     * Test that consecutive spaces is consider the same as one space. Test if
     * constraint 7 is satisfied.
     */
    @Test
    public void testMultipleSpaceFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("  12345", 10));
    }

    /**
     * Test that a multiple tab front of short input does not effect output
     * 
     * Test that consective tabs is consider the same as one non printable separater
     * e.g. space. Test if constraint 6 is satisfied.
     */
    @Test
    public void testMultipleTabFrontShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("\t\t12345", 10));
    }

    /**
     * Test that a newline middle of short input makes a newline in input
     * 
     * Test that words on two different lines would format to two different lines
     * and not to a single line. Test if constraint 9 is satisfied.
     */
    @Test
    public void testNewLineMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12");
        expected.add("45");
        assertEquals(expected, Formatter.flushLeftText("12\n45", 10));
    }

    /**
     * Test that a space middle of short input does not make a newline
     * 
     * Test that two words that is less than the linewidth will not format to two
     * different lines as both words can fit on the same line. Test if constraint 3
     * is satisfied.
     */
    @Test
    public void testSpaceMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12 45");
        assertEquals(expected, Formatter.flushLeftText("12 45", 10));
    }

    /**
     * Test that a tab middle of short input is considered as a single space
     * 
     * Test that tabs can be considered as spaces and would act the same as
     * in @testSpaceMiddleShortInput. Test if constraint 6 is satisfied.
     */
    @Test
    public void testTabMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12 45");
        assertEquals(expected, Formatter.flushLeftText("12\t45", 10));
    }

    /**
     * Test that a multiple newline middle of short input makes a newline in input
     * 
     * Test that multiple newlines are considered as one single newline and would
     * act the same as in @testNewLineMiddleShortInput. Test if constraint 9 is
     * satisfied.
     */
    @Test
    public void testMultipleNewLineMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12");
        expected.add("45");
        assertEquals(expected, Formatter.flushLeftText("12\n\n\n45", 10));
    }

    /**
     * Test that a multiple space middle of short input is considered as one space
     * 
     * Test that multiple spaces are considered as one space and would act the same
     * as in @testSpaceMiddleShortInput. Test if constraint 3 is satisfied.
     */
    @Test
    public void testMultipleSpaceMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12 45");
        assertEquals(expected, Formatter.flushLeftText("12   45", 10));
    }

    /**
     * Test that a multiple tab middle of short input is considered as a single
     * space
     * 
     * Test that tab are consider as spaces and multiple spaces are considered as a
     * single space. It would act the same as in @testSpaceMiddleShortInput. Test if
     * constraint 6 is satisfied.
     */
    @Test
    public void testMultipleTabMiddleShortInput() {
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
    public void testTabSpaceNewLineMiddleShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12");
        expected.add("45");
        assertEquals(expected, Formatter.flushLeftText("12\t\n  \t45", 10));
    }

    /**
     * Test that a newline back of short input does not effect output.
     * 
     * Test that a newline at the end of the input does not create an empty line
     * after formatting. Test if constraint 9 is satisfied.
     */
    @Test
    public void testNewLineBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345\n", 10));
    }

    /**
     * Test that a space back of short input does not effect output
     * 
     * Test that a space at the end of the input does not go into the line after
     * formatting. Test if constraint 5 is satisfied.
     */
    @Test
    public void testSpaceBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345 ", 10));
    }

    /**
     * Test that a tab back of short input does not effect output
     * 
     * Test that a tab is consider as a space and acts like
     * in @testSpaceBackShortInput. Test if constraint 6 is satisfied.
     */
    @Test
    public void testTabBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345\t", 10));
    }

    /**
     * Test that a multiple newline back of short input does not effect output.
     * 
     * Test that consecutive newlines at the end does not create any newlines at the
     * end after formatting. Test if constraint 9 is satisfied.
     */
    @Test
    public void testMultipleNewLineBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345\n\n", 10));
    }

    /**
     * Test that a multiple space front of short input does not effect output.
     * 
     * Test that consecutive spaces at the end does add any spaces to the line. Test
     * if constraint 3 is satisfied.
     */
    @Test
    public void testMultipleSpaceBackShortInput() {
        List<String> expected = new ArrayList<String>();
        expected.add("12345");
        assertEquals(expected, Formatter.flushLeftText("12345  ", 10));
    }

    /**
     * Test that a multiple tab front of short input does not effect output.
     * 
     * Test that tabs are considered as spaces and would act the same as
     * in @testMultipleSpaceBackShortInput. Test if constraint 6 is satisfied.
     */
    @Test
    public void testMultipleTabBackShortInput() {
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
     * Test that a word wraps with a hyphen without any letters lost. Test if
     * constraint 8 and 4 is satisfied.
     */
    @Test
    public void testExtraLongInput() {
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
     * extra hyphen. Test if constraint 8 and 4 is satisfied in this case.
     */
    @Test
    public void testLongInput() {
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
     * If the words are exactly the length of the linewidth no hyphen would be
     * added. Test if constraint 4 is satisfied.
     */
    @Test
    public void testWordLengthWidthInput() {
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
     * in @testWordLengthWidthInput. Test if constraint 6 is satisfied.
     */
    @Test
    public void testWordLengthWidthTabInput() {
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
     * not equal to linewidth. Test if constraint 4 and 5 is satisfied.
     */
    @Test
    public void testBackSpacesInput() {
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
     * hyphen already exist. Test if constraint 8 is satisfied.
     */
    @Test
    public void testHyphenNewLineInput() {
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
     * the next line. Test if constraint 8 and 4 is satisfied in this case.
     */
    @Test
    public void testHyphenWordsInput() {
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
     * be placed in the same line. Test if constraint 6 and 3 is satisfied.
     */
    @Test
    public void testWordsMultipleLengthInput() {
        List<String> actual = Formatter.flushLeftText("1 23 456 7890 12345 678901 2345678", 10);
        List<String> expected = new ArrayList<String>();
        expected.add("1 23 456");
        expected.add("7890 12345");
        expected.add("678901");
        expected.add("2345678");
        assertEquals(expected, actual);
    }
}
