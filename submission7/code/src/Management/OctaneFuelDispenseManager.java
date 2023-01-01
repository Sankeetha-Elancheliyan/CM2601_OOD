package Management;

import java.util.Queue;

public class OctaneFuelDispenseManager implements FuelDispenseManager, Runnable {

    //private double fuelPumped,unitPrice,amount;
    private Operator operator;

    private final Queue<Customer> queue;
    private double fuelPumped,unitPrice,amount;
    private int dispenserNumber;
    private String fuelType;
    private String vehicleType;
    private boolean availability;
    private  double availableOctane;


    public OctaneFuelDispenseManager(int dispenserNumber, Queue<Customer> queue, String vehicleType,  String fuelType, boolean availability, double availableOctane, double fuelPumped, double unitPrice ) {
        this.queue = queue;
        this.fuelPumped = fuelPumped;
        this.unitPrice = unitPrice;
        this.dispenserNumber = dispenserNumber;
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.availability = availability;
        this.availableOctane = availableOctane;
    }

    public double getFuelPumped() {
        return fuelPumped;
    }

    public void setFuelPumped(double fuelPumped) {
        this.fuelPumped = fuelPumped;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void stopPumping() {
        System.out.println("notenough fuel");
    }

    @Override
    public void issuefuel() {
        System.out.println("supply fuel");
    }

    @Override
    public void addnewdispenser() {
        System.out.println("adding new dispenser");

    }
     public double petrolIncome(){
        return this.unitPrice*this.fuelPumped;
     }


    @Override
    public void run() {
        //Check availabilitu
        System.out.println(availableOctane);
        //dispense
        System.out.println("Octane Supplied");
        //Update
        System.out.println("the ques is "+ queue);
        //payment
        System.out.println("the required fuels is "+queue.peek().getFuelamount());
        //dequeue
        while (!queue.isEmpty()) {
            Customer customer = queue.poll();
            System.out.println("poll from the queue :"+customer);
        }
    }
}
