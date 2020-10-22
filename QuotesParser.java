/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightFinderParsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Willie Holmes
 */
public class QuotesParser {

    public static Quotes[] createQuotesArrayFromJsonArray(JSONArray _quotesArray) throws JSONException {
        Quotes[] results = new Quotes[_quotesArray.length()];

        for (int i = 0; i < _quotesArray.length(); i++) {
            JSONObject quotesObject = _quotesArray.getJSONObject(i);
            results[i] = createQuotesFromJsonObject(quotesObject);
        }

        return results;
    }

    /**
     * Parse a Quotes object from a JSONObject
     * @param _jsonObject The JSONObject to parse
     * @return A Quotes object parsed from the JSONObject
     * @throws JSONException
     */
    public static Quotes createQuotesFromJsonObject(JSONObject _jsonObject) throws JSONException {
        //Parse fields

        int quotesQuoteId = _jsonObject.getInt("QuoteId");
        int quotesMinPrice = _jsonObject.getInt("MinPrice");
        boolean quotesDirect = _jsonObject.getBoolean("Direct");
        String quotesOutboundLeg = _jsonObject.getString("OutboundLeg");
        int quotesCarrierIds = _jsonObject.getInt("CarrierIds");
        int quotesOriginId = _jsonObject.getInt("OriginId");
        int quotesDestinationId = _jsonObject.getInt("DestinationId");
        String quotesDepartureDate = _jsonObject.getString("DepartureDate");
        String quotesInboundLeg = _jsonObject.getString("InboundLeg");
        String quotesQuoteDateTime = _jsonObject.getString("QuoteDateTime");

        //Construct result
        Quotes result = new Quotes (quotesQuoteId, quotesMinPrice, quotesDirect, quotesOutboundLeg, quotesCarrierIds, 
                quotesOriginId, quotesDestinationId, quotesDepartureDate, quotesInboundLeg, quotesQuoteDateTime);

        return result;
    }
}



    

