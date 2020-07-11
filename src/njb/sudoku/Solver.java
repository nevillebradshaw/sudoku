package njb.sudoku;

import java.util.List;

public class Solver {
    SudokuGrid sudokuGrid_;
    static final int[][] GRID = new int[][]{
            {0, 0, 0, 2, 6, 0, 7, 0, 1},
            {6, 8, 0, 0, 7, 0, 0, 9, 0},
            {1, 9, 0, 0, 0, 4, 5, 0, 0},
            {8, 2, 0, 1, 0, 0, 0, 4, 0},
            {0, 0, 4, 6, 0, 2, 9, 0, 0},
            {0, 5, 0, 0, 0, 3, 0, 2, 8},
            {0, 0, 9, 3, 0, 0, 0, 7, 4},
            {0, 4, 0, 0, 5, 0, 0, 3, 6},
            {7, 0, 3, 0, 1, 8, 0, 0, 0}
    };

    public Solver() {
        sudokuGrid_ = new SudokuGrid(GRID);
        Cell[][] cellGrid = sudokuGrid_.getCellGrid();
        int numIterations = 0;
        while (!sudokuGrid_.isSolved() && numIterations++ < 20) {
            for (int i = 0; i < SudokuGrid.GRID_WIDTH; i++) {
                for (int j = 0; j < SudokuGrid.GRID_HEIGHT; j++) {
                    Cell currentCell = cellGrid[i][j];
                    if (currentCell.getSymbol() == null) {
                        currentCell.subtractFromPossibles(sudokuGrid_.getRow(i));
                    }
                    if (currentCell.getSymbol() == null) {
                        currentCell.subtractFromPossibles(sudokuGrid_.getCol(j));
                    }
                    if (currentCell.getSymbol() == null) {
                        currentCell.subtractFromPossibles(sudokuGrid_.getGroup(i,j));
                    }
                }
            }
        }
        if (sudokuGrid_.isSolved()) {
            System.out.println("SOLVED");
        }
    }
}
