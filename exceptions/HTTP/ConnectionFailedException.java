package main.java.exceptions.http;

/**
 * Exception that is thrown when an HTTP request fails due to a connectivity problem.
 * 
 * @author Teegan Krieger
 * @LastUpdate 9/30/2020
 */
public class ConnectionFailedException extends RuntimeException {
    
    public ConnectionFailedException(String _errorMessage)
    {
        super(_errorMessage);
    }
    
}
