package main.java.models.flightapi.stores;

import java.util.ArrayList;
import java.util.Collections;
import main.java.models.flightapi.QuoteStructConverter;
import main.java.models.flightapi.comparators.QuoteAlphabeticalComparator;
import main.java.models.flightapi.comparators.QuoteCheapestComparator;
import main.java.models.flightapi.comparators.QuoteEarliestOutboundDateComparator;
import main.java.models.flightapi.comparators.QuoteLatestOutboundDateComparator;
import main.java.models.flightapi.comparators.QuoteExpensiveComparator;
import main.java.models.flightapi.comparators.QuoteEarliestInboundDateComparator;
import main.java.models.flightapi.comparators.QuoteLatestInboundDateComparator;
import main.java.models.flightapi.enums.StoreSortMode;
import main.java.models.flightapi.structures.UniversalQuote;
import main.java.models.flightapi.interfaces.IStore;
import main.java.models.flightapi.structures.QuoteStruct;

/**
 * A data store designed to hold and sort quotes
 *
 * @author Teegan Krieger
 * @LastUpdate 10/22/2020
 */
public class QuotesStore implements IStore {

    private static final QuoteAlphabeticalComparator quoteAlphabeticalComparator = new QuoteAlphabeticalComparator();
    private static final QuoteCheapestComparator quoteCheapestComparator = new QuoteCheapestComparator();
    private static final QuoteExpensiveComparator quoteExpensiveComparator = new QuoteExpensiveComparator();
    private static final QuoteEarliestOutboundDateComparator quoteEarliestOutboundComparator = new QuoteEarliestOutboundDateComparator();
    private static final QuoteLatestOutboundDateComparator quoteLatestOutboundComparator = new QuoteLatestOutboundDateComparator();
    private static final QuoteEarliestInboundDateComparator quoteEarliestInboundComparator = new QuoteEarliestInboundDateComparator();
    private static final QuoteLatestInboundDateComparator quoteLatestInboundComparator = new QuoteLatestInboundDateComparator();

    private final ArrayList<UniversalQuote> sortedQuotes;

    private StoreSortMode currentSortMode;

    public QuotesStore() {
        sortedQuotes = new ArrayList<UniversalQuote>();
        currentSortMode = StoreSortMode.CHEAPEST;
    }

    /**
     * Add a collections of quotes to the quote store
     * @param objects The quotes to add to the store
     */
    @Override
    public void addCollection(Object... objects)
    {
        //insert new objects into array
        for (int j = 0;j < objects.length; j++)
        {
            sortedQuotes.add((UniversalQuote)objects[j]);
        }

        //Re-Sort the array
        sort(currentSortMode);
    }

    /**
     * Clear the stores contents
     */
    @Override
    public void clear()
    {
        sortedQuotes.clear();
    }

    /**
     * Sort the contents of the store using the selected sorting method
     * @param _sortMode The method by which to sort the contents of the store
     */
    @Override
    public void sort(StoreSortMode _sortMode) {
        switch (_sortMode) {
            case ALPHABETICALLY:
                sortAlphabetically();
                break;
            case CHEAPEST:
                sortCheapest();
                break;
            case EXPENSIVE:
                sortExpensive();
                break;
            case EARLIEST_INBOUND_DATE:
                sortEarliestInboundDate();
                break;
            case LATEST_INBOUND_DATE:
                sortLatestInboundDate();
                break;
            case EARLIEST_OUTBOUND_DATE:
                sortEarliestOutboundDate();
                break;
            case LATEST_OUTBOUND_DATE:
                sortLatestOutboundDate();
                break;
        }
        currentSortMode = _sortMode;
    }

    /**
     * Sort the data currently in the store alphabetically.
     * NOTE: Might be removed!!! What can I sort alphabetically? Location names? Maybe...
     */
    private void sortAlphabetically() {
        Collections.sort(sortedQuotes, quoteAlphabeticalComparator);
    }

    /**
     * Sort the data currently in the store based on cheapest price
     */
    private void sortCheapest() {
        Collections.sort(sortedQuotes, quoteCheapestComparator);
    }

    /**
     * Sort the data currently in the store based on most expensive price
     */
    private void sortExpensive() {
        Collections.sort(sortedQuotes, quoteExpensiveComparator);
    }

    /**
     * Sort the data currently in the store based on their earliest inbound date
     */
    private void sortEarliestInboundDate() {
        Collections.sort(sortedQuotes, quoteEarliestInboundComparator);
    }

    /**
     * Sort the data currently in the store based on their latest inbound date
     */
    private void sortLatestInboundDate() {
        Collections.sort(sortedQuotes, quoteLatestInboundComparator);
    }

    /**
     * Sort the data currently in the store based on their earliest outbound date
     */
    private void sortEarliestOutboundDate() {
        Collections.sort(sortedQuotes, quoteEarliestOutboundComparator);
    }

    /**
     * Sort the data currently in the store based on their latest outbound date
     */
    private void sortLatestOutboundDate() {
        Collections.sort(sortedQuotes, quoteLatestOutboundComparator);
    }

    /**
     * Get a UniversalQuote from the desired index.
     * (Mainly used for testing)
     * @param index The index to get the UniversalQuote from
     * @return A UniversalQuote object from the desired index
     */
    public UniversalQuote getAtIndex(int index)
    {
        if (index < 0 || index > sortedQuotes.size() - 1)
            throw new IndexOutOfBoundsException();

        return sortedQuotes.get(index);
    }

    /**
     * Get an array of sorted QuoteStructs
     * @return A sorted array of QuoteStructs
     */
    public ArrayList<QuoteStruct> getSortedQuoteStructs()
    {
        ArrayList<QuoteStruct> quoteStructs = new ArrayList<QuoteStruct>(sortedQuotes.size());

        for (int i = 0; i < sortedQuotes.size(); i++)
        {
            quoteStructs.add(i, QuoteStructConverter.convertQuoteToStruct(sortedQuotes.get(i)));
        }

        return quoteStructs;
    }
}
