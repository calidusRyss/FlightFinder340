package main.java.models.http;

/**
 * A class representing an HTTP response.
 *
 * @author Teegan Krieger
 * @LastModified 9/29/2020
 */
public class Response {

    private final boolean successful;
    private final int responseCode;
    private final String httpMessage;
    private final String body;

    public Response(boolean _successful, int _responseCode, String _httpMessage, String _body) {
        this.successful = _successful;
        this.responseCode = _responseCode;
        this.httpMessage = _httpMessage;
        this.body = _body;
    }

    //=================  GETTERS ===============

    /**
     * Get whether the request was successful or not
     * @return Whether the request was successful or not
     */
    public boolean isSuccessful() {
        return this.successful;
    }

    /**
     * Get the response code of this response
     * @return The response code of this response
     */
    public int getResponseCode() {
        return this.responseCode;
    }

    /**
     * Get the HTTP response message of this response
     * @return The HTTP response message of this response
     */
    public String getHttpMessage() {
        return this.httpMessage;
    }

    /**
     * Get the response body of this response
     * @return The response body of this response
     */
    public String getBody() {
        return this.body;
    }

}
