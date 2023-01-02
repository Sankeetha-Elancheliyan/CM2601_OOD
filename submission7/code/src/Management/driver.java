package Management;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.*;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


import java.sql.*;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;

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

    public static void main(String[] args) throws InterruptedException {

        Customer c1 = new Customer("Ashvin", "octane", "Car", 10);
        Customer c2 = new Customer("vignesh", "octane", "Car", 5);
//        Customer c2=new Customer("kumaru","octane","Van",15);
        Customer c3 = new Customer("Sakada", "octane", "Motorbike", 9);
        Customer c4 = new Customer("suBallu", "octane", "Threewheeler", 3);
        Customer c5 = new Customer("jendran", "octane", "Car", 16);
        Customer c6 = new Customer("Ravi", "octane", "Car", 2);
        Customer c7 = new Customer("Ravi", "octane", "Car", 14);
        Customer c8 = new Customer("Ashvin", "octane", "Car", 20);
        Customer c9 = new Customer("kumaru", "octane", "Van", 13);
        Customer c10 = new Customer("Ashvin", "octane", "Car", 8);
        Customer c11 = new Customer("kumaru", "octane", "Van", 10);
        Customer c12 = new Customer("Ashvin", "diesel", "Other", 25);
        Customer c13 = new Customer("kumaru", "diesel", "Other", 12);
        Customer c14 = new Customer("Ashvin", "diesel", "Other", 15);
        Customer c15 = new Customer("kumaru", "diesel", "Other", 15);
        Customer c16 = new Customer("Songi", "diesel", "Other", 15);
        Customer c17 = new Customer("hhh", "octane", "Car", 12);
        Customer c18 = new Customer("jjjj", "octane", "Car", 10);
        Customer c19 = new Customer("oooo", "octane", "Car", 10);
        Customer c20 = new Customer("pppp", "octane", "Car", 10);
        Customer c21 = new Customer("rrr", "octane", "Other", 10);
        Customer c22 = new Customer("Songimonkey", "diesel", "PublicTransport", 18);

        Customer c23 = new Customer("jjjj", "octane", "Car", 10);
        Customer c24 = new Customer("oooo", "octane", "Car", 10);
        Customer c25 = new Customer("pppp", "octane", "Car", 10);
        Customer c26 = new Customer("rrr", "octane", "Other", 10);

        Customer c27 = new Customer("jjjj", "octane", "Car", 10);
        Customer c28 = new Customer("oooo", "octane", "Car", 10);
        Customer c29 = new Customer("pppp", "octane", "Other", 10);
        Customer c30 = new Customer("rrr", "octane", "Other", 10);

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


        OctaneRepository octanerepo = new OctaneRepository(25000, 25000, v, false, 25000);
        DieselRepository dieselrepo = new DieselRepository(25000, 25000, v, false, 25000);


        double fuelatdeiselrepo = dieselrepo.getAvailableFuel();
        System.out.println("avilable fuel: " + fuelatdeiselrepo);


/////////////////////////////////////////////////////////////////

        DispenserQueue ocd1 = new DispenserQueue();
        DispenserQueue ocd2 = new DispenserQueue();
        DispenserQueue ocd3 = new DispenserQueue();
        DispenserQueue ocd4 = new DispenserQueue();

        DispenserQueue dd1 = new DispenserQueue();
        DispenserQueue dd2 = new DispenserQueue();
        DispenserQueue dd3 = new DispenserQueue();

        CommonQueue commonQueue = new CommonQueue();



//        Collection<Customer> listcustomers= List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22);

        LinkedList<Customer> listcustomers = new LinkedList<Customer>();
        Collections.addAll(listcustomers, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30);


//      adding customers
        for (Customer c : listcustomers) {
            // if the vehicle is octane and other type vehicle adding to ocd2 if, not adding to the shortest of ocd1 or ocd2, if neither to the common queue
            if ((c.getFuelType().equals("octane") && (c.getVehicleType().equals("Car") || c.getVehicleType().equals("Van"))) || (c.getFuelType().equals("octane") && (c.getVehicleType().equals("Car") || c.getVehicleType().equals("Van") || c.getVehicleType().equals("Other")))) {
                if (c.getVehicleType().equals("Other")) {
                    if (ocd2.dispenserqueue.size() < 10) {
                        ocd2.dispenserqueue.add(c);
                    } else {
                        System.out.println("OCD2 Queue full added to the common queue");
                        commonQueue.commonqueue.add(c);
                    }
                } else {
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

            } else if (c.getFuelType().equals("octane") && (c.getVehicleType().equals("Threewheeler"))) {
                if (ocd3.dispenserqueue.size() < 10) {
                } else {
                    System.out.println("Queue full");
                    commonQueue.commonqueue.add(c);

                }
            } else if ((c.getFuelType().equals("octane") && (c.getVehicleType().equals("Motorbike")))) {
                if (ocd4.dispenserqueue.size() < 10) {
                    ocd4.dispenserqueue.add(c);

                } else {
                    System.out.println("Queue full");
                    commonQueue.commonqueue.add(c);

                }

            } else if (c.getFuelType().equals("diesel") && (c.getVehicleType().equals("PublicTransport"))) {

                if (dd1.dispenserqueue.size() < 10) {
                    dd1.dispenserqueue.add(c);
                }else{
                    System.out.println(" DD1 Queue full");
                    commonQueue.commonqueue.add(c);
                }
            }

            //if other type disel vechile adding to the shortest dispenser
            else if (c.getFuelType().equals("diesel") && (c.getVehicleType().equals("Other"))) {

                if (dd2.dispenserqueue.size() < dd3.dispenserqueue.size() && dd2.dispenserqueue.size() < 10) {
                    dd2.dispenserqueue.add(c);
                } else if (dd2.dispenserqueue.size() > dd3.dispenserqueue.size() || dd3.dispenserqueue.size() < 10) {
                    dd3.dispenserqueue.add(c);
                    //System.out.println("OCD1 Queue full added to the common queue");
                } else {
                    System.out.println("dd2 Queue and dd3 Queue full added to the common queue");
                    commonQueue.commonqueue.add(c);
                }
            } else {
                commonQueue.commonqueue.add(c);
            }

        }

        // Issuing Tickets to customers in each specific queue

        int ticketNumber = 1;
        for ( Customer C1: ocd1.dispenserqueue) {
            C1.setTicketNumber(ticketNumber);
            ticketNumber++;
            System.out.println( C1.getName()+"'s Ticket:"+ ticketNumber);
        }
        for (Customer C1 : ocd2.dispenserqueue) {
            C1.setTicketNumber(ticketNumber);
            ticketNumber++;
            System.out.println( C1.getName()+"'s Ticket:"+ ticketNumber);
        }
        for (Customer C1 : ocd3.dispenserqueue) {
            C1.setTicketNumber(ticketNumber);
            ticketNumber++;
            System.out.println( C1.getName()+"'s Ticket:"+ ticketNumber);
        }
        for (Customer C1 : ocd4.dispenserqueue) {
            C1.setTicketNumber(ticketNumber);
            ticketNumber++;
            System.out.println( C1.getName()+"'s Ticket:"+ ticketNumber);
        }
        for (Customer C1 : dd1.dispenserqueue) {
            C1.setTicketNumber(ticketNumber);
            ticketNumber++;
            System.out.println( C1.getName()+"'s Ticket:"+ ticketNumber);
        }
        for (Customer C1 : dd2.dispenserqueue) {
            C1.setTicketNumber(ticketNumber);
            ticketNumber++;
            System.out.println( C1.getName()+"'s Ticket:"+ ticketNumber);
        }
        for (Customer C1 : dd3.dispenserqueue) {
            C1.setTicketNumber(ticketNumber);
            ticketNumber++;
            System.out.println( C1.getName()+"'s Ticket:"+ ticketNumber);
        }



        System.out.printf("%78s\n", "\033[1mDISPLAY AVAILABLE SLOTS");
        System.out.printf("%5s %11s %12s %12s %12s %12s %12s", "| Dispenserqueue 1 |", "Dispenserqueue 2 |", "Dispenserqueue 3 |", "Dispenserqueue 4 |", "Dispenserqueue 5 |", "Dispenserqueue 6 |", "Dispenserqueue 7 |\n");
        System.out.format("%8s %20s %17s %17s %18s %18s %19s", 10 - ocd1.dispenserqueue.size(), 10 - ocd2.dispenserqueue.size(), 10 - ocd3.dispenserqueue.size(), 10 - ocd4.dispenserqueue.size(), 10 - dd1.dispenserqueue.size(), 10 - dd2.dispenserqueue.size(), 10 - dd3.dispenserqueue.size());
        System.out.println("\n\n           \033[1mDisplaying Dispenser 1 ");
        ocd1.iterateUsingEnhancedForLoop(ocd1.dispenserqueue);
        System.out.println("\n          \033[1mDisplaying Dispenser 2 ");
        ocd1.iterateUsingEnhancedForLoop(ocd2.dispenserqueue);
        System.out.println("\n          \033[1mDisplaying Dispenser 3 ");
        ocd1.iterateUsingEnhancedForLoop(ocd3.dispenserqueue);
        System.out.println("\n          \033[1mDisplaying Dispenser 4 ");
        ocd1.iterateUsingEnhancedForLoop(ocd4.dispenserqueue);
        System.out.println("\n          \033[1mDisplaying Dispenser 5 ");
        ocd1.iterateUsingEnhancedForLoop(dd1.dispenserqueue);
        System.out.println("\n          \033[1mDisplaying Dispenser 6 ");
        ocd1.iterateUsingEnhancedForLoop(dd2.dispenserqueue);



        System.out.println("Common Queue length: " + commonQueue.commonqueue.size());
        System.out.println("Common Queue: " + commonQueue.commonqueue);



        System.out.println("\n \033[1m Statistics for fuel by fuel type \n");
        double totalpetrol = 0;
        for (Customer c : listcustomers) {
            if (c.getFuelType().equals("octane")) {
                totalpetrol += c.getFuelamount();
            }
        }
//        System.out.println("Total petrol fuel liters :"+totalpetrol+" l");

        int totaldiesel = 0;
        for (Customer c : listcustomers) {
            if (c.getFuelType().equals("diesel")) {
                totaldiesel += c.getFuelamount();
            }
        }
//        System.out.println("Total diesel fuel liters :"+totaldiesel+" l");

        System.out.println("\n \033[1m___Statistics for fuel by fuel type___ \n");
        System.out.println(" ---------------------");
        System.out.printf("%5s %11s "," | Diesel |","Petrol |\n");
        System.out.println("--------------------- ");
        System.out.format("%7s %12s",totaldiesel,totalpetrol);
        System.out.println("\n ---------------------");
        int totalCar = 0;
        for (Customer c : listcustomers) {
            if (c.getVehicleType().equals("Car")) {
                totalCar += c.getFuelamount();
            }
        }
//        System.out.println("Total Car fuel liters :"+totalCar+" l");

        int totalVan = 0;
        for (Customer c : listcustomers) {
            if (c.getVehicleType().equals("Van")) {
                totalVan += c.getFuelamount();
            }
        }
//        System.out.println("Total Van fuel liters :"+totalVan+" l");
        int totalmotorbike = 0;
        for (Customer c : listcustomers) {
            if (c.getVehicleType().equals("Motorbike")) {
                totalmotorbike += c.getFuelamount();
            }
        }
//        System.out.println("Total Motorbike fuel liters :"+totalmotorbike+" l");
        int totalthreewheeler = 0;
        for (Customer c : listcustomers) {
            if (c.getVehicleType().equals("Threewheeler")) {
                totalthreewheeler += c.getFuelamount();
            }
        }
//        System.out.println("Total Threewheeler fuel liters :"+totalthreewheeler+" l");
        int max = 0;
        Object cus = 0;
        for (Customer c : listcustomers) {

            if (c.getFuelamount() > max) {
                max = c.getFuelamount();
                cus = c;
            }
        }

        System.out.println("\033[1m___Statistics for fuel by vehicle type___ \n");
        System.out.println(" -------------------------------------------");
        System.out.printf("%1s %5s %5s %11s","| Car |","| Van |","| motorbike |","| threewheeler |\n");
        System.out.println(" -------------------------------------------");

        System.out.format("%5s %6s %10s %13s ",totalCar,totalVan,totalmotorbike,totalthreewheeler);
        System.out.println(" \n-------------------------------------------");


        Operator op1 = new Operator("David");
        Operator op2 = new Operator("Vitor");
        Operator op3 = new Operator("Viyak");
        Operator op4 = new Operator("Pari");
        Operator op5 = new Operator("Andrew");
        Operator op6 = new Operator("John");
        Operator op7 = new Operator("Tim");


        double DieselFuelAtRepo = dieselrepo.getAvailableFuel();
        double OctaneFuelAtRepo = octanerepo.getAvailableFuel();

        //creating octane fuel dispensers
        OctaneFuelDispenseManager OCD1 = new OctaneFuelDispenseManager(1, ocd1.dispenserqueue, "Car and Van", "Octane", true, OctaneFuelAtRepo, totalpetrol, 450, op1, commonQueue);
        OctaneFuelDispenseManager OCD2 = new OctaneFuelDispenseManager(2, ocd2.dispenserqueue, "Car and Van and other vehicle", "Octane", true, OctaneFuelAtRepo, totalpetrol, 450, op2, commonQueue);
        OctaneFuelDispenseManager OCD3 = new OctaneFuelDispenseManager(3, ocd3.dispenserqueue, "Threewheeler", "Octane", true, OctaneFuelAtRepo, totalpetrol, 450, op3, commonQueue);
        OctaneFuelDispenseManager OCD4 = new OctaneFuelDispenseManager(4, ocd4.dispenserqueue, "Motorbikes", "Octane", true, OctaneFuelAtRepo, totalpetrol, 450, op4, commonQueue);

        //creating Diesel fuel dispensers
        DieselFuelDispenseManager DD1 = new DieselFuelDispenseManager(5, dd1.dispenserqueue, "Public transport vehicles", "Diesel", true, DieselFuelAtRepo, totaldiesel, 430, op5, commonQueue);
        DieselFuelDispenseManager DD2 = new DieselFuelDispenseManager(6, dd2.dispenserqueue, "other vehicles", "Diesel", true, DieselFuelAtRepo, totaldiesel, 430, op6, commonQueue);
        DieselFuelDispenseManager DD3 = new DieselFuelDispenseManager(7, dd3.dispenserqueue, "other vehicles", "Diesel", true, DieselFuelAtRepo, totaldiesel, 430, op7, commonQueue);

        //********* these code need to be rewritten ***********
        System.out.println("\nTotal Petrol income Rs. " + OCD1.petrolIncome());
        System.out.println("Total Diesel income Rs." + DD2.dieselIncome());
        System.out.println("\nThe Largest amount of the fuel amount of the day :" + max + "L. \nDetails -:" + cus);

        double availbalefuelpetrol = octanerepo.getAvailableFuel() - totalpetrol;
        double availbalefueldiesel = dieselrepo.getAvailableFuel() - totaldiesel;
        System.out.println("\nAvailable fuel in octane repository :" + availbalefuelpetrol + "l");
        System.out.println("Available fuel in diesel repository :" + availbalefueldiesel + "l");


        Thread serviceOCD1 = new Thread(OCD1);
        serviceOCD1.start();

        Thread serviceOCD2 = new Thread(OCD2);
        serviceOCD2.start();

        Thread serviceOCD3 = new Thread(OCD3);
        serviceOCD3.start();

        Thread serviceOCD4 = new Thread(OCD4);
        serviceOCD4.start();

        Thread serviceDD1 = new Thread(DD1);
        serviceDD1.start();

        Thread serviceDD2 = new Thread(DD2);
        serviceDD2.start();

        Thread serviceDD3 = new Thread(DD3);
        serviceDD3.start();

        serviceOCD1.join();
        serviceOCD2.join();
        serviceOCD3.join();
        serviceOCD4.join();
        serviceDD1.join();
        serviceDD2.join();
        serviceDD3.join();

        System.out.println("This is the end");

        CentralRepository centralRepo = new CentralRepository();
        centralRepo.printStats();

        System.out.println("the final ocd1 queue:"+ ocd1.dispenserqueue);
        System.out.println("the final ocd2 queue:"+ ocd2.dispenserqueue);
        System.out.println("the final ocd3 queue:"+ ocd3.dispenserqueue);
        System.out.println("the final ocd4 queue:"+ ocd4.dispenserqueue);
        System.out.println("the final dd1 queue:"+ dd1.dispenserqueue);
        System.out.println("the final dd2 queue:"+ dd2.dispenserqueue);
        System.out.println("the final dd3 queue:"+ dd3.dispenserqueue);
        System.out.println("the final common queue:"+ commonQueue.commonqueue);

    }
}