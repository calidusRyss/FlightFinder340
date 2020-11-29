/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.api.skyscanner.models.parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import main.java.api.skyscanner.models.structures.QuotePlace;

/**
 *
 * @author Willie Holmes
 */
public class QuotePlaceParser {

    public static QuotePlace[] createPlacesArrayFromJsonArray(JSONArray _placesArray) throws JSONException {
        QuotePlace[] results = new QuotePlace[_placesArray.length()];

        for (int i = 0; i < _placesArray.length(); i++) {
            JSONObject placesObject = _placesArray.getJSONObject(i);
            results[i] = createPlacesFromJsonObject(placesObject);
        }

        return results;
    }

    /**
     * Parse a Places  object from a JSONObject
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





