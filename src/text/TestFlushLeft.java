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

    @Test
    public void TestGeneralCase() {
        String input = "12345678901234";
        String output = "[123456789-, 01234]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestOneSpaceAtBegining() {
        String input = " 12345";
        String output = "[12345]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestMoreSpaceAtBegining() {
        String input = "   12345";
        String output = "[12345]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());

    }

    @Test
    public void TestOneSpaceAtEnd() {
        String input = "12345 ";
        String output = "[12345]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestMoreSpaceAtEnd() {
        String input = "12345   ";
        String output = "[12345]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestOneSpeceAtMiddle() {
        String input = "I love you";
        String output = "[I love you]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestMoreSpeceAtMiddle() {
        String input = "I    love";
        String output = "[I love]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestNewlineAsInput() {
        String input = "\n";
        String output = "[]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());

    }

    @Test
    public void TestOneNewLineAtEnd() {
        String input = "I love you" + "\n" + "12345678";
        String output = "[I love you, 12345678]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestMoreNewLineAtEnd() {
        String input = "I love you" + "\n\n" + "12345678";
        String output = "[I love you, 12345678]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestOneNewLineAtMiddle() {
        String input = "12345\n67890";
        String output = "[12345, 67890]";
        System.out.println();
        assertEquals(output, Formatter.flushLeftText(input, 20).toString());
    }

    @Test
    public void TestMoreNewLineAtMiddle() {
        String input = "123\n45\n678\n90";
        String output = "[123, 45, 678, 90]";
        System.out.println();
        assertEquals(output, Formatter.flushLeftText(input, 20).toString());
    }

    @Test
    public void TestOneNewLineAtBegining() {
        String input = "\n12345";
        String output = "[12345]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestMoreNewLinesAtBegining() {
        String input = "\n\n\n12345";
        String output = "[12345]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestTabAsInput() {
        String input = "\t";
        String output = "[]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestTabAtEnd() {
        String input = "1234\t";
        String output = "[1234]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestTabAtBegin() {
        String input = "\t1234";
        String output = "[1234]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestOneTabAtMiddle() {
        String input = "1234\t1234";
        String output = "[1234 1234]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestMoreTabAtMiddle() {
        String input = "12\t34\t1234";
        String output = "[12 34 1234]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestWordShorterThanLineWidth() {
        String input = "love";
        String output = "[love]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestWordSameThanLineWidth() {
        String input = "12345";
        String output = "[12345]";
        assertEquals(output, Formatter.flushLeftText(input, 5).toString());
    }

    @Test
    public void TestWordLongerThanLineWidthWithouthyphenated() {
        String input = "engineering";
        String output = "[engineeri-, ng]";
        assertEquals(output, Formatter.flushLeftText(input, 10).toString());
    }

    @Test
    public void TestWordHasHyphenated() {
        String input = "Software-Engineering";
        String output = "[Software-Engineering]";
        assertEquals(output, Formatter.flushLeftText(input, 20).toString());
    }

    @Test
    public void TestWordHasHyphenatedAtEnd() {
        String input = "SoftwareEngineering-";
        String output = "[SoftwareEngineering-]";
        assertEquals(output, Formatter.flushLeftText(input, 20).toString());
    }

    @Test
    public void TestWordHasHyphenatedAtBegining() {
        String input = "-SoftwareEngineering";
        String output = "[-SoftwareEngineering]";
        assertEquals(output, Formatter.flushLeftText(input, 20).toString());
    }

    @Test
    public void TestSplitAndAddHyphenated() {
        String input = "Software-Engineering";
        String output = "[Software-Engineering]";
        assertEquals(output, Formatter.flushLeftText(input, 20).toString());

    }

    @Test
    public void TestWordHasMoreHyphenated() {
        String input = "I-love-you";
        String output = "[I-love-you]";
        assertEquals(output, Formatter.flushLeftText(input, 20).toString());
    }

    @Test
    public void TestChangeOfLine() {
        String input = "I love engineering";
        String output = "[I love, engineering]";
        assertEquals(output, Formatter.flushLeftText(input, 15).toString());
    }

    @Test
    public void TestNoneSenceLineWidth() {
        String input = "1234";
        String output = "[1234]";
        try {
            assertEquals(output, Formatter.flushLeftText(input, 0).toString());
        } catch (Exception e) {

        }
    }
}
