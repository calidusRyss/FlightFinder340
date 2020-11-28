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
 * @LastModified 10/28/2020
 */
public class QuoteSearchController {

    private final QuotesStore quotesStore;
    private final PlaceSuggestionsController placeSuggestionsController;

    public QuoteSearchController(PlaceSuggestionsController _placeSuggestionsController) {
        this.quotesStore = new QuotesStore();
        this.placeSuggestionsController = _placeSuggestionsController;
    }

    /**
     * Searches for quotes using the given properties
     *
     * @param _searchFields The properties to search with
     * @return An array list of QuoteStructs
     */
    public ArrayList<QuoteStruct> searchQuotes(Property[] _searchFields) throws QuoteRequestException {
        String currencyCode = "";
        String countryCode = "";
        String originString = "";
        String destinationString = "";
        LocalDateTime originDepartureDate = LocalDateTime.now();
        LocalDateTime destinationDepartureDate = null;

        for (Property p : _searchFields) {
            switch (p.name) {
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
        this.placeSuggestionsController.setQuery(originString);
        this.placeSuggestionsController.refreshSuggestions();
        originString = this.placeSuggestionsController.getSuggestionCode(originString);

        this.placeSuggestionsController.setQuery(destinationString);
        this.placeSuggestionsController.refreshSuggestions();
        destinationString = this.placeSuggestionsController.getSuggestionCode(destinationString);

        if (destinationString.equals("")) {
            destinationString = "Anywhere";
        }

        //Run the request
        QuotesResponse response = FlightAPIAdapter.flightAPI.fetchQuotes(countryCode, currencyCode, originString, destinationString, originDepartureDate, destinationDepartureDate);

        switch (response.getResponseCode()) {
            case OK:
                this.quotesStore.clear();
                this.quotesStore.addCollection(response.getQuotes());
                break;
            default:
                throw new QuoteRequestException(response.getResponseCode().toString());
        }

        return getSortedQuotes();
    }

    /**
     * Sort the contents of the store using the selected sorting method
     *
     * @param _sortMode The method by which to sort the contents of the store
     * @return An ArrayList of sorted QuoteStruct objects
     */
    public ArrayList<QuoteStruct> sortQuotesBy(SortMode _sortMode) {
        this.quotesStore.sort(_sortMode);
        return getSortedQuotes();
    }

    /**
     * Get an ArrayList of sorted QuoteStruct objects
     *
     * @return An ArrayList of sorted QuoteStruct objects
     */
    public ArrayList<QuoteStruct> getSortedQuotes() {
        return this.quotesStore.getSortedQuoteStructs();
    }

    /**
     * Get the QuoteStore object used by this controller (Used for testing and Debugging)
     *
     * @return The QuoteStore object used by this controller
     */
    public QuotesStore getQuoteStore() {
        return this.quotesStore;
    }

    /**
     * Get the current sort mode of the QuoteStore
     *
     * @return The current sort mode of the QuoteStore
     */
    public SortMode getCurrentSortMode() {
        return this.quotesStore.getCurrentSortMode();
    }

}
