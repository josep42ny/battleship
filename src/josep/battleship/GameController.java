package josep.battleship;

public class GameController {

    private BoardController boardController;
    private InputHandler inputHandler;
    private View view;

    public void awake() {
        boardController = new BoardController(2);
        inputHandler = new InputHandler();
        view = new View();
        update();
    }

    private void update() {
        while (true) {
            // todo
            Board current = boardController.nextBoard();
            view.drawBoard(current);
            int[] coords = inputHandler.ask();

            boardController.revealTile(coords);
            view.drawBoard(current);
        }
    }

}
