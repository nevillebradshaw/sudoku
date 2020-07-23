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
     * A boolean value which may be changed once and once only.
     */
    private class BooleanLatch {
        private boolean value_;
        private boolean isValueChanged_;

        public BooleanLatch(boolean value) {
            value_ = value;
        }

        public boolean isValue() {
            return value_;
        }

        public void setValue(boolean value) {
            if (!isValueChanged_) {
                isValueChanged_ = true;
                value_ = value;
            }
        }
    }

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
            BooleanLatch gridChangedInThisIteration = new BooleanLatch(false);
            for (int i = 0; i < SudokuGrid.GRID_WIDTH; i++) {
                for (int j = 0; j < SudokuGrid.GRID_HEIGHT; j++) {
                    //Easy Grids
                    Cell currentCell = sudokuGrid_.getCellGrid()[i][j];
                    gridChangedInThisIteration.setValue(currentCell.removeFromPossibleSymbols(sudokuGrid_.getRowCells(i)));
                    gridChangedInThisIteration.setValue(currentCell.removeFromPossibleSymbols(sudokuGrid_.getColCells(j)));
                    gridChangedInThisIteration.setValue(currentCell.removeFromPossibleSymbols(sudokuGrid_.getGroupCells(i, j)));
                }
            }
            if (!gridChangedInThisIteration.isValue()) {
                break;
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

    public int[][] getSolution() {
        return solution;
    }
}
