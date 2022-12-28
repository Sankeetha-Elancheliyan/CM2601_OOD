package Management;

import java.util.ArrayList;

public class OctaneRepository extends CentralRepository {
    private double availableFuel;

    private ArrayList<OctaneFuelDispenseManager> listOfPetrolDispenser =new ArrayList<>();

    public OctaneRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L, double availableFuel) {
        super(stockAmount, capacity, datetime, is500L);
        this.availableFuel = availableFuel;
    }

    public void addListOfDieselDispenser(OctaneFuelDispenseManager d){
        this.listOfPetrolDispenser.add(d);
    }

    public void removeListOfDieselDispenser(OctaneFuelDispenseManager d){
        this.listOfPetrolDispenser.remove(d);
    }
    public double getAvailableFuel() {
        return availableFuel;
    }

    public void setAvailableFuel(double availableFuel) {
        this.availableFuel = availableFuel;
    }

}
