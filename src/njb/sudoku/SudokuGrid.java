package njb.sudoku;

import java.util.ArrayList;
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

    List<Cell> getGroup(int row, int col) {
        List<Cell> groupCells = new ArrayList<>();
        // Group A
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    groupCells.add(cellGrid[i][j]);
                }
            }
        }
        // Group B
        else if (row >= 0 && row <= 2 && col >= 3 && col <= 5) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 3; j <= 5; j++) {
                    groupCells.add(cellGrid[i][j]);
                }
            }
        }
        // Group C
        else if (row >= 0 && row <= 2 && col >= 6 && col <= 8) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 6; j <= 8; j++) {
                    groupCells.add(cellGrid[i][j]);
                }
            }
        }
        // Group D
        else if (row >= 3 && row <= 5 && col >= 0 && col <= 2) {
            for (int i = 3; i <= 5; i++) {
                for (int j = 0; j <= 2; j++) {
                    groupCells.add(cellGrid[i][j]);
                }
            }
        }
        // Group E
        else if (row >= 3 && row <= 5 && col >= 3 && col <= 5) {
            for (int i = 3; i <= 5; i++) {
                for (int j = 3; j <= 5; j++) {
                    groupCells.add(cellGrid[i][j]);
                }
            }
        }
        // Group F
        else if (row >= 3 && row <= 5 && col >= 6 && col <= 8) {
            for (int i = 3; i <= 5; i++) {
                for (int j = 6; j <= 8; j++) {
                    groupCells.add(cellGrid[i][j]);
                }
            }
        }
        // Group G
        else if (row >= 6 && row <= 8 && col >= 0 && col <= 2) {
            for (int i = 6; i <= 8; i++) {
                for (int j = 0; j <= 2; j++) {
                    groupCells.add(cellGrid[i][j]);
                }
            }
        }
        // Group H
        else if (row >= 6 && row <= 8 && col >= 3 && col <= 5) {
            for (int i = 6; i <= 8; i++) {
                for (int j = 3; j <= 5; j++) {
                    groupCells.add(cellGrid[i][j]);
                }
            }
        }
        // Group I
        else if (row >= 6 && row <= 8 && col >= 6 && col <= 8) {
            for (int i = 6; i <= 8; i++) {
                for (int j = 6; j <= 8; j++) {
                    groupCells.add(cellGrid[i][j]);
                }
            }
        }
        return groupCells;
    }

}
