package main.java.api.skyscanner.models.structures;

/**
 * A class representing carrier information
 *
 * @author Teegan Krieger
 */
public class Carrier {
    private final int carrierID;
    private final String carrierName;

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
