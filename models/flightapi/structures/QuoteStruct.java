package main.java.models.flightapi.structures;

/**
 * A class containing quote data in formatted strings.
 *
 * @author Teegan Krieger
 * @LastUpdated 10/22/2020
 */
public class QuoteStruct {
    public final String outboundOrigin;                 //The origin destination
    public final String outboundDestination;
    public final String outboundDepartureTime;    //The 1st flights departure time
    public final String[] outboundFlightCarriers;    //The 1st flights carrier

    public final String inboundOrigin;
    public final String inboundDestination;            //The destination
    public final String inboundDepartureTime;   //The departure time of the 1st inbound flight
    public final String[] inboundFlightCarriers;   //The carrier of the 1st inbound flight

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
