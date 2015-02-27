package no.scienta.ordjakt;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class Solver {

    private final Board board;
    private final Dictionary dictionary;
    private final Set<String> solutions = new LinkedHashSet<>();

    public Solver(Board board, Dictionary dictionary) {
        this.board = board;
        this.dictionary = dictionary;
    }

    public void solve() {
        for (Cell cell : board) {
            solveForPath(new Path(cell.getPosition()));
        }
    }

    private void solveForPath(Path path) {
        String word = path.getWord(board);
        if (dictionary.contains(word)) {
            solutions.add(word);
        }

        if (dictionary.containsStart(word)) {
            Position tail = path.tail();
            Cell cell = board.getCell(tail);
            cell.setVisited(true);

            for (Cell neighbour : cell.getUnvisitedNeighbours()) {
                solveForPath(path.append(neighbour.getPosition()));
            }
            cell.setVisited(false);
        }
    }

    public List<String> getSolutions() {
        return solutions.stream().sorted((o1, o2) -> o2.length() - o1.length()).collect(Collectors.toList());
    }
}
