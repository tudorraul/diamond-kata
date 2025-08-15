package kata.diamond;
import net.jqwik.api.*;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiamondPrinterPropertyTest {
    @Property
    void diamondIsVerticallySymmetrical(@ForAll("capitalLetters") char letter) {
        List<String> diamond = new DiamondPrinter().printDiamond(letter);
        List<String> reversed = new StringBuilder(String.join("\n", diamond))
                .reverse()
                .toString()
                .lines()
                .toList();

        assertEquals(diamond, reversed);
    }

    @Property
    void diamondLinesAreHorizontallySymmetric(@ForAll("capitalLetters") char letter) {
        DiamondPrinter printer = new DiamondPrinter();
        List<String> diamond = printer.printDiamond(letter);

        for (String line : diamond) {
            String reversed = new StringBuilder(line).reverse().toString();
            Assertions.assertEquals(line, reversed);
        }
    }

    @Provide
    Arbitrary<Character> capitalLetters() {
        return Arbitraries.chars().range('A', 'Z');
    }
}