package main.java.api.skyscanner.models.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import main.java.api.skyscanner.models.structures.Quote;
import main.java.api.skyscanner.models.structures.QuotePlace;
import main.java.api.skyscanner.models.structures.Carrier;
import main.java.api.skyscanner.models.structures.JourneyLeg;
import main.java.models.flightapi.structures.Currency;
import main.java.models.flightapi.structures.Location;
import main.java.models.flightapi.structures.UniversalJourneyLeg;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 * A class that will take an array of Quotes, Carriers, Places and Currencies and convert them all into an array of UniversalQuote objects.
 *
 * @author Teegan Krieger
 * @LastModified 10/28/2020
 */
public class UniversalQuoteFactory {

    /**
     * Convert an array of Quotes, Carriers, Places and Currencies into an array of UniversalQuotes.
     *
     * @param _quotes The quotes array.
     * @param _quotePlaces The QuotePlaces array.
     * @param _carriers The carriers array.
     * @param _currencies The currencies array.
     * @return An array of UniversalQuote objects.
     */
    public static UniversalQuote[] createUniversalQuotes(Quote[] _quotes, QuotePlace[] _quotePlaces, Carrier[] _carriers, Currency[] _currencies) {
        HashMap<Integer, QuotePlace> placesHashMap = new HashMap<Integer, QuotePlace>();
        HashMap<Integer, Carrier> carriersHashMap = new HashMap<Integer, Carrier>();

        //Sort carriers and places into hashmaps
        for (QuotePlace place : _quotePlaces) {
            placesHashMap.put(place.getPlaceId(), place);
        }

        for (Carrier carrier : _carriers) {
            carriersHashMap.put(carrier.getCarrierId(), carrier);
        }

        //Create Universal Quotes
        UniversalQuote[] universalQuotes = new UniversalQuote[_quotes.length];

        for (int i = 0; i < _quotes.length; i++) {
            int price = _quotes[i].getMinPrice();

            Currency currency = _currencies[0];

            UniversalJourneyLeg[] universalJourneyLegs = constructUniversalJourneyLegs(_quotes[i], placesHashMap, carriersHashMap);

            boolean directFlight = _quotes[i].isDirect();

            universalQuotes[i] = new UniversalQuote(price, currency, universalJourneyLegs[0], universalJourneyLegs[1], directFlight);
        }

        return universalQuotes;
    }

    /**
     * Construct inbound and outbound JourneyLeg objects from a quote, QuotePlaces and Carriers
     *
     * @param _quote The quote to construct the JourneyLegs from
     * @param _placesHashMap A HashMap with all QuotePlaces
     * @param _carriersHashMap A HashMap with all Carriers
     * @return An array of JourneyLegs, always length of 2 with the first item being the outbound leg and the second item being the inbound leg (If an inbound leg exists)
     */
    private static UniversalJourneyLeg[] constructUniversalJourneyLegs(Quote _quote, HashMap<Integer, QuotePlace> _placesHashMap, HashMap<Integer, Carrier> _carriersHashMap) {

        UniversalJourneyLeg[] inboundOutboundJourneyLegs = new UniversalJourneyLeg[2];

        //Construct Outbound Leg
        JourneyLeg outboundLeg = _quote.getOutboundLeg();
        int[] outboundCarrierIds = outboundLeg.getCarrierIDs();

        //Construct Carriers
        String[] outboundCarriers = new String[outboundCarrierIds.length];

        for (int i = 0; i < outboundCarriers.length; i++) {
            outboundCarriers[i] = _carriersHashMap.get(outboundCarrierIds[i]).getName();
        }

        //Construct Origin and Destination
        QuotePlace outboundOrigin = _placesHashMap.get(outboundLeg.getOriginID());
        QuotePlace outboundDestination = _placesHashMap.get(outboundLeg.getDestinationID());

        Location originLocation = null;

        switch (outboundOrigin.getType()) {
            case "Country":
                originLocation = new Location(outboundOrigin.getName(), null, null);
                break;
            case "City":
                originLocation = new Location(null, outboundOrigin.getName(), null);
                break;
            case "Airport":
            case "Station":
                originLocation = new Location(null, null, outboundOrigin.getName());
                break;
        }

        Location destinationLocation = null;

        switch (outboundDestination.getType()) {
            case "Country":
                destinationLocation = new Location(outboundDestination.getName(), null, null);
                break;
            case "City":
                destinationLocation = new Location(null, outboundDestination.getName(), null);
                break;
            case "Airport":
            case "Station":
                destinationLocation = new Location(null, null, outboundDestination.getName());
                break;
        }

        //Parse Time
        LocalDateTime outboundDateTime = LocalDateTime.parse(outboundLeg.getDepartureTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        inboundOutboundJourneyLegs[0] = new UniversalJourneyLeg(outboundCarriers, originLocation, destinationLocation, outboundDateTime);

        //If the inbound leg exists, parse it
        if (_quote.getInboundLeg() != null) {
            JourneyLeg inboundLeg = _quote.getOutboundLeg();
            int[] inboundCarrierIds = outboundLeg.getCarrierIDs();

            //Construct Carriers
            String[] inboundCarriers = new String[inboundCarrierIds.length];

            for (int i = 0; i < inboundCarriers.length; i++) {
                inboundCarriers[i] = _carriersHashMap.get(inboundCarrierIds[i]).getName();
            }

            //Construct Origin and Destination
            QuotePlace inboundOrigin = _placesHashMap.get(inboundLeg.getOriginID());
            QuotePlace inboundDestination = _placesHashMap.get(inboundLeg.getDestinationID());

            Location inboundOriginLocation = null;

            switch (inboundOrigin.getType()) {
                case "Country":
                    inboundOriginLocation = new Location(inboundOrigin.getName(), null, null);
                    break;
                case "City":
                    inboundOriginLocation = new Location(null, inboundOrigin.getName(), null);
                    break;
                case "Airport":
                case "Station":
                    inboundOriginLocation = new Location(null, null, inboundOrigin.getName());
                    break;
            }

            Location inboundDestinationLocation = null;

            switch (inboundDestination.getType()) {
                case "Country":
                    inboundDestinationLocation = new Location(inboundDestination.getName(), null, null);
                    break;
                case "City":
                    inboundDestinationLocation = new Location(null, inboundDestination.getName(), null);
                    break;
                case "Airport":
                case "Station":
                    inboundDestinationLocation = new Location(null, null, inboundDestination.getName());
                    break;
            }

            //Parse Time
            LocalDateTime inboundDateTime = LocalDateTime.parse(inboundLeg.getDepartureTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            inboundOutboundJourneyLegs[1] = new UniversalJourneyLeg(inboundCarriers, inboundOriginLocation, inboundDestinationLocation, inboundDateTime);
        }

        return inboundOutboundJourneyLegs;
    }

}
