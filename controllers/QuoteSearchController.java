package main.java.controllers;

import main.java.models.flightapi.enums.StoreSortMode;
import main.java.models.flightapi.stores.QuotesStore;
import main.java.models.flightapi.structures.QuoteStruct;

/**
 * A controller that handles searching for quotes and manipulating the views using it
 *
 * @author Teegan Krieger
 */
public class QuoteSearchController {

    private QuotesStore quotesStore;

    public void requestQuotes()
    {

    }

    public QuoteStruct[] sortQuotesBy(StoreSortMode _sortMode)
    {
        quotesStore.sort(_sortMode);
        return getSortedQuotes();
    }

    public QuoteStruct[] getSortedQuotes()
    {
        return quotesStore.getSortedQuoteStructs();
    }

}
