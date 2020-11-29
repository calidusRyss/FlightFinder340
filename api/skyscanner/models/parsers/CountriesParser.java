/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.api.skyscanner.models.parsers;

/**
 *
 * @author Willie Holmes
 */

import main.java.models.flightapi.structures.Country;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CountriesParser {

    public static Country [] createCountriesArrayFromJsonArray(JSONArray _countriesArray) throws JSONException {
        Country[] results = new Country[_countriesArray.length()];

        for (int i = 0; i < _countriesArray.length(); i++) {
            JSONObject countriesObject = _countriesArray.getJSONObject(i);
            results[i] = createCountriesFromJsonObject(countriesObject);
        }

        return results;
    }

    /**
     * Parse a Countries object from a JSONObject
     * @param _jsonObject The JSONObject to parse
     * @return A Countries object parsed from the JSONObject
     * @throws JSONException
     */
    public static Country createCountriesFromJsonObject(JSONObject _jsonObject) throws JSONException {
        //Parse
        String countriesCode = _jsonObject.getString("Code");
        String countriesName = _jsonObject.getString("Name");


        //Construct result
        Country result = new Country (countriesCode, countriesName);

        return result;
    }
}

