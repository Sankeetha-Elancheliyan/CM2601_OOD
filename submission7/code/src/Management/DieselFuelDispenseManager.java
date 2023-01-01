package Management;

import java.util.Queue;

public class DieselFuelDispenseManager implements FuelDispenseManager, Runnable{
//    private double fuelPumped,unitPrice,amount;
    private Operator operator;

    private final Queue<Customer> queue;
    private double fuelPumped,unitPrice,amount;
    private int dispenserNumber;
    private String fuelType;
    private String vehicleType;
    private boolean availability;
    private  double availableDiesel;

    public DieselFuelDispenseManager(int dispenserNumber, Queue<Customer> queue, String vehicleType,  String fuelType, boolean availability, double availableDiesel, double fuelPumped, double unitPrice , Operator operator) {
        this.queue = queue;
        this.fuelPumped = fuelPumped;
        this.unitPrice = unitPrice;
        this.dispenserNumber = dispenserNumber;
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.availability = availability;
        this.availableDiesel = availableDiesel;
        this.operator=operator;
    }

//    public void setOperator(Operator operator) {
//        this.operator = operator;
//    }

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
        this.availability = false;
    }

    @Override
    public void issuefuel() {
        System.out.println("supply fuel");
    }

    @Override
    public void addnewdispenser() {
        System.out.println("adding new dispenser");

    }
    public double dieselIncome(){
        return this.unitPrice*this.fuelPumped;
    }



    @Override
    public void run() {

        while (queue.size() > 0) {
            //Check availability
            if (availableDiesel>500) {
//                System.out.println(availableDiesel);
                //dispense
                System.out.println("Diesel Supplied");
                availableDiesel-=queue.peek().getFuelamount();
                //payment
                System.out.println("The operator handling payment is " + operator.getName() +"\n the operator id is " + operator.getOp_id());
//                System.out.println("the required fuels is for " + queue.peek().getName() + " is :" + queue.peek().getFuelamount());
                //Update
                System.out.println("the ques is " + queue);
                //dequeue
                System.out.println("the required fuels is for " + queue.peek().getName() + " is :" + queue.peek().getFuelamount());
                Customer customer = queue.poll();
                System.out.println("poll from the queue :" + customer);
            }else{
                // stop supply
                stopPumping();
                System.out.println("The dispenser " + dispenserNumber + " unavailable until restock");
                break;
            }
        }

    }
}
