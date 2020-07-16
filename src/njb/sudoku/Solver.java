package njb.sudoku;

/**
 * @author nevillebradshaw@hotmail.com
 *
 * This Solver attempts to find the Sudoku solution to the grid passed in to the constructor.
 * This solver iterates through each Cell in the Grid each of which keeps a tally of the possible values
 * the cell may have based on the actual resolved values in the current row, column and group.
 * (the 3 x 3 array the current Cell resides in)
 * If a solution is not found within MAX_ITERATIONS attempts the solver simply prints out a message
 * to that effect.
 * If a solution is found it is pretty printed to the console.
 *
 */
public class Solver {
    private static int MAX_ITERATIONS = 20;
    private int[][] solution = new int[SudokuGrid.GRID_WIDTH][SudokuGrid.GRID_HEIGHT];

    /**
     *
     * @param grid  A 9x9 integer array specifying the sudoku grid.
     *              Each element should either be an integer 1 to 9
     *              or 0 which represents the missing values to be determined here.
     */
    public Solver(int[][] grid) {
        SudokuGrid sudokuGrid_ = new SudokuGrid(grid);
        int numIterations = 0;
        while (!sudokuGrid_.isSolved() && numIterations++ < MAX_ITERATIONS) {
            boolean gridChangedInThisIteration = false;
            for (int i = 0; i < SudokuGrid.GRID_WIDTH; i++) {
                for (int j = 0; j < SudokuGrid.GRID_HEIGHT; j++) {
                    //Easy Grids
                    Cell currentCell = sudokuGrid_.getCellGrid()[i][j];
                    boolean rowChanged = currentCell.removeFromPossibleSymbols(sudokuGrid_.getRowCells(i));
                    boolean colChanged = currentCell.removeFromPossibleSymbols(sudokuGrid_.getColCells(j));
                    boolean groupChanged = currentCell.removeFromPossibleSymbols(sudokuGrid_.getGroupCells(i, j));
                    if (rowChanged || colChanged || groupChanged) {
                        gridChangedInThisIteration = true;
                    }
                }
            }
            if (!gridChangedInThisIteration) {
                // Hard Grids
                sudokuGrid_ = solve(sudokuGrid_);
            }
        }

        if (sudokuGrid_.isSolved()) {
            System.out.println("Solution found in " + numIterations + " iterations");
            System.out.println("-----------------");
            for (int i = 0; i < SudokuGrid.GRID_WIDTH; i++) {
                for (int j = 0; j < SudokuGrid.GRID_HEIGHT; j++) {
                    Cell currentCell = sudokuGrid_.getCellGrid()[i][j];
                    solution[i][j] = currentCell.getSymbol().getValue();
                    System.out.print(currentCell.getSymbol() + " ");
                }
                System.out.println(" ");
            }
            System.out.println("-----------------");
        }
        else {
            System.out.println("Unable to find a solution for this grid in " + numIterations + " iterations.");
        }
    }

    SudokuGrid solve(SudokuGrid sudokuGrid) {
        if (sudokuGrid.isSolved()) {
            return sudokuGrid;
        }
        else {
            int nextUnresolvedCellRowIndex = 0;
            int nextUnresolvedCellColIndex = 0;

            loop : for (int i = 0; i < SudokuGrid.GRID_WIDTH; i++) {
                for (int j = 0; j < SudokuGrid.GRID_HEIGHT; j++) {
                    Cell currentCell = sudokuGrid.getCellGrid()[i][j];
                    if (currentCell.getSymbol() == null) {
                        nextUnresolvedCellRowIndex = i;
                        nextUnresolvedCellColIndex = j;
                        break loop;
                    }
                }
            }

            Symbol trySymbol = Symbol.ONE;
            sudokuGrid.getCellGrid()[nextUnresolvedCellRowIndex][nextUnresolvedCellColIndex] = new Cell(trySymbol);
            while (!sudokuGrid.isValid() && trySymbol != Symbol.NINE) {
                if (trySymbol == Symbol.ONE) {
                    trySymbol = Symbol.TWO;
                }
                else if (trySymbol == Symbol.TWO) {
                    trySymbol = Symbol.THREE;
                }
                else if (trySymbol == Symbol.THREE) {
                    trySymbol = Symbol.FOUR;
                }
                else if (trySymbol == Symbol.FOUR) {
                    trySymbol = Symbol.FIVE;
                }
                else if (trySymbol == Symbol.FIVE) {
                    trySymbol = Symbol.SIX;
                }
                else if (trySymbol == Symbol.SIX) {
                    trySymbol = Symbol.SEVEN;
                }
                else if (trySymbol == Symbol.SEVEN) {
                    trySymbol = Symbol.EIGHT;
                }
                else {
                    trySymbol = Symbol.NINE;
                }

                sudokuGrid.getCellGrid()[nextUnresolvedCellRowIndex][nextUnresolvedCellColIndex] = new Cell(trySymbol);
            }
            if (sudokuGrid.isValid()) {
                solve(sudokuGrid);
            }
            else {
                return sudokuGrid;
            }
        }
        return sudokuGrid;
    }

    public int[][] getSolution() {
        return solution;
    }
}
