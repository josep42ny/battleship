package josep.battleship;

public class BoardController {

    Board[] boards;

    BoardController(int boardAmount) {
        boards = new Board[boardAmount];
        for (int i = 0; i < boardAmount; i++) {
            boards[i] = new Board();
        }
    }

}
