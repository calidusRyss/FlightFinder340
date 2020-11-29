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
 * @LastModified 10/22/2020
 */
public class QuotesStore implements IStore {

    private static final QuoteCheapestComparator quoteCheapestComparator = new QuoteCheapestComparator();
    private static final QuoteExpensiveComparator quoteExpensiveComparator = new QuoteExpensiveComparator();

    private final ArrayList<UniversalQuote> sortedQuotes;

    private SortMode currentSortMode;

    public QuotesStore() {
        this.sortedQuotes = new ArrayList<UniversalQuote>();
        this.currentSortMode = SortMode.CHEAPEST;
    }

    /**
     * Add a collections of quotes to the quote store
     *
     * @param _objects The quotes to add to the store
     */
    @Override
    public void addCollection(Object... _objects) {
        //insert new objects into array
        for (int j = 0; j < _objects.length; j++) {
            this.sortedQuotes.add((UniversalQuote) _objects[j]);
        }

        //Re-Sort the array
        sort(this.currentSortMode);
    }

    /**
     * Clear the stores contents
     */
    @Override
    public void clear() {
        this.sortedQuotes.clear();
    }

    /**
     * Sort the contents of the store using the selected sorting method
     *
     * @param _sortMode The method by which to sort the contents of the store
     */
    @Override
    public void sort(SortMode _sortMode) {
        switch (_sortMode) {
            case CHEAPEST:
                Collections.sort(this.sortedQuotes, quoteCheapestComparator);
                break;
            case EXPENSIVE:
                Collections.sort(this.sortedQuotes, quoteExpensiveComparator);
                break;
        }
        this.currentSortMode = _sortMode;
    }

    //=================  GETTERS ===============
    /**
     * Get a UniversalQuote from the desired index. (Mainly used for testing)
     *
     * @param _index The index to get the UniversalQuote from
     * @return A UniversalQuote object from the desired index
     */
    public UniversalQuote getAtIndex(int _index) {
        if (_index < 0 || _index > this.sortedQuotes.size() - 1) {
            throw new IndexOutOfBoundsException();
        }

        return this.sortedQuotes.get(_index);
    }

    /**
     * Get an array of sorted QuoteStructs
     *
     * @return A sorted array of QuoteStructs
     */
    public ArrayList<QuoteStruct> getSortedQuoteStructs() {
        ArrayList<QuoteStruct> quoteStructs = new ArrayList<QuoteStruct>(this.sortedQuotes.size());

        for (int i = 0; i < this.sortedQuotes.size(); i++) {
            quoteStructs.add(i, QuoteStructConverter.convertQuoteToStruct(this.sortedQuotes.get(i)));
        }

        return quoteStructs;
    }

    /**
     * Get the current sort mode of the QuoteStore
     *
     * @return The current sort mode of the QuoteStore
     */
    public SortMode getCurrentSortMode() {
        return this.currentSortMode;
    }
}
