package main.java.api.skyscanner.models.structures;

/**
 * A simple class to represent a leg of a journey
 *
 * @author Teegan Krieger
 * @LastModified 11/15/2020
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

    //=================  GETTERS ===============
    /**
     * Get an array of integers that represent the ID's of the carriers this JourneyLeg references
     *
     * @return An array of integers that represent the ID's of the carriers this JourneyLeg references
     */
    public int[] getCarrierIDs() {
        return carrierIDs;
    }

    /**
     * Get an integer that represents the ID of the origin place of this JourneyLeg
     *
     * @return An integer that represents the ID of the origin place of this JourneyLeg
     */
    public int getOriginID() {
        return originID;
    }

    /**
     * Get an integer that represents the ID of the destination place of this JourneyLeg
     *
     * @return An integer that represents the ID of the destination place of this JourneyLeg
     */
    public int getDestinationID() {
        return destinationID;
    }

    /**
     * Get a string that represents the departure time of the flight this JourneyLeg represents
     *
     * @return A string that represents the departure time of the flight this JourneyLeg represents
     */
    public String getDepartureTime() {
        return departureTime;
    }

}
