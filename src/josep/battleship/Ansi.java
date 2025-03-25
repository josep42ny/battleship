package josep.battleship;

public class Ansi {

    private static String CURSOR_UP = "\033[F";
    private static String CLEAR_LINE = "\033[2K";

    public static void clearLine() {
        System.out.print(CURSOR_UP);
        System.out.print(CLEAR_LINE);
        System.out.flush();
    }

}
