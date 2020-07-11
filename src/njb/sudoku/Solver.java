package njb.sudoku;

/**
 * @author nevillebradshaw@hotmail.com
 *
 * This Solver attempts to find the Sudoku solution to the grid passed in to the constructor.
 * This solver iterates through each Cell in the Grid each of which keeps a tally of the possible values
 * the cell may have based on the actual resolved values in the current row, column and local group.
 * (the 3 x 3 array the current Cell resides in)
 * If a solution is not found within MAX_ITERATIONS attempts the solver simply prints out a message
 * to that effect.
 * If a solution is found it is pretty printed to the console
 * At present this solver doesn't validate the grid before attempting to solve it.
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
            for (int i = 0; i < SudokuGrid.GRID_WIDTH; i++) {
                for (int j = 0; j < SudokuGrid.GRID_HEIGHT; j++) {
                    Cell currentCell = sudokuGrid_.getCellGrid()[i][j];
                    currentCell.removeFromPossibleSymbols(sudokuGrid_.getRow(i));
                    currentCell.removeFromPossibleSymbols(sudokuGrid_.getCol(j));
                    currentCell.removeFromPossibleSymbols(sudokuGrid_.getGroup(i, j));
                }
            }
        }

        if (sudokuGrid_.isSolved()) {
            System.out.println("Solution");
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
