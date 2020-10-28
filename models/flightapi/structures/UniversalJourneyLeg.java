package main.java.models.flightapi.structures;

import java.time.LocalDateTime;

/**
 * A class that represents a Journey Leg. I.E. Point A to Point B
 * Contains origin and destination locations, as well as carrier names and departure time
 *
 * @author Teegan Krieger
 * @LastUpdate 10/22/2020
 */
public class UniversalJourneyLeg {

    private final String[] carrierNames;

    private final Location originLocation;
    private final Location destinationLocation;

    private final LocalDateTime departureDateTime;

    public UniversalJourneyLeg(String[] _carrierNames, Location _originLocation, Location _destinationLocation, LocalDateTime _departureDateTime) {
        this.carrierNames = _carrierNames;
        this.originLocation = _originLocation;
        this.destinationLocation = _destinationLocation;
        this.departureDateTime = _departureDateTime;
    }

    @Override
    public String toString() {
        return "UniversalJourneyLeg{" + "carrierNames=" + carrierNames + ", originLocation=" + originLocation + ", destinationLocation=" + destinationLocation + ", departureDateTime=" + departureDateTime + '}';
    }

    //=================  GETTERS ===============

    public String[] getCarrierNames() {
        return carrierNames;
    }

    public Location getOriginLocation() {
        return originLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

}
