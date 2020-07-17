package njb.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CellTest {
    private static List<Symbol> ALL_SYMBOLS = new ArrayList<>(Arrays.asList(Symbol.values()));
    private static List<Cell> ALL_CELLS = Arrays.asList(new Cell(1), new Cell(2), new Cell(3), new Cell(4), new Cell(5), new Cell(6), new Cell(7), new Cell(8), new Cell(9));
    private static List<Cell> RANDOM_CELLS = Arrays.asList(new Cell(8), new Cell(2), new Cell(3), new Cell(6), new Cell(1), new Cell(4), new Cell(7), new Cell(9), new Cell(5));

    @Test
    public void checkCellComparator() {
        List<Cell> randomCells = new ArrayList<>(RANDOM_CELLS);
        Collections.sort(randomCells);
        Assert.assertTrue("Comparator incorrect", Objects.deepEquals(randomCells, ALL_CELLS));
    }

    @Test
    public void checkCellCorrectEmptyValue() {
        Cell cell = new Cell(0);
        Assert.assertTrue("cell initialised with 0 should have a null Symbol", cell.getSymbol() == null && ALL_SYMBOLS.equals(cell.getPossibleSymbols()));
    }

    @Test
    public void checkCellCorrectNonEmptyValues() {
        Assert.assertSame("cell initialised with 1 should have Symbol == ONE", new Cell(1).getSymbol(), Symbol.ONE);
        Assert.assertSame("cell initialised with 2 should have Symbol == TWO", new Cell(2).getSymbol(), Symbol.TWO);
        Assert.assertSame("cell initialised with 3 should have Symbol == THREE", new Cell(3).getSymbol(), Symbol.THREE);
        Assert.assertSame("cell initialised with 4 should have Symbol == FOUR", new Cell(4).getSymbol(), Symbol.FOUR);
        Assert.assertSame("cell initialised with 5 should have Symbol == FIVE", new Cell(5).getSymbol(), Symbol.FIVE);
        Assert.assertSame("cell initialised with 6 should have Symbol == SIX", new Cell(6).getSymbol(), Symbol.SIX);
        Assert.assertSame("cell initialised with 7 should have Symbol == SEVEN", new Cell(7).getSymbol(), Symbol.SEVEN);
        Assert.assertSame("cell initialised with 8 should have Symbol == EIGHT", new Cell(8).getSymbol(), Symbol.EIGHT);
        Assert.assertSame("cell initialised with 9 should have Symbol == NINE", new Cell(9).getSymbol(), Symbol.NINE);
    }

    @Test(expected = RuntimeException.class)
    public void checkCellIncorrectValue() {
        Cell cell = new Cell(10);
        Assert.fail("cell initialised with 10 should throw exception");
    }
}
