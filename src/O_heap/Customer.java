package O_heap;

public record Customer(String name, int years) implements Comparable<Customer> {
    @Override
    public String toString() {
        return name + " " + years;
    }

    // compares customers based on how long they were customers
    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.years, other.years);
    }
}