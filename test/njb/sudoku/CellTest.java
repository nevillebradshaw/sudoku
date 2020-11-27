package njb.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CellTest {
    private static final List<Cell> ALL_CELLS = Arrays.asList(new Cell(1), new Cell(2), new Cell(3), new Cell(4), new Cell(5), new Cell(6), new Cell(7), new Cell(8), new Cell(9));
    private static final List<Cell> RANDOM_CELLS = Arrays.asList(new Cell(8), new Cell(2), new Cell(3), new Cell(6), new Cell(1), new Cell(4), new Cell(7), new Cell(9), new Cell(5));

    @Test
    public void checkCellComparator() {
        List<Cell> randomCells = new ArrayList<>(RANDOM_CELLS);
        Collections.sort(randomCells);
        Assert.assertTrue("Comparator incorrect", Objects.deepEquals(randomCells, ALL_CELLS));
    }

    @Test
    public void checkCellCorrectEmptyValueZero() {
        Cell cell = new Cell(0);
        Assert.assertTrue("cell initialised with 0 should be empty", cell.isCellEmpty());
    }

    @Test
    public void checkCellCorrectEmptyValue() {
        Cell cell = new Cell();
        Assert.assertTrue("cell initialised with default constructor should be empty", cell.isCellEmpty());
    }

    @Test
    public void checkCellCorrectNonEmptyValues() {
        Assert.assertSame("cell initialised with 1 should have Symbol ONE   Value", new Cell(1).getValue(), Symbol.ONE.getValue());
        Assert.assertSame("cell initialised with 2 should have Symbol TWO   Value", new Cell(2).getValue(), Symbol.TWO.getValue());
        Assert.assertSame("cell initialised with 3 should have Symbol THREE Value", new Cell(3).getValue(), Symbol.THREE.getValue());
        Assert.assertSame("cell initialised with 4 should have Symbol FOUR  Value", new Cell(4).getValue(), Symbol.FOUR.getValue());
        Assert.assertSame("cell initialised with 5 should have Symbol FIVE  Value", new Cell(5).getValue(), Symbol.FIVE.getValue());
        Assert.assertSame("cell initialised with 6 should have Symbol SIX   Value", new Cell(6).getValue(), Symbol.SIX.getValue());
        Assert.assertSame("cell initialised with 7 should have Symbol SEVEN Value", new Cell(7).getValue(), Symbol.SEVEN.getValue());
        Assert.assertSame("cell initialised with 8 should have Symbol EIGHT Value", new Cell(8).getValue(), Symbol.EIGHT.getValue());
        Assert.assertSame("cell initialised with 9 should have Symbol NINE  Value", new Cell(9).getValue(), Symbol.NINE.getValue());
    }

    @Test(expected = RuntimeException.class)
    public void checkCellIncorrectValue() {
        Cell cell = new Cell(10);
        Assert.fail("cell initialised with 10 should throw exception");
    }
}
