package josep.battleship;

public class View {

    public void drawBoard(Board board) {

        System.out.println("   A B C D E F G H I J");
        for (int row = 0; row < board.getRows(); row++) {
            System.out.print(((row + 1 < 10) ? " " : "") + (row + 1) + " ");
            for (int column = 0; column < board.getColumns(); column++) {
                System.out.print(board.getTile(row, column));
            }
            System.out.println();
        }
    }

}
