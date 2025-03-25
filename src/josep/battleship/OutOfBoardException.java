package josep.battleship;

public class OutOfBoardException extends RuntimeException {
    public OutOfBoardException() {

    }

    public OutOfBoardException(String message) {
        super(message);
    }
}
