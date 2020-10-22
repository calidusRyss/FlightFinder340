package main.java.api.skyscanner.models.structures;

/**
 *
 * @author STUB
 */
public class Carrier {
    private int carrierID;
    private String carrierName;

    public Carrier(int carrierID, String carrierName) {
        this.carrierID = carrierID;
        this.carrierName = carrierName;
    }

    public int getCarrierID() {
        return carrierID;
    }

    public String getCarrierName() {
        return carrierName;
    }



}
