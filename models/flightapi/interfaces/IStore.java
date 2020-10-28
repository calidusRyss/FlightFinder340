package main.java.models.flightapi.interfaces;

import main.java.models.flightapi.enums.StoreSortMode;

/**
 * An interface defining shared functionality between store objects
 *
 * @author Teegan Krieger
 */
public interface IStore {
    public void addCollection(Object... objects);
    public void clear();
    public void sort(StoreSortMode sortMode);
}
