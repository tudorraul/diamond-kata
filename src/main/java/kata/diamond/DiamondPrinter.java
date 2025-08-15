package kata.diamond;

import java.util.List;

public class DiamondPrinter {
    public List<String> printDiamond(char letter) {
        if (letter == 'A') return List.of("A");
        return List.of();
    }
}
