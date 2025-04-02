package josep.battleship;

public enum Tile {

    FOG(0, "▓▓"),
    HIT(0, Ansi.paint("╺╸", Ansi.BG_BRIGHT_BLACK + Ansi.FG_BRIGHT_RED)),
    MISS(0, Ansi.paint("╺╸", Ansi.BG_BRIGHT_BLUE + Ansi.FG_BRIGHT_WHITE)),
    WATER(0, Ansi.paint("  ", Ansi.BG_BRIGHT_BLUE)),
    CARRIER(5, Ansi.paint("  ", Ansi.BG_PURPLE)),
    BATTLESHIP(4, Ansi.paint("  ", Ansi.BG_YELLOW)),
    CRUISER(3, Ansi.paint("  ", Ansi.BG_CYAN)),
    SUBMARINE(3, Ansi.paint("  ", Ansi.BG_GREEN)),
    DESTROYER(2, Ansi.paint("  ", Ansi.BG_BRIGHT_BLACK));

    private final String symbol;
    private final int size;

    private Tile(int size, String symbol) {
        this.symbol = symbol;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
