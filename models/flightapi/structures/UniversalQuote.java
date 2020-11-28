package main.java.models.flightapi.structures;

/**
 * A class representing quote data not relying on any specific API
 *
 * @author Teegan Krieger
 * @LastModified 10/22/2020
 */
public class UniversalQuote {

    private int price;
    private Currency currency;

    private UniversalJourneyLeg outboundLeg;
    private UniversalJourneyLeg inboundLeg;

    private boolean directFlight;

    public UniversalQuote() {
        //Empty Default constructor left in for reflection.
    }

    public UniversalQuote(int _price, Currency _currency, UniversalJourneyLeg _outboundLeg, UniversalJourneyLeg _inboundLeg, boolean _directFlight) {
        this.price = _price;
        this.currency = _currency;
        this.outboundLeg = _outboundLeg;
        this.inboundLeg = _inboundLeg;
        this.directFlight = _directFlight;
    }

    //=================  GETTERS ===============
    /**
     * Get the raw price of this quote
     *
     * @return The raw price of this quote
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get the Currency object used by this quote
     *
     * @return The Currency object used by this quote
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Get the outbound JourneyLeg of this quote
     *
     * @return The outbound JourneyLeg of this quote
     */
    public UniversalJourneyLeg getOutboundLeg() {
        return outboundLeg;
    }

    /**
     * Get the inbound JourneyLeg of this quote
     *
     * @return The inbound JourneyLeg of this quote
     */
    public UniversalJourneyLeg getInboundLeg() {
        return inboundLeg;
    }

    /**
     * Get whether this flight is a direct flight or not
     *
     * @return Whether this flight is a direct flight or not
     */
    public boolean isDirectFlight() {
        return directFlight;
    }

    /**
     * Get the price of this Quote Formatted into a string
     *
     * @return The price of this Quote Formatted into a string
     */
    public String getPriceFormatted() {
        return currency.getFormattedValue(price);
    }

    @Override
    public String toString() {
        return "UniversalQuote{" + "price=" + price + ", currency=" + currency + ", outboundLeg=" + outboundLeg + ", inboundLeg=" + inboundLeg + ", directFlight=" + directFlight + '}';
    }

}
