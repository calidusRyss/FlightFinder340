package main.java.controllers;

import main.java.models.general.Property;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import main.java.adapters.FlightAPIAdapter;
import main.java.exceptions.controllers.QuoteRequestException;
import main.java.models.enums.SortMode;
import main.java.models.flightapi.responses.QuotesResponse;
import main.java.models.flightapi.collections.QuotesStore;
import main.java.models.flightapi.structures.QuoteStruct;

/**
 * A controller that handles searching for quotes and manipulating the views using it
 *
 * @author Teegan Krieger
 * @LastUpdate 10/28/2020
 */
public class QuoteSearchController {

    private final QuotesStore quotesStore;
    private final PlaceSuggestionsController placeSuggestionsController;

    public QuoteSearchController(PlaceSuggestionsController _placeSuggestionsController)
    {
        quotesStore = new QuotesStore();
        placeSuggestionsController = _placeSuggestionsController;
    }

    /**
     * Searches for quotes using the given properties
     * @param _searchFields The properties to search with
     * @return An array list of QuoteStructs
     */
    public ArrayList<QuoteStruct> searchQuotes(Property[] _searchFields) throws QuoteRequestException
    {
        String currencyCode = "";
        String countryCode = "";
        String originString = "";
        String destinationString = "";
        LocalDateTime originDepartureDate = LocalDateTime.now();
        LocalDateTime destinationDepartureDate = null;

        for (Property p : _searchFields)
        {
            switch (p.name)
            {
                case "currencycode":
                    currencyCode = p.content;
                    break;
                case "countrycode":
                    countryCode = p.content;
                    break;
                case "origin":
                    originString = p.content;
                    break;
                case "destination":
                    destinationString = p.content;
                    break;
                case "departing":
                    originDepartureDate = LocalDateTime.parse(p.content, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    break;
                case "returning":
                    destinationDepartureDate = LocalDateTime.parse(p.content, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    break;
            }
        }

        //Convert Query in Code
        placeSuggestionsController.setQuery(originString);
        placeSuggestionsController.refreshSuggestions();
        originString = placeSuggestionsController.getSuggestionCode(originString);

        placeSuggestionsController.setQuery(destinationString);
        placeSuggestionsController.refreshSuggestions();
        destinationString = placeSuggestionsController.getSuggestionCode(destinationString);

        if (destinationString.equals(""))
            destinationString = "Anywhere";

        //Run the request
        QuotesResponse response = FlightAPIAdapter.flightAPI.fetchQuotes(countryCode, currencyCode, originString, destinationString, originDepartureDate, destinationDepartureDate);

        switch(response.getResponseCode())
        {
            case OK:
                quotesStore.clear();
                quotesStore.addCollection(response.getQuotes());
                break;
            default:
                //System.out.println("Params:\n" + "Country Code: " + countryCode + "\nCurrency Code: " + currencyCode + "\nOrigin: " + originString + "\nDestination: " + destinationString + "\nDepartureTime: " + originDepartureDate.toString()); //"\nReturningTime: " + destinationDepartureDate.toString()
                //System.out.println("MISC. ERROR: " + response.getResponseCode().toString() + "\n" + response.getHttpResponseMessage());
                throw new QuoteRequestException(response.getResponseCode().toString());
        }

        return getSortedQuotes();
    }

    public ArrayList<QuoteStruct> sortQuotesBy(SortMode _sortMode)
    {
        quotesStore.sort(_sortMode);
        return getSortedQuotes();
    }

    public ArrayList<QuoteStruct> getSortedQuotes()
    {
        return quotesStore.getSortedQuoteStructs();
    }

    public QuotesStore getQuoteStore()
    {
        return quotesStore;
    }

    /**
     * Get the current sort mode of the QuoteStore
     * @return The current sort mode of the QuoteStore
     */
    public SortMode getCurrentSortMode()
    {
        return quotesStore.getCurrentSortMode();
    }

}
