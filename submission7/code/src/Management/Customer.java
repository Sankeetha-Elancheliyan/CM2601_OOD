package Management;

public class Customer  {
    private int cId,phoneNum;
    private  String name,fuelType,VehicleType;


    public Customer(String name, int phoneNum,  int cId, String fuelType, String vehicleType) {
        this.fuelType = fuelType;
        this.VehicleType = vehicleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void getPayment() {

    }



}

