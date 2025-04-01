package josep.battleship;

public class Main {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.print("\nstopping...\n\n");
        }));

        GameController gameController = new GameController();
        gameController.awake();

    }

}
