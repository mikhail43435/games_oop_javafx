package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void positionTest() {
        BishopBlack bb = new BishopBlack(Cell.C8);
        Cell bbposition = bb.position();
        assertThat(Cell.C8, is(bbposition));

    }

    @Test
    public void copyTest() {
        BishopBlack bb = new BishopBlack(Cell.C8);
        assertThat(bb.copy(Cell.D7).position(), is(Cell.D7));
    }

    @Test
    public void wayTestC1H6() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] wayCells = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        bb.way(Cell.C1, Cell.H6);
        assertThat(bb.way(Cell.C1, Cell.H6), is(wayCells));
    }

    @Test
    public void wayTestB7A6() {
        BishopBlack bb = new BishopBlack(Cell.B7);
        Cell[] wayCells = new Cell[] { };
        assertThat(bb.way(Cell.B7, Cell.A8), is(wayCells));
    }

    @Test
    public void wrongMoveTest() {
        BishopBlack bb = new BishopBlack(Cell.B7);
        Cell[] wayCells = new Cell[] { };
        assertThat(bb.way(Cell.B7, Cell.A8), is(wayCells));
    }
}