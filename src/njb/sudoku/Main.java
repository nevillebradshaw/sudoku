package njb.sudoku;

public class Main {
    static final int[][] EASY_GRID_1 = new int[][] {
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

    static final int[][] EASY_GRID_2 = new int[][] {
            {0, 0, 0, 0, 7, 2, 0, 0, 0},
            {6, 0, 0, 0, 3, 0, 0, 0, 0},
            {0, 2, 7, 5, 0, 9, 6, 1, 0},
            {1, 0, 5, 0, 6, 0, 4, 2, 0},
            {9, 0, 2, 0, 1, 5, 3, 0, 0},
            {0, 0, 0, 9, 0, 0, 0, 6, 1},
            {4, 0, 6, 1, 0, 0, 8, 3, 0},
            {7, 0, 0, 0, 8, 0, 1, 9, 0},
            {0, 1, 8, 0, 9, 6, 0, 4, 5}
    };

    static final int[][] HARD_GRID_1 = new int[][] {
            {0, 3, 8, 9, 0, 0, 4, 0, 0},
            {2, 0, 0, 0, 0, 5, 0, 0, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 6, 0, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 6, 0, 8, 0, 0, 0, 4, 0},
            {0, 8, 0, 4, 0, 6, 1, 0, 0},
            {0, 7, 5, 0, 0, 0, 0, 9, 0},
            {0, 0, 6, 0, 5, 0, 0, 8, 0}
    };

    static final int[][] HARD_GRID_2 = new int[][] {
            {2, 0, 0, 5, 0, 1, 0, 0, 8},
            {0, 8, 0, 0, 6, 0, 0, 9, 0},
            {0, 0, 0, 8, 0, 2, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 0, 3, 0},
            {5, 0, 1, 0, 2, 0, 4, 0, 9},
            {0, 9, 0, 0, 0, 0, 0, 2, 0},
            {0, 0, 0, 1, 0, 6, 0, 0, 0},
            {0, 6, 0, 0, 4, 0, 0, 7, 0},
            {8, 0, 0, 9, 0, 5, 0, 0, 6}
    };

    public static void main(String[] args) {
        Solver solver = new Solver(HARD_GRID_2);
    }
}
