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
public class PlacesParser {

    public static Places[] createPlacesArrayFromJsonArray(JSONArray _placesArray) throws JSONException {
        Places[] results = new Places[_placesArray.length()];

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
    public static Places createPlacesFromJsonObject(JSONObject _jsonObject) throws JSONException {
        //Parse fields
        int placesPlaceId = _jsonObject.getInt("PlaceId");
        String placesName= _jsonObject.getString("Name");
        String placesType = _jsonObject.getString("Type");
        String placesSkyscannerCode = _jsonObject.getString("SkyscannerCode");
    
        //Construct result
        Places result = new Places(placesPlaceId, placesName, placesType,
                placesSkyscannerCode);

        return result;
    }
}



    

