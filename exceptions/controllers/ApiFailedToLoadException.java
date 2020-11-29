package main.java.exceptions.controllers;

/**
 * An exception that is thrown when an essential API call fails and the program cannot continue.
 *
 * @author Teegan Krieger
 * @LastModified 11/18/2020
 */
public class ApiFailedToLoadException extends RuntimeException {

    public ApiFailedToLoadException(String _message) {
        super(_message);
    }

}
