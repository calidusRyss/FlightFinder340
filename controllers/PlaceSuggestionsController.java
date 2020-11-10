package main.java.controllers;

import main.java.models.flightapi.PlaceSuggester;

/**
 * A controller that handles making place suggestions.
 * Used for auto-completing text and for proper quote queries.
 *
 * @author Teegan Krieger
 * @LastUpdate 11/10/2020
 */
public class PlaceSuggestionsController {

    private final PlaceSuggester placeSuggester;

    public PlaceSuggestionsController(CountryController _countryController, CurrencyController _currencyController)
    {
        placeSuggester = new PlaceSuggester(_countryController, _currencyController);
    }

    public void setQuery(String _query)
    {
        placeSuggester.setQuery(_query);
    }

    public void clearQuery()
    {
        placeSuggester.clearQuery();
    }

    public void getQuery()
    {
        placeSuggester.getQuery();
    }

    public String[] getSuggestions()
    {
        return placeSuggester.getSuggestions();
    }

    public String getSuggestionCode(String _suggestionString)
    {
        return placeSuggester.getSuggestionCode(_suggestionString);
    }

    public void refreshSuggestions()
    {
        placeSuggester.refreshSuggestions();
    }

    public void close()
    {
        placeSuggester.close();
    }

}
