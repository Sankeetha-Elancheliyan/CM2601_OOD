package Management;

public class DieselFuelDispenseManager implements FuelDispenseManager{
    private double fuelPumped,unitPrice,amount;



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
}
