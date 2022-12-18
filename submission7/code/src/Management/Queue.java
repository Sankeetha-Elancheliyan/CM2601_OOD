package Management;

import java.util.ArrayList;

public class Queue {
    private ArrayList<String> vehicleType = new ArrayList<>();
    private ArrayList<Customer> listOfCustomers = new ArrayList<>();


    public void addNewDispenserQueue() {

    }

    public void setListOfCustomers(ArrayList<Customer> listOfCustomers) {
        this.listOfCustomers = listOfCustomers;
    }

    public void addListOfCustomer(Customer c) {
        this.listOfCustomers.add(c);

    }

    public void removeListOfCustomer(Customer c){
        this.listOfCustomers.remove(c);
    }



}
