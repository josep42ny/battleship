package josep.battleship;

public class Ansi {

    private static String CURSOR_UP = "\033[F";
    private static String CURSOR_TOP = "\033[H";
    private static String CLEAR_LINE = "\033[2K";
    private static String CLEAR_SCREEN = "\033[2J";
    private static String RESET = "\033[0m";
    public static String BLUE = "\033[44m";
    public static String RED = "\033[41m";

    public static void clearLine() {
        System.out.print(CURSOR_UP);
        System.out.print(CLEAR_LINE);
        System.out.flush();
    }

    public static void clearScreen() {
        System.out.print(CURSOR_TOP);
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
    }

    public static String paint(String string, String colorCode) {
        return colorCode + string + RESET;
    }

}
