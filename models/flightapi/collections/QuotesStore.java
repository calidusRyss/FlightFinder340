package main.java.models.flightapi.collections;

import java.util.ArrayList;
import java.util.Collections;
import main.java.models.flightapi.helpers.QuoteStructConverter;
import main.java.models.flightapi.comparators.QuoteCheapestComparator;
import main.java.models.flightapi.comparators.QuoteExpensiveComparator;
import main.java.models.enums.SortMode;
import main.java.models.flightapi.structures.UniversalQuote;
import main.java.models.interfaces.IStore;
import main.java.models.flightapi.structures.QuoteStruct;

/**
 * A data store designed to hold and sort quotes
 *
 * @author Teegan Krieger
 * @LastUpdate 10/22/2020
 */
public class QuotesStore implements IStore {

    private static final QuoteCheapestComparator quoteCheapestComparator = new QuoteCheapestComparator();
    private static final QuoteExpensiveComparator quoteExpensiveComparator = new QuoteExpensiveComparator();

    private final ArrayList<UniversalQuote> sortedQuotes;

    private SortMode currentSortMode;

    public QuotesStore() {
        sortedQuotes = new ArrayList<UniversalQuote>();
        currentSortMode = SortMode.CHEAPEST;
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
    public void sort(SortMode _sortMode) {
        switch (_sortMode) {
            case CHEAPEST:
                Collections.sort(sortedQuotes, quoteCheapestComparator);
                break;
            case EXPENSIVE:
                Collections.sort(sortedQuotes, quoteExpensiveComparator);
                break;
        }
        currentSortMode = _sortMode;
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

    /**
     * Get the current sort mode of the QuoteStore
     * @return The current sort mode of the QuoteStore
     */
    public SortMode getCurrentSortMode()
    {
        return currentSortMode;
    }
}
