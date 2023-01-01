package Management;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.*;
import java.util.Collection;
import java.util.List;


import java.sql.*;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Queue;

import java.sql.SQLOutput;
import java.sql.Statement;

public class driver {

    static final String DB_URL = "jdbc:mysql://localhost:3306/oop1";
    static final String USER = "root";
    static final String PASS = "";

    private static double getrevenue(Collection<Payment> payments){
        return payments.stream()
                .mapToDouble(r -> r.getPaymentValue()).sum();

    }

    public static void main(String[] args) {

        Customer c1=new Customer("Ashvin","octane","Car",10);
        Customer c2=new Customer("vignesh","octane","Car",5);
//        Customer c2=new Customer("kumaru","octane","Van",15);
        Customer c3=new Customer("SaniyanSakada","octane","Motorbike",9);
        Customer c4=new Customer("PattasuBallu","octane","Threewheeler",3);
        Customer c5=new Customer("MottaRajendran","octane","Car",16);
        Customer c6=new Customer("PaanPaarakuRavi","octane","Car",2);
        Customer c7=new Customer("PaanPaarakuRavi","octane","Car",14);
        Customer c8=new Customer("Ashvin","octane","Car",20);
        Customer c9=new Customer("kumaru","octane","Van",13);
        Customer c10=new Customer("Ashvin","octane","Car",8);
        Customer c11=new Customer("kumaru","octane","Van",10);
        Customer c12=new Customer("Ashvin","diesel","Other",25);
        Customer c13=new Customer("kumaru","diesel","Other",12);
        Customer c14=new Customer("Ashvin","diesel","Other",15);
        Customer c15=new Customer("kumaru","diesel","Other",15);
        Customer c16=new Customer("Songi","diesel","Other",15);
        Customer c17 =new Customer("hhh","octane","Car",12);
        Customer c18 =new Customer("jjjj","octane","Car",10);
        Customer c19 =new Customer("oooo","octane","Car",10);
        Customer c20 =new Customer("pppp","octane","Car",10);
        Customer c21 =new Customer("rrr","octane","Other",10);
        Customer c22 =new Customer("Songimonkey","diesel","PublicTransport",18);

////////////////////////////////////////////////////////////////////////////////////////////////
        ////file test commit added here

        System.out.println("Fuel Dispensing Management System ");
        System.out.println("_______******************________\n");
        DateTime v = new DateTime();
        System.out.println("Welcome");
//        System.out.println(v.getDateTime());
        System.out.println();
        System.out.println(v);
        /////////////////////////////////////////////////
        /////////

        OctaneRepository octanerepo = new OctaneRepository(25000,25000,v,false,25000);
        DieselRepository dieselrepo = new DieselRepository(25000,25000,v,false, 600);


        double fuelatdeiselrepo = dieselrepo.getAvailableFuel();
        System.out.println("avilable fuel: "+ fuelatdeiselrepo);



/////////////////////////////////////////////////////////////////

        DispenserQueue ocd1 = new DispenserQueue();
        DispenserQueue ocd2 = new DispenserQueue();
        DispenserQueue ocd3 = new DispenserQueue();
        DispenserQueue ocd4 = new DispenserQueue();

        DispenserQueue dd1 = new DispenserQueue();
        DispenserQueue dd2 = new DispenserQueue();
        DispenserQueue dd3 = new DispenserQueue();

        CommonQueue commonQueue = new CommonQueue();

//        for(int i=0;i<ocd1.dispenserqueue.size();i++){
//            try {
//                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                String sql = "INSERT INTO `customer` (`Name`, `FuelType`, `VehicleType`, `Amount`)"
//                        + "VALUES('" + c20.getName() + "','" + c20.getFuelType()
//                        + "','" +  c20.getVehicleType() + "'," + c20.getFuelamount()  + ")";
//                Statement stmt = conn.createStatement();
//                int j = stmt.executeUpdate(sql);
//                if (j > 0) {
//                    System.out.println("ROW INSERTED");
//                } else {
//                    System.out.println("ROW NOT INSERTED");
//                }
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            ocd1.dispenserqueue.remove();
//        }



        //Payment p1 =new Payment("cash",5000,c1,op1);
        //Payment p2 =new Payment("card",2000,c1,op1);



//
//
//        try {
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            String sql = "INSERT INTO `payment` (`paymentId`, `paymentType`, `paymentValue`, `customer`,`operator`)"
//                    + "VALUES('" + p1.getPaymentId() + "','" + p1.getPaymentType()
//                    + "','" +  p1.getPaymentValue()
//                    + "'," + p1.getCustomer().getName()
//                    + "','" +p1.getOperator().getOp_id()+")";
//            Statement stmt = conn.createStatement();
//            int j = stmt.executeUpdate(sql);
//            if (j > 0) {
//                System.out.println("ROW INSERTED");
//            } else {
//                System.out.println("ROW NOT INSERTED");
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }


        Collection<Customer> listcustomers= List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22);

//        Collection<Customer> listcustomers= List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15);
//        listcustomers.add(c16);
//
//        for(Customer c: listcustomers){
//            System.out.println(c);
//        }



//        for(int i=0;i<=ocd1.dispenserqueue.size();i++){
//            System.out.println();
//        }
//        before adding customers
        System.out.println("\nInitial Slots");
        System.out.println("Available slots in Dispenser queue 1 :"+(10-ocd1.dispenserqueue.size()));
        System.out.println("Available slots in Dispenser queue 2 :"+(10-ocd2.dispenserqueue.size()));
        System.out.println("Available slots in Dispenser queue 3 :"+(10-ocd3.dispenserqueue.size()));
        System.out.println("Available slots in Dispenser queue 4 :"+(10-ocd4.dispenserqueue.size()));
        System.out.println("Available slots in Dispenser queue 5 :"+(10-dd1.dispenserqueue.size()));
        System.out.println("Available slots in Dispenser queue 6 :"+(10-dd2.dispenserqueue.size()));
        System.out.println("Available slots in Dispenser queue 7 :"+(10-dd3.dispenserqueue.size()));

        System.out.println("Common queue length :"+ commonQueue.commonqueue.size());
        System.out.println(commonQueue.commonqueue+"\n");

//      adding customers
        for(Customer c: listcustomers){
            // if the vehicle is octane and other type vehicle adding to ocd2 if, not adding to the shortest of ocd1 or ocd2, if neither to the common queue
            if((c.getFuelType().equals("octane") && (c.getVehicleType().equals("Car") || c.getVehicleType().equals("Van"))) || (c.getFuelType().equals("octane") && (c.getVehicleType().equals("Car") || c.getVehicleType().equals("Van") || c.getVehicleType().equals("Other")))){
                if(c.getVehicleType().equals("Other")){
                    if(ocd2.dispenserqueue.size()<10){
                        ocd2.dispenserqueue.add(c);
                    }else{
                        System.out.println("OCD2 Queue full added to the common queue");
                        commonQueue.commonqueue.add(c);
                    }
                }
                else{
                    if (ocd1.dispenserqueue.size() < ocd2.dispenserqueue.size() || ocd1.dispenserqueue.size() < 10) {
                        ocd1.dispenserqueue.add(c);
                    } else if (ocd1.dispenserqueue.size() > ocd2.dispenserqueue.size() || ocd2.dispenserqueue.size() < 10) {
                        ocd2.dispenserqueue.add(c);
                        //System.out.println("OCD1 Queue full added to the common queue");
                    } else {
                        System.out.println("OCD1 Queue and OCD2 Queue full added to the common queue");
                        commonQueue.commonqueue.add(c);
                    }
                }

            }
             else if(c.getFuelType().equals("octane") && (c.getVehicleType().equals("Threewheeler"))){
                if(ocd3.dispenserqueue.size()<10){
                }
                else{
                    System.out.println("Queue full");
                    commonQueue.commonqueue.add(c);

                }
            }
             else if((c.getFuelType().equals("octane") && (c.getVehicleType().equals("Motorbike")))){
                if(ocd4.dispenserqueue.size()<10){
                    ocd4.dispenserqueue.add(c);

                }
                else{
                    System.out.println("Queue full");
                    commonQueue.commonqueue.add(c);

                }

            }
            else if(c.getFuelType().equals("diesel") && (c.getVehicleType().equals("PublicTransport"))){

                if(dd1.dispenserqueue.size()<10){
                    dd1.dispenserqueue.add(c);
                }
                else{
                    System.out.println(" DD1 Queue full");
                    commonQueue.commonqueue.add(c);

                }
            }

            //if other type disel vechile adding to the shortest dispenser
            else if(c.getFuelType().equals("diesel") && (c.getVehicleType().equals("Other"))){

                if (dd2.dispenserqueue.size() < dd3.dispenserqueue.size() && dd2.dispenserqueue.size() < 10) {
                    dd2.dispenserqueue.add(c);
                } else if (dd2.dispenserqueue.size() > dd3.dispenserqueue.size() || dd3.dispenserqueue.size() < 10) {
                    dd3.dispenserqueue.add(c);
                    //System.out.println("OCD1 Queue full added to the common queue");
                } else {
                    System.out.println("dd2 Queue and dd3 Queue full added to the common queue");
                    commonQueue.commonqueue.add(c);
                }
            }
            else{
                commonQueue.commonqueue.add(c);
            }

        }

//        for(Customer c: listcustomers){
//            try {
//                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                String sql = "INSERT INTO `customer` (`Name`, `FuelType`, `VehicleType`, `Amount`)"
//                        + "VALUES('" + c.getName() + "','" + c.getFuelType()
//                        + "','" +  c.getVehicleType() + "'," + c.getFuelamount()  + ")";
//                Statement stmt = conn.createStatement();
//                System.out.println(ocd1.dispenserqueue.poll()+"  removed");
//
//                int j = stmt.executeUpdate(sql);
//                if (j > 0) {
//                    System.out.println("ROW INSERTED");
//                    Thread.sleep(2000);
//                } else {
//                    System.out.println("ROW NOT INSERTED");
//                }
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//        System.out.println("common queue: "+ commonQueue.commonqueue);
//        System.out.println("OCD1: "+ocd1.dispenserqueue);
//        System.out.println("OCD2: "+ocd2.dispenserqueue);
//        System.out.println("OCD3: "+ocd3.dispenserqueue);
//        System.out.println("OCD4: "+ocd4.dispenserqueue);
//        System.out.println("DD1: "+dd1.dispenserqueue);
//        System.out.println("DD2: "+dd2.dispenserqueue);
//        System.out.println("DD3: "+dd3.dispenserqueue);
//        for(Customer c: listcustomers){
//            System.out.println(c);
//        }

        System.out.println("Available slots in Dispenserqueue 1 :"+(10-ocd1.dispenserqueue.size()));
        System.out.println("Available slots in Dispenserqueue 2 :"+(10-ocd2.dispenserqueue.size()));
        System.out.println("Available slots in Dispenserqueue 3 :"+(10-ocd3.dispenserqueue.size()));
        System.out.println("Available slots in Dispenserqueue 4 :"+(10-ocd4.dispenserqueue.size()));
        System.out.println("Available slots in Dispenserqueue 5 :"+(10-dd1.dispenserqueue.size()));
        System.out.println("Available slots in Dispenserqueue 6 :"+(10-dd2.dispenserqueue.size()));
        System.out.println("Available slots in Dispenserqueue 7 :"+(10-dd3.dispenserqueue.size()));

        System.out.println("Common queue length :"+ commonQueue.commonqueue.size());
        System.out.println("common queue: "+ commonQueue.commonqueue);
//        ocd1.addQueue()



        //Collection<Payment> payments =List.of(p1,p2);
        //double totalpayments= getrevenue(payments);
        //System.out.println("\nTotal Payments :"+totalpayments+"rs\n");

        System.out.println("Statistics for fuel by fuel type \n");
        double totalpetrol=0;
        for(Customer c: listcustomers){
            if(c.getFuelType().equals("octane")){
                totalpetrol+=c.getFuelamount();
            }
        }
        System.out.println("Total Diesel fuel liters :"+totalpetrol+" l");

        int totaldiesel=0;
        for(Customer c: listcustomers){
            if(c.getFuelType().equals("diesel")){
                totaldiesel+=c.getFuelamount();
            }
        }
        System.out.println("Total Petrol fuel liters :"+totaldiesel+" l");

        System.out.println("\nStatistics for fuel by vehicle type \n");
        int totalCar=0;
        for(Customer c: listcustomers){
            if(c.getVehicleType().equals("Car")){
                totalCar+=c.getFuelamount();
            }
        }
        System.out.println("Total Car fuel liters :"+totalCar+" l");

        int totalVan=0;
        for(Customer c: listcustomers){
            if(c.getVehicleType().equals("Van")){
                totalVan+=c.getFuelamount();
            }
        }
        System.out.println("Total Van fuel liters :"+totalVan+" l");
        int totalmotorbike=0;
        for(Customer c: listcustomers){
            if(c.getVehicleType().equals("Motorbike")){
                totalmotorbike+=c.getFuelamount();
            }
        }
        System.out.println("Total Motorbike fuel liters :"+totalmotorbike+" l");
        int totalthreewheeler=0;
        for(Customer c: listcustomers){
            if(c.getVehicleType().equals("Threewheeler")){
                totalthreewheeler+=c.getFuelamount();
            }
        }
        System.out.println("Total Threewheeler fuel liters :"+totalthreewheeler+" l");
        int max=0;
        Object cus=0;
        for(Customer c: listcustomers){

            if (c.getFuelamount() > max)
            {
                max = c.getFuelamount();
                cus = c;
            }
        }
        // octaneFuelDispenseManager=new OctaneFuelDispenseManager(totalpetrol,450);
        //DieselFuelDispenseManager dieselFuelDispenseManager =new DieselFuelDispenseManager(totaldiesel,430);

        Operator op1 = new Operator("David");
        Operator op2 = new Operator("Vitor");
        Operator op3 = new Operator("Viyak");
        Operator op4 = new Operator("Pari");
        Operator op5 = new Operator("Andrew");
        Operator op6 = new Operator("John");
        Operator op7 = new Operator("Tim");


        double DieselFuelAtRepo = dieselrepo.getAvailableFuel();
        double OctaneFuelAtRepo = octanerepo.getAvailableFuel();
        OctaneFuelDispenseManager OCD1 = new OctaneFuelDispenseManager(1, ocd1.dispenserqueue, "Car and Van", "Octane", true, OctaneFuelAtRepo,totalpetrol,450,op1);
        OctaneFuelDispenseManager OCD2 = new OctaneFuelDispenseManager(2, ocd2.dispenserqueue, "Car and Van and other vehicle", "Octane", true, OctaneFuelAtRepo,totalpetrol,450,op2);
        OctaneFuelDispenseManager OCD3 = new OctaneFuelDispenseManager(3, ocd3.dispenserqueue, "Threewheeler", "Octane", true, OctaneFuelAtRepo,totalpetrol,450,op3);
        OctaneFuelDispenseManager OCD4 = new OctaneFuelDispenseManager(4, ocd4.dispenserqueue, "Motorbikes", "Octane", true, OctaneFuelAtRepo,totalpetrol,450,op4);

        DieselFuelDispenseManager DD1 = new DieselFuelDispenseManager(5, dd2.dispenserqueue, "Public transport vehicles", "Diesel", true, DieselFuelAtRepo,totaldiesel,430,op5);
        DieselFuelDispenseManager DD2 = new DieselFuelDispenseManager(6, dd2.dispenserqueue, "other vehicles", "Diesel", true, DieselFuelAtRepo,totaldiesel,430,op6);
        DieselFuelDispenseManager DD3 = new DieselFuelDispenseManager(7, dd2.dispenserqueue, "other vehicles", "Diesel", true, DieselFuelAtRepo,totaldiesel,430,op7);


        System.out.println("\npetrol income "+OCD1.petrolIncome()+"rs");
        System.out.println("diesel income "+DD2.dieselIncome()+"rs");
        System.out.println("\nLargest amount of the fuel amount of the day :"+max+"L. \nDetails -:"+cus);

        double availbalefuelpetrol =octanerepo.getAvailableFuel()-totalpetrol;
        double availbalefueldiesel =dieselrepo.getAvailableFuel()-totaldiesel;
        System.out.println("\nAvailable fuel in octane repository :"+ availbalefuelpetrol+"l");
        System.out.println("Available fuel in diesel repository :"+ availbalefueldiesel+"l");

//        Thread serviceDd3;
//        while(dd1.dispenserqueue.size() > 0) {
//            serviceDd3 = new Thread(DD1);
//            serviceDd3.start();
//        }

//        while(dd2.dispenserqueue.size() > 0) {
//            Thread serviceDd2 = new Thread(DD2);
//            serviceDd2.start();
//        }

//        while(dd3.dispenserqueue.size() > 0) {
//            serviceDd3 = new Thread(DD3);
//            serviceDd3.start();
//        }


//        while (dd1.dispenserqueue.size()>0) {
//            Thread serviceDd1 = new Thread(DD1);
//            serviceDd1.start();
//        }

            Thread serviceDd2 = new Thread(DD2);
            serviceDd2.start();
            //System.out.println("the queue in driver class:" +dd2.dispenserqueue);

//        while (dd3.dispenserqueue.size()>0) {
//            Thread serviceDd3 = new Thread(DD3);
//            serviceDd3.start();
//        }

//        Thread serviceDd3 = new Thread(DD3);
//        serviceDd3.start();
//        Thread serviceDd2 = new Thread(DD2);
//        serviceDd2.start();

        System.out.println("common queue: "+ commonQueue.commonqueue);
        System.out.println("OCD1: "+ocd1.dispenserqueue);
        System.out.println("OCD2: "+ocd2.dispenserqueue);
        System.out.println("OCD3: "+ocd3.dispenserqueue);
        System.out.println("OCD4: "+ocd4.dispenserqueue);
        System.out.println("DD1: "+dd1.dispenserqueue);
        System.out.println("DD2: "+dd2.dispenserqueue);
        System.out.println("DD3: "+dd3.dispenserqueue);


////        CentralRepository centralRepo = new CentralRepository();
////        centralRepo.printStats();
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
////                Blob blob = rs.getBlob(1);
////                byte[] data = blob.getBytes(1, (int) blob.length());
//
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















    //                //deserialization
//                // Connect to the database
//                Connection con = null;
//                try {
//                    con = DriverManager.getConnection(
//                            "jdbc:mysql://localhost:3306/Petrol_Station_Queue_Management", "new", "sankee"
//                    );
//
//
//                // Create a statement with a SELECT query
//                String sql = "SELECT * FROM customer ?";
//                PreparedStatement stmt = con.prepareStatement(sql);
//
//                // Set the value of the placeholder
//                stmt.setInt(1, 1);
//
//                // Execute the query and get the ResultSet
//                ResultSet rs = stmt.executeQuery();
//
//                // Iterate through the ResultSet
//                while (rs.next()) {
//                    // Get the serialized object from the ResultSet
//                    byte[] data = rs.getBytes("data");
//
//                    // Deserialize the object using an ObjectInputStream
//                    ByteArrayInputStream bais = new ByteArrayInputStream(data);
//                    ObjectInputStream ois = new ObjectInputStream(bais);
//                    Object object = ois.readObject();
//
//                    // Cast the deserialized object to the appropriate type
//                    Customer customer = (Customer) object;
//
//                    // Use the deserialized object
//                    System.out.println(customer.getName());
//                }
//
//                // Close the streams and connection
//                ois.close();
//                bais.close();
//                stmt.close();
//                con.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }





//    SELECT fuelType, vehicleType
//    FROM customer
//    WHERE amount = (SELECT MAX(amount) FROM customer)


}
