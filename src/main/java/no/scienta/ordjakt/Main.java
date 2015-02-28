package no.scienta.ordjakt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class Main {

    private final Dictionary dictionary = new Dictionary();

    public Main() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = readLine(reader);
            if (line == null) {
                System.out.println("Bye.");
                System.exit(0);
            }
            solve(line);
        }
    }

    private String readLine(BufferedReader reader) throws IOException {
        String line = "";
        while (line.length() != 16) {
            System.out.print("Enter 16 characters: ");
            line = reader.readLine().replaceAll("\\s+", "");
            if (line.isEmpty()) {
                return null;
            }
        }
        return line;
    }

    private void solve(String line) {
        Board board = new BoardBuilder().build();
        board.setCharacters(line);

        Solver solver = new Solver(board, dictionary);
        solver.solve();

        System.out.println(solver.getSolutions());
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
