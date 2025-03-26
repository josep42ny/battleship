package josep.battleship;

public class BoardController {

    private final String[] colors = new String[]{Ansi.RED, Ansi.BLUE};
    private Board[] boards;
    private int current = 0;

    BoardController(int boardAmount) {
        boards = new Board[boardAmount];
        for (int i = 0; i < boardAmount; i++) {
            boards[i] = new Board(colors[i % colors.length]);
        }
    }

    public Board nextBoard() {
        current = (current + 1) % boards.length;
        return boards[current];
    }

    public void revealTile(int[] coords) {
        boards[current].reveal(coords);
    }

    public boolean isTileVisible(int[] coords) {
        return boards[current].isTileVisible(coords);
    }

    public Board currentBoard() {
        return boards[current];
    }
}
