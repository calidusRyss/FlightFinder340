package main.java.adapters;

import main.java.exceptions.HTTP.ConnectionFailedException;
import main.java.exceptions.HTTP.InvalidUrlException;
import main.java.models.HTTP.Request;
import main.java.models.HTTP.Response;
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

    /**
     * Make an HTTP request using the currently selected wrapper.
     * @param _request The request to make.
     * @return A response object with a response code and body.
     */
    public static Response callRequest(Request _request) throws InvalidUrlException, ConnectionFailedException
    {
        return httpWrapper.callRequest(_request);
    }
}
