package njb.sudoku;

import java.util.Arrays;
import java.util.List;

class SudokuGrid {
    private static int GRID_WIDTH = 9;
    private static int GRID_HEIGHT = 9;

    private Cell[][] cellGrid = new Cell[GRID_WIDTH][GRID_HEIGHT];

    SudokuGrid(int[][] grid) {
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                cellGrid[i][j] = new Cell(grid[i][j]);
//                System.out.println(cellGrid[i][j]);
            }
        }
    }

    List<Cell> getRow(int i) {
        return Arrays.asList(cellGrid[i]);
    }

    List<Cell> getCol(int j) {
        Cell[] col = new Cell[GRID_HEIGHT];
        for (int i = 0; i < GRID_HEIGHT; i++) {
            col[i] = cellGrid[i][j];
        }
        return Arrays.asList(col);
    }

}
