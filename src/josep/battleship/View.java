package josep.battleship;

public class View {

    public void drawBoard(Board board) {
        for (int row = 0; row < board.getRows(); row++) {
            for (int column = 0; column < board.getColumns(); column++) {
                System.out.print(board.getTile(row, column));
            }
            System.out.println();
        }
    }

}
