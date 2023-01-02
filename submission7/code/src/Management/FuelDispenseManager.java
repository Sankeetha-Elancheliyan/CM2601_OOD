package Management;

public interface FuelDispenseManager {

    //to stop the fuel supply if the fuel type repo is < 500
    public abstract void stopPumping();
    public abstract void issuefuel();
    public abstract void addnewdispenser();


}
