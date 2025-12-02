package O_heap;

public record Client(String name, int importance) implements Comparable<Client> {
    @Override
    public String toString() {
        return name + " " + importance;
    }

    // compares clients based on importance level
    @Override
    public int compareTo(Client other) {
        return Integer.compare(this.importance, other.importance);
    }
}