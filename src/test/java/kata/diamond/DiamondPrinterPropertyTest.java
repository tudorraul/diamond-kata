package kata.diamond;
import net.jqwik.api.*;
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

    @Provide
    Arbitrary<Character> capitalLetters() {
        return Arbitraries.chars().range('A', 'Z');
    }
}