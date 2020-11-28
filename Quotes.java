/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightFinderParsers;

/**
 *
 * @author lavon
 */
public class Quotes {
    private int QuoteId;
    private int MinPrice;
    private boolean Direct;
    private String OutboundLeg; 
    private int CarrierIds;
    private int OriginId;
    private int DestinationId;
    private String DepartureDate;
    private String InboundLeg;
    private String QuoteDateTime;
    
       /**
     * Construct a Quotes object
     * @param _QuoteId. Example: '1'
     * @param _MinPrice. Minimum Price available. Example: '381'
     * @param _Direct Bootlean determining Whether the flight is a direct flight or connected. Example: 'true'
     * @param _OutboundLeg The outbound identifiers of the trip
     * @param _CarrierIds Carrier Identification. Example '470'
     * @param _OriginId Origin Identification of current leg of trip. Example '68033'
     * @param _DestinationId Identification of the Destination of current leg of trip. Example '42833'
     * @param _DepartureDate The Date of Departure of current leg of trip. Example '"2017-02-03T00:00:00"'
     * @param _InboundLeg The Inbound identifiers of the trip
     * @param _QuoteDateTime The date and time quote was recieved. Example '"2016-11-09T21:20:00"'
     */    
     public Quotes(int _QuoteId, int _MinPrice, boolean _Direct, String _OutboundLeg, int _CarrierIds, int _OriginId, int _DestinationId, String _DepartureDate, String _InboundLeg, String _QuoteDateTime) {
        this.QuoteId = _QuoteId;
        this.MinPrice = _MinPrice;
        this.Direct = _Direct;
        this.OutboundLeg = _OutboundLeg;
        this.CarrierIds = _CarrierIds;
        this.OriginId = _OriginId;
        this.DestinationId = _DestinationId;
        this.DepartureDate = _DepartureDate;
        this.InboundLeg = _InboundLeg;
        this.QuoteDateTime = _QuoteDateTime;
        
    }

   @Override
    public String toString() {
        return "Quotes [QuoteId=" + QuoteId + ", MinPrice=" + MinPrice + ",  Direct=" + Direct
                + ", OutboundLeg=" + OutboundLeg + ", CarrierIds="
                + CarrierIds + ", OriginId=" + OriginId + ", DestinationId=" + DestinationId
                + ", DepartureDate=" + DepartureDate + ", InboundLeg=" + InboundLeg + ",QuoteDateTime=" + QuoteDateTime+"]";
    }

    //=================  GETTERS ===============

    /**
     * 
     * @return Quote Id
     */
    public int  getQuoteId() {
        return QuoteId;
    }

    /**
     * 
     * @return The Min. Price 
     */
    public int getMinPrice() {
        return MinPrice;
    }

    /**
     * 
     * @return Whether it is Direct or not
     */
    public boolean  isDirect() {
        return Direct;
    }

    /**
     * 
     * @return The OutboundLeg of the trip
     */
    public String getOutboundLeg() {
        return OutboundLeg;
    }

    /**
     * 
     * @return The Carrier Id
     */
    public int getCarrierId() {
        return CarrierIds;
    }

    /**
     * 
     * @return The Origin Id
     */
    public int getOriginId() {
        return OriginId;
    }

    /**
     * 
     * @return The Destination ID
     */
    public int getDestinationId() {
        return DestinationId;
    }

    /**
     * 
     * @return The Departure date
     */
    public String getDepartureDate() {
        return DepartureDate;
        
    }
    public String getInboundLeg() {
        return InboundLeg;

}
  
   public String getQuoteDateTime() {
        return QuoteDateTime;
   }

}
