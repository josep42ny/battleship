package josep.battleship;

public class InputHandler {

    public int[] ask () {
        int[] coords = new int[2];
        int number;
        char letter;

        String in;
        int abc = 0;
        int abcd = 0;
        System.out.println();

        // fixme
        do {
            do {
                System.out.print("\033[F\033[2K");
                System.out.flush();
                in = System.console().readLine("Enter play [a-j][1-10]: ");
            } while (in.length() != 3 && in.length() != 2);


            try {
                abc = Integer.parseInt(in.substring(1));
            } catch (NumberFormatException nfe) {};
            abc--;

            abcd = in.charAt(0) - 97;

            System.out.println(abc);
            System.out.println(abcd);
        } while ((abc < 0 || abc > 10) || (abcd < 0 || abcd > 10));

        return coords;
    }

}
