package main.java.models.flightapi.structures;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A class that represents a Journey Leg. I.E. Point A to Point B
 * Contains origin and destination locations, as well as carrier names and departure time
 *
 * @author Teegan Krieger
 * @LastModified 10/22/2020
 */
public class UniversalJourneyLeg {

    private static final DateTimeFormatter universalDateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private String[] carrierNames;

    private Location originLocation;
    private Location destinationLocation;

    private String departureDateTime;

    public UniversalJourneyLeg()
    {
        //Empty Default constructor left in for reflection.
    }

    public UniversalJourneyLeg(String[] _carrierNames, Location _originLocation, Location _destinationLocation, LocalDateTime _departureDateTime) {
        this.carrierNames = _carrierNames;
        this.originLocation = _originLocation;
        this.destinationLocation = _destinationLocation;
        this.departureDateTime = _departureDateTime.format(universalDateTimeFormatter);
    }

    @Override
    public String toString() {
        return "UniversalJourneyLeg{" + "carrierNames=" + carrierNames + ", originLocation=" + originLocation + ", destinationLocation=" + destinationLocation + ", departureDateTime=" + departureDateTime + '}';
    }

    //=================  GETTERS ===============

    /**
     * Get an array of carrier names associated to this JourneyLeg
     * @return An array of carrier names associated to this JourneyLeg
     */
    public String[] getCarrierNames() {
        return carrierNames;
    }

    /**
     * Get the origin location of this JourneyLeg
     * @return The origin location of this JourneyLeg
     */
    public Location getOriginLocation() {
        return originLocation;
    }

    /**
     * Get the destination location of this JourneyLeg
     * @return The destination location of this JourneyLeg
     */
    public Location getDestinationLocation() {
        return destinationLocation;
    }

    /**
     * Get the departure date and time of this JourneyLeg
     * @return The departure date and time of this JourneyLeg
     */
    public String getDepartureDateTime() {
        return departureDateTime;
    }

}
