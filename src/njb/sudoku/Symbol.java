package njb.sudoku;

/**
 * @author nevillebradshaw@hotmail.com
 * <p>
 * Each Cell in the solved Sudoku grid will contain one of these 9 symbols
 * These symbols are currently represented by the numbers 1 to 9.
 */
enum Symbol {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

    private int value_;

    Symbol(int value) {
        value_ = value;
    }

    public int getValue() {
        return value_;
    }

    @Override
    public String toString() {
        return value_ + "";
    }
}
