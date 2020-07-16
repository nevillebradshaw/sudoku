package njb.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author nevillebradshaw@hotmail.com
 * <p>
 * A Cell is a container for a symbol in the Sudoku Grid.
 * E.G. the number 1 to 9.
 * A Cell that is currently not resolved has symbol == null.
 * When the symbol is null the possibleSymbols_ list contains the potenial values.
 * This list starts with all available nine symbols.
 * This list is reduced with each iteration of the Solver until only a single value remains.
 * At this point the symbol_ is set to this value and the list of possibleValues_ is set to null
 */
class Cell implements Comparable<Cell>{
    private static List<Symbol> ALL_SYMBOLS = new ArrayList<>(Arrays.asList(Symbol.values()));
    private Symbol symbol_;
    private List<Symbol> possibleSymbols_;

    Cell(Symbol symbol) {
        symbol_ = symbol;
        possibleSymbols_ = null;
    }

    Cell(int value) {
        symbol_ = switch (value) {
            case 0 -> {
                possibleSymbols_ = new ArrayList<>(ALL_SYMBOLS);
                yield null;
            }
            case 1 -> Symbol.ONE;
            case 2 -> Symbol.TWO;
            case 3 -> Symbol.THREE;
            case 4 -> Symbol.FOUR;
            case 5 -> Symbol.FIVE;
            case 6 -> Symbol.SIX;
            case 7 -> Symbol.SEVEN;
            case 8 -> Symbol.EIGHT;
            case 9 -> Symbol.NINE;
            default -> throw new RuntimeException(value + " is not valid - must be in the range 1 to 9");
        };
    }

    Symbol getSymbol() {
        return symbol_;
    }

    List<Symbol> getPossibleSymbols() {
        return possibleSymbols_;
    }

    boolean removeFromPossibleSymbols(List<Cell> otherCellsList) {
        boolean cellChanged = false;
        if (symbol_ == null) {
            List<Symbol> removeList = new ArrayList<>();
            for (Cell cell : otherCellsList) {
                if (cell.getSymbol() != null) {
                    removeList.add(cell.getSymbol());
                }
            }
            cellChanged = possibleSymbols_.removeAll(removeList);
            if (possibleSymbols_.size() == 1) {
                symbol_ = possibleSymbols_.get(0);
                possibleSymbols_ = null;
            }
        }
        return cellChanged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return symbol_ == cell.symbol_ && Objects.equals(possibleSymbols_, cell.possibleSymbols_);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol_, possibleSymbols_);
    }

    @Override
    public String toString() {
        return "Cell{symbol_=" + symbol_ + ", possibleSymbols_=" + possibleSymbols_ + '}';
    }

    @Override
    public int compareTo(Cell otherCell) {
        int thisVal = symbol_.getValue();
        int thatVal = otherCell.getSymbol().getValue();
        int ret = 1;
        if (thisVal < thatVal) {
            ret = -1;
        }
        else if (thisVal == thatVal) {
            ret = 0;
        }
        return ret;
    }
}