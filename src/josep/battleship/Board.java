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
    private static final Tile[] shipAmounts = new Tile[]{Tile.CARRIER, Tile.BATTLESHIP, Tile.CRUISER, Tile.SUBMARINE, Tile.DESTROYER};

    public Board(int rows, int columns, String color) {
        this.color = color;
        this.rows = rows;
        this.columns = columns;
        this.random = new Random();
        this.tiles = new Tile[rows][columns];
        this.visible = new boolean[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                this.tiles[row][column] = Tile.WATER;
            }
        }
        placeAllShips();
    }

    public void placeAllShips() {
        for (Tile ship : shipAmounts) {
            while (true) {
                try {
                    placeShip(ship, random.nextBoolean());
                    break;
                } catch (InvalidTileException e) {

                }
            }
        }
    }

    private void placeShip(Tile type, boolean vertical) throws InvalidTileException {
        int shipLength = type.getSize();

        int rowBound = vertical ? rows - shipLength - 1 : rows - 1;
        int colBound = vertical ? columns - 1 : columns - shipLength - 1;

        int row = random.nextInt(rowBound);
        int col = random.nextInt(colBound);

        for (int i = 0; i < shipLength; i++) {
            if (tiles[row][col] != Tile.WATER) {
                throw new InvalidTileException();
            }
        }

        for (int i = 0; i < shipLength; i++) {
            tiles[row][col] = type;
            row += vertical ? 1 : 0;
            col += vertical ? 0 : 1;
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
            return tiles[row][column] == Tile.WATER ? Tile.MISS : Tile.HIT;
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
