package kata.diamond;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class that generates a diamond-shaped pattern of uppercase letters.
 * Input must be a letter from 'A' to 'Z'.
 */
public final class DiamondPrinter {
    /**
     * Generates a list of strings representing the diamond pattern
     * with the input character as the widest midpoint.
     *
     * @param   letter A capital letter from 'A' to 'Z'
     * @return  List of strings representing the diamond
     * @throws  IllegalArgumentException if input is not an uppercase A–Z
     */
    public List<String> printDiamond(char letter) {
        validateInput(letter);

        int maxIndex = letter - 'A';
        List<String> lines = new ArrayList<>();

        // top half
        for (int i = 0; i <= maxIndex; i++) {
            lines.add(buildLine(i, maxIndex));
        }

        // bottom half
        for (int i = maxIndex - 1; i >= 0; i--) {
            lines.add(buildLine(i, maxIndex));
        }

        return lines;
    }

    /**
     * Builds a single line of the diamond based on the current letter index.
     *
     * @param currentIndex  The current line's index (0 = 'A', 1 = 'B', etc.)
     * @param maxIndex      The index of the widest letter (e.g. 'C' = 2, 'D' = 3)
     * @return              The formatted line as a string, including outer and inner spaces
     */
    private String buildLine(int currentIndex, int maxIndex) {
        // convert index to the corresponding letter
        char currentChar = (char) ('A' + currentIndex);
        // number of spaces before/after the letters to center the line
        int outerSpaces = maxIndex - currentIndex;
        int innerSpaces = 2 * currentIndex - 1;

        StringBuilder line = new StringBuilder();

        // leading spaces
        appendChars(line, ' ', outerSpaces);

        // first letter
        line.append(currentChar);

        if (currentIndex > 0) {
            // inner spaces and second letter
            appendChars(line, ' ', innerSpaces);
            line.append(currentChar);
        }

        // trailing spaces
        appendChars(line, ' ', outerSpaces);

        return line.toString();
    }

    /**
     * Ensures the input is a valid uppercase letter A–Z.
     */
    private void validateInput(char letter) {
        if (letter < 'A' || letter > 'Z') {
            throw new IllegalArgumentException("Input must be an uppercase letter A–Z.");
        }
    }

    /**
     * Appends a character to the builder, repeated n times.
     */
    private void appendChars(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}
