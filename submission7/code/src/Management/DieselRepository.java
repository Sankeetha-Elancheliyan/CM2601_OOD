package Management;

import java.util.ArrayList;

public class DieselRepository extends CentralRepository {
    // private instance variable
    private double availableFuel;
    private ArrayList<DieselFuelDispenseManager> listOfDieselDispenser = new ArrayList<>();

    /**
     * Constructor to create a new DieselRepository with the given details and list of diesel dispensers
     * @param stockAmount initial stock amount of fuel in the repository
     * @param capacity maximum capacity of the repository
     * @param datetime date and time the repository was created
     * @param is500L whether the repository is for 500L tanks or not
     * @param availableFuel initial available fuel in the repository
     * @param listOfDieselDispenser list of diesel dispensers associated with the repository
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
     * @param stockAmount initial stock amount of fuel in the repository
     * @param capacity maximum capacity of the repository
     * @param datetime date and time the repository was created
     * @param is500L whether the repository is for 500L tanks or not
     * @param availableFuel initial available fuel in the repository
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
     * @param availableFuel available fuel to set for the repository
     */
    public void setAvailableFuel(double availableFuel) {
        this.availableFuel = availableFuel;
    }
}
