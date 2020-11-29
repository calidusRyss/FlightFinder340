package main.java.exceptions.controllers;

/**
 * An exception that is thrown when a Quote Request fails in the QuoteSearchController
 *
 * @author Teegan Krieger
 * @LastModified 11/19/2020
 */
public class QuoteRequestException extends RuntimeException {

    public QuoteRequestException(String _message) {
        super(_message);
    }

}
