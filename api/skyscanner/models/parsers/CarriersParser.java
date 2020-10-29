package main.java.api.skyscanner.models.parsers;

import main.java.api.skyscanner.models.structures.Carrier;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple JSON parser designed to parse Carrier objects
 *
 * @author Teegan Krieger
 */
public class CarriersParser {

    /**
     * Parse a JSONArray object into an array of Carriers
     * @param _carriersArray The JSONArray to parse
     * @return An array of Carrier objects
     * @throws JSONException
     */
    public static Carrier[] createCarrierArrayFromJsonArray(JSONArray _carriersArray) throws JSONException {

        Carrier[] results = new Carrier[_carriersArray.length()];

        for (int i = 0; i < _carriersArray.length(); i++) {
            JSONObject carrierObject = _carriersArray.getJSONObject(i);
            results[i] = createCarrierFromJsonObject(carrierObject);
        }

        return results;
    }

    /**
     * Parse a JSONObject into a singular Carrier object
     * @param _jsonObject The JSONObject to parse
     * @return A singular Carrier object
     * @throws JSONException
     */
    public static Carrier createCarrierFromJsonObject(JSONObject _jsonObject) throws JSONException {

        int carrierID = _jsonObject.getInt("CarrierId");
        String carrierName = _jsonObject.getString("Name");

        Carrier result = new Carrier(carrierID, carrierName);

        return result;
    }

}
