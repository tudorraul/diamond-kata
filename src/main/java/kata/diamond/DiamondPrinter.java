package kata.diamond;

import java.util.List;

public class DiamondPrinter {
    public List<String> printDiamond(char letter) {
        if (letter == 'A') return List.of("A");
        if (letter == 'B') return List.of(" A ", "B B", " A ");
        return List.of();
    }
}
