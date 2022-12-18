package Management;

public class DieselFuelRepository extends CentralFuelRepository{
    private double availableDiesel;

    public DieselFuelRepository(int repositoryNum, String name, double capacity, double availableDiesel) {
        super(repositoryNum, name, capacity);
        this.availableDiesel=availableDiesel;
    }

    public double getAvailableDiesel() {
        return availableDiesel;
    }

    public void restockDiesel(double availableDiesel) {
        this.availableDiesel = availableDiesel;
    }
}
