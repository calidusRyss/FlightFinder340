package main.java.models.flightapi.structures;

/**
 * A class containing quote data in formatted strings.
 *
 * @author Teegan Krieger
 * @LastModified 10/22/2020
 */
public class QuoteStruct {
    public final String outboundOrigin;
    public final String outboundDestination;
    public final String outboundDepartureTime;
    public final String[] outboundFlightCarriers;

    public final String inboundOrigin;
    public final String inboundDestination;
    public final String inboundDepartureTime;
    public final String[] inboundFlightCarriers;

    public final String price;  //The minimum starting price of the entire trip

    public QuoteStruct(String outboundOrigin, String outboundDestination, String outboundDepartureTime, String[] outboundFlightCarriers, String inboundOrigin, String inboundDestination, String inboundDepartureTime, String[] inboundFlightCarriers, String price) {
        this.outboundOrigin = outboundOrigin;
        this.outboundDestination = outboundDestination;
        this.outboundDepartureTime = outboundDepartureTime;
        this.outboundFlightCarriers = outboundFlightCarriers;
        this.inboundOrigin = inboundOrigin;
        this.inboundDestination = inboundDestination;
        this.inboundDepartureTime = inboundDepartureTime;
        this.inboundFlightCarriers = inboundFlightCarriers;
        this.price = price;
    }

    @Override
    public String toString() {
        return "QuoteStruct{" + "outboundOrigin=" + outboundOrigin + ", outboundDestination=" + outboundDestination + ", outboundDepartureTime=" + outboundDepartureTime + ", outboundFlightCarriers=" + outboundFlightCarriers + ", inboundOrigin=" + inboundOrigin + ", inboundDestination=" + inboundDestination + ", inboundDepartureTime=" + inboundDepartureTime + ", inboundFlightCarriers=" + inboundFlightCarriers + ", price=" + price + '}';
    }


}
