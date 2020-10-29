package main.java.models.flightapi.comparators;

import java.util.Comparator;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 * A comparator used for sorting quotes from latest departure to earliest departure
 *
 * @author Teegan Krieger
 * @LastUpdate 10/22/2020
 */
public class QuoteLatestOutboundDateComparator implements Comparator<UniversalQuote> {

    @Override
    public int compare(UniversalQuote o1, UniversalQuote o2) {
        return -(o1.getOutboundLeg().getDepartureDateTime().compareTo(o2.getOutboundLeg().getDepartureDateTime()));
    }

}
