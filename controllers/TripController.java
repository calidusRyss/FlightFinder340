package main.java.controllers;

import main.java.models.Trips.Trip;
import main.java.models.Trips.TripBuilder;
import main.java.models.Trips.enums.TripSortMode;
import main.java.models.Trips.stores.TripsStore;
import main.java.models.flightapi.stores.CurrencySelector;

/**
 * A controller that handles storing, sorting and viewing Trips
 *
 * @author Teegan Krieger
 */
public class TripController {

    private final TripsStore tripsStore;
    private final TripBuilder tripBuilder;
    private final CurrencySelector currencySelector;

    public TripController(QuoteSearchController _quoteSearchController, CurrencyController _currencyController)
    {
        tripsStore = new TripsStore();
        tripBuilder = new TripBuilder(_quoteSearchController.getQuoteStore());
        currencySelector = _currencyController.getCurrencySelector();
    }

    /**
     * Create a new empty trip using the currently selected currency from the currency selector
     */
    public void createNewTrip()
    {
        tripsStore.addCollection(new Trip(currencySelector.getSelectedCurrency()));
    }

    /**
     * Delete a specified trip at the given index
     * @param _index The index of the trip to delete
     */
    public void deleteTrip(int _index)
    {
        tripsStore.DeleteTrip(_index);
    }

    /**
     * Sort the trips in the store using the given sorting mode
     * @param _sortMode The sorting mode
     */
    public void sortTrips(TripSortMode _sortMode)
    {
        tripsStore.sort(_sortMode);
    }

    /**
     * Get a specified trip at the given index
     * @param _index The index of the trip to get
     * @return The trip at the index provided
     */
    public Trip getTripAtIndex(int _index)
    {
        return tripsStore.getAtIndex(_index);
    }

    /**
     * Get an array of all trips currently in the TripStore
     * @return an array of all trips in the TripStore
     */
    public Trip[] getAllTrips()
    {
        return tripsStore.getTrips();
    }

    /**
     * Get the TripStore itself.
     * Mostly used to pass the TripStore to other controllers.
     * @return The TripStore associated to this controller
     */
    public TripsStore getTripsStore()
    {
        return tripsStore;
    }

}
