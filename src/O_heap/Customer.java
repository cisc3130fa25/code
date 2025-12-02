package O_heap;

public record Customer(String name, int importance) implements Comparable<Customer> {
    @Override
    public String toString() {
        return name + " " + importance;
    }

    // compares customers based on importance level
    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.importance, other.importance);
    }
}