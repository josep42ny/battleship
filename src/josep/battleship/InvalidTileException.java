package josep.battleship;

public class InvalidTileException extends RuntimeException {
    public InvalidTileException() {

    }

    public InvalidTileException(String message) {
        super(message);
    }
}
