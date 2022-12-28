import java.util.Collection;

public class Customer{

    private int customerId;
    private String vehicleType;

    private String fuelType;

    private int fuelAmount;

    public Customer(int customerId,String vehicleType, String fuelType, int fuelAmount) {
        this.customerId = customerId;

        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.fuelAmount = fuelAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                +customerId +" "+
        vehicleType +" "+ '\'' +
                 fuelType+ '\'' +
                 " "+ fuelAmount+
                '}';
    }
}
