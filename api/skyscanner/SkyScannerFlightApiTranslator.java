package main.java.api.skyscanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import main.java.adapters.HttpAdapter;
import main.java.api.interfaces.IFlightApiTranslator;
import main.java.api.skyscanner.models.helpers.UniversalQuoteFactory;
import main.java.api.skyscanner.models.parsers.CarriersParser;
import main.java.api.skyscanner.models.parsers.CountriesParser;
import main.java.exceptions.http.ConnectionFailedException;
import main.java.exceptions.http.InvalidUrlException;
import main.java.models.http.Header;
import main.java.models.http.Request;
import main.java.models.http.RequestMethod;
import main.java.models.http.Response;
import main.java.api.skyscanner.models.parsers.CurrencyParser;
import main.java.api.skyscanner.models.parsers.PlaceParser;
import main.java.api.skyscanner.models.parsers.QuotePlaceParser;
import main.java.api.skyscanner.models.parsers.QuotesParser;
import main.java.api.skyscanner.models.structures.Carrier;
import main.java.models.flightapi.structures.Place;
import main.java.api.skyscanner.models.structures.Quote;
import main.java.models.flightapi.structures.Country;
import main.java.models.flightapi.structures.Currency;

import main.java.models.flightapi.responses.CountriesResponse;
import main.java.models.flightapi.responses.CurrenciesResponse;
import main.java.models.flightapi.responses.PlacesResponse;
import main.java.models.flightapi.responses.QuotesResponse;
import main.java.api.skyscanner.models.structures.QuotePlace;
import main.java.models.flightapi.structures.UniversalQuote;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A translator used for making calls to and parsing data from the SkyScanner API
 * https://rapidapi.com/skyscanner/api/skyscanner-flight-search/details FREE VERSION (Which is used here)
 * https://skyscanner.github.io/slate/#api-documentation ENTERPRISE VERSION (Useful documentation but not all features are available in the free version)
 *
 * @author Teegan Krieger
 * @LastModified 10/28/2020
 */
public class SkyScannerFlightApiTranslator implements IFlightApiTranslator {

    private final String baseApiEndpoint = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices";

    private final String rapidAPIHostHeaderKey = "x-rapidapi-host";
    private final String rapidAPIHostHeaderValue = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

    private final String apiKeyHeaderKey = "x-rapidapi-key";
    private final String apiKeyHeaderValue = "1128fd20eemshabf4f1a2a039d35p1dbea4jsn4faf9b16a624";

    private final String fetchCurrenciesEndpoint = "/reference/v1.0/currencies";
    private final String fetchMarketsEndpoint = "/reference/v1.0/countries/en-US";
    private final String fetchPlacesEndpoint = "/autosuggest/v1.0/%s/%s/en-US/?query=%s";
    private final String fetchQuotesEndpoint = "/browsequotes/v1.0/%s/%s/en-US/%s/%s/%s?inboundpartialdate=%s";

    /**
     * Make a call with the SkyScanner API to fetch all valid country codes
     *
     * @return A country response object with a response code, message and country objects
     */
    @Override
    public CountriesResponse fetchAvaliableCountries() {

        //Make request
        Request countryRequest = new Request(this.baseApiEndpoint + this.fetchMarketsEndpoint, RequestMethod.GET);

        Response countryResponse = makeAPICall(countryRequest);

        if (!countryResponse.isSuccessful()) {
            CountriesResponse finalResponse = new CountriesResponse(countryResponse, new Country[0]);
            return finalResponse;
        }

        //Parse and Organize data since Country Request succeeded
        try {
            JSONObject countriesJson = new JSONObject(countryResponse.getBody());
            JSONArray countriesArray = countriesJson.getJSONArray("Countries");
            Country[] countries = CountriesParser.createCountriesArrayFromJsonArray(countriesArray);

            CountriesResponse finalResponse = new CountriesResponse(countryResponse, countries);
            return finalResponse;
        } catch (Exception e) {
            CountriesResponse finalResponse = new CountriesResponse(countryResponse, new Country[0]);
            return finalResponse;
        }
    }

    /**
     * Make a call with the SkyScanner API to fetch all valid currency codes
     *
     * @return A currency response object with a response code, message and currency objects
     */
    @Override
    public CurrenciesResponse fetchAvaliableCurrencies() {

        //Make request
        Request currencyRequest = new Request(this.baseApiEndpoint + this.fetchCurrenciesEndpoint, RequestMethod.GET);

        Response currencyResponse = makeAPICall(currencyRequest);

        if (!currencyResponse.isSuccessful()) {
            CurrenciesResponse finalResponse = new CurrenciesResponse(currencyResponse, new Currency[0]);
            return finalResponse;
        }

        //Parse and Organize data since Currency Request succeeded
        try {
            JSONObject currencyJson = new JSONObject(currencyResponse.getBody());
            JSONArray currencyArray = currencyJson.getJSONArray("Currencies");
            Currency[] currencies = CurrencyParser.createCurrencyArrayFromJsonArray(currencyArray);

            CurrenciesResponse finalResponse = new CurrenciesResponse(currencyResponse, currencies);
            return finalResponse;
        } catch (Exception e) //Json Parsing Failed
        {
            CurrenciesResponse finalResponse = new CurrenciesResponse(currencyResponse, new Currency[0]);
            return finalResponse;
        }
    }

    /**
     * Make a call with the SkyScanner API to fetch all valid places (Cities and airports)
     *
     * @param _country The country the user is in
     * @param _currency The currency the user wants values returned in
     * @param _query The Country, City or Airport the user want's to lookup. This value can also be set to "Anywhere" to return all results
     * @return A places response object with a response code, message and place objects
     */
    @Override
    public PlacesResponse fetchAvaliablePlaces(String _country, String _currency, String _query) {

        //Format endpoint string
        String formattedEndpoint = this.baseApiEndpoint + String.format(this.fetchPlacesEndpoint, _country, _currency, _query);

        //Make request
        Request placesRequest = new Request(formattedEndpoint, RequestMethod.GET);

        Response placesResponse = makeAPICall(placesRequest);

        if (!placesResponse.isSuccessful()) {
            PlacesResponse finalResponse = new PlacesResponse(placesResponse, new Place[0]);
            return finalResponse;
        }

        //Parse and Organize data since Places Request succeeded
        try {
            JSONObject placesJson = new JSONObject(placesResponse.getBody());
            JSONArray placesArray = placesJson.getJSONArray("Places");
            Place[] places = PlaceParser.createPlaceArrayFromJsonArray(placesArray);

            PlacesResponse finalResponse = new PlacesResponse(placesResponse, places);
            return finalResponse;
        } catch (Exception e) {
            PlacesResponse finalResponse = new PlacesResponse(placesResponse, new Place[0]);
            return finalResponse;
        }
    }

    /**
     * Make a call with the SkyScanner API to fetch all quotes within the constraints provided
     *
     * @param _country The country the user is in
     * @param _currency The currency the user wants values returned in
     * @param _origin The origin location for the route(s) the user wants to lookup
     * @param _destination The destination location for the route(s) the user wants to lookup. This value can be set to null to indicate "Anywhere"
     * @param _outboundTime The time the user would like the outbound flight to occur. If this is just a date with no time, the request will find all flights on that date
     * @return A quotes response object with a response code, message and quote objects
     */
    @Override
    public QuotesResponse fetchQuotes(String _country, String _currency, String _origin, String _destination, LocalDateTime _outboundTime) {

        return fetchQuotes(_country, _currency, _origin, _destination, _outboundTime, null);
    }

    /**
     * Make a call with the SkyScanner API to fetch all quotes within the constraints provided
     *
     * @param _country The country the user is in
     * @param _currency The currency the user wants values returned in
     * @param _origin The origin location for the route(s) the user wants to lookup
     * @param _destination The destination location for the route(s) the user wants to lookup. This value can be set to null to indicate "Anywhere"
     * @param _outboundTime The time the user would like the outbound flight to occur. If this is just a date with no time, the request will find all flights on that date
     * @param _inboundTime The time the user would like the inbound flight to occur. If this is set to null, the request will assume the user is looking for a one way flight
     * @return A quotes response object with a response code, message and quote objects
     */
    @Override
    public QuotesResponse fetchQuotes(String _country, String _currency, String _origin, String _destination, LocalDateTime _outboundTime, LocalDateTime _inboundTime) {

        //Format time strings
        String outboundTimeString = _outboundTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String inboundTimeString = _inboundTime == null ? "" : _inboundTime.format(DateTimeFormatter.ISO_LOCAL_DATE);

        //Format endpoint string
        String formattedEndpoint = this.baseApiEndpoint + String.format(this.fetchQuotesEndpoint, _country, _currency, _origin, _destination, outboundTimeString, inboundTimeString);

        //Make request
        Request quoteRequest = new Request(formattedEndpoint, RequestMethod.GET);

        Response quoteResponse = makeAPICall(quoteRequest);

        if (!quoteResponse.isSuccessful()) {
            //Quote Request failed. Pass back an empty quote response with error code
            QuotesResponse finalResponse = new QuotesResponse(quoteResponse, new UniversalQuote[0]);
            return finalResponse;
        }

        //Parse and Organize data since Quote Request succeeded
        try {
            JSONObject quotesJson = new JSONObject(quoteResponse.getBody());

            JSONArray quotesArray = quotesJson.getJSONArray("Quotes");
            JSONArray placesArray = quotesJson.getJSONArray("Places");
            JSONArray currenciesArray = quotesJson.getJSONArray("Currencies");
            JSONArray carriersArray = quotesJson.getJSONArray("Carriers");

            Quote[] quotes = QuotesParser.createQuotesArrayFromJsonArray(quotesArray);
            QuotePlace[] places = QuotePlaceParser.createPlacesArrayFromJsonArray(placesArray);
            Currency[] currencies = CurrencyParser.createCurrencyArrayFromJsonArray(currenciesArray);
            Carrier[] carriers = CarriersParser.createCarriersArrayFromJsonArray(carriersArray);

            UniversalQuote[] universalQuotes = UniversalQuoteFactory.createUniversalQuotes(quotes, places, carriers, currencies);

            QuotesResponse finalResponse = new QuotesResponse(quoteResponse, universalQuotes);
            return finalResponse;
        } catch (Exception e) {
            QuotesResponse finalResponse = new QuotesResponse(quoteResponse, new UniversalQuote[0]);
            return finalResponse;
        }
    }

    /**
     * Helper method for making API calls using the HTTP adapter
     *
     * @param _request The request to make
     * @return A response object. Response can contain error codes
     */
    private Response makeAPICall(Request _request) {

        //Prepare request headers
        _request.addHeaders(new Header(this.rapidAPIHostHeaderKey, this.rapidAPIHostHeaderValue), new Header(this.apiKeyHeaderKey, this.apiKeyHeaderValue));

        try {
            Response response = HttpAdapter.makeRequest(_request);
            return response;
        } catch (InvalidUrlException e) {
            //Note: If this error is caught, something VERY VERY wrong happened. This could only happen if the url for the request changed.
            //Which would mean an update to the endpoints above would need to be made!
            System.out.println("An error occured with an API url: " + _request.getUrl() + "\nThis is not a problem that can be fixed at runtime. The url might be dead.");

            return new Response(false, 404, "The url could not be located.", "[]");
        } catch (ConnectionFailedException e) {

            //This exception is raised when a connection error occurs.
            return new Response(false, 1, "A connection error occured!", "[]");
        }
    }

}
