package main.java.models.trips.comparators;

import java.util.Comparator;
import main.java.models.trips.collections.Trip;

/**
 * A comparator used for sorting trips from most expensive to cheapest
 *
 * @author Teegan Krieger
 * @LastModified 11/9/2020
 */
public class TripExpensiveComparator implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {
        return -(o1.getTotalPrice() - o2.getTotalPrice());
    }

}
