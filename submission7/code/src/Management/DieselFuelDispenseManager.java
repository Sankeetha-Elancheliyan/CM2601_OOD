package Management;

import java.sql.*;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Queue;

import java.sql.SQLOutput;
import java.sql.Statement;

public class DieselFuelDispenseManager implements FuelDispenseManager, Runnable {
//    private double fuelPumped,unitPrice,amount;
    private Operator operator;

    private final Queue<Customer> queue;
    private double fuelPumped,unitPrice,amount;
    private int dispenserNumber;
    private String fuelType;
    private String vehicleType;
    private boolean availability;
    private  double availableDiesel;

    public DieselFuelDispenseManager(int dispenserNumber, Queue<Customer> queue, String vehicleType,  String fuelType, boolean availability, double availableDiesel, double fuelPumped, double unitPrice , Operator operator) {
        this.queue = queue;
        this.fuelPumped = fuelPumped;
        this.unitPrice = unitPrice;
        this.dispenserNumber = dispenserNumber;
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.availability = availability;
        this.availableDiesel = availableDiesel;
        this.operator=operator;
    }

//    public void setOperator(Operator operator) {
//        this.operator = operator;
//    }

    public double getFuelPumped() {
        return fuelPumped;
    }

    public void setFuelPumped(double fuelPumped) {
        this.fuelPumped = fuelPumped;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void stopPumping() {
        this.availability = false;
    }

    @Override
    public void issuefuel() {
        System.out.println("supply fuel");
    }

    @Override
    public void addnewdispenser() {
        System.out.println("adding new dispenser");

    }
    public double dieselIncome(){
        return this.unitPrice*this.fuelPumped;
    }



    @Override
    public void run() {

        while (queue.size() > 0) {
            Object lock = new Object();
            //Check availability
            //Synchronizing to ensure concurrent behaviour
            synchronized (lock) {
                if (availableDiesel > 500) {
//                System.out.println(availableDiesel);
                    //dispense
                    System.out.println("Diesel Supplied");
                    availableDiesel -= queue.peek().getFuelamount();
                    //payment
                    System.out.println("The operator handling payment is " + operator.getName() + "\n the operator id is " + operator.getOp_id());
//                System.out.println("the required fuels is for " + queue.peek().getName() + " is :" + queue.peek().getFuelamount());

                    //Update

                    System.out.println("the ques is " + queue);
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/Petrol_Station_Queue_Management", "new", "sankee"
                        );
                        // Create a prepared statement with an INSERT query
                        String sql = "INSERT INTO customer (name, fuelType, vehicleType, amount) VALUES (?, ?, ?, ?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        // Set the values of the placeholders
                        stmt.setString(1, queue.peek().getName());
                        stmt.setString(2, queue.peek().getFuelType());
                        stmt.setString(3, queue.peek().getVehicleType());
                        stmt.setInt(4, queue.peek().getFuelamount());
                        // Serialize the object to a byte array
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(baos);
                        oos.writeObject(queue.peek());
                        byte[] data = baos.toByteArray();
                        // Set the prepared statement's parameter to the serialized object
                        stmt.setObject(1, data[0]);
                        stmt.setObject(2, data[1]);
                        stmt.setObject(3, data[2]);
                        stmt.setObject(4, data[3]);
                        // Execute the prepared statement
                        stmt.executeUpdate();
                        // Close the streams and connection
                        oos.close();
                        baos.close();
                        stmt.close();
                        con.close();

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    //dequeue
                    System.out.println("the required fuels is for " + queue.peek().getName() + " is :" + queue.peek().getFuelamount());
                    Customer customer = queue.poll();
                    System.out.println("poll from the queue :" + customer);
                } else {
                    // stop supply
                    stopPumping();
                    System.out.println("The dispenser " + dispenserNumber + " unavailable until restock");
                    break;
                }

            }
        }





    }
}
