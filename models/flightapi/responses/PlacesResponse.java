package main.java.models.flightapi.responses;

import main.java.models.HTTP.Response;
import main.java.models.HTTP.ResponseCode;
import main.java.api.skyscanner.models.structures.QuotePlace;

/**
 * A class containing response data from a places request
 *
 * @author Teegan Krieger
 * @LastUpdate 10/5/2020
 */
public class PlacesResponse {

    private final ResponseCode responseCode;
    private final String httpResponseMessage;
    private final QuotePlace[] places;

    public PlacesResponse(Response _httpResponse, QuotePlace[] _parsedData) {
        this.responseCode = ResponseCode.getResponseCode(_httpResponse.getResponseCode());
        this.httpResponseMessage = _httpResponse.getHttpMessage();
        this.places = _parsedData;
    }

    //=================  GETTERS ===============
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public String getHttpResponseMessage() {
        return httpResponseMessage;
    }

    public QuotePlace[] getPlaces() {
        return places;
    }

}
