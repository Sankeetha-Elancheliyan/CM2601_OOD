package Management;

public class CardPayment extends Payment{
    private int cardNum;
    private String expiry;
    private int ccv;


    public CardPayment(int payId, double amount,int cardNum, String expiry, int ccv) {
        super(payId, amount);
        this.cardNum=cardNum;
        this.expiry=expiry;
        this.ccv=ccv;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

//    hkujhkjhk
}
