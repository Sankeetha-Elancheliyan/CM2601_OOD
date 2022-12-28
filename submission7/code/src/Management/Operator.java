package Management;

public class Operator {

    private String name;
    private int op_id;
    private static int nextop_id=0;

    public Operator(String name) {
        this.name = name;
        this.op_id =Operator.nextop_id;
        Operator.nextop_id +=1;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOp_id() {
        return op_id;
    }

    public void setOp_id(int op_id) {
        this.op_id = op_id;
    }

    @Override
    public String toString() {
        return "Operator{" + name + "-" + op_id + '}';
    }
}
