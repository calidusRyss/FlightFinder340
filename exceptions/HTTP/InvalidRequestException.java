package main.java.exceptions.HTTP;

import main.java.models.HTTP.Request;

/**
 * Exception that is thrown when a Request is invalid.
 *
 * @author Teegan Krieger
 * @LastUpdate 9/29/2020
 */
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String _errorMessage, Request _request) {
        super(_errorMessage);
    }
}
