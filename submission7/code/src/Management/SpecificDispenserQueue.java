package Management;

import java.util.ArrayList;

public class SpecificDispenserQueue extends Queue{
    private  int length,availableSlots,dispenserNum;
    private ArrayList<Ticket> listOfTicket =new ArrayList<>();

    public SpecificDispenserQueue (int length, int availableSlots,int dispenserNum ) {
        this.length = 10;
        this.availableSlots=availableSlots;
        this.dispenserNum=dispenserNum;
    }

    public int getDispenserNum() {
        return dispenserNum;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<Ticket> getListOfTicket() {
        return listOfTicket;
    }

    public void setListOfTicket(ArrayList<Ticket> listOfTicket) {
        this.listOfTicket = listOfTicket;
    }

    public void addListOfTicket(Ticket t) {
        this.listOfTicket.add(t);

    }

    public void removeListOfTicket(Ticket t){
        this.listOfTicket.remove(t);
    }

}
