package Management;

public class CentralFuelRepository {
    private int repositoryNum;
    private String name;
    private double capacity;

    public  CentralFuelRepository(int repositoryNum, String name,double capacity ) {
        this.repositoryNum = repositoryNum;
        this.name= name;
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
