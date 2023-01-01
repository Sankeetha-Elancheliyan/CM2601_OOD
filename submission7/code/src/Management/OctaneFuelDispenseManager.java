package Management;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Queue;

public class OctaneFuelDispenseManager implements FuelDispenseManager, Runnable {

    //private double fuelPumped,unitPrice,amount;
    private Operator operator;

    private final Queue<Customer> queue;
    private double fuelPumped,unitPrice,amount;
    private int dispenserNumber;
    private String fuelType;
    private String vehicleType;
    private boolean availability;
    private  double availableOctane;
    private double cash_amount_for_dispence;


    public OctaneFuelDispenseManager(int dispenserNumber, Queue<Customer> queue, String vehicleType,  String fuelType, boolean availability, double availableOctane, double fuelPumped, double unitPrice,Operator operator ) {
        this.queue = queue;
        this.fuelPumped = fuelPumped;
        this.unitPrice = unitPrice;
        this.dispenserNumber = dispenserNumber;
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.availability = availability;
        this.availableOctane = availableOctane;
        this.operator=operator;
    }

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
        System.out.println("notenough fuel");
    }

    @Override
    public void issuefuel() {
        System.out.println("supply fuel");
    }

    @Override
    public void addnewdispenser() {
        System.out.println("adding new dispenser");

    }
     public double petrolIncome(){
        return this.unitPrice*this.fuelPumped;
     }


    @Override
    public void run() {
        while (queue.size() > 0) {
            Object lock = new Object();
            // synchronize concurrent behavior
            synchronized (lock) {
                if (availableOctane > 500) {
                    // dispense fuel and update available octane
                    availableOctane -= queue.peek().getFuelamount();
                    System.out.println("Octane Supplied of " + queue.peek().getFuelamount() + "L remaining fuel at repository is: " + availableOctane);

                    // handle payment
                    cash_amount_for_dispence = queue.peek().getFuelamount() * unitPrice;
                    System.out.println("The operator " + operator.getName() + "of id " + operator.getOp_id() + " handled Rs."+ cash_amount_for_dispence +".");

                    // update database with customer information
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/Petrol_Station_Queue_Management", "admin", "admin"
                        );
                        // create prepared statement with insert query
                        String sql = "INSERT INTO customer (name, fuelType, vehicleType, amount) VALUES (?, ?, ?, ?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        // set values of placeholders
                        stmt.setString(1, queue.peek().getName());
                        stmt.setString(2, queue.peek().getFuelType());
                        stmt.setString(3, queue.peek().getVehicleType());
                        stmt.setInt(4, queue.peek().getFuelamount());
                        // serialize object to byte array
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(baos);
                        oos.writeObject(queue.peek());
                        byte[] data = baos.toByteArray();
                        // set prepared statement's parameter to serialized object
                        stmt.setObject(1, data[0]);
                        stmt.setObject(2, data[1]);
                        stmt.setObject(3, data[2]);
                        stmt.setObject(4, data[3]);
                        // execute prepared statement
                        stmt.executeUpdate();
                        // close streams and connection
                        oos.close();
                        baos.close();
                        stmt.close();
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    // dequeue customer
                    System.out.println("the required fuels is for " + queue.peek().getName() + " is :" + queue.peek().getFuelamount());
                    Customer customer = queue.poll();
                    System.out.println("Following customer dispensed :" + customer);
                    System.out.println("\n\n");
                } else {
                    // stop fuel supply and break loop
                    stopPumping();
                    System.out.println("The dispenser " + dispenserNumber + " unavailable until restock");
                    break;
                }
            }
        }
    }
}
