package njb.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SudokuGridTest {
    private static int GRID_WIDTH = 9;
    private static int GRID_HEIGHT = 9;
    private static List<Cell> rowZero = Arrays.asList(new Cell(0), new Cell(0), new Cell(0), new Cell(2), new Cell(6), new Cell(0), new Cell(7), new Cell(0), new Cell(1));
    private static List<Cell> colEight = Arrays.asList(new Cell(1), new Cell(0), new Cell(0), new Cell(0), new Cell(0), new Cell(8), new Cell(4), new Cell(6), new Cell(0));

    private SudokuGrid sudokuGrid_;

    @Before
    public void init() {
        int[][] grid = {
                {0,0,0,2,6,0,7,0,1},
                {6,8,0,0,7,0,0,9,0},
                {1,9,0,0,0,4,5,0,0},
                {8,2,0,1,0,0,0,4,0},
                {0,0,4,6,0,2,9,0,0},
                {0,5,0,0,0,3,0,2,8},
                {0,0,9,3,0,0,0,7,4},
                {0,4,0,0,5,0,0,3,6},
                {7,0,3,0,1,8,0,0,0}
        };
        sudokuGrid_ = new SudokuGrid(grid);
    }

    @Test
    public void testGetRow() {
        List<Cell> testRow = sudokuGrid_.getRow(0);
        Assert.assertEquals("incorrect row", testRow, rowZero);
    }

    @Test
    public void testGetCol() {
        List<Cell> testCol = sudokuGrid_.getCol(8);
        Assert.assertEquals("incorrect col", testCol, colEight);
    }
}
