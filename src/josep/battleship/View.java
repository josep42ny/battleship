package josep.battleship;

public class View {

    public void drawBoards(Board opponent, Board player) {
        Ansi.clearScreen();
        drawBoard(opponent);
        System.out.println();
        drawBoardRevealed(player);
    }

    private void drawBoard(Board board) {
        System.out.println("   A B C D E F G H I J");
        for (int row = 0; row < board.getRows(); row++) {
            System.out.print(((row + 1 < 10) ? " " : "") + (row + 1) + " ");
            for (int column = 0; column < board.getColumns(); column++) {
                System.out.print(board.getTile(row, column));
            }
            System.out.println(Ansi.paint("▒", board.getColor()));
        }
    }

    private void drawBoardRevealed(Board board) {
        System.out.println("   A B C D E F G H I J");
        for (int row = 0; row < board.getRows(); row++) {
            System.out.print(((row + 1 < 10) ? " " : "") + (row + 1) + " ");
            for (int column = 0; column < board.getColumns(); column++) {
                System.out.print(board.getTrueTile(row, column));
            }
            System.out.println(Ansi.paint("▒", board.getColor()));
        }
    }

    public void drawPlayerSwitch() {
        Ansi.clearScreen();
        System.out.println("Cambiau jugadors");
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

}
