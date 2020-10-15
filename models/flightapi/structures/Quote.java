package main.java.models.flightapi.structures;

import java.time.LocalDate;

/**
 * A class representing quote data
 *
 * @author Teegan Krieger
 * @LastUpdate 10/8/2020
 */
public class Quote {

    private final LocalDate departureDateTime;

    private final int price;
    private final Currency currency;

    private final Carrier[] outboundCarriers;
    private final Carrier[] inboundCarriers;

    private final Location originLocation;
    private final Location destinationLocation;

    private final boolean directFlight;

    public Quote(LocalDate _departureDateTime, int _price, Currency _currency, Carrier[] _outboundCarriers, Carrier[] _inboundCarriers, Location _originLocation, Location _destinationLocation, boolean _directFlight) {
        this.departureDateTime = _departureDateTime;
        this.price = _price;
        this.currency = _currency;
        this.outboundCarriers = _outboundCarriers;
        this.inboundCarriers = _inboundCarriers;
        this.originLocation = _originLocation;
        this.destinationLocation = _destinationLocation;
        this.directFlight = _directFlight;
    }

    //=================  GETTERS ===============

    public LocalDate getDepartureDateTime() {
        return departureDateTime;
    }

    public int getPriceValue() {
        return price;
    }

    public String getPriceFormatted()
    {
        //Make call to Currency.FormatValue();
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Carrier[] getOutboundCarriers() {
        return outboundCarriers;
    }

    public Carrier[] getInboundCarriers() {
        return inboundCarriers;
    }

    public Location getOriginLocation() {
        return originLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public boolean isDirectFlight() {
        return directFlight;
    }
}
