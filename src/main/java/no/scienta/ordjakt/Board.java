package no.scienta.ordjakt;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class Board implements Iterable<Cell> {

    private final Map<Position, Cell> cells = new LinkedHashMap<>();

    public Board(int rows, int columns, String characters) {
        int i = 0;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Position position = Position.of(row, column);
                cells.put(position, new Cell(position, characters.charAt(i++)));
            }
        }
    }

    public Cell getCell(Position position) {
        return cells.get(position);
    }

    public Cell getCell(int row, int column) {
        return getCell(Position.of(row, column));
    }

    @Override
    public Iterator<Cell> iterator() {
        return cells.values().iterator();
    }
}
