package main.java.models.flightapi.responses;

import main.java.models.HTTP.Response;
import main.java.models.HTTP.ResponseCode;
import main.java.models.flightapi.structures.Quote;

/**
 * A class containing response data from a quotes request
 *
 * @author Teegan Krieger
 * @LastUpdate 10/8/2020
 */
public class QuotesResponse {

    private final ResponseCode responseCode;
    private final String httpResponseMessage;

    private final Quote[] quotes;

    public QuotesResponse(Response _httpResponse, Quote[] _parsedData) {
        this.responseCode = ResponseCode.getResponseCode(_httpResponse.getResponseCode());
        this.httpResponseMessage = _httpResponse.getHttpMessage();
        this.quotes = _parsedData;
    }

    //=================  GETTERS ===============
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public String getHttpResponseMessage() {
        return httpResponseMessage;
    }

    public Quote[] getQuotes() {
        return quotes;
    }

}
