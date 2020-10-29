package main.java.models.flightapi.comparators;

import java.util.Comparator;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 *
 * @author Teegan Krieger
 * @LastUpdate 10/22/2020
 */
public class QuoteEarliestInboundDateComparator implements Comparator<UniversalQuote> {

    @Override
    public int compare(UniversalQuote o1, UniversalQuote o2) {
        return o1.getInboundLeg().getDepartureDateTime().compareTo(o2.getInboundLeg().getDepartureDateTime());
    }
}
