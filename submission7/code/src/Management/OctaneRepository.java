package Management;

import java.util.ArrayList;

public class OctaneRepository extends CentralRepository {
    // private instance variable
    private double availableFuel;
    private ArrayList<OctaneFuelDispenseManager> listOfPetrolDispenser = new ArrayList<>();

    /**
     * Constructor - to create a new OctaneRepository with the given details
     * stockAmount - initial stock amount of fuel in the repository
     * capacity - maximum capacity of the repository
     * datetime - date and time the repository was created
     * is500L - whether the repository is for 500L tanks or not
     * availableFuel - initial available fuel in the repository
     */
    public OctaneRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L, double availableFuel) {
        super(stockAmount, capacity, datetime, is500L);
        this.availableFuel = availableFuel;
    }

    /**
     * Adds a new OctaneFuelDispenseManager to the list of petrol dispensers
     * d - OctaneFuelDispenseManager to add to the list
     */
    public void addListOfDieselDispenser(OctaneFuelDispenseManager d) {
        this.listOfPetrolDispenser.add(d);
    }

    /**
     * Removes an OctaneFuelDispenseManager from the list of petrol dispensers
     * d - OctaneFuelDispenseManager to remove from the list
     */
    public void removeListOfDieselDispenser(OctaneFuelDispenseManager d) {
        this.listOfPetrolDispenser.remove(d);
    }

    /**
     * Returns the available fuel in the repository
     * return available fuel in the repository
     */
    public double getAvailableFuel() {
        return availableFuel;
    }

    /**
     * Sets the available fuel in the repository
     * availableFuel- available fuel to set for the repository
     */
    public void setAvailableFuel(double availableFuel) {
        this.availableFuel = availableFuel;
    }
}
