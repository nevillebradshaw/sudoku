package njb.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Cell {
    private static List<Symbol> ALL_SYMBOLS = new ArrayList<>(Arrays.asList(Symbol.values()));
    private Symbol symbol_;
    private List<Symbol> possibleSymbols_;

    Cell(int value) {
        symbol_ = switch (value) {
            case 0 -> {
                possibleSymbols_ = ALL_SYMBOLS;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return symbol_ == cell.symbol_ &&
                Objects.equals(possibleSymbols_, cell.possibleSymbols_);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol_, possibleSymbols_);
    }

    @Override
    public String toString() {
        return "Cell{symbol_=" + symbol_ + ", possibleSymbols_=" + possibleSymbols_ + '}';
    }
}