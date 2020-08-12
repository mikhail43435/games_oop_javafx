package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void moveThenFigureNotFound() throws OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.C2, Cell.H6);
        } catch (FigureNotFoundException ae) {
            assertThat(ae.toString(), is("ru.job4j.chess.FigureNotFoundException"));
        }
    }

    @Test
    public void moveThenIllegalMove() throws IllegalStateException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.C1, Cell.C2);
        } catch (IllegalStateException | FigureNotFoundException ae) {
            assertThat(ae.toString(), is("java.lang.IllegalStateException: Could not way by diagonal from C1 to C2"));
        }
    }

    @Test
    public void moveThenImpossibleMove() throws IllegalStateException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.D2));
        try {
            logic.move(Cell.C1, Cell.E3);
        } catch (OccupiedCellException | FigureNotFoundException ae) {
            assertThat(ae.toString(), is("ru.job4j.chess.OccupiedCellException"));
        }
    }
}