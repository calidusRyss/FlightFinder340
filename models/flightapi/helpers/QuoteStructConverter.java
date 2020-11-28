package main.java.models.flightapi.helpers;

import main.java.models.flightapi.structures.QuoteStruct;
import main.java.models.flightapi.structures.UniversalJourneyLeg;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 * A class that holds functionality to convert a UniversalQuote into a QuoteStruct
 *
 * @author Teegan Krieger
 */
public class QuoteStructConverter {



    /**
     * Helper method that converts a Quote object into a QuoteStruct object and formats strings
     *
     * @param _quote The Quote object to convert
     * @return A QuoteStruct object containing formatted strings to represent all relevant quote data
     */
    public static QuoteStruct convertQuoteToStruct(UniversalQuote _quote) {
        //Note: This method will change based on Willie's handling of the Quote object

        if (_quote == null) {
            throw new IllegalArgumentException("The provided quote object was null.");
        }

        UniversalJourneyLeg outboundLeg = _quote.getOutboundLeg();
        UniversalJourneyLeg inboundLeg = _quote.getInboundLeg();

        String outboundOrigin = outboundLeg.getOriginLocation().getMostAccurateLocation();
        String outboundDestination = outboundLeg.getDestinationLocation().getMostAccurateLocation();
        String outboundDepartureTime = outboundLeg.getDepartureDateTime();
        String[] outboundCarrierNames = outboundLeg.getCarrierNames();

        String inboundOrigin = "";
        String inboundDestination = "";
        String inboundDepartureTime = "";
        String[] inboundCarrierNames = new String[0];

        if (inboundLeg != null) {
            inboundOrigin = inboundLeg.getOriginLocation().getMostAccurateLocation();
            inboundDestination = inboundLeg.getDestinationLocation().getMostAccurateLocation();
            inboundDepartureTime = inboundLeg.getDepartureDateTime();
            inboundCarrierNames = inboundLeg.getCarrierNames();
        }
        //Format Price
        String price = _quote.getPriceFormatted();

        //Construct QuoteStruct
        QuoteStruct quoteStruct = new QuoteStruct(outboundOrigin, outboundDestination, outboundDepartureTime, outboundCarrierNames, inboundOrigin, inboundDestination, inboundDepartureTime, inboundCarrierNames, price);

        return quoteStruct;
    }

}
