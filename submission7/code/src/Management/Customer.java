package Management;

import java.io.Serializable;

public class Customer implements Serializable {
    // Fields to store the customer's name, fuel type, vehicle type, and fuel amount
    private String name, fuelType, VehicleType;
    private int fuelAmount, customerTicketId;


    // Constructor to initialize the fields when a Customer object is created
    public Customer(String name, String fuelType, String vehicleType, int fuelAmount) {
        this.name = name;
        this.fuelType = fuelType;
        this.VehicleType = vehicleType;
        this.fuelAmount = fuelAmount;
    }

    // Getters and setters for each field
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
        this.VehicleType = vehicleType;
    }

    public int getFuelamount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    // toString method to create a string representation of a Customer object
    public String toString() {
        return "Customer {" + name + "-" + fuelType + "-" + VehicleType + "-" + fuelAmount + "}";
    }

    public void setTicketNumber(int ticketNumber) {
        this.customerTicketId = ticketNumber;
    }
}
