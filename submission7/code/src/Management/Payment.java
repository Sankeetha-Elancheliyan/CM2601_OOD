package Management;

import java.util.ArrayList;

public class Payment {

     static private int paymentId;
    private String paymentType;
    private double paymentValue;
    private Customer customer;
    private Operator operator;
    private static int nextpayment_id=0;
    private ArrayList<Operator> listOfOperator = new ArrayList<>();


    public Payment(String paymentType, double paymentValue, Customer customer, Operator operator) {
        this.paymentType = paymentType;
        this.paymentValue = paymentValue;
        this.customer = customer;
        this.operator = operator;
        this.paymentId = Payment.paymentId;
        Payment.nextpayment_id +=nextpayment_id;

    }


    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(double paymentValue) {
        this.paymentValue = paymentValue;
    }

    @Override
    public String toString() {
        return "Payment{" +
                  paymentType +
                 "-" +paymentValue +
                 " - " + customer +
                 " - " + operator +
                '}';
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }


}
