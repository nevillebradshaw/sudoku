package njb.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author nevillebradshaw@hotmail.com
 * <p>
 * This class represents the Grid of Cells
 * It provides methods to indicate if the Grid has been solved and if it is valid
 * i.e. that the current cell values conform to the rules of sudoku.
 */
class SudokuGrid {
    static int GRID_SIZE = 9;

    private Cell[][] cellGrid_ = new Cell[GRID_SIZE][GRID_SIZE];

    SudokuGrid(int[][] grid) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                setCell(i, j, new Cell(grid[i][j]));
            }
        }
    }

    Cell getCell(int i, int j) {
        return cellGrid_[i][j];
    }

    void setCell(int i, int j, Cell cell) {
        cellGrid_[i][j] = cell;
    }

    boolean isValid(int i, int j) {
        boolean isVal = true;
        if (!isCellListValid(getSolvedRowCells(i))) {
            isVal = false;
        }

        if (isVal) {
            if (!isCellListValid(getSolvedColCells(j))) {
                isVal = false;
            }
        }

        if (isVal) {
            if (!isCellListValid(getSolvedGroupCells(i, j))) {
                isVal = false;
            }
        }
        return isVal;
    }

    boolean isValid() {
        boolean isVal = true;
        for (int i = 0; i < GRID_SIZE; i++) {
            if (!isCellListValid(getSolvedRowCells(i))) {
                isVal = false;
                break;
            }
        }

        if (isVal) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (!isCellListValid(getSolvedColCells(j))) {
                    isVal = false;
                    break;
                }
            }
        }

        if (isVal) {
            int[] idx = {0, 3, 6};
            for (int i : idx) {
                for (int j : idx) {
                    if (!isCellListValid(getSolvedGroupCells(i, j))) {
                        isVal = false;
                        break;
                    }
                }
            }
        }

        return isVal;
    }

    private boolean isCellListValid(List<Cell> cellList) {
        return cellList.size() == new HashSet<>(cellList).size();
    }

    boolean isSolved() {
        boolean solved = true;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (getCell(i, j).isCellEmpty()) {
                    solved = false;
                    break;
                }
            }
        }
        return solved;
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
            col[i] = getCell(i, j);
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
                groupCells.add(getCell(i, j));
            }
        }
        return groupCells;
    }

    private List<Cell> getSolvedGroupCells(int i, int j) {
        return getSolvedCells(getGroupCells(i, j));
    }

    private List<Cell> getSolvedCells(List<Cell> allCells) {
        List<Cell> nullCellList = new ArrayList<>();
        nullCellList.add(new Cell());
        allCells.removeAll(nullCellList);
        return allCells;
    }
}
