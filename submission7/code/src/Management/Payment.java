package Management;

import java.util.ArrayList;

public class Payment {
    // static variable to keep track of the next payment id
    private static int nextpayment_id = 0;
    // private instance variables
    private int paymentId;
    private String paymentType;
    private double paymentValue;
    private Customer customer;
    private Operator operator;

    /**
     * Constructor to create a new payment with the given details
     *
     * paymentType -  type of payment (e.g. cash, credit card)
     * paymentValue - value of the payment
     * customer -     customer making the payment
     * operator -     operator processing the payment
     */
    public Payment(String paymentType, double paymentValue, Customer customer, Operator operator) {
        this.paymentType = paymentType;
        this.paymentValue = paymentValue;
        this.customer = customer;
        this.operator = operator;
        this.paymentId = Payment.nextpayment_id;
        Payment.nextpayment_id += 1;
    }

    /**
     * Returns the payment id
     */

    public int getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the payment id
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Returns the type of payment
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Returns the customer making the payment
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the type of payment
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * Returns the value of the payment
     */
    public double getPaymentValue() {
        return paymentValue;
    }

    /**
     * Sets the value of the payment
     */
    public void setPaymentValue(double paymentValue) {
        this.paymentValue = paymentValue;
    }

    /**
     * Returns a string representation of the payment in the format "Payment{paymentType-paymentValue - customer - operator}"
     */
    @Override
    public String toString() {
        return "Payment{" +
                paymentType +
                "-" + paymentValue +
                " - " + customer +
                " - " + operator +
                '}';
    }

    /**
     * Returns the operator who processed the payment
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * Sets the operator who processed the payment
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}