package main.java.api.skyscanner.models.parsers;

import main.java.api.skyscanner.models.structures.Carrier;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Teegan Krieger
 */
public class CarriersParser {

    public static Carrier[] createCarrierArrayFromJsonArray(JSONArray _carriersArray) throws JSONException {

        Carrier[] results = new Carrier[_carriersArray.length()];

        for (int i = 0; i < _carriersArray.length(); i++) {
            JSONObject carrierObject = _carriersArray.getJSONObject(i);
            results[i] = createCarrierFromJsonObject(carrierObject);
        }

        return results;
    }

    public static Carrier createCarrierFromJsonObject(JSONObject _jsonObject) throws JSONException {

        int carrierID = _jsonObject.getInt("CarrierId");
        String carrierName = _jsonObject.getString("Name");

        Carrier result = new Carrier(carrierID, carrierName);

        return result;
    }

}
