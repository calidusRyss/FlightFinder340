package main.java.models.interfaces;

import main.java.models.enums.SortMode;

/**
 * An interface defining shared functionality between store objects
 *
 * @author Teegan Krieger
 */
public interface IStore {
    public void addCollection(Object... objects);
    public void clear();
    public void sort(SortMode sortMode);
}
