package no.scienta.ordjakt;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class BoardBuilder {

    private final static int ROWS = 4;
    private final static int COLUMNS = 4;

    public Board build(String characters) {
        Board board = new Board(ROWS, COLUMNS, characters);
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                Cell cell = board.getCell(row, column);

                cell.addNeighbourIfPresent(board.getCell(row - 1, column - 1));
                cell.addNeighbourIfPresent(board.getCell(row - 1, column));
                cell.addNeighbourIfPresent(board.getCell(row - 1, column + 1));
                cell.addNeighbourIfPresent(board.getCell(row, column - 1));
                cell.addNeighbourIfPresent(board.getCell(row, column + 1));
                cell.addNeighbourIfPresent(board.getCell(row + 1, column - 1));
                cell.addNeighbourIfPresent(board.getCell(row + 1, column));
                cell.addNeighbourIfPresent(board.getCell(row + 1, column + 1));
            }
        }
        return board;
    }

}
