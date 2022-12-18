package Management;

public class PetrolFuelRepository extends CentralFuelRepository{
    private double availablePetrol;

    public PetrolFuelRepository(int repositoryNum, String name, double capacity,double availablePetrol) {
        super(repositoryNum, name, capacity);
        this.availablePetrol=availablePetrol;
    }

    public double getAvailablePetrol() {
        return availablePetrol;
    }

    public void restockPetrol(double availablePetrol) {
        this.availablePetrol = availablePetrol;
    }
}
