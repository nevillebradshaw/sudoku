package njb.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SudokuGridTest {
    private static int GRID_WIDTH = 9;
    private static int GRID_HEIGHT = 9;
    private static List<Cell> ROW_ZERO = Arrays.asList(new Cell(0), new Cell(0), new Cell(0), new Cell(2), new Cell(6), new Cell(0), new Cell(7), new Cell(0), new Cell(1));
    private static List<Cell> COL_EIGHT = Arrays.asList(new Cell(1), new Cell(0), new Cell(0), new Cell(0), new Cell(0), new Cell(8), new Cell(4), new Cell(6), new Cell(0));
    private static List<Cell> GROUP_A = Arrays.asList(new Cell(0), new Cell(0), new Cell(0), new Cell(6), new Cell(8), new Cell(0), new Cell(1), new Cell(9), new Cell(0));
    private static List<Cell> GROUP_B = Arrays.asList(new Cell(2), new Cell(6), new Cell(0), new Cell(0), new Cell(7), new Cell(0), new Cell(0), new Cell(0), new Cell(4));
    private static List<Cell> GROUP_C = Arrays.asList(new Cell(7), new Cell(0), new Cell(1), new Cell(0), new Cell(9), new Cell(0), new Cell(5), new Cell(0), new Cell(0));
    private static List<Cell> GROUP_D = Arrays.asList(new Cell(8), new Cell(2), new Cell(0), new Cell(0), new Cell(0), new Cell(4), new Cell(0), new Cell(5), new Cell(0));
    private static List<Cell> GROUP_E = Arrays.asList(new Cell(1), new Cell(0), new Cell(0), new Cell(6), new Cell(0), new Cell(2), new Cell(0), new Cell(0), new Cell(3));
    private static List<Cell> GROUP_F = Arrays.asList(new Cell(0), new Cell(4), new Cell(0), new Cell(9), new Cell(0), new Cell(0), new Cell(0), new Cell(2), new Cell(8));
    private static List<Cell> GROUP_G = Arrays.asList(new Cell(0), new Cell(0), new Cell(9), new Cell(0), new Cell(4), new Cell(0), new Cell(7), new Cell(0), new Cell(3));
    private static List<Cell> GROUP_H = Arrays.asList(new Cell(3), new Cell(0), new Cell(0), new Cell(0), new Cell(5), new Cell(0), new Cell(0), new Cell(1), new Cell(8));
    private static List<Cell> GROUP_I = Arrays.asList(new Cell(0), new Cell(7), new Cell(4), new Cell(0), new Cell(3), new Cell(6), new Cell(0), new Cell(0), new Cell(0));

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
        Assert.assertEquals("incorrect row", testRow, ROW_ZERO);
    }

    @Test
    public void testGetCol() {
        List<Cell> testCol = sudokuGrid_.getCol(8);
        Assert.assertEquals("incorrect col", testCol, COL_EIGHT);
    }

    @Test
    public void testGetGroupA() {
        List<Cell> groupA = sudokuGrid_.getGroup(0, 0);
        Assert.assertEquals("incorrect group A", groupA, GROUP_A);
        groupA = sudokuGrid_.getGroup(0, 1);
        Assert.assertEquals("incorrect group A", groupA, GROUP_A);
        groupA = sudokuGrid_.getGroup(0, 2);
        Assert.assertEquals("incorrect group A", groupA, GROUP_A);
        groupA = sudokuGrid_.getGroup(1, 0);
        Assert.assertEquals("incorrect group A", groupA, GROUP_A);
        groupA = sudokuGrid_.getGroup(1, 1);
        Assert.assertEquals("incorrect group A", groupA, GROUP_A);
        groupA = sudokuGrid_.getGroup(1, 2);
        Assert.assertEquals("incorrect group A", groupA, GROUP_A);
        groupA = sudokuGrid_.getGroup(2, 0);
        Assert.assertEquals("incorrect group A", groupA, GROUP_A);
        groupA = sudokuGrid_.getGroup(2, 1);
        Assert.assertEquals("incorrect group A", groupA, GROUP_A);
        groupA = sudokuGrid_.getGroup(2, 2);
        Assert.assertEquals("incorrect group A", groupA, GROUP_A);
    }

    @Test
    public void testGetGroupB() {
        List<Cell> groupB = sudokuGrid_.getGroup(0, 3);
        Assert.assertEquals("incorrect group B", groupB, GROUP_B);
        groupB = sudokuGrid_.getGroup(0, 4);
        Assert.assertEquals("incorrect group B", groupB, GROUP_B);
        groupB = sudokuGrid_.getGroup(0, 5);
        Assert.assertEquals("incorrect group B", groupB, GROUP_B);
        groupB = sudokuGrid_.getGroup(1, 3);
        Assert.assertEquals("incorrect group B", groupB, GROUP_B);
        groupB = sudokuGrid_.getGroup(1, 4);
        Assert.assertEquals("incorrect group B", groupB, GROUP_B);
        groupB = sudokuGrid_.getGroup(1, 5);
        Assert.assertEquals("incorrect group B", groupB, GROUP_B);
        groupB = sudokuGrid_.getGroup(2, 3);
        Assert.assertEquals("incorrect group B", groupB, GROUP_B);
        groupB = sudokuGrid_.getGroup(2, 4);
        Assert.assertEquals("incorrect group B", groupB, GROUP_B);
        groupB = sudokuGrid_.getGroup(2, 5);
        Assert.assertEquals("incorrect group B", groupB, GROUP_B);
    }

    @Test
    public void testGetGroupC() {
        List<Cell> groupC = sudokuGrid_.getGroup(0, 6);
        Assert.assertEquals("incorrect group C", groupC, GROUP_C);
        groupC = sudokuGrid_.getGroup(0, 7);
        Assert.assertEquals("incorrect group C", groupC, GROUP_C);
        groupC = sudokuGrid_.getGroup(0, 8);
        Assert.assertEquals("incorrect group C", groupC, GROUP_C);
        groupC = sudokuGrid_.getGroup(1, 6);
        Assert.assertEquals("incorrect group C", groupC, GROUP_C);
        groupC = sudokuGrid_.getGroup(1, 7);
        Assert.assertEquals("incorrect group C", groupC, GROUP_C);
        groupC = sudokuGrid_.getGroup(1, 8);
        Assert.assertEquals("incorrect group C", groupC, GROUP_C);
        groupC = sudokuGrid_.getGroup(2, 6);
        Assert.assertEquals("incorrect group C", groupC, GROUP_C);
        groupC = sudokuGrid_.getGroup(2, 7);
        Assert.assertEquals("incorrect group C", groupC, GROUP_C);
        groupC = sudokuGrid_.getGroup(2, 8);
        Assert.assertEquals("incorrect group C", groupC, GROUP_C);
    }

    @Test
    public void testGetGroupD() {
        List<Cell> groupD = sudokuGrid_.getGroup(3, 0);
        Assert.assertEquals("incorrect group D", groupD, GROUP_D);
        groupD = sudokuGrid_.getGroup(3, 1);
        Assert.assertEquals("incorrect group D", groupD, GROUP_D);
        groupD = sudokuGrid_.getGroup(3, 2);
        Assert.assertEquals("incorrect group D", groupD, GROUP_D);
        groupD = sudokuGrid_.getGroup(4, 0);
        Assert.assertEquals("incorrect group D", groupD, GROUP_D);
        groupD = sudokuGrid_.getGroup(4, 1);
        Assert.assertEquals("incorrect group D", groupD, GROUP_D);
        groupD = sudokuGrid_.getGroup(4, 2);
        Assert.assertEquals("incorrect group D", groupD, GROUP_D);
        groupD = sudokuGrid_.getGroup(5, 0);
        Assert.assertEquals("incorrect group D", groupD, GROUP_D);
        groupD = sudokuGrid_.getGroup(5, 1);
        Assert.assertEquals("incorrect group D", groupD, GROUP_D);
        groupD = sudokuGrid_.getGroup(5, 2);
        Assert.assertEquals("incorrect group D", groupD, GROUP_D);
    }

    @Test
    public void testGetGroupE() {
        List<Cell> groupE = sudokuGrid_.getGroup(3, 3);
        Assert.assertEquals("incorrect group E", groupE, GROUP_E);
        groupE = sudokuGrid_.getGroup(3, 4);
        Assert.assertEquals("incorrect group E", groupE, GROUP_E);
        groupE = sudokuGrid_.getGroup(3, 5);
        Assert.assertEquals("incorrect group E", groupE, GROUP_E);
        groupE = sudokuGrid_.getGroup(4, 3);
        Assert.assertEquals("incorrect group E", groupE, GROUP_E);
        groupE = sudokuGrid_.getGroup(4, 4);
        Assert.assertEquals("incorrect group E", groupE, GROUP_E);
        groupE = sudokuGrid_.getGroup(4, 5);
        Assert.assertEquals("incorrect group E", groupE, GROUP_E);
        groupE = sudokuGrid_.getGroup(5, 3);
        Assert.assertEquals("incorrect group E", groupE, GROUP_E);
        groupE = sudokuGrid_.getGroup(5, 4);
        Assert.assertEquals("incorrect group E", groupE, GROUP_E);
        groupE = sudokuGrid_.getGroup(5, 5);
        Assert.assertEquals("incorrect group E", groupE, GROUP_E);
    }

    @Test
    public void testGetGroupF() {
        List<Cell> groupF = sudokuGrid_.getGroup(3, 6);
        Assert.assertEquals("incorrect group F", groupF, GROUP_F);
        groupF = sudokuGrid_.getGroup(3, 7);
        Assert.assertEquals("incorrect group F", groupF, GROUP_F);
        groupF = sudokuGrid_.getGroup(3, 8);
        Assert.assertEquals("incorrect group F", groupF, GROUP_F);
        groupF = sudokuGrid_.getGroup(4, 6);
        Assert.assertEquals("incorrect group F", groupF, GROUP_F);
        groupF = sudokuGrid_.getGroup(4, 7);
        Assert.assertEquals("incorrect group F", groupF, GROUP_F);
        groupF = sudokuGrid_.getGroup(4, 8);
        Assert.assertEquals("incorrect group F", groupF, GROUP_F);
        groupF = sudokuGrid_.getGroup(5, 6);
        Assert.assertEquals("incorrect group F", groupF, GROUP_F);
        groupF = sudokuGrid_.getGroup(5, 7);
        Assert.assertEquals("incorrect group F", groupF, GROUP_F);
        groupF = sudokuGrid_.getGroup(5, 8);
        Assert.assertEquals("incorrect group F", groupF, GROUP_F);
    }

    @Test
    public void testGetGroupG() {
        List<Cell> groupG= sudokuGrid_.getGroup(6, 0);
        Assert.assertEquals("incorrect group G", groupG, GROUP_G);
        groupG = sudokuGrid_.getGroup(6, 1);
        Assert.assertEquals("incorrect group G", groupG, GROUP_G);
        groupG = sudokuGrid_.getGroup(6, 2);
        Assert.assertEquals("incorrect group G", groupG, GROUP_G);
        groupG = sudokuGrid_.getGroup(7, 0);
        Assert.assertEquals("incorrect group G", groupG, GROUP_G);
        groupG = sudokuGrid_.getGroup(7, 1);
        Assert.assertEquals("incorrect group G", groupG, GROUP_G);
        groupG = sudokuGrid_.getGroup(7, 2);
        Assert.assertEquals("incorrect group G", groupG, GROUP_G);
        groupG = sudokuGrid_.getGroup(8, 0);
        Assert.assertEquals("incorrect group G", groupG, GROUP_G);
        groupG = sudokuGrid_.getGroup(8, 1);
        Assert.assertEquals("incorrect group G", groupG, GROUP_G);
        groupG = sudokuGrid_.getGroup(8, 2);
        Assert.assertEquals("incorrect group G", groupG, GROUP_G);
    }

    @Test
    public void testGetGroupH() {
        List<Cell> groupH= sudokuGrid_.getGroup(6, 3);
        Assert.assertEquals("incorrect group G", groupH, GROUP_H);
        groupH = sudokuGrid_.getGroup(6, 4);
        Assert.assertEquals("incorrect group G", groupH, GROUP_H);
        groupH = sudokuGrid_.getGroup(6, 5);
        Assert.assertEquals("incorrect group G", groupH, GROUP_H);
        groupH = sudokuGrid_.getGroup(7, 3);
        Assert.assertEquals("incorrect group G", groupH, GROUP_H);
        groupH = sudokuGrid_.getGroup(7, 4);
        Assert.assertEquals("incorrect group G", groupH, GROUP_H);
        groupH = sudokuGrid_.getGroup(7, 5);
        Assert.assertEquals("incorrect group G", groupH, GROUP_H);
        groupH = sudokuGrid_.getGroup(8, 3);
        Assert.assertEquals("incorrect group G", groupH, GROUP_H);
        groupH = sudokuGrid_.getGroup(8, 4);
        Assert.assertEquals("incorrect group G", groupH, GROUP_H);
        groupH = sudokuGrid_.getGroup(8, 5);
        Assert.assertEquals("incorrect group G", groupH, GROUP_H);
    }

    @Test
    public void testGetGroupI() {
        List<Cell> groupI= sudokuGrid_.getGroup(6, 6);
        Assert.assertEquals("incorrect group G", groupI, GROUP_I);
        groupI = sudokuGrid_.getGroup(6, 7);
        Assert.assertEquals("incorrect group G", groupI, GROUP_I);
        groupI = sudokuGrid_.getGroup(6, 8);
        Assert.assertEquals("incorrect group G", groupI, GROUP_I);
        groupI = sudokuGrid_.getGroup(7, 6);
        Assert.assertEquals("incorrect group G", groupI, GROUP_I);
        groupI = sudokuGrid_.getGroup(7, 7);
        Assert.assertEquals("incorrect group G", groupI, GROUP_I);
        groupI = sudokuGrid_.getGroup(7, 8);
        Assert.assertEquals("incorrect group G", groupI, GROUP_I);
        groupI = sudokuGrid_.getGroup(8, 6);
        Assert.assertEquals("incorrect group G", groupI, GROUP_I);
        groupI = sudokuGrid_.getGroup(8, 7);
        Assert.assertEquals("incorrect group G", groupI, GROUP_I);
        groupI = sudokuGrid_.getGroup(8, 8);
        Assert.assertEquals("incorrect group G", groupI, GROUP_I);
    }
}
