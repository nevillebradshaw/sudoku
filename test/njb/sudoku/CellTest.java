package njb.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CellTest {
    private static List<Symbol> ALL_SYMBOLS = new ArrayList<>(Arrays.asList(Symbol.values()));

    @Test
    public void checkCellCorrectEmptyValue() {
        Cell cell = new Cell(0);
        Assert.assertTrue("cell initialised with 0 should have a null Symbol", cell.getSymbol() == null && ALL_SYMBOLS.equals(cell.getPossibleSymbols()));
    }

    @Test
    public void checkCellCorrectNonEmptyValues() {
        Cell cell = new Cell(1);
        Assert.assertSame("cell initialised with 1 should have Symbol == ONE", cell.getSymbol(), Symbol.ONE);
        cell = new Cell(2);
        Assert.assertSame("cell initialised with 2 should have Symbol == TWO", cell.getSymbol(), Symbol.TWO);
        cell = new Cell(3);
        Assert.assertSame("cell initialised with 3 should have Symbol == THREE", cell.getSymbol(), Symbol.THREE);
        cell = new Cell(4);
        Assert.assertSame("cell initialised with 4 should have Symbol == FOUR", cell.getSymbol(), Symbol.FOUR);
        cell = new Cell(5);
        Assert.assertSame("cell initialised with 5 should have Symbol == FIVE", cell.getSymbol(), Symbol.FIVE);
        cell = new Cell(6);
        Assert.assertSame("cell initialised with 6 should have Symbol == SIX", cell.getSymbol(), Symbol.SIX);
        cell = new Cell(7);
        Assert.assertSame("cell initialised with 7 should have Symbol == SEVEN", cell.getSymbol(), Symbol.SEVEN);
        cell = new Cell(8);
        Assert.assertSame("cell initialised with 8 should have Symbol == EIGHT", cell.getSymbol(), Symbol.EIGHT);
        cell = new Cell(9);
        Assert.assertSame("cell initialised with 9 should have Symbol == NINE", cell.getSymbol(), Symbol.NINE);
    }

    @Test(expected = RuntimeException.class)
    public void checkCellIncorrectValue() {
        Cell cell = new Cell(10);
        Assert.fail("cell initialised with 10 should throw exception");
    }
}
