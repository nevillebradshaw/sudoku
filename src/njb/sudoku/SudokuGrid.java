package njb.sudoku;

import java.util.*;

/**
 * @author nevillebradshaw@hotmail.com
 * <p>
 * This class represents the Grid of Cells
 * It provides methods to indicate if the Grid has been solved and if it isValid
 * i.e. current cell values conform to the rules of sudoku.
 */
class SudokuGrid {
    static int GRID_SIZE = 9;

    private Cell[][] cellGrid_ = new Cell[GRID_SIZE][GRID_SIZE];

    SudokuGrid(int[][] grid) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                cellGrid_[i][j] = new Cell(grid[i][j]);
            }
        }
    }

    boolean isValid() {
        boolean isVal = true;
        for (int i = 0; i < GRID_SIZE; i++) {
            List<Cell> rowList = getSolvedRowCells(i);
            if (!isCellListValid(rowList)) {
                isVal = false;
                break;
            }
        }

        if (isVal) {
            for (int j = 0; j < GRID_SIZE; j++) {
                List<Cell> colList = getSolvedColCells(j);
                if (!isCellListValid(colList)) {
                    isVal = false;
                    break;
                }
            }
        }

        if (isVal) {
            int[] idx = {0, 3, 6};
            for (int i : idx) {
                for (int j : idx) {
                    List<Cell> groupList = getSolvedGroupCells(i, j);
                    if (!isCellListValid(groupList)) {
                        isVal = false;
                        break;
                    }
                }
            }
        }

        return isVal;
    }

    private boolean isCellListValid(List<Cell> cellList) {
        boolean valid = true;
        Set<Cell> cellSet = new HashSet<>(cellList);
        if (cellList.size() != cellSet.size()) {
            valid = false;
        }
        return valid;
    }

    boolean isSolved() {
        boolean solved = true;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (cellGrid_[i][j].getSymbol() == null) {
                    solved = false;
                    break;
                }
            }
        }
        return solved;
    }

    Cell[][] getCellGrid() {
        return cellGrid_;
    }

    List<Cell> getRowCells(int i) {
        return new ArrayList<>(Arrays.asList(cellGrid_[i]));
    }

    private List<Cell> getSolvedRowCells(int i) {
        return getSolvedCells(getRowCells(i));
    }

    List<Cell> getColCells(int j) {
        Cell[] col = new Cell[GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            col[i] = cellGrid_[i][j];
        }
        return new ArrayList<>(Arrays.asList(col));
    }

    private List<Cell> getSolvedColCells(int j) {
        return getSolvedCells(getColCells(j));
    }

    List<Cell> getGroupCells(int row, int col) {
        int rowMin = row - row % 3;
        int rowMax = rowMin + 2;
        int colMin = col - col % 3;
        int colMax = colMin + 2;

        return getGroup(rowMin, rowMax, colMin, colMax);
    }

    private List<Cell> getGroup(int rowMin, int rowMax, int colMin, int colMax) {
        List<Cell> groupCells = new ArrayList<>();
        for (int i = rowMin; i <= rowMax; i++) {
            for (int j = colMin; j <= colMax; j++) {
                groupCells.add(cellGrid_[i][j]);
            }
        }
        return groupCells;
    }

    private List<Cell> getSolvedGroupCells(int i, int j) {
        return getSolvedCells(getGroupCells(i, j));
    }

    private List<Cell> getSolvedCells(List<Cell> allCells) {
        List<Cell> cellList = new ArrayList<>();
        for (Cell cell : allCells) {
            if (cell.getSymbol() != null) {
                cellList.add(cell);
            }
        }
        return cellList;
    }
}
