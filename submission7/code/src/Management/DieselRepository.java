package Management;

import java.util.ArrayList;

public class DieselRepository extends CentralRepository {
    // private instance variable
    private double availableFuel;
    private ArrayList<DieselFuelDispenseManager> listOfDieselDispenser = new ArrayList<>();

    /**
     * Constructor to create a new DieselRepository with the given details and list of diesel dispensers
     */
    public DieselRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L, double availableFuel, ArrayList<DieselFuelDispenseManager> listOfDieselDispenser) {
        super(stockAmount, capacity, datetime, is500L);
        this.availableFuel = availableFuel;
        this.listOfDieselDispenser = listOfDieselDispenser;
    }

    /**
     * Adds a new DieselFuelDispenseManager to the list of diesel dispensers
     * @param d DieselFuelDispenseManager to add to the list
     */
    public void addListOfDieselDispenser(DieselFuelDispenseManager d) {
        this.listOfDieselDispenser.add(d);
    }

    /**
     * Removes a DieselFuelDispenseManager from the list of diesel dispensers
     * @param d DieselFuelDispenseManager to remove from the list
     */
    public void removeListOfDieselDispenser(DieselFuelDispenseManager d) {
        this.listOfDieselDispenser.remove(d);
    }

    /**
     * Constructor to create a new DieselRepository with the given details
     */
    public DieselRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L, double availableFuel) {
        super(stockAmount, capacity, datetime, is500L);
        this.availableFuel = availableFuel;
    }

    /**
     * Returns the available fuel in the repository
     * @return available fuel in the repository
     */
    public double getAvailableFuel() {
        return availableFuel;
    }

    /**
     * Sets the available fuel in the repository
     */
    public void setAvailableFuel(double availableFuel) {
        this.availableFuel = availableFuel;
    }
}
