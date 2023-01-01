package Management;

import java.util.LinkedList;
import java.util.Queue;

public class DispenserQueue {
    Queue <Customer> dispenserqueue = new LinkedList<Customer>();
    public void iterateUsingEnhancedForLoop(Queue<Customer> linkedList)
    {

//        System.out.print("Iterating the LinkedList using enhanced for loop : ");
        System.out.println("--------------------------------------------");
        System.out.printf("%5s %11s %12s %12s ", "Name", "FuelType", "VehicleType", "FuelAmount");
        System.out.println();
        System.out.println("--------------------------------------------");
        for (Customer listElement : linkedList) {
            System.out.format("%5s %7s %12s %12s",listElement.getName(),listElement.getFuelamount(),listElement.getVehicleType(),listElement.getFuelamount() );
            System.out.println();

        }
        System.out.println("--------------------------------------------");
    }

        //    public DispenserQueue(Queue dispenserqueue) {
//        this.dispenserqueue = dispenserqueue;
//    }
        public boolean addQueue(Customer c) {
            if (dispenserqueue.size() < 10) {
                return dispenserqueue.add(c);
            } else {
                return false;
            }
        }
//public boolean addQueue(Customer c){
//    return dispenserqueue.add(c);
//}

    public void addQ(Customer c) {
        if (dispenserqueue.size() < 10) {
            dispenserqueue.add(c);
        } else {
            System.out.println("Not enough space");
        }
    }
        public boolean removeQueue(Customer c) {
            return dispenserqueue.remove(c);
        }

        public void displayavailableSlots(){
            System.out.println(dispenserqueue.size());
        }
//
//    public Queue getDispenserqueue() {
//        return dispenserqueue;
//    }
//
}

