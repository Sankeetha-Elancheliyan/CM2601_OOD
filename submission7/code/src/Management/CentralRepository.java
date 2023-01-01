package Management;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
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



//    public void printStats(){
//        try {
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/Petrol_Station_Queue_Management", "new", "sankee"
//            );
//            // Create a prepared statement with an INSERT query
//            String sql = "SELECT fuelType, vehicleType FROM customer WHERE amount = (SELECT MAX(amount) FROM customer)";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            // Execute the query and get the result set
//            ResultSet rs = stmt.executeQuery();
//            // Iterate through the result set
//            while (rs.next()) {
//                // Retrieve the serialized data from the result set
//                byte[] data = (byte[]) rs.getObject(1);
//
//                // Use an ObjectInputStream to deserialize the data
//                ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
//
//                // Read the object from the stream and cast it to the appropriate type
//                Customer customer = (Customer) ois.readObject();
//
//                // Close the stream
//                ois.close();
//
//                // Use the deserialized object as needed
//                System.out.println("The Vehicle type which recieved the highest amount of fuel: "+ customer.getVehicleType());
//                System.out.println("The Fuel type they got: "+ customer.getFuelType());
//            }
//            // Close the result set, statement, and connection
//            rs.close();
//            stmt.close();
//            con.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }

}

