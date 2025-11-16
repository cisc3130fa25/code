package N_bst.B_application;

// A location within a file.
public record Location(int lineNumber, int columnNumber) {
    @Override
    public String toString() {
        return "(" + lineNumber + ", " + columnNumber + ")";
    }
}