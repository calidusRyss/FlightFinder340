package main.java.exceptions.controllers;

/**
 * An exception that is thrown when a Quote Request fails in the QuoteSearchController
 * @author Teegan Krieger
 */
public class QuoteRequestException extends RuntimeException {

    public QuoteRequestException(String _message)
    {
        super(_message);
    }

}
