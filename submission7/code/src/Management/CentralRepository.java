package Management;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CentralRepository {
    // Field to store the current amount of fuel in the repository
    private double stockAmount;

    // Field to store the capacity of the repository
    private double capacity;

    // Field to store the current date and time
    private DateTime dateTime;

    // Field to store whether the repository is a 500L tank or not
    private boolean is500L;

    /**
     * Constructor for CentralRepository
     * @param stockAmount current amount of fuel in the repository
     * @param capacity capacity of the repository
     * @param datetime current date and time
     * @param is500L whether the repository is a 500L tank or not
     */
    public CentralRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L) {
        this.stockAmount = stockAmount;
        this.capacity = capacity;
        this.dateTime = datetime;
        this.is500L = is500L;
    }

    /**
     * Default constructor for CentralRepository
     * Initializes stockAmount and capacity to 50000
     */
    public CentralRepository() {
        this.stockAmount = 50000;
        this.capacity = 50000;
    }

    // Getter and setter for the stockAmount field
    public double getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(double stockAmount) {
        this.stockAmount = stockAmount;

    }

    // Method to stop pumping fuel from the repository
    public boolean stopPumping() {
        return is500L;
    }




    // To print Stats for the day

    public void printStats() {

        // prints total fuel dispensed per day by all the dispensers
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Petrol_Station_Queue_Management", "new", "sankee"
            );
            // SQL statement
            String sql = "SELECT SUM(amount) AS total_fuel FROM customer ";
            PreparedStatement stmt = con.prepareStatement(sql);
            // query
            ResultSet rs = stmt.executeQuery();
            // Iterate
            while (rs.next()) {
                // Retrieve
                BigDecimal totalFuel = rs.getBigDecimal("total_fuel");

                System.out.println(" total fuel dispensed by all the dispensers: " + totalFuel);
            }
            // Close
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        //prints the vehicle type which received the highest amount of fuel
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Petrol_Station_Queue_Management", "new", "sankee"
            );
            // Create a prepared statement with a SELECT query
            String sql = "SELECT vehicleType FROM customer WHERE amount = (SELECT MAX(amount) FROM customer)";
            PreparedStatement stmt = con.prepareStatement(sql);
            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery();
            // Iterate through the result set
            while (rs.next()) {
                // Retrieve the fuel type as a string
                String vehicleType = rs.getString(1);
                System.out.println("The Vehicle type which received the highest amount of fuel: "+ vehicleType);
            }
            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        //prints the fuel type which dispensed the highest amount
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Petrol_Station_Queue_Management", "new", "sankee"
            );
            // Create a prepared statement with a SELECT query
            String sql = "SELECT fuelType FROM customer WHERE amount = (SELECT MAX(amount) FROM customer)";
            PreparedStatement stmt = con.prepareStatement(sql);
            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery();
            // Iterate through the result set
            while (rs.next()) {
                // Retrieve the fuel type as a string
                String fuelType = rs.getString(1);
                System.out.println("The Fuel type which got dispensed highest: "+ fuelType);
            }
            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}

