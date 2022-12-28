package Management;

public class OctaneFuelDispenseManager implements FuelDispenseManager {

    private double fuelPumped,unitPrice,amount;
    private Operator operator;
//    DateTime v = new DateTime();
//    OctaneRepository OR1=new OctaneRepository(25000,25000,v,false,25000);
//    OctaneFuelDispenseManager OD1=new OctaneFuelDispenseManager(500,450,200);
//    OctaneFuelDispenseManager OD2=new OctaneFuelDispenseManager(500,450,200);
//    OctaneFuelDispenseManager OD3=new OctaneFuelDispenseManager(500,450,200);
//    OctaneFuelDispenseManager OD4=new OctaneFuelDispenseManager(500,450,200);
//    ArrayList<OctaneFuelDispenseManager> listofdispensers=new ArrayList<OctaneFuelDispenseManager>();


    public OctaneFuelDispenseManager(double fuelPumped, double unitPrice) {
        this.fuelPumped = fuelPumped;
        this.unitPrice = unitPrice;

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
}
