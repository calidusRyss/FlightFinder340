package main.java.models.HTTP;

/**
 * A class representing an HTTP response
 * @author Teegan Krieger
 */
public class Response {
    
    private final boolean successful;
    private final int responseCode;
    private final String httpMessage;
    private final String body;

    public Response(boolean _successful, int _responseCode, String _httpMessage, String _body)
    {
        this.successful = _successful;
        this.responseCode = _responseCode;
        this.httpMessage = _httpMessage;
        this.body = _body;
    }
    
    //=================  GETTERS ===============

    public boolean isSuccessful() {
        return successful;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getHttpMessage() {
        return httpMessage;
    }

    public String getBody() {
        return body;
    }
    
}
