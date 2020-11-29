package main.java.api.skyscanner.models.parsers;

import main.java.api.skyscanner.models.structures.Carrier;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A class that parses a SkyScanner Carriers JSON into Carrier objects
 *
 * @author Willie Holmes
 * @LastModified 11/15/2020
 */
public class CarriersParser {

    /**
     * Parse a JSONArray object into an array of Carrier objects
     *
     * @param _carriersArray The JSONArray object to parse
     * @return An array of Carrier objects
     * @throws JSONException
     */
    public static Carrier[] createCarriersArrayFromJsonArray(JSONArray _carriersArray) throws JSONException {

        Carrier[] results = new Carrier[_carriersArray.length()];

        for (int i = 0; i < _carriersArray.length(); i++) {
            JSONObject carriersObject = _carriersArray.getJSONObject(i);
            results[i] = createCarriersFromJsonObject(carriersObject);
        }

        return results;
    }

    /**
     * Parse a Carrier object from a JSONObject
     *
     * @param _jsonObject The JSONObject to parse
     * @return A Carrier object parsed from the JSONObject
     * @throws JSONException
     */
    public static Carrier createCarriersFromJsonObject(JSONObject _jsonObject) throws JSONException {

        //Parse fields
        int carriersCarrierId = _jsonObject.getInt("CarrierId");
        String carriersName = _jsonObject.getString("Name");

        //Construct result
        Carrier result = new Carrier(carriersCarrierId, carriersName);

        return result;
    }

}
