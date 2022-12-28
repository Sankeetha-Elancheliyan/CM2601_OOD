import java.util.Scanner;

public class Payment {
    private String paymentMethod;
    private double paymentValue;
    private double balance;


    public Payment(String paymentMethod, double paymentValue, double balance) {
        this.paymentMethod = paymentMethod;
        this.paymentValue = paymentValue;
        this.balance = balance;
    }


    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(double paymentValue) {
        this.paymentValue = paymentValue;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void paymentVerification(){
        Scanner s = new Scanner(System.in);
        System.out.println("Amount Due: "+ paymentValue);
        System.out.println("Enter Amount: ");
        Double amountReceived = s.nextDouble();
        if (amountReceived.equals(paymentValue)){
            System.out.println("Payment Received");
        }else {
            System.out.println("Issue with the payment!");
        }
    }
}
