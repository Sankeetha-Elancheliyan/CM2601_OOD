package Management;

public class CentralFuelRepository {
    private double StockAmount;
    private double Capacity;
    private DateTime dateTime;
    private boolean is500L;

    public CentralRepository(double stockAmount, double capacity, DateTime datetime, boolean is500L) {
        StockAmount = stockAmount;
        Capacity = capacity;
        this.dateTime=datetime;
        this.is500L = is500L;
    }

    public double getStockAmount() {
        return StockAmount;
    }

    public void setStockAmount(double stockAmount) {
        StockAmount = stockAmount;
    }
    public boolean stopPumping(){
        return is500L;
    }
}
