package no.scienta.ordjakt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class Main {

    public static void main(String[] args) throws IOException {

        System.out.print("Enter 16 characters: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        Board board = new BoardBuilder().build();
        board.setCharacters(line);

        Dictionary dictionary = new Dictionary();
        Solver solver = new Solver(board, dictionary);
        solver.solve();

        System.out.println(solver.getSolutions());
    }
}
