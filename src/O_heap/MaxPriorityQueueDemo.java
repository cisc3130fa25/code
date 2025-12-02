import O_heap.Client;
import O_heap.MaxPriorityQueue;

void main() {
    Client client1 = new Client("John", 2);
    Client client2 = new Client("Cindy", 7);
    Client client3 = new Client("Tim", 5);
    Client client4 = new Client("Jim", 1);

    MaxPriorityQueue<Client> priorityQueue = new MaxPriorityQueue<>();
    priorityQueue.add(client1);
    priorityQueue.add(client2);
    priorityQueue.add(client3);
    priorityQueue.add(client4);

    IO.println(priorityQueue);

    while (!priorityQueue.isEmpty()) {
        IO.println(priorityQueue.remove() + " ");
    }
}