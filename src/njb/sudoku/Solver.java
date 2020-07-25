package njb.sudoku;

/**
 * @author nevillebradshaw@hotmail.com
 * <p>
 * This Solver attempts to find the Sudoku solution to the grid passed in to the constructor.
 */
public class Solver {
    private SudokuGrid sudokuGrid_;
    private int[][] solution = new int[SudokuGrid.GRID_WIDTH][SudokuGrid.GRID_HEIGHT];

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
            for (int i = 0; i < SudokuGrid.GRID_WIDTH; i++) {
                for (int j = 0; j < SudokuGrid.GRID_HEIGHT; j++) {
                    Cell currentCell = sudokuGrid_.getCellGrid()[i][j];
                    solution[i][j] = currentCell.getSymbol().getValue();
                    System.out.print(currentCell.getSymbol() + " ");
                }
                System.out.println(" ");
            }
            System.out.println("-----------------");
        } else {
            System.out.println("Unable to find a solution for this grid.");
        }
    }

    boolean solve() {
        for (int i = 0; i < SudokuGrid.GRID_WIDTH; i++) {
            for (int j = 0; j < SudokuGrid.GRID_HEIGHT; j++) {
                if (sudokuGrid_.getCellGrid()[i][j].getSymbol() == null) {
                    for (Symbol symbol : Symbol.values()) {
                        sudokuGrid_.getCellGrid()[i][j] = new Cell(symbol);
                        if (sudokuGrid_.isValid()) {
                            if (solve()) {
                                return true;
                            } else {
                                sudokuGrid_.getCellGrid()[i][j] = new Cell();
                            }
                        } else {
                            sudokuGrid_.getCellGrid()[i][j] = new Cell();
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
