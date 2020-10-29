/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightFinderParsers;

/**
 *
 * @author Willie Holmes
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CarriersParser {
    
    public static Carriers [] createCarriersArrayFromJsonArray(JSONArray _carriersArray) throws JSONException {
        Carriers[] results = new Carriers[_carriersArray.length()];

        for (int i = 0; i < _carriersArray.length(); i++) {
            JSONObject carriersObject = _carriersArray.getJSONObject(i);
            results[i] = createCarriersFromJsonObject(carriersObject);
        }

        return results;
    }

    /**
     * Parse a Carrier object from a JSONObject
     * @param _jsonObject The JSONObject to parse
     * @return A Carrier object parsed from the JSONObject
     * @throws JSONException
     */
    public static Carriers createCarriersFromJsonObject(JSONObject _jsonObject) throws JSONException {
        //Parse fields
        int carriersCarrierId = _jsonObject.getInt("CarrierId");
        String carriersName = _jsonObject.getString("Name");
       

        //Construct result
        Carriers result = new Carriers (carriersCarrierId, carriersName);

        return result;
    }
}



    

