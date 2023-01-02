package Management;

public class Operator {
    // static variable to keep track of the next operator id
    private static int nextop_id = 0;
    // private instance variables
    private String name;
    private int op_id;

    /**
     * Constructor to create a new operator with the given name
     */
    public Operator(String name) {
        this.name = name;
        this.op_id = Operator.nextop_id;
        Operator.nextop_id += 1;
    }

    /**
     * Returns the name of the operator
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the operator
     *name - name to set for the operator
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the id of the operator
     */
    public int getOp_id() {
        return op_id;
    }

    /**
     * Sets the id of the operator
     */
    public void setOp_id(int op_id) {
        this.op_id = op_id;
    }

    /**
     * Returns a string representation of the operator in the format "Operator{name-op_id}"
     */
    @Override
    public String toString() {
        return "Operator{" + name + "-" + op_id + '}';
    }
}
