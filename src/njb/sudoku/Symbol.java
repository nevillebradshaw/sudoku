package njb.sudoku;

enum Symbol {
    ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9");

    private String value_;

    Symbol(String value) {
        value_ = value;
    }

    @Override
    public String toString() {
        return value_;
    }
}
