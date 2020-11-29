package main.java.models.flightapi.responses;

import main.java.models.http.Response;
import main.java.models.http.ResponseCode;
import main.java.models.flightapi.structures.Country;

/**
 * A class containing response data from a countries request
 *
 * @author Teegan Krieger
 * @LastModified 10/5/2020
 */
public class CountriesResponse {

    private final ResponseCode responseCode;
    private final String httpResponseMessage;
    private final Country[] countries;

    public CountriesResponse(Response _httpResponse, Country[] _parsedData) {
        this.responseCode = ResponseCode.getResponseCode(_httpResponse.getResponseCode());
        this.httpResponseMessage = _httpResponse.getHttpMessage();
        this.countries = _parsedData;
    }

    //=================  GETTERS ===============
    public ResponseCode getResponseCode() {
        return this.responseCode;
    }

    public String getHttpResponseMessage() {
        return this.httpResponseMessage;
    }

    public Country[] getCountries() {
        return this.countries;
    }

}
