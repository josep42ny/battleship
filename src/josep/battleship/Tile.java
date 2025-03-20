package josep.battleship;

public enum Tile {

    WATER(0, "░░"),
    CARRIER(5, "▀▄"),
    BATTLESHIP(4, "▀▄"),
    CRUISER(3, "▀▄"),
    SUBMARINE(3, "▀▄"),
    DESTROYER(2, "▀▄");

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
