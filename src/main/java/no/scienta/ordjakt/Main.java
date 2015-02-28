package no.scienta.ordjakt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.common.base.Joiner;

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
            line = reader.readLine().replaceAll("\\s+", "").toUpperCase();
            if (line.isEmpty()) {
                return null;
            }
        }
        return line;
    }

    private void solve(String characters) {
        Board board = new BoardBuilder().build(characters);

        Solver solver = new Solver(board, dictionary);
        solver.solve();

        System.out.println(Joiner.on("\n").join(solver.getSolutions()));
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
