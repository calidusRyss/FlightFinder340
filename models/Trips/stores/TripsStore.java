package main.java.models.Trips.stores;

import java.util.ArrayList;
import java.util.Collections;
import main.java.models.Trips.comparators.TripCheapestComparator;
import main.java.models.Trips.comparators.TripExpensiveComparator;
import main.java.models.Trips.Trip;
import main.java.models.Trips.enums.TripSortMode;

/**
 * A class that stores loaded trips and allows for sorting of these trips
 *
 * @author Teegan Krieger
 */
public class TripsStore {

    private static final TripCheapestComparator tripCheapestComparator = new TripCheapestComparator();
    private static final TripExpensiveComparator tripExpensiveComparator = new TripExpensiveComparator();

    private ArrayList<Trip> sortedTrips;

    private TripSortMode currentSortMode;

    public TripsStore() {
        sortedTrips = new ArrayList<>();
        currentSortMode = TripSortMode.CHEAPEST;
    }

    /**
     * Adds 1 or more Trips to the Store
     * @param _objects
     */
    public void addCollection(Trip... _objects) {

        for (int i = 0; i < _objects.length; i++) {
            sortedTrips.add(_objects[i]);
        }

        sort(currentSortMode);
    }

    /**
     * Deletes a Trip at the give index.
     * @param _index The index of the trip to delete
     */
    public void DeleteTrip(int _index) {
        sortedTrips.remove(_index);
    }

    /**
     * Clear the Trip Store
     */
    public void clear() {
        sortedTrips.clear();
    }

    /**
     * Sort the Trips within the store using the given sort mode
     * @param _sortMode The sort mode
     */
    public void sort(TripSortMode _sortMode) {
        switch (_sortMode) {
            case CHEAPEST:
                Collections.sort(sortedTrips, tripCheapestComparator);
                break;
            case EXPENSIVE:
                Collections.sort(sortedTrips, tripExpensiveComparator);
                break;
        }
        currentSortMode = _sortMode;
    }

    /**
     * Get a trip at the given index
     * @param _index The index of the trip
     * @return The quote stored at the provided index
     */
    public Trip getAtIndex(int _index) {
        if (_index < 0 || _index > sortedTrips.size() - 1) {
            throw new IndexOutOfBoundsException();
        }

        return sortedTrips.get(_index);
    }

    /**
     * Get an array of all Trips in the store
     * @return An array of all Trips in the store
     */
    public Trip[] getTrips() {
        Trip[] allTrips = new Trip[sortedTrips.size()];

        for (int i = 0; i < allTrips.length; i++) {
            allTrips[i] = sortedTrips.get(i);
        }

        return allTrips;
    }

}
