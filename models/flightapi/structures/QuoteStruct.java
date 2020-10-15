package main.java.models.flightapi.structures;

/**
 * A class containing quote data in formatted strings.
 *
 * @author Teegan Krieger
 * @LastUpdated 10/14/2020
 */
public class QuoteStruct {
    public final String origin;                 //The origin destination
    public final String originDepartureTime;    //The 1st flights departure time
    public final String originFlightCarrier;    //The 1st flights carrier

    public final String destination;            //The destination
    public final String inboundDepartureTime;   //The departure time of the 1st inbound flight
    public final String inboundFlightCarrier;   //The carrier of the 1st inbound flight

    public final String[] outboundLayoverLocations;         //An array of each outbound layover (in order)
    public final String[] outboundLayoverDepartureTimes;    //An array of each outbound layover's departure time
    public final String[] outboundLayoverFlightCarriers;    //An array of each outbound layover's carrier

    public final String[] inboundLayoverLocations;          //An array of each inbound layover (in order)
    public final String[] inboundLayoverDepartureTimes;     //An array of each inbound layover's departure time
    public final String[] inboundLayoverFlightCarriers;     //An array of each inbound layover's carrier

    public final String price;  //The minimum starting price of the entire trip

    public QuoteStruct(String _origin, String _originDepartureTime, String _originFlightCarrier, String _destination, String _inboundDepartureTime, String _inboundFlightCarrier, String[] _outboundLayoverLocations, String[] _outboundLayoverDepartureTimes, String[] _outboundLayoverFlightCarriers, String[] _inboundLayoverLocations, String[] _inboundLayoverDepartureTimes, String[] _inboundLayoverFlightCarriers, String _price) {
        this.origin = _origin;
        this.originDepartureTime = _originDepartureTime;
        this.originFlightCarrier = _originFlightCarrier;
        this.destination = _destination;
        this.inboundDepartureTime = _inboundDepartureTime;
        this.inboundFlightCarrier = _inboundFlightCarrier;
        this.outboundLayoverLocations = _outboundLayoverLocations;
        this.outboundLayoverDepartureTimes = _outboundLayoverDepartureTimes;
        this.outboundLayoverFlightCarriers = _outboundLayoverFlightCarriers;
        this.inboundLayoverLocations = _inboundLayoverLocations;
        this.inboundLayoverDepartureTimes = _inboundLayoverDepartureTimes;
        this.inboundLayoverFlightCarriers = _inboundLayoverFlightCarriers;
        this.price = _price;
    }




}
