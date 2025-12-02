import O_heap.Client;

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

    Queue<Client> clients = new PriorityQueue<>(Comparator.reverseOrder());
    clients.add(new Client("Jim", 3));
    clients.add(new Client("Jane", 2));
    clients.add(new Client("Mark", 4));
    clients.add(new Client("Nancy", 2));
    IO.println(clients);

    while (!clients.isEmpty()) {
        IO.println(clients.remove());
    }

    // TODO: https://leetcode.com/problems/take-gifts-from-the-richest-pile/
}
