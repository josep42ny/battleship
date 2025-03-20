package josep.battleship;

public class Board {

    private int columns;
    private int rows;
    private final Tile[][] tiles;


    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.tiles = new Tile[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                this.tiles[row][column] = Tile.WATER;
            }
        }

        tiles[3][2] = Tile.DESTROYER;
        tiles[3][3] = Tile.DESTROYER;

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
        return tiles[row][column];
    }
}
