package Management;

public class Payment {
    private int payId;
    private double amount;

    public Payment (int payId, double amount ) {
        this.payId=payId;
        this.amount=amount;
    }

    public double generateReceipt( double amount){
        return amount;
    }

    public double getAmount() {
        return amount;
    }

    public int getPayId() {
        return payId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }
}
