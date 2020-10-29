package main.java.api.skyscanner.models.structures;

/**
 * A simple class to represent a leg of a journey
 *
 * @author Teegan Krieger
 */
public class JourneyLeg {

    private final int[] carrierIDs;

    private final int originID;
    private final int destinationID;
    private final String departureTime;

    public JourneyLeg(int[] carrierIDs, int originID, int destinationID, String departureTime) {
        this.carrierIDs = carrierIDs;
        this.originID = originID;
        this.destinationID = destinationID;
        this.departureTime = departureTime;
    }

    public int[] getCarrierIDs() {
        return carrierIDs;
    }

    public int getOriginID() {
        return originID;
    }

    public int getDestinationID() {
        return destinationID;
    }

    public String getDepartureTime() {
        return departureTime;
    }



}
