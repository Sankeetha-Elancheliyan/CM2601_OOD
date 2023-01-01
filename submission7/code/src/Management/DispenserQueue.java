package Management;

import java.util.LinkedList;
import java.util.Queue;

public class DispenserQueue {
    Queue <Customer> dispenserqueue = new LinkedList<Customer>();


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

