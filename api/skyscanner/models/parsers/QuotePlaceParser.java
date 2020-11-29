package main.java.api.skyscanner.models.parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import main.java.api.skyscanner.models.structures.QuotePlace;

/**
 * A class that parses a SkyScanner QuotePlaces JSON into QuotePlace objects
 *
 * @author Willie Holmes
 * @LastModified 11/15/2020
 */
public class QuotePlaceParser {

    /**
     * Parse a JSONArray object into an array of QuotePlace objects
     *
     * @param _placesArray The JSONArray object to parse
     * @return An array of QuotePlace objects
     * @throws JSONException
     */
    public static QuotePlace[] createPlacesArrayFromJsonArray(JSONArray _placesArray) throws JSONException {
        QuotePlace[] results = new QuotePlace[_placesArray.length()];

        for (int i = 0; i < _placesArray.length(); i++) {
            JSONObject placesObject = _placesArray.getJSONObject(i);
            results[i] = createPlacesFromJsonObject(placesObject);
        }

        return results;
    }

    /**
     * Parse a Places object from a JSONObject
     *
     * @param _jsonObject The JSONObject to parse
     * @return A Places object parsed from the JSONObject
     * @throws JSONException
     */
    public static QuotePlace createPlacesFromJsonObject(JSONObject _jsonObject) throws JSONException {
        //Parse fields
        int placesPlaceId = _jsonObject.getInt("PlaceId");

        String placesType = _jsonObject.getString("Type");

        String placesName = _jsonObject.getString("Name");

        String placesSkyscannerCode = _jsonObject.getString("SkyscannerCode");

        //Construct result
        QuotePlace result = new QuotePlace(placesPlaceId, placesName, placesType,
                placesSkyscannerCode);

        return result;
    }
}
