package njb.sudoku;

/**
 * @author nevillebradshaw@hotmail.com
 * <p>
 * This Solver attempts to find the solution to the Sudoku grid passed in to the constructor.
 */
public class Solver {
    private final SudokuGrid sudokuGrid_;
    private final int[][] solution = new int[SudokuGrid.GRID_SIZE][SudokuGrid.GRID_SIZE];

    /**
     * @param grid A 9x9 integer array specifying the sudoku grid.
     *             Each element should either be an integer 1 to 9
     *             or 0 which represents the missing values to be determined here.
     */
    public Solver(int[][] grid) {
        sudokuGrid_ = new SudokuGrid(grid);

        solve();

        if (sudokuGrid_.isSolved()) {
            System.out.println("Solution");
            System.out.println("-----------------");
            for (int i = 0; i < SudokuGrid.GRID_SIZE; i++) {
                for (int j = 0; j < SudokuGrid.GRID_SIZE; j++) {
                    Cell currentCell = sudokuGrid_.getCell(i, j);
                    solution[i][j] = currentCell.getValue();
                    System.out.print(currentCell + " ");
                }
                System.out.println(" ");
            }
            System.out.println("-----------------");
        } else {
            System.out.println("Unable to find a solution for this grid.");
        }
    }

    boolean solve() {
        for (int i = 0; i < SudokuGrid.GRID_SIZE; i++) {
            for (int j = 0; j < SudokuGrid.GRID_SIZE; j++) {
                if (sudokuGrid_.getCell(i, j).isCellEmpty()) {
                    for (Symbol symbol : Symbol.values()) {
                        sudokuGrid_.setCell(i, j, new Cell(symbol));
                        if (!sudokuGrid_.isValid(i, j)) {
                            sudokuGrid_.setCell(i, j, new Cell());
                        } else {
                            if (solve()) {
                                return true;
                            } else {
                                sudokuGrid_.setCell(i, j, new Cell());
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] getSolution() {
        return solution;
    }
}