package main.java.test;

import java.time.LocalDateTime;
import java.time.Month;
import main.java.models.enums.SortMode;
import main.java.models.flightapi.collections.QuotesStore;
import main.java.models.flightapi.structures.Currency;
import main.java.models.flightapi.structures.Location;
import main.java.models.flightapi.structures.UniversalJourneyLeg;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 *
 * A collection of tests for the QuoteStore class
 *
 * @author Teegan Krieger
 * @LastUpdate 10/29/2020
 */
public class QuoteStoreTests {

    public static void main(String[] args) {

        //Construct Test Data
        Currency testCurrency = new Currency("USD", "$", ",", ".", true, false, 0, 0);

        QuotesStore store = new QuotesStore();

        UniversalJourneyLeg q1Outbound = new UniversalJourneyLeg(new String[] {"Delta"}, new Location(null, "New York", null), new Location(null, "London", null), LocalDateTime.of(2020, Month.NOVEMBER, 12, 0, 0));
        UniversalJourneyLeg q1Inbound = new UniversalJourneyLeg(new String[] {"Delta"}, new Location(null, "New York", null), new Location(null, "London", null), LocalDateTime.of(2020, Month.DECEMBER, 12, 0, 0));

        UniversalJourneyLeg q2Outbound = new UniversalJourneyLeg(new String[] {"Delta"}, new Location(null, "New York", null), new Location(null, "London", null), LocalDateTime.of(2020, Month.NOVEMBER, 11, 0, 0));
        UniversalJourneyLeg q2Inbound = new UniversalJourneyLeg(new String[] {"Delta"}, new Location(null, "New York", null), new Location(null, "London", null), LocalDateTime.of(2020, Month.DECEMBER, 13, 0, 0));

        UniversalJourneyLeg q3Outbound = new UniversalJourneyLeg(new String[] {"Delta"}, new Location(null, "New York", null), new Location(null, "London", null), LocalDateTime.of(2020, Month.NOVEMBER, 10, 0, 0));
        UniversalJourneyLeg q3Inbound = new UniversalJourneyLeg(new String[] {"Delta"}, new Location(null, "New York", null), new Location(null, "London", null), LocalDateTime.of(2020, Month.DECEMBER, 11, 0, 0));


        UniversalQuote q1 = new UniversalQuote(100, testCurrency, q1Outbound, q1Inbound, true);
        UniversalQuote q2 = new UniversalQuote(250, testCurrency, q2Outbound, q2Inbound, true);
        UniversalQuote q3 = new UniversalQuote(300, testCurrency, q3Outbound, q3Inbound, true);

        //Perform Tests
        System.out.println("Running Add Collection Test...\t\t" + (addCollectionTest(store, q1, q2, q3) ? "Success" : "Failure"));

        System.out.println("Running sort by cheapest test...\t\t" + (sortCheapestTest(store, q1, q2, q3) ? "Success" : "Failure")); //Expected Result: q1, q2, q3

        System.out.println("Running sort by expensive test...\t\t" + (sortExpensiveTest(store, q3, q2, q1) ? "Success" : "Failure")); //Expected Result: q3, q2, q1

        System.out.println("Running clear test...\t\t" + (clearTest(store) ? "Success" : "Failure"));

    }

    /**
     * Test adding a collection of quotes to the QuoteStore
     * @param store The QuoteStore to test
     * @param quotes The quotes to add to the store
     * @return The results of the test
     */
    public static boolean addCollectionTest(QuotesStore store, UniversalQuote... quotes) {
        try {
            for (UniversalQuote q : quotes) {
                store.addCollection(q);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Test sorting the QuoteStore by cheapest to most expensive quote
     * @param store The QuoteStore to test
     * @param expectedOrder The expected order of the objects in store after sorting
     * @return The results of the test
     */
    public static boolean sortCheapestTest(QuotesStore store, UniversalQuote... expectedOrder) {
        store.sort(SortMode.CHEAPEST);

        for (int i = 0; i < expectedOrder.length; i++) {
            if (store.getAtIndex(i).equals(expectedOrder[i])) {
                continue;
            }
            System.out.println("Failed @ " + i);
            return false;
        }
        return true;
    }

    /**
     * Test sorting the QuoteStore by most expensive to cheapest quote
     * @param store The QuoteStore to test
     * @param expectedOrder The expected order of the objects in store after sorting
     * @return The results of the test
     */
    public static boolean sortExpensiveTest(QuotesStore store, UniversalQuote... expectedOrder) {
        store.sort(SortMode.EXPENSIVE);

        for (int i = 0; i < expectedOrder.length; i++) {
            if (store.getAtIndex(i).equals(expectedOrder[i])) {
                continue;
            }
            System.out.println("Failed @ " + i);
            return false;
        }
        return true;
    }

    /**
     * Test clearing the QuoteStore
     * @param store The QuoteStore to test
     * @return The results of the test
     */
    public static boolean clearTest(QuotesStore store)
    {
        store.clear();

        return store.getSortedQuoteStructs().isEmpty();

    }

}
