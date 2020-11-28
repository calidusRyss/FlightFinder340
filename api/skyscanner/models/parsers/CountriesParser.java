package main.java.api.skyscanner.models.parsers;


import main.java.models.flightapi.structures.Country;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A class that parses a SkyScanner Countries JSON into Country objects
 *
 * @author Willie Holmes
 * @LastModified 11/15/2020
 */
public class CountriesParser {

    /**
     * Parse a JSONArray object into an array of Country objects
     *
     * @param _countriesArray The JSONArray object to parse
     * @return An array of Country objects
     * @throws JSONException
     */
    public static Country[] createCountriesArrayFromJsonArray(JSONArray _countriesArray) throws JSONException {
        Country[] results = new Country[_countriesArray.length()];

        for (int i = 0; i < _countriesArray.length(); i++) {
            JSONObject countriesObject = _countriesArray.getJSONObject(i);
            results[i] = createCountriesFromJsonObject(countriesObject);
        }

        return results;
    }

    /**
     * Parse a Countries object from a JSONObject
     *
     * @param _jsonObject The JSONObject to parse
     * @return A Countries object parsed from the JSONObject
     * @throws JSONException
     */
    public static Country createCountriesFromJsonObject(JSONObject _jsonObject) throws JSONException {
        //Parse
        String countriesCode = _jsonObject.getString("Code");
        String countriesName = _jsonObject.getString("Name");

        //Construct result
        Country result = new Country(countriesCode, countriesName);

        return result;
    }
}
