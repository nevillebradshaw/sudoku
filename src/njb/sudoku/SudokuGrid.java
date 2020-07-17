package njb.sudoku;

import java.util.*;

/**
 * @author nevillebradshaw@hotmail.com
 * <p>
 * This class represents the Grid of Cells
 * It provides methods to indicate if the Grid has been resolved
 * as well as the helper methods to List the nine values in a row,column or 3x3 group.
 * There are 9 3x3 groups in the grid referred to as GroupA, GroupB...GroupI.
 * These are the 3x3 arrays listed from top left of the grid to bottom right.
 */
class SudokuGrid {
    public static int GRID_WIDTH = 9;
    public static int GRID_HEIGHT = 9;

    private Cell[][] cellGrid_ = new Cell[GRID_WIDTH][GRID_HEIGHT];

    SudokuGrid(int[][] grid) {
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                cellGrid_[i][j] = new Cell(grid[i][j]);
            }
        }
    }

    boolean isValid() {
        boolean isVal = true;
        for (int i = 0; i < GRID_WIDTH; i++) {
            List<Cell> rowList = getSolvedRowCells(i);
            if (!isCellListValid(rowList)) {
                isVal = false;
                break;
            }
        }

        if (isVal) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                List<Cell> colList = getSolvedColCells(j);
                if (!isCellListValid(colList)) {
                    isVal = false;
                    break;
                }
            }
        }

        if (isVal) {
            //TODO only get each group once
            for (int i = 0; i < GRID_WIDTH; i++) {
                for (int j = 0; j < GRID_HEIGHT; j++) {
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
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
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
        Cell[] col = new Cell[GRID_HEIGHT];
        for (int i = 0; i < GRID_HEIGHT; i++) {
            col[i] = cellGrid_[i][j];
        }
        return new ArrayList<>(Arrays.asList(col));
    }

    private List<Cell> getSolvedColCells(int j) {
        return getSolvedCells(getColCells(j));
    }

    List<Cell> getGroupCells(int row, int col) {
        List<Cell> groupCellsList = new ArrayList<>();
        // Group A
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            groupCellsList = getGroup(0, 2, 0, 2);
        }
        // Group B
        else if (row >= 0 && row <= 2 && col >= 3 && col <= 5) {
            groupCellsList = getGroup(0, 2, 3, 5);
        }
        // Group C
        else if (row >= 0 && row <= 2 && col >= 6 && col <= 8) {
            groupCellsList = getGroup(0, 2, 6, 8);
        }
        // Group D
        else if (row >= 3 && row <= 5 && col >= 0 && col <= 2) {
            groupCellsList = getGroup(3, 5, 0, 2);
        }
        // Group E
        else if (row >= 3 && row <= 5 && col >= 3 && col <= 5) {
            groupCellsList = getGroup(3, 5, 3, 5);
        }
        // Group F
        else if (row >= 3 && row <= 5 && col >= 6 && col <= 8) {
            groupCellsList = getGroup(3, 5, 6, 8);
        }
        // Group G
        else if (row >= 6 && row <= 8 && col >= 0 && col <= 2) {
            groupCellsList = getGroup(6, 8, 0, 2);
        }
        // Group H
        else if (row >= 6 && row <= 8 && col >= 3 && col <= 5) {
            groupCellsList = getGroup(6, 8, 3, 5);
        }
        // Group I
        else if (row >= 6 && row <= 8 && col >= 6 && col <= 8) {
            groupCellsList = getGroup(6, 8, 6, 8);
        }
        return groupCellsList;
    }

    private List<Cell> getSolvedGroupCells(int i, int j) {
        return getSolvedCells(getGroupCells(i, j));
    }

    private List<Cell> getSolvedCells(List<Cell> allCells) {
        List<Cell> solvedCells = new ArrayList<>();
        for (Cell cell : allCells) {
            if (cell.getSymbol() != null) {
                solvedCells.add(cell);
            }
        }
        return solvedCells;
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
}
