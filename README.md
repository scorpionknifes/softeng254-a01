# Softeng254 Assignment 1 - Creating Tests

## Overview
The main goal of this assignment is to write tests that will detect faults in code.

You are to create a test suite to test the method `text.Formatter#flushLeftText()`. Your test suite should detect all the faults in the "bad" implementations, and all tests should pass for the "good" implementation (assuming there are, in fact, no faults in that implementation!).

*Tips: decompile black box jar to identify differences.*

7.5/7.5

## Flush Left Formatting

There specific details in the provided JavaDoc page for `text.Formatter`. Below is a hopefully more accessible description.

The task the implementations are supposed to do is to perform flush left text alignment on a piece of text, the text is formatted to fit on a page (of a given width) so that only the left edge is vertically aligned and the the right edge "ragged" (so this formatting is sometimes known as ragged right. In practical terms, this means taking a piece of text, and ensuring that it fits into lines of a given width, removing all extraneous [whitespace characters](https://en.wikipedia.org/wiki/Whitespace_character) (Links to an external site.). Most web pages will format (English) text (such as this paragraph) using flush left.

Other forms of formatting include flush right (common for languages that are read right-to-left) or justified, meaning both edges are aligned. This means it plays games with the spacing between words and kerning (spacing between characters), and if it really has to, hyphenate words, so that both edges of every full line are aligned. If the browser you are using to read this page respects the `text-align` attribute, then this paragraph should be justified. (You may need to make the window narrower to really appreciate the effect). Books, magazines, etc. are typically justified. A useful (although non-authoritative) discussion of text alignment can be found in [WikiPedia](https://en.wikipedia.org/wiki/Typographic_alignment) (Links to an external site.).

What any implementation is supposed to do is, take an input string and a linewidth and break the input into a list of strings so that no string is longer than the specified linewidth. To simplify matters we will assume mono-spaced fonts (all characters are exactly the same width). This means we can specify the linewidth in terms of the maximum number of characters allowed in a line. In the example below, the first piece of text is the input (formatted so that it fits on the page, but think of it as one big line), and the second piece of text is the input formatted to fit on lines of length 20. (The row of numbers provides a "ruler" to measure the width of the lines.). There are no whitespace characters at the end of any line.

```
Program testing can be used to show the presence of bugs, but never to show their absence.

12345678901234567890
Program testing can
be used to show the
presence of bugs,
but never to show
their absence.
```

Roughly speaking, the procedure any implementation needs to follow is, take the input string, go to the position that would allow the longest portion to fit on a line (i.e., position linewidth), and then work backwards until a whitespace character is found. The input string can then be "broken" at that point, and the procedure is applied again from that point.

Naturally it is not quite as simple as that. The input string may contain extraneous characters. The extra spaces must not appear in the final output, and so they must be taken into account when figuring out where the line is to be broken. For example:

```
There are    too many spaces in this!

12345678901234567890
There are too many
spaces in this!
```

The extraneous whitespace characters may occur at the beginning or end of the input string. The whitespace characters also don't necessarily have to be the "space" character — they could also be (for example), a "tab" character or any non-printable character. The requirement is that in the final output, the only whitespace character that is allowed is the "space" character, and there should not be more than one such character sequentially.

There is one special case with regards to whitespace characters, and that is the "newline" character. Such characters indicate the end of a paragraph, and so cannot be ignored. When such characters are encountered in the input, the line must be broken at that position, no matter where they appear. The only exceptions to this are when there are multiple newline characters in a row — the extra ones should be ignored, or at the beginning or end of the input.

In the example below, following the Java standard, the sequence \n represents a single newline character in the input.

```
\nProgram testing can be used\nto show the\n\n\n presence of bugs, but never to show their absence.\n

12345678901234567890
Program testing can
be used
to show the
presence of bugs, 
but never to show
their absence.
```

Note that the newline characters have been removed in the formatted text, the multiple newlines only cause one line break, the space following those multiple newlines has been removed, and the leading and trailing newlines have been removed.

There is a question as to what to do when a "word" is too long to fit on a line. In this case, and this case only, the word has to be hyphenated so that it can be broken across a line. The hyphen appears in the last position of the line, as shown below:

```
abcdefghijklmnopqrstu is a 21-character word

12345678901234567890
abcdefghijklmnopqrs-
tu is a 21-character
word
```

Finally, the implementation must also handle the case when someone is silly enough to specify a nonsense linewidth. For example, it's difficult to fit any amount of text into a line of width zero! Whenever there is no way that the input can fit into the specified line width, the implementation is expected to throw an exception with an appropriate message. The JavaDoc page gives the details.
