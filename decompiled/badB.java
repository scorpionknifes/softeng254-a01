package text;

import java.util.ArrayList;
import java.util.List;

public class Formatter {
    public static List<String> flushLeftText(String text, int LINEWIDTH) {
        if (text == null)
            throw new IllegalArgumentException("Invalid text (null)");
        if (LINEWIDTH < 0)
            throw new IllegalArgumentException("Constraints cannot be satisfied");
        String normalisedInput = normaliseInput(text);
        List<String> result = new ArrayList<>();
        if (normalisedInput.length() == 0) {
            result.add("");
            return result;
        }
        if (LINEWIDTH == 0)
            throw new IllegalArgumentException("Constraints cannot be satisfied");
        if (LINEWIDTH == 1)
            return oneCharWords(normalisedInput);
        int currentPos = 0;
        while (currentPos < normalisedInput.length()) {
            boolean addHyphen = false;
            int lastPos = getSplitPoint(normalisedInput, LINEWIDTH, currentPos);
            if (lastPos < 0) {
                //DIFFERENT
                lastPos = currentPos + LINEWIDTH - 1;
                //DIFFERENT
                addHyphen = true;
            }
            String candidate = null;
            if (lastPos + 1 < normalisedInput.length()) {
                candidate = normalisedInput.substring(currentPos, lastPos + 1) + (addHyphen ? "-" : "");
            } else {
                candidate = normalisedInput.substring(currentPos);
            }
            result.add(candidate);
            currentPos = lastPos + 1;
            if (currentPos < normalisedInput.length() && Character.isWhitespace(normalisedInput.charAt(currentPos)))
                currentPos++;
        }
        return result;
    }

    protected static String normaliseInput(String text) {
        String input = text.trim();
        String normalisedInput = "";
        char sep = Character.MIN_VALUE;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isWhitespace(currentChar)) {
                if (currentChar == '\n') {
                    sep = '\n';
                } else if (sep == '\000') {
                    sep = ' ';
                }
            } else {
                if (sep != '\000') {
                    normalisedInput = normalisedInput + sep;
                    sep = Character.MIN_VALUE;
                }
                normalisedInput = normalisedInput + input.charAt(i);
            }
        }
        return normalisedInput;
    }

    protected static List<String> oneCharWords(String normalisedInput) {
        String[] words = normalisedInput.split(" |\n");
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 2) {
                if (word.charAt(0) == '-') {
                    result.add("-");
                    result.add(word.charAt(1) + "");
                } else {
                    throw new IllegalArgumentException("Constraints cannot be satisfied");
                }
            } else if (word.length() > 2) {
                if (word.matches("-+")) {
                    for (char hyphen : word.toCharArray())
                        result.add(hyphen + "");
                } else {
                    throw new IllegalArgumentException("Constraints cannot be satisfied");
                }
            } else {
                result.add(word);
            }
        }
        return result;
    }

    private static int getSplitPoint(String normalisedInput, int LINEWIDTH, int startPos) {
        int nextNLPos = normalisedInput.indexOf('\n', startPos);
        if (nextNLPos > 0 && nextNLPos < startPos + LINEWIDTH)
            return nextNLPos - 1;
        if (startPos + LINEWIDTH >= normalisedInput.length())
            return normalisedInput.length();
        int split = startPos + LINEWIDTH;
        if (Character.isWhitespace(normalisedInput.charAt(split)))
            return split - 1;
        int candidateSplitPos = -1;
        while (split > startPos) {
            split--;
            char currentChar = normalisedInput.charAt(split);
            if (currentChar == ' ') {
                candidateSplitPos = split - 1;
                break;
            }
            if (currentChar == '-') {
                candidateSplitPos = split;
                break;
            }
        }
        return candidateSplitPos;
    }
}
