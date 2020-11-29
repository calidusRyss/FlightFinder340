package main.java.models.trips.collections;

import java.util.ArrayList;
import java.util.Collections;
import main.java.adapters.DataStoreAdapter;
import main.java.models.trips.comparators.TripCheapestComparator;
import main.java.models.trips.comparators.TripExpensiveComparator;
import main.java.models.enums.SortMode;
import main.java.models.interfaces.IStore;

/**
 * A class that stores loaded trips and allows for sorting of these trips
 *
 * @author Teegan Krieger
 * @LastModified 11/9/2020
 */
public class TripsStore implements IStore {

    private static final TripCheapestComparator tripCheapestComparator = new TripCheapestComparator();
    private static final TripExpensiveComparator tripExpensiveComparator = new TripExpensiveComparator();

    private ArrayList<Trip> sortedTrips;

    private SortMode currentSortMode;

    public TripsStore() {
        this.sortedTrips = new ArrayList<>();
        this.currentSortMode = SortMode.CHEAPEST;

        Object[] existingTrips = DataStoreAdapter.translator.load(Trip.class);
        if (existingTrips != null) {
            for (int i = 0; i < existingTrips.length; i++) {
                this.sortedTrips.add((Trip) existingTrips[i]);
            }
        }
        sort(this.currentSortMode);
    }

    /**
     * Adds 1 or more Trips to the Store
     *
     * @param _objects
     */
    @Override
    public void addCollection(Object... _objects) {

        for (int i = 0; i < _objects.length; i++) {
            this.sortedTrips.add((Trip) _objects[i]);
            DataStoreAdapter.translator.create((Trip) _objects[i]);
        }

        sort(this.currentSortMode);
    }

    /**
     * Adds 1 Trips to the Store and Give it a free Name by appending a number if needed.
     *
     * @param _t the tip.
     * @param _tripName the name to use.
     */
    public void addCollection(Trip _t, String _tripName) {

        _t.setName(this.getNextFreeName(_tripName));

        this.sortedTrips.add(_t);
        DataStoreAdapter.translator.create(_t);

        this.sort(this.currentSortMode);
    }

    /**
     * Deletes a Trip at the give index.
     *
     * @param _index The index of the trip to delete
     */
    public void DeleteTrip(int _index) {
        this.sortedTrips.remove(_index);
        DataStoreAdapter.translator.delete(_index, Trip.class);
    }

    /**
     * Clear the Trip Store
     */
    @Override
    public void clear() {
        this.sortedTrips.clear();
    }

    /**
     * Sort the Trips within the store using the given sort mode
     *
     * @param _sortMode The sort mode
     */
    @Override
    public void sort(SortMode _sortMode) {
        switch (_sortMode) {
            case CHEAPEST:
                Collections.sort(this.sortedTrips, tripCheapestComparator);
                break;
            case EXPENSIVE:
                Collections.sort(this.sortedTrips, tripExpensiveComparator);
                break;
        }

        for (int i = 0; i < sortedTrips.size(); i++) {
            //Update each object in the Persistent Data Store, only saving on the last object
            DataStoreAdapter.translator.update(sortedTrips.get(i), i, (i == sortedTrips.size() - 1));
        }

        this.currentSortMode = _sortMode;
    }

    /**
     * Get a trip at the given index
     *
     * @param _index The index of the trip
     * @return The quote stored at the provided index
     */
    public Trip getAtIndex(int _index) {
        if (_index < 0 || _index > this.sortedTrips.size() - 1) {
            throw new IndexOutOfBoundsException();
        }

        return this.sortedTrips.get(_index);
    }

    /**
     * Get an array of all Trips in the store
     *
     * @return An array of all Trips in the store
     */
    public Trip[] getTrips() {
        Trip[] allTrips = new Trip[this.sortedTrips.size()];

        for (int i = 0; i < allTrips.length; i++) {
            allTrips[i] = this.sortedTrips.get(i);
        }

        return allTrips;
    }

    /**
     * Get the number of trips currently in the store
     * @return The number of trips currently in the store
     */
    public int getTripsCount()
    {
        return sortedTrips.size();
    }

    /**
     * Get a string that is not currently a tripName by appending a number or Incrementing a number at the end.
     *
     * @param _tripName The new name for the trip.
     * @return a string that is not currently a tripName.
     */
    public String getNextFreeName(String _tripName) {
        ArrayList<String> namesList = new ArrayList<String>();

        if (_tripName.trim().equals("")) {
            _tripName = "New Trip";
        }

        for (Trip t : this.sortedTrips) {
            namesList.add(t.getName());
        }

        while (namesList.contains(_tripName)) {
            if (_tripName.contains("-")) {
                String[] a = _tripName.split("-", -2);

                int newNumber = Integer.parseInt(a[1]) + 1;
                _tripName = a[0] + "-" + newNumber;
            } else {
                _tripName += "-1";
            }

        }

        return _tripName;
    }

}
