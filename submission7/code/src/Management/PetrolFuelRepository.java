package Management;

public class PetrolFuelRepository extends CentralFuelRepository{
    private double availablePetrol;

   private ArrayList<PetrolFuelDispenseManager> listOfPetrolDispenser =new A
    
    public PetrolFuelRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L, double availableFuel) {
        super(stockAmount, capacity, datetime, is500L);
        this.availableFuel = availableFuel;
    }

    public void addListOfDieselDispenser(PetrolFuelDispenseManager d){
        this.listOfPetrolDispenser.add(d);
    }

    public void removeListOfDieselDispenser(PetrolFuelDispenseManager d){
        this.listOfPetrolDispenser.remove(d);
    }
    public double getAvailableFuel() {
        return availableFuel;
    }

    public void setAvailableFuel(double availableFuel) {
        this.availableFuel = availableFuel;
    }

}
