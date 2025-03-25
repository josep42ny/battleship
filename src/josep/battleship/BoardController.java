package josep.battleship;

public class BoardController {

    Board[] boards;
    int current = 0;

    BoardController(int boardAmount) {
        boards = new Board[boardAmount];
        for (int i = 0; i < boardAmount; i++) {
            boards[i] = new Board();
        }
    }

    public Board nextBoard() {
        current = (current + 1) % boards.length;
        return boards[current];
    }

    public void revealTile(int[] coords) {
        boards[current].reveal(coords);
    }

}
