package main.java.api.skyscanner.models.parsers;

import main.java.api.skyscanner.models.structures.Place;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A class that parses Place objects
 * @author Teegan Krieger
 */
public class PlaceParser {

    /**
     * Parse an array of Place objects from a JSONArray
     * @param _placesArray The JSONArray to parse
     * @return An array of place objects
     * @throws JSONException
     */
    public static Place[] createPlaceArrayFromJsonArray(JSONArray _placesArray) throws JSONException {
        Place[] results = new Place[_placesArray.length()];

        for (int i = 0; i < _placesArray.length(); i++) {
            JSONObject currencyObject = _placesArray.getJSONObject(i);
            results[i] = createPlaceFromJsonObject(currencyObject);
        }

        return results;
    }

    /**
     * Parse a Place object from a JSONObject
     * @param _jsonObject The JSONObject to parse
     * @return A Place object parsed from the JSONObject
     * @throws JSONException
     */
    public static Place createPlaceFromJsonObject(JSONObject _jsonObject) throws JSONException {
        //Parse fields
        String placeID = _jsonObject.getString("PlaceId");
        String placeName = _jsonObject.getString("PlaceName");
        String countryID = _jsonObject.getString("CountryId");
        String regionID = _jsonObject.getString("RegionId");
        String cityID = _jsonObject.getString("CityId");
        String countryName = _jsonObject.getString("CountryName");

        //Construct result
        Place result = new Place(placeID, placeName, countryID, regionID, cityID, countryName);

        return result;
    }

}
