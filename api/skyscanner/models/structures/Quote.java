package main.java.api.skyscanner.models.structures;

/**
 * A class that holds information about a Quote from the SkyScanner API
 *
 * @author Willie Holmes
 * @LastModified 11/15/2020
 */
public class Quote {

    private int quoteId;
    private int minPrice;
    private boolean direct;
    private JourneyLeg outboundLeg;
    private JourneyLeg inboundLeg;
    private String quoteDateTime;

    /**
     * Construct a Quotes object
     *
     * @param _QuoteId. Example: '1'
     * @param _MinPrice. Minimum Price available. Example: '381'
     * @param _Direct Boolean determining Whether the flight is a direct flight or connected. Example: 'true'
     * @param _OutboundLeg The outbound identifiers of the trip
     * @param _InboundLeg The Inbound identifiers of the trip
     * @param _QuoteDateTime The date and time quote was received. Example '"2016-11-09T21:20:00"'
     */
    public Quote(int _QuoteId, int _MinPrice, boolean _Direct, JourneyLeg _OutboundLeg, JourneyLeg _InboundLeg, String _QuoteDateTime) {
        this.quoteId = _QuoteId;
        this.minPrice = _MinPrice;
        this.direct = _Direct;
        this.outboundLeg = _OutboundLeg;
        this.inboundLeg = _InboundLeg;
        this.quoteDateTime = _QuoteDateTime;

    }

    @Override
    public String toString() {
        return "Quotes [QuoteId=" + this.quoteId + ", MinPrice=" + this.minPrice + ",  Direct=" + this.direct
                + ", OutboundLeg=" + this.outboundLeg + ", CarrierIds="
                + ", InboundLeg=" + this.inboundLeg + ",QuoteDateTime=" + this.quoteDateTime + "]";
    }

    //=================  GETTERS ===============
    /**
     * Get an integer that represents the ID of this quote
     *
     * @return An integer that represents the ID of this quote
     */
    public int getQuoteId() {
        return this.quoteId;
    }

    /**
     * Get the minimum price of this quote in the form of an integer
     *
     * @return The minimum price of this quote in the form of an integer
     */
    public int getMinPrice() {
        return this.minPrice;
    }

    /**
     * Get a Boolean that describes whether the quote is a direct flight or not
     *
     * @return A Boolean that describes whether the quote is a direct flight or not
     */
    public boolean isDirect() {
        return this.direct;
    }

    /**
     * Get the outbound JourneyLeg of this quote
     *
     * @return The outbound JourneyLeg of this quote
     */
    public JourneyLeg getOutboundLeg() {
        return this.outboundLeg;
    }

    /**
     * Get the inbound JourneyLeg of this quote
     *
     * @return The inbound JourneyLeg of this quote
     */
    public JourneyLeg getInboundLeg() {
        return this.inboundLeg;
    }

    /**
     * Get the time this quote was requested at
     *
     * @return The time this quote was requested at
     */
    public String getQuoteDateTime() {
        return this.quoteDateTime;
    }

}
