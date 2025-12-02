import O_heap.Customer;
import O_heap.MaxPriorityQueue;

void main() {
    Customer customer1 = new Customer("John", 2);
    Customer customer2 = new Customer("Cindy", 7);
    Customer customer3 = new Customer("Tim", 5);
    Customer customer4 = new Customer("Jim", 1);

    MaxPriorityQueue<Customer> priorityQueue = new MaxPriorityQueue<>();
    priorityQueue.add(customer1);
    priorityQueue.add(customer2);
    priorityQueue.add(customer3);
    priorityQueue.add(customer4);

    IO.println(priorityQueue);

    while (!priorityQueue.isEmpty()) {
        IO.println(priorityQueue.remove() + " ");
    }
}