package main.java.models.flightapi.collections;

import main.java.adapters.FlightAPIAdapter;
import main.java.api.skyscanner.models.structures.Place;
import main.java.controllers.CountryController;
import main.java.controllers.CurrencyController;
import main.java.models.http.ResponseCode;
import main.java.models.flightapi.responses.PlacesResponse;

/**
 * A class that helps make suggestions about places based on user input
 *
 * @author Teegan Krieger
 * @LastModified 11/25/2020
 */
public class PlaceSuggester {

    private String queryString = "";
    private Suggestion[] suggestions;

    private final CountryController countryController;
    private final CurrencyController currencyController;

    public PlaceSuggester(CountryController _countryController, CurrencyController _currencyController) {

        this.countryController = _countryController;
        this.currencyController = _currencyController;

        this.suggestions = new Suggestion[0];
    }

    /**
     * Refresh the suggestions by making an API call using the current query string
     */
    public void refreshSuggestions() {
        String country = this.countryController.getSelectedCountryCode();
        String currency = this.currencyController.getSelectedCurrencyCode();

        PlacesResponse response = FlightAPIAdapter.flightAPI.fetchAvaliablePlaces(country, currency, this.queryString);

        if (response.getResponseCode() != ResponseCode.OK) {
            this.suggestions = new Suggestion[0];

            return;
        }

        Place[] places = response.getPlaces();

        //synchronize the suggestions array (prevents race conditions)
        this.suggestions = new Suggestion[places.length];

        for (int i = 0; i < places.length; i++) {
            this.suggestions[i] = new Suggestion(places[i].getPlaceName(), places[i].getPlaceID());
        }

    }

    //=================  SETTERS ===============
    /**
     * Set the query
     *
     * @param _value The new string to set the query to
     */
    public void setQuery(String _value) {
        if (_value == null) {
            throw new IllegalArgumentException("Query value cannot be null!");
        }

        this.queryString = _value;
    }

    /**
     * Clear the query, reset the countdown and clear all suggestions
     */
    public void clearQuery() {
        this.queryString = "";
        this.suggestions = new Suggestion[0];
    }

    //=================  GETTERS ===============
    /**
     * Get the current value of the query
     *
     * @return
     */
    public String getQuery() {
        return this.queryString;
    }

    /**
     * Get an array of strings with all current suggestions
     *
     * @return An array of strings
     */
    public String[] getSuggestions() {
        String[] names = new String[this.suggestions.length];

        for (int i = 0; i < this.suggestions.length; i++) {
            names[i] = this.suggestions[i].name;
        }

        return names;
    }

    /**
     * Get the suggestion code for a specific suggestion.
     *
     * @param _suggestionString The suggestion to find the code for
     * @return A string representing a suggestion code. If the suggestion isn't found, returns a blank string
     */
    public String getSuggestionCode(String _suggestionString) {
        for (int i = 0; i < this.suggestions.length; i++) {
            if (this.suggestions[i].name.toLowerCase().equals(_suggestionString.toLowerCase())) {
                return this.suggestions[i].code;
            }
        }
        return (this.suggestions.length > 0 ? this.suggestions[0].code : "");
    }

    /**
     * Nested class used to represent a suggestion
     */
    private class Suggestion {

        private String name;
        private String code;

        public Suggestion(String _name, String _code) {
            this.name = _name;
            this.code = _code;
        }

        @Override
        public String toString() {
            return "Suggestion{" + "name=" + this.name + ", code=" + this.code + '}';
        }

        //=================  GETTERS ===============
        public String getName() {
            return this.name;
        }

        public String getCode() {
            return this.code;
        }

    }

}
