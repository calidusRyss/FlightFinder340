package main.java.controllers;

import java.util.ArrayList;
import main.java.adapters.FlightAPIAdapter;
import main.java.models.flightapi.responses.CurrenciesResponse;
import main.java.models.flightapi.stores.CurrencySelector;

/**
 * A controller that handles loading currency data and selecting an active currency
 *
 * @author Teegan Krieger
 * @LastUpdate 10/28/2020
 */
public class CurrencyController {

    private CurrencySelector currencySelector;

    public CurrencyController() {
        currencySelector = new CurrencySelector();
    }

    /**
     * Load all currencies into the selector
     */
    public void loadCurrencies() {
        CurrenciesResponse currencyResponse = FlightAPIAdapter.flightAPI.FetchAvaliableCurrencies();

        switch (currencyResponse.getResponseCode()) {
            case OK:
                currencySelector.setCurrencyData(currencyResponse.getCurrencies());
                break;

            default:
                //This means an error occured while trying to fetch the currencies. The program cannot run without these, so I suggest having the view retry 3-5 times then display
                //An error message to the user saying the there must be an issue with their connection, as either that, or a change in the api itself would be the only reasons
                //This fails
                break;
        }
    }

    /**
     * Set the currency selection using the index of the currency
     *
     * @param _index The index of the currency to set the selection to
     * @throws IndexOutOfBoundsException thrown if the provided index is out of bounds for the data currently in the selector
     */
    public void selectCurrency(int _index) {
        currencySelector.selectCurrency(_index);
    }

    /**
     * Get an array list of all currency codes
     *
     * @return An array list of all currency codes
     */
    public ArrayList<String> getAllCurrencyCodes() {
        return currencySelector.getAllCurrencyCodes();
    }

    /**
     * Get an array list of all currency symbols
     *
     * @return An array list of all currency symbols
     */
    public ArrayList<String> getAllCurrencySymbols() {
        return currencySelector.getAllCurrencySymbols();
    }

    /**
     * Get the currency code of the selected currency
     *
     * @return The currency code of the selected currency
     */
    public String getSelectedCurrencyCode() {
        return currencySelector.getSelectedCurrencyCode();
    }

    /**
     * Get the currency symbol of the selected currency
     *
     * @return The currency symbol of the selected currency
     */
    public String getSelectedCurrencySymbol() {
        return currencySelector.getSelectedCurrencySymbol();
    }

}
