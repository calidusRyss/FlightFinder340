package main.java.api.interfaces;
import java.time.LocalDateTime;
import main.java.models.flightapi.structures.Currency;
import main.java.models.flightapi.structures.Country;
import main.java.models.flightapi.responses.CountriesResponse;
import main.java.models.flightapi.responses.CurrenciesResponse;
import main.java.models.flightapi.responses.PlacesResponse;
import main.java.models.flightapi.responses.QuotesResponse;
import main.java.models.flightapi.responses.RoutesResponse;

/**
 * An interface dictating standard flight API functionality
 * @author Teegan Krieger
 * @LastUpdate 10/28/2020
 */
public interface IFlightApiTranslator {

    public CountriesResponse FetchAvaliableCountries();
    public CurrenciesResponse FetchAvaliableCurrencies();

    public PlacesResponse FetchAvaliablePlaces(Country _country, Currency _currency, String _query);

    public RoutesResponse FetchRoutes(String _country, String _currency, String _origin, String _destination, LocalDateTime _outboundTime);
    public RoutesResponse FetchRoutes(String _country, String _currency, String _origin, String _destination, LocalDateTime _outboundTime, LocalDateTime _inboundTime);

    public QuotesResponse FetchQuotes(String _country, String _currency, String _origin, String _destination, LocalDateTime _outboundTime);
    public QuotesResponse FetchQuotes(String _country, String _currency, String _origin, String _destination, LocalDateTime _outboundTime, LocalDateTime _inboundTime);

}
