package main.java.wrappers.HTTP;

import main.java.exceptions.HTTP.ConnectionFailedException;
import main.java.exceptions.HTTP.InvalidUrlException;
import main.java.models.HTTP.Request;
import main.java.models.HTTP.Response;

/**
 * An interface that dictates HTTP wrapper functionality.
 *
 * @author Teegan Krieger
 * @LastUpdate 9/29/2020
 */
public interface IHttpWrapper {

    public Response callRequest(Request _request) throws InvalidUrlException, ConnectionFailedException;

}
