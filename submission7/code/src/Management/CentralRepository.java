package Management;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CentralRepository {
    private double StockAmount;
    private double Capacity;
    private DateTime dateTime;
    private boolean is500L;

    public CentralRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L) {
        StockAmount = stockAmount;
        Capacity = capacity;
        this.dateTime=datetime;
        this.is500L = is500L;
    }

    public CentralRepository() {
        StockAmount=50000;
        Capacity=50000;
    }



    public double getStockAmount() {
        return StockAmount;
    }

    public void setStockAmount(double stockAmount) {
        StockAmount = stockAmount;
    }

    public boolean stopPumping(){
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

