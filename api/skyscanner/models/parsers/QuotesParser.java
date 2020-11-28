package main.java.api.skyscanner.models.parsers;

import main.java.api.skyscanner.models.structures.JourneyLeg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import main.java.api.skyscanner.models.structures.Quote;

/**
 * A class that parses a SkyScanner Quotes JSON into Quote objects
 *
 * @author Willie Holmes
 * @LastModified 11/15/2020
 */
public class QuotesParser {

    /**
     * Parse a JSONArray object into an array of Quote objects
     *
     * @param _quotesArray The JSONArray object to parse
     * @return An array of Quote objects
     * @throws JSONException
     */
    public static Quote[] createQuotesArrayFromJsonArray(JSONArray _quotesArray) throws JSONException {
        Quote[] results = new Quote[_quotesArray.length()];

        for (int i = 0; i < _quotesArray.length(); i++) {
            JSONObject quotesObject = _quotesArray.getJSONObject(i);
            results[i] = createQuotesFromJsonObject(quotesObject);
        }

        return results;
    }

    /**
     * Parse a Quotes object from a JSONObject
     *
     * @param _jsonObject The JSONObject to parse
     * @return A Quotes object parsed from the JSONObject
     * @throws JSONException
     */
    public static Quote createQuotesFromJsonObject(JSONObject _jsonObject) throws JSONException {
        //Parse fields

        int quotesQuoteId = _jsonObject.getInt("QuoteId");
        int quotesMinPrice = _jsonObject.getInt("MinPrice");
        boolean quotesDirect = _jsonObject.getBoolean("Direct");
        JourneyLeg quotesOutboundLeg = parseJourneyLeg(_jsonObject.getJSONObject("OutboundLeg"));
        //int quotesCarrierIds = _jsonObject.getInt("CarrierIds");
        //int quotesOriginId = _jsonObject.getInt("OriginId");
        //int quotesDestinationId = _jsonObject.getInt("DestinationId");
        //String quotesDepartureDate = _jsonObject.getString("DepartureDate");
        JourneyLeg quotesInboundLeg = null;
        if (_jsonObject.has("InboundLeg")) {
            quotesInboundLeg = parseJourneyLeg(_jsonObject.getJSONObject("InboundLeg"));
        }
        String quotesQuoteDateTime = _jsonObject.getString("QuoteDateTime");

        //Construct result
        Quote result = new Quote(quotesQuoteId, quotesMinPrice, quotesDirect, quotesOutboundLeg, /*quotesCarrierIds,
                quotesOriginId, quotesDestinationId,*/ /*quotesDepartureDate,*/ quotesInboundLeg, quotesQuoteDateTime);

        return result;
    }

    /**
     * Parse a JourneyLeg object from within a Quote JSON
     * @param journeyLeg The JSONObject to parse
     * @return The JourneyLeg parsed from the JSONObject
     */
    private static JourneyLeg parseJourneyLeg(JSONObject journeyLeg) {
        JSONArray carriers = journeyLeg.getJSONArray("CarrierIds");
        int[] carrierIDs = new int[carriers.length()];

        for (int i = 0; i < carrierIDs.length; i++) {
            carrierIDs[i] = carriers.getInt(i);
        }

        int originID = journeyLeg.getInt("OriginId");
        int destinationID = journeyLeg.getInt("DestinationId");
        String departureTime = journeyLeg.getString("DepartureDate");

        JourneyLeg result = new JourneyLeg(carrierIDs, originID, destinationID, departureTime);

        return result;
    }

}
