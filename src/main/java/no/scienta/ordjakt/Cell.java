package no.scienta.ordjakt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class Cell {

    private final Position position;
    private final List<Cell> neighbours = new ArrayList<>();
    private char character;
    private boolean visited;

    public Cell(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void addNeighbourIfPresent(Cell neighbour) {
        if (neighbour != null) {
            this.neighbours.add(neighbour);
        }
    }

    public Stream<Cell> getUnvisitedNeighbours() {
        return neighbours.stream().filter(cell -> !cell.visited);
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}

