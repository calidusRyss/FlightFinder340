package main.java.models.flightapi.responses;

import main.java.models.HTTP.Response;
import main.java.models.HTTP.ResponseCode;
import main.java.models.flightapi.structures.Currency;

/**
 * A class containing response data from a currencies request
 *
 * @author Teegan Krieger
 * @LastUpdate 10/5/2020
 */
public class CurrenciesResponse {

    private final ResponseCode responseCode;
    private final String httpResponseMessage;
    private final Currency[] currencies;

    public CurrenciesResponse(Response _httpResponse, Currency[] _parsedData) {
        this.responseCode = ResponseCode.getResponseCode(_httpResponse.getResponseCode());
        this.httpResponseMessage = _httpResponse.getHttpMessage();
        this.currencies = _parsedData;
    }

    //=================  GETTERS ===============
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public String getHttpResponseMessage() {
        return httpResponseMessage;
    }

    public Currency[] getCurrencies() {
        return currencies;
    }

}
