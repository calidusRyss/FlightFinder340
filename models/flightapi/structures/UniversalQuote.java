package main.java.models.flightapi.structures;

/**
 * A class representing quote data not relying on any specific API
 *
 * @author Teegan Krieger
 * @LastUpdate 10/22/2020
 */
public class UniversalQuote {

    private int price;
    private Currency currency;

    private UniversalJourneyLeg outboundLeg;
    private UniversalJourneyLeg inboundLeg;

    private boolean directFlight;

    public UniversalQuote()
    {
        
    }

    public UniversalQuote(int _price, Currency _currency, UniversalJourneyLeg _outboundLeg, UniversalJourneyLeg _inboundLeg, boolean _directFlight) {
        this.price = _price;
        this.currency = _currency;
        this.outboundLeg = _outboundLeg;
        this.inboundLeg = _inboundLeg;
        this.directFlight = _directFlight;
    }

    //=================  GETTERS ===============

    public int getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public UniversalJourneyLeg getOutboundLeg() {
        return outboundLeg;
    }

    public UniversalJourneyLeg getInboundLeg() {
        return inboundLeg;
    }

    public boolean isDirectFlight() {
        return directFlight;
    }

    public String getPriceFormatted()
    {
        return currency.getFormattedValue(price);
    }

    @Override
    public String toString() {
        return "UniversalQuote{" + "price=" + price + ", currency=" + currency + ", outboundLeg=" + outboundLeg + ", inboundLeg=" + inboundLeg + ", directFlight=" + directFlight + '}';
    }

}
