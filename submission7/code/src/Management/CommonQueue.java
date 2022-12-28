package Management;

import java.util.LinkedList;

public class CommonQueue {
    LinkedList commonqueue=new LinkedList();

    private int NumberInQueue;


//    public CommonQueue(LinkedList commonqueue,int numberInQueue) {
//        this.commonqueue = commonqueue;
//        NumberInQueue = numberInQueue;
//    }



    public boolean addQueue(Customer c){
        return commonqueue.add(c);
    }

    public boolean removeQueue(Customer c){
        return commonqueue.remove(c);
    }
    public int getNumberInQueue() {
        return NumberInQueue;
    }

    public void setNumberInQueue(int numberInQueue) {
        NumberInQueue = numberInQueue;
    }


}
