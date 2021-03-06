package main.java.controllers;

import java.util.ArrayList;
import main.java.adapters.FlightAPIAdapter;
import main.java.exceptions.controllers.ApiFailedToLoadException;
import main.java.models.flightapi.responses.CountriesResponse;
import main.java.models.flightapi.collections.CountrySelector;

/**
 * A controller that handles loading all country data and selecting an active country
 *
 * @author Teegan Krieger
 * @LastModified 10/28/2020
 */
public class CountryController {

    private CountrySelector countrySelector;

    public CountryController() throws ApiFailedToLoadException {
        this.countrySelector = new CountrySelector();
        loadCountries();
    }

    /**
     * Set the country selection using the index of the country
     *
     * @param _index The index of the country to set the selection to
     * @throws IndexOutOfBoundsException thrown if the provided index is out of bounds for the data currently in the selector
     */
    public void selectCountry(int _index) {
        this.countrySelector.selectCountry(_index);
    }

    /**
     * Load all currencies into the selector
     */
    private void loadCountries() throws ApiFailedToLoadException {
        CountriesResponse currencyResponse = FlightAPIAdapter.flightAPI.fetchAvaliableCountries();

        switch (currencyResponse.getResponseCode()) {
            case OK:
                this.countrySelector.setCountryData(currencyResponse.getCountries());
                break;

            default:
                //This means an error occured while trying to fetch the currencies. The program cannot run without these, so I suggest having the view retry 3-5 times then display
                //An error message to the user saying the there must be an issue with their connection, as either that, or a change in the api itself would be the only reasons
                //This fails
                throw new ApiFailedToLoadException("The api call to load all country data has failed. Consider retrying or aborting the program");
        }
    }

    //=================  GETTERS ===============
    /**
     * Get an array list of all country codes
     *
     * @return An array list of all country codes
     */
    public ArrayList<String> getAllCountryCodes() {
        return this.countrySelector.getAllCountryCodes();
    }

    /**
     * Get an array list of all country names
     *
     * @return An array list of all country names
     */
    public ArrayList<String> getAllCountryNames() {
        return this.countrySelector.getAllCountryNames();
    }

    /**
     * Get the code of the selected country
     *
     * @return The code of the selected country
     */
    public String getSelectedCountryCode() {
        return this.countrySelector.getSelectedCountryCode();
    }

    /**
     * Get the name of the selected country
     *
     * @return The name of the selected country
     */
    public String getSelectedCountryName() {
        return this.countrySelector.getSelectedCountryName();
    }

    /**
     * Get the index of either a country name or country code
     *
     * @param _countryNameOrCode The country name or code
     * @return The index of this country within the selector. Returns -1 if the country or code was not found
     */
    public int getIndexOf(String _countryNameOrCode) {
        return this.countrySelector.getIndexOf(_countryNameOrCode);
    }

}
