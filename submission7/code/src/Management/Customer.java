package Management;

public class Customer {
    private String name, fuelType,VehicleType;
    private int fuelamount;
    //cmt
    public Customer(String name, String fuelType, String vehicleType, int fuelamount) {
        this.name = name;
        this.fuelType = fuelType;
        VehicleType = vehicleType;
        this.fuelamount = fuelamount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public int getFuelamount() {
        return fuelamount;
    }

    public void setFuelamount(int fuelamount) {
        this.fuelamount = fuelamount;
    }
    public String toString()
    {
        return "Customer {"+name+"-"+fuelType+"-"+VehicleType+"-"+fuelamount+"}";
    }
}
