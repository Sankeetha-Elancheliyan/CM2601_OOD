package Management;

public class DieselFuelRepository extends CentralFuelRepository{
      
    private double availableFuel;
    private ArrayList<DieselFuelDispenserManager> listOfDieselDispenser =new ArrayList<>();

    public DieselFuelRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L, double availableFuel, ArrayList<DieselFuelDispenseManager> listOfDieselDispenser) {
        super(stockAmount, capacity, datetime, is500L);
        this.availableFuel = availableFuel;
        this.listOfDieselDispenser = listOfDieselDispenser;
    }


    public  void addListOfDieselDispenser(DieselFuelDispenserManager d){
        this.listOfDieselDispenser.add(d);
    }

    public void removeListOfDieselDispenser(DieselFuelDispenserManager d){
        this.listOfDieselDispenser.remove(d);
    }

    public DieselFuelRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L, double availableFuel) {
        super(stockAmount, capacity, datetime, is500L);
        this.availableFuel = availableFuel;
    }

    public double getAvailableFuel() {
        return availableFuel;
    }

    public void setAvailableFuel(double availableFuel) {
        this.availableFuel = availableFuel;
    }

}
