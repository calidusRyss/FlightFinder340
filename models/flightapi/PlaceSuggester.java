package main.java.models.flightapi;

import java.util.Timer;
import java.util.TimerTask;
import main.java.adapters.FlightAPIAdapter;
import main.java.api.skyscanner.models.structures.Place;
import main.java.controllers.CountryController;
import main.java.controllers.CurrencyController;
import main.java.models.HTTP.ResponseCode;
import main.java.models.flightapi.responses.PlacesResponse;

/**
 * A class that helps make suggestions about places based on user input
 *
 * @author Teegan Krieger
 * @LastUpdate 11/4/2020
 */
public class PlaceSuggester {

    private final int countdownRefreshTiming = 2;

    private String queryString = "";
    private Suggestion[] suggestions;
    private int countdownToRefresh;

    private final Timer timer;

    private final CountryController countryController;
    private final CurrencyController currencyController;

    public PlaceSuggester(CountryController _countryController, CurrencyController _currencyController) {

        countryController = _countryController;
        currencyController = _currencyController;

        suggestions = new Suggestion[0];
        countdownToRefresh = -1;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timerExecution();
            }
        };

        timer = new Timer();
        //Schedule the task to occur every half second.
        timer.schedule(task, 0, 500);
    }

    /**
     * Refresh the suggestions by making an API call using the current query string
     */
    public void refreshSuggestions() {
        String country = countryController.getSelectedCountryCode();
        String currency = currencyController.getSelectedCurrencyCode();

        PlacesResponse response = FlightAPIAdapter.flightAPI.fetchAvaliablePlaces(country, currency, queryString);

        if (response.getResponseCode() != ResponseCode.OK) {
            synchronized (suggestions) {
                suggestions = new Suggestion[0];
            }
            return;
        }

        Place[] places = response.getPlaces();

        //synchronize the suggestions array (prevents race conditions)
        synchronized (suggestions) {
            suggestions = new Suggestion[places.length];

            for (int i = 0; i < places.length; i++) {
                suggestions[i] = new Suggestion(places[i].getPlaceName(), places[i].getPlaceID());
            }
        }
    }

    /**
     * Close the Place Suggester. This should be called when the place suggester is done being used!
     */
    public void close() {
        timer.cancel();
    }

    /**
     * Called whenever the time executes. Decrements the countdown and then calls refresh when the countdown equals 0
     */
    private void timerExecution() {
        if (countdownToRefresh > -1) {
            synchronized (suggestions) {
                countdownToRefresh--;
            }
        }
        if (countdownToRefresh == 0) {
            refreshSuggestions();
        }
    }

    //=================  SETTERS ===============

    /**
     * Set the query
     * @param _value The new string to set the query to
     */
    public void setQuery(String _value) {
        if (_value == null) {
            throw new IllegalArgumentException("Query value cannot be null!");
        }

        synchronized (suggestions) {
            countdownToRefresh = countdownRefreshTiming;
        }
        queryString = _value;
    }

    /**
     * Clear the query, reset the countdown and clear all suggestions
     */
    public void clearQuery() {
        synchronized (suggestions) {
            countdownToRefresh = -1;
            queryString = "";
            suggestions = new Suggestion[0];
        }
    }

    //=================  GETTERS ===============

    /**
     * Get the current value of the query
     * @return
     */
    public String getQuery() {
        return queryString;
    }

    /**
     * Get an array of strings with all current suggestions
     * @return An array of strings
     */
    public String[] getSuggestions() {
        String[] names = new String[suggestions.length];

        for (int i = 0; i < suggestions.length; i++) {
            names[i] = suggestions[i].name;
        }

        return names;
    }

    /**
     * Get the suggestion code for a specific suggestion.
     * @param _suggestionString The suggestion to find the code for
     * @return A string representing a suggestion code. If the suggestion isn't found, returns a blank string
     */
    public String getSuggestionCode(String _suggestionString) {
        for (int i = 0; i < suggestions.length; i++) {
            if (suggestions[i].name.toLowerCase().equals(_suggestionString.toLowerCase())) {
                return suggestions[i].code;
            }
        }
        return (suggestions.length > 0 ? suggestions[0].code : "");
    }

    /**
     * Nested class used to represent a suggestion
     */
    private class Suggestion {

        private String name;
        private String code;

        public Suggestion(String _name, String _code) {
            name = _name;
            code = _code;
        }

        @Override
        public String toString() {
            return "Suggestion{" + "name=" + name + ", code=" + code + '}';
        }

        //=================  GETTERS ===============
        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

    }

}
