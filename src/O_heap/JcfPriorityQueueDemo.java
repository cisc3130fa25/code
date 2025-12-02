import O_heap.Customer;

// The JCF's priority queue is a MIN priority queue, built upon a min heap; the head is the min.
void main() {
    Queue<String> pq = new PriorityQueue<>();
    pq.add("Oklahoma");
    pq.add("Texas");
    pq.add("New York");
    pq.add("California");
    pq.add("Georgia");
    IO.println(pq); // note: not sorted! all we know is that head is always the min

    while (!pq.isEmpty()) {
        IO.print(pq.remove() + " ");
    }
    IO.println();

    Queue<Customer> customers = new PriorityQueue<>(Comparator.reverseOrder());
    customers.add(new Customer("Jim", 3));
    customers.add(new Customer("Jane", 2));
    customers.add(new Customer("Mark", 4));
    customers.add(new Customer("Nancy", 2));
    IO.println(customers);

    while (!customers.isEmpty()) {
        IO.println(customers.remove());
    }

    // TODO: https://leetcode.com/problems/take-gifts-from-the-richest-pile/
}
