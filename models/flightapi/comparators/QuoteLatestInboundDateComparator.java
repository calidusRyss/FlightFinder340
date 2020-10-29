/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.models.flightapi.comparators;

import java.util.Comparator;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 *
 * @author Teegan Krieger
 * @LastUpdate 10/22/2020
 */
public class QuoteLatestInboundDateComparator implements Comparator<UniversalQuote> {

    @Override
    public int compare(UniversalQuote o1, UniversalQuote o2) {
        return -o1.getInboundLeg().getDepartureDateTime().compareTo(o2.getInboundLeg().getDepartureDateTime());
    }
}
