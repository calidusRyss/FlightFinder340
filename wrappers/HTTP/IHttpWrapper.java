package main.java.wrappers.HTTP;

import main.java.models.HTTP.Request;
import main.java.models.HTTP.Response;

/**
 * An interface that dictates HTTP wrapper functionality
 * @author Teegan Krieger
 */
public interface IHttpWrapper {
    
    public Response callRequest(Request _request);
    
}
