package main.java.models.flightapi.comparators;

import java.util.Comparator;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 * A comparator used for sorting quotes from cheapest to most expensive
 *
 * @author Teegan Krieger
 * @LastModified 10/22/2020
 */
public class QuoteExpensiveComparator implements Comparator<UniversalQuote> {

    @Override
    public int compare(UniversalQuote _o1, UniversalQuote _o2) {
        return -(_o1.getPrice() - _o2.getPrice());
    }

}
