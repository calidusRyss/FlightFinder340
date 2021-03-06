package main.java.models.flightapi.responses;

import main.java.models.http.Response;
import main.java.models.http.ResponseCode;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 * A class containing response data from a quotes request
 *
 * @author Teegan Krieger
 * @LastModified 10/8/2020
 */
public class QuotesResponse {

    private final ResponseCode responseCode;
    private final String httpResponseMessage;

    private final UniversalQuote[] quotes;

    public QuotesResponse(Response _httpResponse, UniversalQuote[] _parsedData) {
        this.responseCode = ResponseCode.getResponseCode(_httpResponse.getResponseCode());
        this.httpResponseMessage = _httpResponse.getHttpMessage();
        this.quotes = _parsedData;
    }

    //=================  GETTERS ===============
    public ResponseCode getResponseCode() {
        return this.responseCode;
    }

    public String getHttpResponseMessage() {
        return this.httpResponseMessage;
    }

    public UniversalQuote[] getQuotes() {
        return this.quotes;
    }

}
