package main.java.controllers;

import main.java.models.trips.collections.Trip;
import main.java.models.trips.collections.TripsStore;
import main.java.models.enums.SortMode;
import main.java.models.flightapi.collections.CurrencySelector;

/**
 * A controller that handles storing, sorting and viewing Trips
 *
 * @author Teegan Krieger
 * @LastModified 11/15/2020
 */
public class TripController {

    private final TripsStore tripsStore;
    private final CurrencySelector currencySelector;

    public TripController(QuoteSearchController _quoteSearchController, CurrencyController _currencyController) {
        this.tripsStore = new TripsStore();
        this.currencySelector = _currencyController.getCurrencySelector();
    }

    /**
     * Create a new empty trip using the currently selected currency from the currency selector
     */
    public void createNewTrip(String _tripName) {
        this.tripsStore.addCollection(new Trip(this.currencySelector.getSelectedCurrency()), _tripName);
    }

    /**
     * Delete a specified trip at the given index
     *
     * @param _index The index of the trip to delete
     */
    public void deleteTrip(int _index) {
        this.tripsStore.DeleteTrip(_index);
    }

    /**
     * Sort the trips in the store using the given sorting mode
     *
     * @param _sortMode The sorting mode
     */
    public void sortTrips(SortMode _sortMode) {
        this.tripsStore.sort(_sortMode);
    }

    //=================  GETTERS ===============
    /**
     * Get a specified trip at the given index
     *
     * @param _index The index of the trip to get
     * @return The trip at the index provided
     */
    public Trip getTripAtIndex(int _index) {
        return this.tripsStore.getAtIndex(_index);
    }

    /**
     * Get an array of all trips currently in the TripStore
     *
     * @return an array of all trips in the TripStore
     */
    public Trip[] getAllTrips() {
        return this.tripsStore.getTrips();
    }

    /**
     * Get the TripStore itself. Mostly used to pass the TripStore to other controllers.
     *
     * @return The TripStore associated to this controller
     */
    public TripsStore getTripsStore() {
        return this.tripsStore;
    }

}
