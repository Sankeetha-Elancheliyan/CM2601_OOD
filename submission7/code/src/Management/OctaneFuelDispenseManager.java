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
    private Customer customer;
    private CommonQueue commonQueue;


    public OctaneFuelDispenseManager(int dispenserNumber, Queue<Customer> queue, String vehicleType,  String fuelType, boolean availability, double availableOctane, double fuelPumped, double unitPrice,Operator operator, CommonQueue commonQueue ) {
        this.queue = queue;
        this.fuelPumped = fuelPumped;
        this.unitPrice = unitPrice;
        this.dispenserNumber = dispenserNumber;
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.availability = availability;
        this.availableOctane = availableOctane;
        this.operator=operator;
        this.commonQueue = commonQueue;
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
        Object lock = new Object();
        while (queue.size() > 0) {

            //Check availability if the octane fuel available is > 500
            if (availableOctane > 500) {

                synchronized (lock) {
                    // dispense fuel and update available octane
                    availableOctane -= queue.peek().getFuelamount();
                    System.out.println("Octane Supplied of " + queue.peek().getFuelamount() + "L remaining fuel at repository is: " + availableOctane);

                    // handle payment
                    cash_amount_for_dispence = queue.peek().getFuelamount() * unitPrice;
                    System.out.println("The operator " + operator.getName() + "of id " + operator.getOp_id() + " handled Rs." + cash_amount_for_dispence + ".");

                    // updating database with customer information
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/Petrol_Station_Queue_Management", "admin", "admin"
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
                }

                // Dequeue customer
                System.out.println("the required fuels is for " + queue.peek().getName() + " is :" + queue.peek().getFuelamount());
                Customer customer = queue.poll();
                System.out.println("Following customer dispensed :" + customer);
                System.out.println("\n\n");

                //Check the common queue and if any octane vehicles are there add them to the relevant dispenser
                for (int i = 0; i < commonQueue.commonqueue.size(); i++) {
                    Customer currentCustomer = commonQueue.commonqueue.get(i);
                    if (dispenserNumber == 1) {
                        if (currentCustomer.getFuelType().equals("octane") && currentCustomer.getVehicleType().equals("Car") || currentCustomer.getFuelType().equals("octane") && currentCustomer.getVehicleType().equals("Van")) {
                            queue.add(currentCustomer);
                            commonQueue.commonqueue.remove(i);
                            break;
                        } else if (dispenserNumber == 2) {
                            if (currentCustomer.getFuelType().equals("octane") && currentCustomer.getVehicleType().equals("Car") || currentCustomer.getFuelType().equals("octane") && currentCustomer.getVehicleType().equals("Van") || currentCustomer.getFuelType().equals("octane") && currentCustomer.getVehicleType().equals("Other")) {
                                queue.add(currentCustomer);
                                commonQueue.commonqueue.remove(i);
                                break;
                            } else if (dispenserNumber == 3) {
                                if (currentCustomer.getFuelType().equals("octane") && currentCustomer.getVehicleType().equals("Threewheeler")) {
                                    queue.add(currentCustomer);
                                    commonQueue.commonqueue.remove(i);
                                    break;
                                } else if (dispenserNumber == 4) {
                                    if (currentCustomer.getFuelType().equals("octane") && currentCustomer.getVehicleType().equals("Motorbike")) {
                                        queue.add(currentCustomer);
                                        commonQueue.commonqueue.remove(i);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

            }else {
                // stop fuel supply and break loop
                stopPumping();
                System.out.println("The dispenser " + dispenserNumber + " unavailable until restock");
                break;
            }
        }
    }
}