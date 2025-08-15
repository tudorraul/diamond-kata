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

    @Test
    void printsDiamondWithB() {
        var printer = new DiamondPrinter();
        var expected = List.of(
                " A ",
                "B B",
                " A "
        );
        assertEquals(expected, printer.printDiamond('B'));
    }

    @Test
    void printsDiamondWithC() {
        var printer = new DiamondPrinter();
        var expected = List.of(
                "  A  ",
                " B B ",
                "C   C",
                " B B ",
                "  A  "
        );
        assertEquals(expected, printer.printDiamond('C'));
    }

    @Test
    void printsDiamondWithZ() {
        DiamondPrinter printer = new DiamondPrinter();
        List<String> result = printer.printDiamond('Z');

        // assert the correct number of lines: 26 top + 25 bottom = 51
        assertEquals(51, result.size());

        // first line should be centered 'A'
        assertEquals("                         A                         ", result.get(0));

        // middle line should be Z...Z (with 49 spaces in between)
        assertEquals("Z                                                 Z", result.get(25));

        // last line should again be centered 'A'
        assertEquals("                         A                         ", result.get(50));
    }

}