package Management;

import java.util.LinkedList;

public class CommonQueue extends Queue{
    private int length;
    LinkedList commonqueue=new LinkedList();
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
