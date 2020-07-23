package njb.sudoku;

public class NakedPair {
    private Symbol first_;
    private Symbol second_;

    public NakedPair(Symbol first_, Symbol second_) {
        this.first_ = first_;
        this.second_ = second_;
    }

    public Symbol getFirst() {
        return first_;
    }

    public Symbol getSecond() {
        return second_;
    }
}
