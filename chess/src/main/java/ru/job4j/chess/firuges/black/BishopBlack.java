package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!this.isDiagonal(source, dest)) {
            throw new IllegalStateException(String.format("Could not way by diagonal from %s to %s", source, dest));
        }
        int size = Math.abs(Math.abs(dest.getX() - source.getX()) - 1);
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - source.getX()) > 0 ? 1: -1;
        int deltaY = (dest.getY() - source.getY()) > 0 ? 1: -1;
        //Cell previousCell = source;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.getX() + deltaX , source.getY() + deltaY);
            source = steps[index];
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int xDistance = Math.abs(source.getX() - dest.getX());
        int yDistance = Math.abs(source.getY() - dest.getY());
        return xDistance == yDistance;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
