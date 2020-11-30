package main.java.models.flightapi.responses;

import main.java.models.flightapi.structures.Place;
import main.java.models.http.Response;
import main.java.models.http.ResponseCode;

/**
 * A class containing response data from a places request
 *
 * @author Teegan Krieger
 * @LastModified 10/5/2020
 */
public class PlacesResponse {

    private final ResponseCode responseCode;
    private final String httpResponseMessage;
    private final Place[] places;

    public PlacesResponse(Response _httpResponse, Place[] _parsedData) {
        this.responseCode = ResponseCode.getResponseCode(_httpResponse.getResponseCode());
        this.httpResponseMessage = _httpResponse.getHttpMessage();
        this.places = _parsedData;
    }

    //=================  GETTERS ===============
    public ResponseCode getResponseCode() {
        return this.responseCode;
    }

    public String getHttpResponseMessage() {
        return this.httpResponseMessage;
    }

    public Place[] getPlaces() {
        return this.places;
    }

}
