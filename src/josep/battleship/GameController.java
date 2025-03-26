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
            Board board = boardController.nextBoard();
            view.drawBoard(board);
            int[] coords;
            while (true) {
                coords = inputHandler.ask();
                if (!boardController.isTileVisible(coords)) {
                    break;
                }
                Ansi.clearLine();
            }
            boardController.revealTile(coords);
        }
    }


}
