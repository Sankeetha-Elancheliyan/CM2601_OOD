package Management;

import java.util.LinkedList;
import java.util.Queue;

public class DispenserQueue {
    // Queue to store customers waiting to use a dispenser
    Queue<Customer> dispenserqueue = new LinkedList<>();

    /**
     * Iterates through the given queue and prints the details of each customer
     * @param linkedList queue to iterate through
     */
    public void iterateUsingEnhancedForLoop(Queue<Customer> linkedList) {
        System.out.println("--------------------------------------------");
        System.out.printf("%5s %11s %12s %12s ", "Name", "FuelType", "VehicleType", "FuelAmount");
        System.out.println();
        System.out.println("--------------------------------------------");
        for (Customer listElement : linkedList) {
            System.out.format("%5s %7s %12s %12s", listElement.getName(), listElement.getFuelType(), listElement.getVehicleType(), listElement.getFuelamount());
            System.out.println();
        }
        System.out.println("--------------------------------------------");
    }

    /**
     * Adds a customer to the dispenser queue if there is space available
     * @param c customer to add to the queue
     * @return true if customer was added, false if queue is full
     */
    public boolean addQueue(Customer c) {
        if (dispenserqueue.size() < 10) {
            return dispenserqueue.add(c);
        } else {
            return false;
        }
    }

    /**
     * Adds a customer to the dispenser queue if there is space available
     * @param c customer to add to the queue
     */
    public void addQ(Customer c) {
        if (dispenserqueue.size() < 10) {
            dispenserqueue.add(c);
        } else {
            System.out.println("Not enough space");
        }
    }

    /**
     * Removes a customer from the dispenser queue
     * @param c customer to remove from the queue
     * @return true if customer was removed, false if customer was not found in the queue
     */
    public boolean removeQueue(Customer c) {
        return dispenserqueue.remove(c);
    }

    /**
     * Displays the number of available slots in the dispenser queue
     */
    public void displayAvailableSlots() {
        System.out.println(dispenserqueue.size());
    }
}
