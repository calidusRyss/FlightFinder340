package main.java.controllers;

import main.java.models.flightapi.collections.PlaceSuggester;

/**
 * A controller that handles making place suggestions. Used for auto-completing text and for proper quote queries.
 *
 * @author Teegan Krieger
 * @LastModified 11/10/2020
 */
public class PlaceSuggestionsController {

    private final PlaceSuggester placeSuggester;

    public PlaceSuggestionsController(CountryController _countryController, CurrencyController _currencyController) {
        if (_countryController == null) {
            throw new IllegalArgumentException("Country controller cannot be null!");
        }
        if (_currencyController == null) {
            throw new IllegalArgumentException("Currency controller cannot be null!");
        }

        this.placeSuggester = new PlaceSuggester(_countryController, _currencyController);
    }

    /**
     * Refresh the suggestions (Makes an API call to find new suggestions using the query)
     */
    public void refreshSuggestions() {
        this.placeSuggester.refreshSuggestions();
    }

    //=================  SETTERS ===============
    /**
     * Set the current query of the place suggester
     *
     * @param _query The query
     */
    public void setQuery(String _query) {
        this.placeSuggester.setQuery(_query);
    }

    /**
     * Clear the current query in the place suggester. Use this instead of send a null or blank string through setQuery.
     */
    public void clearQuery() {
        this.placeSuggester.clearQuery();
    }

    //=================  GETTERS ===============
    /**
     * Get the current query in the place suggester.
     */
    public void getQuery() {
        this.placeSuggester.getQuery();
    }

    /**
     * Get all current suggestion the place suggester has. Be sure to call RefreshSuggestions before getting this list if you changed the query.
     *
     * @return
     */
    public String[] getSuggestions() {
        return this.placeSuggester.getSuggestions();
    }

    /**
     * Get the suggestion code associated with a given suggestion.
     *
     * @param _suggestionString The suggestion string that the suggester should look up the code for.
     * @return A suggestion code, used for making quote search calls.
     */
    public String getSuggestionCode(String _suggestionString) {
        return this.placeSuggester.getSuggestionCode(_suggestionString);
    }

}
