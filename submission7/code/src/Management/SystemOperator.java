package Management;

import java.util.ArrayList;

public class SystemOperator {
    private String name;
    private int sId, phoneNum;
    private ArrayList<Payment> listOfPayments =new ArrayList<>();
    private ArrayList<Ticket> listOfTickets = new ArrayList<>();

    public SystemOperator(String name, int sId, int phoneNum){
        this.name=name;
        this.sId=sId;
        this.phoneNum=phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSId() {
        return sId;
    }

    public void setSId(int sId) {
        this.sId = sId;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void addListOfPayments(Payment amount){

        this.listOfPayments.add(amount);
    }
    public void removeListOfPayments(Payment amount){

        this.listOfPayments.remove(amount);
    }

    public void addListOfTickets(Ticket t){

        this.listOfTickets.add(t);
    }
    public void removeListOfTickets(Ticket t){

        this.listOfTickets.remove(t);
    }
}
