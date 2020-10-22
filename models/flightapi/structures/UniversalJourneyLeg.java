package main.java.models.flightapi.structures;

import java.time.LocalDateTime;

/**
 *
 * @author Teegan Krieger
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

    @Override
    public String toString() {
        return "UniversalJourneyLeg{" + "carrierNames=" + carrierNames + ", originLocation=" + originLocation + ", destinationLocation=" + destinationLocation + ", departureDateTime=" + departureDateTime + '}';
    }

}
