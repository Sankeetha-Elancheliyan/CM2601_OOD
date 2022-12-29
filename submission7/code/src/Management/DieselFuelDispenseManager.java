package Management;

public class DieselFuelDispenseManager implements FuelDispenseManager, Runnable{
//    private double fuelPumped,unitPrice,amount;

    private double fuelPumped;
    private double unitPrice;
    private double amount;
    private int dispenserNumber;
    private String fuelType;
    private String vehicleType;
    private boolean availability;

    public DieselFuelDispenseManager(int i, String vehicles, String d, boolean b) {
        this.dispenserNumber = i;
        this.fuelType = d;
        this.vehicleType = vehicles;
        this.availability = b;
    }



//    public DieselFuelDispenseManager(double fuelPumped, double unitPrice, double amount) {
//        this.fuelPumped = fuelPumped;
//        this.unitPrice = unitPrice;
//        this.amount = amount;
//    }
    public DieselFuelDispenseManager(double fuelPumped,double unitPrice){
        this.unitPrice=unitPrice;
        this.fuelPumped=fuelPumped;
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
        System.out.println("Not enough fuel");
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
        //Check availabilitu
        //dispense
        System.out.println("Diesel Supplied");
        //Update
        //payment
        //dequeue
    }
}
