package josep.battleship;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Board {

    private int columns;
    private int rows;
    private final String color;
    private final Tile[][] tiles;
    private final boolean[][] visible;
    private Random random;
    private static final Map<Tile, Integer> shipAmounts = new HashMap<>() {{
        put(Tile.CARRIER, 1);
        put(Tile.BATTLESHIP, 2);
        put(Tile.CRUISER, 3);
        put(Tile.SUBMARINE, 4);
        put(Tile.DESTROYER, 5);
    }};

    public Board(int rows, int columns, String color) {
        this.color = color;
        this.rows = rows;
        this.columns = columns;
        this.tiles = new Tile[rows][columns];
        this.visible = new boolean[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                this.tiles[row][column] = Tile.WATER;
            }
        }
        placeShip(Tile.CARRIER, 1, 1, new int[]{1, 0});
    }

    public void placeAllShips() {
        for (Tile a : shipAmounts.keySet()) {
            if (random.nextBoolean()) {
                // fixme placeShip(shipAmounts.get(a));
            }
        }
    }

    private void placeShip(Tile type, int row, int col, int[] direction) {
        int rowOffset = direction[0];
        int colOffset = direction[1];

        for (int i = 0; i < type.getSize(); i++) {
            tiles[row][col] = type;
            row += rowOffset;
            col += colOffset;
        }
    }

    public Board(String color) {
        this(10, 10, color);
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Tile getTile(int row, int column) {
        if (visible[row][column]) {
            return tiles[row][column];
        }
        return Tile.FOG;
    }

    public Tile getTrueTile(int row, int column) {
        if (!visible[row][column]) {
            return tiles[row][column];
        }
        return (tiles[row][column] == Tile.WATER) ? Tile.MISS : Tile.HIT;
    }

    public void reveal(int[] coords) {
        visible[coords[0]][coords[1]] = true;
    }

    public boolean isTileVisible(int[] coords) {
        return visible[coords[0]][coords[1]];
    }

    public String getColor() {
        return color;
    }

    public boolean haveAllSank() {
        for (int row = 0; row < tiles.length; row++) {
            for (int column = 0; column < tiles[row].length; column++) {
                if (tiles[row][column] != Tile.WATER && !visible[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }

}
