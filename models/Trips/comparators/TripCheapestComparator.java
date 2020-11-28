package main.java.models.trips.comparators;

import java.util.Comparator;
import main.java.models.trips.collections.Trip;

/**
 * A comparator used for sorting trips from cheapest to most expensive
 * @author Teegan Krieger
 * @LastModified 11/9/2020
 */
public class TripCheapestComparator implements Comparator<Trip>{

    @Override
    public int compare(Trip _o1, Trip _o2) {
        return (_o1.getTotalPrice()- _o2.getTotalPrice());
    }

}
