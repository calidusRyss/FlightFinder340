package main.java.exceptions.http;

import main.java.models.http.Request;

/**
 * Exception that is thrown when a Request is invalid.
 *
 * @author Teegan Krieger
 * @LastUpdate 9/29/2020
 */
public class InvalidUrlException extends RuntimeException {

    public InvalidUrlException(String _errorMessage, Request _request) {
        super(_errorMessage);
    }
}
