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

    public QuoteStruct(String _outboundOrigin, String _outboundDestination, String _outboundDepartureTime, String[] _outboundFlightCarriers, String _inboundOrigin, String _inboundDestination, String _inboundDepartureTime, String[] _inboundFlightCarriers, String _price) {
        this.outboundOrigin = _outboundOrigin;
        this.outboundDestination = _outboundDestination;
        this.outboundDepartureTime = _outboundDepartureTime;
        this.outboundFlightCarriers = _outboundFlightCarriers;
        this.inboundOrigin = _inboundOrigin;
        this.inboundDestination = _inboundDestination;
        this.inboundDepartureTime = _inboundDepartureTime;
        this.inboundFlightCarriers = _inboundFlightCarriers;
        this.price = _price;
    }

    @Override
    public String toString() {
        return "QuoteStruct{" + "outboundOrigin=" + this.outboundOrigin + ", outboundDestination=" + this.outboundDestination + ", outboundDepartureTime=" + this.outboundDepartureTime + ", outboundFlightCarriers=" + this.outboundFlightCarriers + ", inboundOrigin=" + this.inboundOrigin + ", inboundDestination=" + this.inboundDestination + ", inboundDepartureTime=" + this.inboundDepartureTime + ", inboundFlightCarriers=" + this.inboundFlightCarriers + ", price=" + this.price + '}';
    }

}
