package phonebook;

public record Name(String first, String last) {
    @Override
    public String toString() {
        return first + " " + last;
    }
}
