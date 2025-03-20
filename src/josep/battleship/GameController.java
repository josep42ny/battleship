package josep.battleship;

public class GameController {

    private BoardController boardController;

    public void awake() {

        boardController = new BoardController(2);
        update();

    }

    private void update() {
        new View().drawBoard(boardController.getBoards(0));
    }

}
