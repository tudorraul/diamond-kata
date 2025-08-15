package kata.diamond;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiamondPrinterTest {

    @Test
    void printsDiamondWithA() {
        var printer = new DiamondPrinter();
        var expected = List.of("A");
        assertEquals(expected, printer.printDiamond('A'));
    }

}