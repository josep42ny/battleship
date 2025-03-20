package josep.battleship;

public class Board {

    private int columns;
    private int rows;
    private final boolean[][] revealedTiles;
    private final Tile[][] tiles;


    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.revealedTiles = new Tile[rows][columns];
    }

    public Board() {
        this(10, 10);
    }

}
