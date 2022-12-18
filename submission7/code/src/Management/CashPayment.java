package Management;

public class CashPayment extends Payment{
    private double balance;


    public CashPayment(int payId, double amount, double balance) {
        super(payId, amount);
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
