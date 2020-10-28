package main.java.models.flightapi.stores;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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
import main.java.models.flightapi.structures.UniversalJourneyLeg;

/**
 * A data store designed to hold and sort quotes
 *
 * @author Teegan Krieger
 * @LastUpdate 10/22/2020
 */
public class QuotesStore implements IStore {

    private static final DateTimeFormatter universalDateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

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
    public QuoteStruct[] getSortedQuoteStructs()
    {
        QuoteStruct[] quoteStructs = new QuoteStruct[sortedQuotes.size()];

        for (int i = 0; i < sortedQuotes.size(); i++)
        {
            quoteStructs[i] = convertQuoteToStruct(sortedQuotes.get(i));
        }

        return quoteStructs;
    }

    //NOTE: Move this into its own class

    /**
     * Helper method that converts a Quote object into a QuoteStruct object and formats strings
     *
     * @param _quote The Quote object to convert
     * @return A QuoteStruct object containing formatted strings to represent all relevant quote data
     */
    private QuoteStruct convertQuoteToStruct(UniversalQuote _quote)
    {
        //Note: This method will change based on Willie's handling of the Quote object

        if (_quote == null)
            throw new IllegalArgumentException("The provided quote object was null.");

        UniversalJourneyLeg outboundLeg = _quote.getOutboundLeg();
        UniversalJourneyLeg inboundLeg = _quote.getInboundLeg();

        String outboundOrigin = outboundLeg.getOriginLocation().getMostAccurateLocation();
        String outboundDestination = outboundLeg.getDestinationLocation().getMostAccurateLocation();
        String outboundDepartureTime = outboundLeg.getDepartureDateTime().format(universalDateTimeFormatter);
        String[] outboundCarrierNames = outboundLeg.getCarrierNames();

        String inboundOrigin = inboundLeg.getOriginLocation().getMostAccurateLocation();
        String inboundDestination = inboundLeg.getDestinationLocation().getMostAccurateLocation();
        String inboundDepartureTime = inboundLeg.getDepartureDateTime().format(universalDateTimeFormatter);
        String[] inboundCarrierNames = inboundLeg.getCarrierNames();

        //Format Price
        String price = _quote.getPriceFormatted();

        //Construct QuoteStruct
        QuoteStruct quoteStruct = new QuoteStruct(outboundOrigin, outboundDestination, outboundDepartureTime, outboundCarrierNames, inboundOrigin, inboundDestination, inboundDepartureTime, inboundCarrierNames, price);

        return quoteStruct;
    }

}
