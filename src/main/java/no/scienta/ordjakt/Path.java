package no.scienta.ordjakt;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class Path {
    private final List<Position> positions;

    public Path(List<Position> positions) {
        this.positions = positions;
    }

    public Path(Position position) {
        this(Collections.singletonList(position));
    }

    public int length() {
        return positions.size();
    }

    public Position tail() {
        return positions.get(positions.size() - 1);
    }

    public String getWord(Board board) {
        StringBuilder builder = new StringBuilder();
        for (Position position : positions) {
            builder.append(board.getCell(position).getCharacter());
        }
        return builder.toString();
    }

    public Path append(Position position) {
        List<Position> positions = new LinkedList<>(this.positions);
        positions.add(position);
        return new Path(positions);
    }
}
