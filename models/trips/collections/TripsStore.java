package main.java.models.trips.collections;

import java.util.ArrayList;
import java.util.Collections;
import main.java.models.trips.comparators.TripCheapestComparator;
import main.java.models.trips.comparators.TripExpensiveComparator;
import main.java.models.enums.SortMode;
import main.java.models.interfaces.IStore;

/**
 * A class that stores loaded trips and allows for sorting of these trips
 *
 * @author Teegan Krieger
 */
public class TripsStore implements IStore {

    private static final TripCheapestComparator tripCheapestComparator = new TripCheapestComparator();
    private static final TripExpensiveComparator tripExpensiveComparator = new TripExpensiveComparator();

    private ArrayList<Trip> sortedTrips;

    private SortMode currentSortMode;

    public TripsStore() {
        sortedTrips = new ArrayList<>();
        currentSortMode = SortMode.CHEAPEST;
    }

    /**
     * Adds 1 or more Trips to the Store
     * @param _objects
     */
    public void addCollection(Object... _objects) {

        for (int i = 0; i < _objects.length; i++) {
            sortedTrips.add((Trip)_objects[i]);
        }

        sort(currentSortMode);
    }

     /**
     * Adds 1 Trips to the Store and Give it a free Name by appending a number if needed.
     * @param _t the tip.
     * @pram _tripName the name to use.
     */
    public void addTrip(Trip _t, String _tripName) {

        _t.setName( this.getNextFreeName(_tripName));

        this.sortedTrips.add(_t);


        this.sort(this.currentSortMode);
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
    public void sort(SortMode _sortMode) {
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

    /**
     * get a string that is not currently a tripName by appending a number or Incrementing a number at the end.
     * @param _tripName The new name for the trip.
     * @return a string that is not currently a tripName.
     */
    public String getNextFreeName( String _tripName)
    {
         ArrayList<String> namesList = new ArrayList<String>();

        if(_tripName.trim().equals(""))
            _tripName = "New Trip";

        for (Trip t : this.sortedTrips)
        {
            namesList.add(t.getName());
        }

        while (namesList.contains(_tripName))
        {
            if (_tripName.contains("-"))
            {
                String[] a = _tripName.split("-", -2);

                int newNumber = Integer.parseInt(a[1]) + 1;
                _tripName = a[0] + "-" + newNumber;
            }
            else
                _tripName += "-1";

        }

        return _tripName;
    }

}
