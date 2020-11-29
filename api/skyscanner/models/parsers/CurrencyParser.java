/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.api.skyscanner.models.parsers;

/**
 *
 * @author lavon
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import main.java.models.flightapi.structures.Currency;


public class CurrencyParser {
    public static Currency[] createCurrencyArrayFromJsonArray(JSONArray _currencyArray) throws JSONException {
        Currency[] results = new Currency[_currencyArray.length()];

        for (int i = 0; i < _currencyArray.length(); i++) {
            JSONObject currencyObject = _currencyArray.getJSONObject(i);
            results[i] = createCurrencyFromJsonObject(currencyObject);
        }

        return results;
    }

    /**
     * Parse a Currency object from a JSONObject
     * @param _jsonObject The JSONObject to parse
     * @return A Currency object parsed from the JSONObject
     * @throws JSONException
     */
    public static Currency createCurrencyFromJsonObject(JSONObject _jsonObject) throws JSONException {
        //Parse fields
        String currencyCode = _jsonObject.getString("Code");
        String currencySymbol = _jsonObject.getString("Symbol");
        String currencyThousandsSeparator = _jsonObject.getString("ThousandsSeparator");
        String currencyDecimalSeparator = _jsonObject.getString("DecimalSeparator");
        boolean currencySymbolOnLeft = _jsonObject.getBoolean("SymbolOnLeft");
        boolean currencySpaceBetweenAmountAndSymbol = _jsonObject.getBoolean("SpaceBetweenAmountAndSymbol");
        int currencyRoundingCoefficient = _jsonObject.getInt("RoundingCoefficient");
        int currencyDecimalDigits = _jsonObject.getInt("DecimalDigits");

        //Construct result
        Currency result = new Currency(currencyCode, currencySymbol, currencyThousandsSeparator,
                currencyDecimalSeparator, currencySymbolOnLeft, currencySpaceBetweenAmountAndSymbol,
                currencyRoundingCoefficient, currencyDecimalDigits);

        return result;
    }
}


