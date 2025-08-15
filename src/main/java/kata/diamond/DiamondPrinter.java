package kata.diamond;

import java.util.ArrayList;
import java.util.List;

public class DiamondPrinter {
    public List<String> printDiamond(char letter) {
        if (letter < 'A' || letter > 'Z') {
            throw new IllegalArgumentException("Input must be an uppercase letter A–Z.");
        }
        if (letter == 'A') return List.of("A");
        if (letter == 'B') return List.of(" A ", "B B", " A ");
        if (letter >= 'C') {
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

        return List.of();
    }

    /**
     * Builds a single line of the diamond based on the current letter index.
     *
     * @param i         The current line's index (0 = 'A', 1 = 'B', etc.)
     * @param maxIndex  The index of the widest letter (e.g. 'C' = 2, 'D' = 3)
     * @return          The formatted line as a string, including outer and inner spaces
     */
    private String buildLine(int i, int maxIndex) {
        // convert index to the corresponding letter
        char currentChar = (char) ('A' + i);
        // number of spaces before/after the letters to center the line
        int outerSpaces = maxIndex - i;

        if (i == 0) {
            // special case for the first/last line which only has one letter
            return " ".repeat(outerSpaces) + currentChar + " ".repeat(outerSpaces);
        } else {
            // inner space between the two letters (starts at 1 and increases by 2 each row)
            int innerSpaces = 2 * i - 1;
            // format: [outer]Letter[inner]Letter[outer]
            return " ".repeat(outerSpaces) + currentChar + " ".repeat(innerSpaces) + currentChar + " ".repeat(outerSpaces);
        }
    }
}
