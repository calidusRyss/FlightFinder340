package main.java.models.Trips;

import main.java.models.flightapi.stores.QuotesStore;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 * A class that helps construct trip objects and modify existing trip objects
 *
 * @author Teegan Krieger
 */
public class TripBuilder {

    private Trip selectedTrip;

    private final QuotesStore quoteStore;

    public TripBuilder(QuotesStore _quoteStore)
    {
        quoteStore = _quoteStore;
    }

    /**
     * Add a quote from the Quote Store at the given index to the selected trip
     * @param _index The index of the Quote within the Quote Store
     */
    public void addQuoteAtIndexToTrip(int _index)
    {
        if (selectedTrip == null)
            throw new IllegalStateException("A trip has not yet been selected to modify.");

        UniversalQuote quote = quoteStore.getAtIndex(_index);
        selectedTrip.addQuote(quote);
    }

    /**
     * Removes a quote at the given index from the Trip
     * @param _index The index of the quote to remove within the Trip
     */
    public void removeQuoteAtIndexFromTrip(int _index)
    {
        if (selectedTrip == null)
            throw new IllegalStateException("A trip has not yet been selected to modify.");

        selectedTrip.removeQuote(_index);
    }

    /**
     * Move a quote to a new position, cascading other quotes into the now opened holes
     * @param _oldIndex The index of the quote you wish to move
     * @param _newIndex The new index of this quote after moving it
     */
    public void moveQuote(int _oldIndex, int _newIndex)
    {
        if (selectedTrip == null)
            throw new IllegalStateException("A trip has not yet been selected to modify.");

        selectedTrip.moveQuote(_oldIndex, _newIndex);
    }

    /**
     * Set the selected trip.
     * @param _selection The trip to set the selection to.
     */
    public void setSelectedTrip(Trip _selection)
    {
        selectedTrip = _selection;
    }

    /**
     * Gets the selected Trip.
     * @return The selected Trip
     */
    public Trip getSelectedTrip()
    {
        return selectedTrip;
    }

    /**
     * Renames the selected trip
     * @param _newName The new name for the Trip
     */
    public void renameSelectedTrip(String _newName){
        if (selectedTrip == null)
            throw new IllegalStateException("A trip has not yet been selected to modify.");

        selectedTrip.setName(_newName);
    }


}