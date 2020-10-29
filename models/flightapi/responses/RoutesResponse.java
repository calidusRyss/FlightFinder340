package main.java.models.flightapi.responses;

import main.java.models.HTTP.Response;
import main.java.models.HTTP.ResponseCode;
import main.java.models.flightapi.structures.Route;

/**
 * A class containing response data from a routes request
 *
 * @author Teegan Krieger
 * @LastUpdate 10/5/2020
 */
public class RoutesResponse {

    private final ResponseCode responseCode;
    private final String httpResponseMessage;
    private final Route[] routes;

    public RoutesResponse(Response _httpResponse, Route[] _parsedData) {
        this.responseCode = ResponseCode.getResponseCode(_httpResponse.getResponseCode());
        this.httpResponseMessage = _httpResponse.getHttpMessage();
        this.routes = _parsedData;
    }

    //=================  GETTERS ===============
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public String getHttpResponseMessage() {
        return httpResponseMessage;
    }

    public Route[] getCurrencies() {
        return routes;
    }
}
