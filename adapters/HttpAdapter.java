package main.java.adapters;

import main.java.wrappers.HTTP.IHttpWrapper;
import main.java.wrappers.HTTP.OkHttpWrapper;

/**
 * An adapter that holds the active HTTP library wrapper. HTTP calls should be
 * forwarded through this adapter.
 *
 * @author Teegan Krieger
 * @LastUpdate 9/29/2020
 */
public class HttpAdapter {

    public static final IHttpWrapper httpWrapper = new OkHttpWrapper();
}
