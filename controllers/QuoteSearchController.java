package main.java.controllers;

import main.java.models.flightapi.structures.Property;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import main.java.adapters.FlightAPIAdapter;
import main.java.models.flightapi.enums.StoreSortMode;
import main.java.models.flightapi.responses.QuotesResponse;
import main.java.models.flightapi.stores.QuotesStore;
import main.java.models.flightapi.structures.QuoteStruct;

/**
 * A controller that handles searching for quotes and manipulating the views using it
 *
 * @author Teegan Krieger
 * @LastUpdate 10/28/2020
 */
public class QuoteSearchController {

    private final QuotesStore quotesStore;

    public QuoteSearchController()
    {
        quotesStore = new QuotesStore();
    }

    /**
     * Searches for quotes using the given properties
     * @param _searchFields The properties to search with
     * @return An array list of QuoteStructs
     */
    public ArrayList<QuoteStruct> searchQuotes(Property[] _searchFields)
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

        QuotesResponse response = FlightAPIAdapter.flightAPI.FetchQuotes(countryCode, currencyCode, originString, destinationString, originDepartureDate, destinationDepartureDate);

        switch(response.getResponseCode())
        {
            case OK:
                quotesStore.clear();
                quotesStore.addCollection(response.getQuotes());
                break;

            case Bad_Request:
                System.out.println("BAD REQUEST!");
                //This is called if the user input is bad. Tell the view to do something...
                break;

            default:
                System.out.println("Params:\n" + "Country Code: " + countryCode + "\nCurrency Code: " + currencyCode + "\nOrigin: " + originString + "\nDestination: " + destinationString + "\nDepartureTime: " + originDepartureDate.toString() + "\nReturningTime: " + destinationDepartureDate.toString());
                System.out.println("MISC. ERROR: " + response.getResponseCode().toString() + "\n" + response.getHttpResponseMessage());
                //Any other http response code should tell the view to show an error message
                break;
        }

        return getSortedQuotes();
    }

    public ArrayList<QuoteStruct> sortQuotesBy(StoreSortMode _sortMode)
    {
        quotesStore.sort(_sortMode);
        return getSortedQuotes();
    }

    public ArrayList<QuoteStruct> getSortedQuotes()
    {
        return quotesStore.getSortedQuoteStructs();
    }

}
