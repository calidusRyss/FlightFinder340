package main.java.wrappers.HTTP;

import main.java.exceptions.http.ConnectionFailedException;
import main.java.exceptions.http.InvalidUrlException;
import main.java.models.http.Request;
import main.java.models.http.Response;

/**
 * An interface that dictates HTTP wrapper functionality.
 *
 * @author Teegan Krieger
 * @LastModified 9/29/2020
 */
public interface IHttpWrapper {

    public Response callRequest(Request _request) throws InvalidUrlException, ConnectionFailedException;

}
