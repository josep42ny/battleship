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
            view.drawPlayerSwitch();
            Board player = boardController.currentBoard();
            Board opponent = boardController.nextBoard();
            view.drawBoards(opponent, player);
            int[] coords;
            while (true) {
                coords = inputHandler.ask();
                if (!boardController.isTileVisible(coords)) {
                    break;
                }
                Ansi.clearLine();
            }
            boardController.revealTile(coords);
            if (opponent.haveAllSank()) {
                gameover();
            }
        }
    }

    private void gameover() {
        Board player = boardController.currentBoard();
        Board opponent = boardController.nextBoard();
        view.drawBoards(player, opponent);
        System.exit(0);
    }

}
