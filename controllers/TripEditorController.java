package main.java.controllers;

import main.java.models.trips.collections.Trip;
import main.java.models.trips.collections.TripBuilder;
import main.java.models.trips.collections.TripsStore;

/**
 * A controller that handles modifying trips
 *
 * @author Teegan Krieger
 * @LastModified 11/15/2020
 */
public class TripEditorController {

    private final TripsStore tripsStore;
    private final TripBuilder tripBuilder;

    public TripEditorController(QuoteSearchController _quoteSearchController, TripController _tripController) {
        this.tripBuilder = new TripBuilder(_quoteSearchController.getQuoteStore());
        this.tripsStore = _tripController.getTripsStore();
    }

    /**
     * Add a quote from the Quote Store at the given index to the selected trip
     *
     * @param _index The index of the Quote within the Quote Store
     */
    public void addQuoteAtIndexToSelectedTrip(int _index) {
        this.tripBuilder.addQuoteAtIndexToTrip(_index);
    }

    /**
     * Move a quote to a new position, cascading other quotes into the now opened holes
     *
     * @param _oldIndex The index of the quote you wish to move
     * @param _newIndex The new index of this quote after moving it
     */
    public void moveQuoteInSelectedTrip(int _oldIndex, int _newIndex) {
        this.tripBuilder.moveQuote(_oldIndex, _newIndex);
    }

    /**
     * Removes a quote at the given index from the Trip
     *
     * @param _index The index of the quote to remove within the Trip
     */
    public void removeQuoteAtIndexFromSelectedTrip(int _index) {
        this.tripBuilder.removeQuoteAtIndexFromTrip(_index);
    }

    /**
     * Renames the selected trip
     *
     * @param _newName The new name for the Trip
     */
    public void renameSelectedTrip(String _newName) {
        this.tripBuilder.renameSelectedTrip(
                this.tripsStore.getNextFreeName(_newName)
        );
    }

    //=================  SETTERS ===============
    /**
     * Set the selected trip within the trip builder
     *
     * @param _index The index of the trip within the trip store
     */
    public void setSelectedTrip(int _index) {
        this.tripBuilder.setSelectedTrip(this.tripsStore.getAtIndex(_index), _index);
    }

    //=================  GETTERS ===============
    /**
     * Gets the selected Trip
     *
     * @return The selected Trip
     */
    public Trip getSelectedTrip() {
        return this.tripBuilder.getSelectedTrip();
    }

}
