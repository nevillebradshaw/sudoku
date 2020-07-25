package njb.sudoku;

import java.util.Objects;

/**
 * @author nevillebradshaw@hotmail.com
 * <p>
 * A Cell is a container for a symbol in the Sudoku Grid. E.G. the number 1 to 9.
 * A Cell that is currently not resolved has symbol == null.
 */
class Cell implements Comparable<Cell> {
    private Symbol symbol_;

    Cell() {
        symbol_ = null;
    }

    Cell(Symbol symbol) {
        symbol_ = symbol;
    }

    Cell(int value) {
        symbol_ = switch (value) {
            case 0 -> null;
            case 1 -> Symbol.ONE;
            case 2 -> Symbol.TWO;
            case 3 -> Symbol.THREE;
            case 4 -> Symbol.FOUR;
            case 5 -> Symbol.FIVE;
            case 6 -> Symbol.SIX;
            case 7 -> Symbol.SEVEN;
            case 8 -> Symbol.EIGHT;
            case 9 -> Symbol.NINE;
            default -> throw new RuntimeException(value + " is not valid - must be in the range 0 to 9");
        };
    }

    int getValue() {
        return symbol_.getValue();
    }

    boolean isCellEmpty() {
        return symbol_ == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return symbol_ == cell.symbol_;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol_);
    }

    @Override
    public String toString() {
        return symbol_.toString();
    }

    @Override
    public int compareTo(Cell otherCell) {
        int thisVal = symbol_.getValue();
        int thatVal = otherCell.symbol_ == null ? 0 : otherCell.symbol_.getValue();
        int ret = 1;
        if (thisVal < thatVal) {
            ret = -1;
        } else if (thisVal == thatVal) {
            ret = 0;
        }
        return ret;
    }
}