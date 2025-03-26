package josep.battleship;

public class Board {

    private int columns;
    private int rows;
    private final Tile[][] tiles;
    private final boolean[][] visible;


    public Board(int rows, int columns) {
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

    public void placeShip(Tile type, int row, int col, int[] direction) {
        int rowOffset = direction[0];
        int colOffset = direction[1];

        for (int i = 0; i < type.getSize(); i++) {
            tiles[row][col] = type;
            row += rowOffset;
            col += colOffset;
        }
    }

    public Board() {
        this(10, 10);
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

    public void reveal(int[] coords) {
        visible[coords[0]][coords[1]] = true;
    }

    public boolean isTileVisible(int[] coords) {
        return visible[coords[0]][coords[1]];
    }

}
