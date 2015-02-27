package no.scienta.ordjakt;

import java.util.Objects;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class Position {
    private final int row;
    private final int column;

    private Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Position of(int row, int column) {
        return new Position(row, column);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position position = (Position) o;
        return column == position.column && row == position.row;

    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
