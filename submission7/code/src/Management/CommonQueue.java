package Management;

import java.util.LinkedList;

public class CommonQueue {
    // Linked list to store customers in the queue
    LinkedList<Customer> commonqueue = new LinkedList<>();

    // Field to store the number of customers in the queue
    private int numberInQueue;

    // Method to add a customer to the queue
    public boolean addQueue(Customer c) {
        return commonqueue.add(c);
    }

    // Method to remove a customer from the queue
    public boolean removeQueue(Customer c) {
        return commonqueue.remove(c);
    }

    // Getter and setter for the numberInQueue field
    public int getNumberInQueue() {
        return numberInQueue;
    }

    public void setNumberInQueue(int numberInQueue) {
        this.numberInQueue = numberInQueue;
    }
}
