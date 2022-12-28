package Management;

import java.util.ArrayList;

public class DieselRepository extends CentralRepository {
    private double availableFuel;
    private ArrayList<DieselFuelDispenseManager> listOfDieselDispenser =new ArrayList<>();

    public DieselRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L, double availableFuel, ArrayList<DieselFuelDispenseManager> listOfDieselDispenser) {
        super(stockAmount, capacity, datetime, is500L);
        this.availableFuel = availableFuel;
        this.listOfDieselDispenser = listOfDieselDispenser;
    }


    public  void addListOfDieselDispenser(DieselFuelDispenseManager d){
        this.listOfDieselDispenser.add(d);
    }

    public void removeListOfDieselDispenser(DieselFuelDispenseManager d){
        this.listOfDieselDispenser.remove(d);
    }

    public DieselRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L, double availableFuel) {
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
