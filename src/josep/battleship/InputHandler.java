package josep.battleship;

public class InputHandler {

    public int[] ask() {
        String in;

        while (true) {
            in = System.console().readLine("Enter play [a-j][1-10]: ");

            if (in.isEmpty()) {
                Ansi.clearLine();
                continue;
            }

            try {
                return parseCoords(in);
            } catch (NumberFormatException | InvalidTileException e) {
                Ansi.clearLine();
            }
        }
    }

    private int[] parseCoords(String text) throws NumberFormatException, InvalidTileException {
        int[] out = new int[2];
        int row = Integer.parseInt(text.substring(1)) - 1;
        int column = text.charAt(0) - 97;

        if (row < 0 || row > 10 || column < 0 || column > 10) {
            throw new InvalidTileException();
        }

        out[0] = row;
        out[1] = column;
        return out;
    }

}
