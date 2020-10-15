package main.java.api.skyscanner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import main.java.adapters.HttpAdapter;
import main.java.api.interfaces.IFlightApiTranslator;
import main.java.exceptions.HTTP.ConnectionFailedException;
import main.java.exceptions.HTTP.InvalidUrlException;
import main.java.models.HTTP.Header;
import main.java.models.HTTP.Request;
import main.java.models.HTTP.RequestMethod;
import main.java.models.HTTP.Response;
import main.java.models.flightapi.structures.Country;
import main.java.models.flightapi.structures.Currency;
import main.java.models.flightapi.structures.Location;

import main.java.models.flightapi.responses.CountriesResponse;
import main.java.models.flightapi.responses.CurrenciesResponse;
import main.java.models.flightapi.responses.PlacesResponse;
import main.java.models.flightapi.responses.QuotesResponse;
import main.java.models.flightapi.responses.RoutesResponse;
import main.java.models.flightapi.structures.Carrier;
import main.java.models.flightapi.structures.Place;
import main.java.models.flightapi.structures.Quote;
import main.java.models.flightapi.structures.Route;

/**
 * A translator used for making calls to and parsing data from the SkyScanner API
 * https://rapidapi.com/skyscanner/api/skyscanner-flight-search/details  FREE VERSION (Which is used here)
 * https://skyscanner.github.io/slate/#api-documentation   ENTERPRISE VERSION (Useful documentation but not all features are available in the free version)
 *
 * @author Teegan Krieger
 * @LastUpdate 10/15/2020
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
    private final String fetchRoutesEndpoint = "/browseroutes/v1.0/%s/%s/en-US/%s/%s/%s?inboundpartialdate=%s";
    private final String fetchQuotesEndpoint = "/browsequotes/v1.0/%s/%s/en-US/%s/%s/%s?inboundpartialdate=%s";

    /**
     * Make a call with the SkyScanner API to fetch all valid country codes
     *
     * @return A country response object with a response code, message and country objects
     */
    @Override
    public CountriesResponse FetchAvaliableCountries() {

        //Make request
        Request countryRequest = new Request(baseApiEndpoint + fetchMarketsEndpoint, RequestMethod.GET);

        Response countryResponse = makeAPICall(countryRequest);

        if (!countryResponse.isSuccessful())
        {
            CountriesResponse finalResponse = new CountriesResponse(countryResponse, new Country[0]);
            return finalResponse;
        }

        //Parse and Organize data since Country Request succeeded

        //Since the parsers are not complete yet, a stub country will exist in their place
        Country stub = new Country();

        CountriesResponse finalResponse = new CountriesResponse(countryResponse, new Country[]{ stub });
        return finalResponse;
    }

    /**
     * Make a call with the SkyScanner API to fetch all valid currency codes
     *
     * @return A currency response object with a response code, message and currency objects
     */
    @Override
    public CurrenciesResponse FetchAvaliableCurrencies() {

        //Make request
        Request currencyRequest = new Request(baseApiEndpoint + fetchCurrenciesEndpoint, RequestMethod.GET);

        Response currencyResponse = makeAPICall(currencyRequest);

        if (!currencyResponse.isSuccessful())
        {
            CurrenciesResponse finalResponse = new CurrenciesResponse(currencyResponse, new Currency[0]);
            return finalResponse;
        }

        //Parse and Organize data since Currency Request succeeded

        //Since the parsers are not complete yet, a stub currency will exist in their place
        Currency stub = new Currency();

        CurrenciesResponse finalResponse = new CurrenciesResponse(currencyResponse, new Currency[]{ stub });
        return finalResponse;
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
    public PlacesResponse FetchAvaliablePlaces(Country _country, Currency _currency, String _query) {

        //Format endpoint string
        String formattedEndpoint = baseApiEndpoint + String.format(fetchPlacesEndpoint, _country.toString(), _currency.toString(), _query);

        //Make request
        Request placesRequest = new Request(formattedEndpoint, RequestMethod.GET);

        Response placesResponse = makeAPICall(placesRequest);

        if (!placesResponse.isSuccessful())
        {
            PlacesResponse finalResponse = new PlacesResponse(placesResponse, new Place[0]);
            return finalResponse;
        }

        //Parse and Organize data since Places Request succeeded

        //Since the parsers are not complete yet, a stub place will exist in their place
        Place stub = new Place();

        PlacesResponse finalResponse = new PlacesResponse(placesResponse, new Place[]{ stub });
        return finalResponse;

    }

    /**
     * Make a call with the SkyScanner API to fetch all routes within the constraints provided
     *
     * @param _country The country the user is in
     * @param _currency The currency the user wants values returned in
     * @param _origin The origin location for the route(s) the user wants to lookup
     * @param _destination The destination location for the route(s) the user wants to lookup. This value can be set to null to indicate "Anywhere"
     * @param _outboundTime The time the user would like the outbound flight to occur. If this is just a date with no time, the request will find all flights on that date
     * @return A routes response object with a response code, message and route objects
     */
    @Override
    public RoutesResponse FetchRoutes(Country _country, Currency _currency, Location _origin, Location _destination, LocalDateTime _outboundTime) {

        return FetchRoutes(_country, _currency, _origin, _destination, _outboundTime, null);
    }

    /**
     * Make a call with the SkyScanner API to fetch all routes within the constraints provided
     *
     * @param _country The country the user is in
     * @param _currency The currency the user wants values returned in
     * @param _origin The origin location for the route(s) the user wants to lookup
     * @param _destination The destination location for the route(s) the user wants to lookup. This value can be set to null to indicate "Anywhere"
     * @param _outboundTime The time the user would like the outbound flight to occur. If this is just a date with no time, the request will find all flights on that date
     * @param _inboundTime The time the user would like the inbound flight to occur. If this is set to null, the request will assume the user is looking for a one way flight
     * @return A routes response object with a response code, message and route objects
     */
    @Override
    public RoutesResponse FetchRoutes(Country _country, Currency _currency, Location _origin, Location _destination, LocalDateTime _outboundTime, LocalDateTime _inboundTime) {

        //Format time strings
        String outboundTimeString = _outboundTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String inboundTimeString = _inboundTime == null ? "" : _inboundTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        //Format endpoint string
        String formattedEndpoint = baseApiEndpoint + String.format(fetchRoutesEndpoint, _country.toString(), _currency.toString(), _origin.toString(), _destination.toString(), outboundTimeString, inboundTimeString);

        //Make request
        Request routeRequest = new Request(formattedEndpoint, RequestMethod.GET);

        Response routeResponse = makeAPICall(routeRequest);

        if (!routeResponse.isSuccessful())
        {
            //Route Request failed. Pass back an empty route response with error code
            RoutesResponse finalResponse = new RoutesResponse(routeResponse, new Route[0]);
            return finalResponse;
        }

        //Parse and Organize data since Route Request succeeded

        //Since the parsers are not complete yet, a stub route will exist in their place
        Route stub = new Route();

        RoutesResponse finalResponse = new RoutesResponse(routeResponse, new Route[] { stub });
        return finalResponse;
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
    public QuotesResponse FetchQuotes(Country _country, Currency _currency, Location _origin, Location _destination, LocalDateTime _outboundTime) {

        return FetchQuotes(_country, _currency, _origin, _destination, _outboundTime, null);
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
    public QuotesResponse FetchQuotes(Country _country, Currency _currency, Location _origin, Location _destination, LocalDateTime _outboundTime, LocalDateTime _inboundTime) {

        //Format time strings
        String outboundTimeString = _outboundTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String inboundTimeString = _inboundTime == null ? "" : _inboundTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        //Format endpoint string
        String formattedEndpoint = baseApiEndpoint + String.format(fetchQuotesEndpoint, _country.toString(), _currency.toString(), _origin.toString(), _destination.toString(), outboundTimeString, inboundTimeString);

        //Make request
        Request quoteRequest = new Request(formattedEndpoint, RequestMethod.GET);

        Response quoteResponse = makeAPICall(quoteRequest);

        if (!quoteResponse.isSuccessful())
        {
            //Quote Request failed. Pass back an empty quote response with error code
            QuotesResponse finalResponse = new QuotesResponse(quoteResponse, new Quote[0]);
            return finalResponse;
        }

        //Parse and Organize data since Quote Request succeeded

        //Since the parsers are not complete yet, a stub quote will exist in their place
        Quote stub = new Quote(LocalDate.now(), 250, _currency, new Carrier[0], new Carrier[0], _origin, _destination, true);

        QuotesResponse finalResponse = new QuotesResponse(quoteResponse, new Quote[] { stub });
        return finalResponse;
    }

    /**
     * Helper method for making API calls using the HTTP adapter
     * @param _request The request to make
     * @return A response object. Response can contain error codes
     */
    private Response makeAPICall(Request _request) {

        //Prepare request headers
        _request.addHeaders(new Header(rapidAPIHostHeaderKey, rapidAPIHostHeaderValue), new Header(apiKeyHeaderKey, apiKeyHeaderValue));

        try {
            Response response = HttpAdapter.callRequest(_request);
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
