package main.java.adapters;

import main.java.models.filesystem.FileSystemTranslator;
import main.java.models.interfaces.IDataStore;

/**
 * Adapter class for the persistent data store
 *
 * @author Teegan Krieger
 * @LastModified 11/28/2020
 */
public class DataStoreAdapter {

    public static final IDataStore translator = new FileSystemTranslator();

}
