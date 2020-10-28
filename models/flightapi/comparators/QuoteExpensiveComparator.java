package main.java.models.flightapi.comparators;

import java.util.Comparator;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 * A comparator used for sorting quotes from cheapest to most expensive
 *
 * @author Teegan Krieger
 * @LastUpdate 10/22/2020
 */
public class QuoteExpensiveComparator implements Comparator<UniversalQuote>{

    @Override
    public int compare(UniversalQuote o1, UniversalQuote o2) {
        return -(o1.getPrice() - o2.getPrice());
    }

}
