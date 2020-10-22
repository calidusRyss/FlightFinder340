package main.java.api.interfaces;
import java.time.LocalDate;
import java.time.LocalDateTime;
import main.java.models.flightapi.structures.Location;
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
 */
public interface IFlightApiTranslator {

    public CountriesResponse FetchAvaliableCountries();
    public CurrenciesResponse FetchAvaliableCurrencies();

    public PlacesResponse FetchAvaliablePlaces(Country _country, Currency _currency, String _query);

    public RoutesResponse FetchRoutes(Country _country, Currency _currency, Location _origin, Location _destination, LocalDate _outboundTime);
    public RoutesResponse FetchRoutes(Country _country, Currency _currency, Location _origin, Location _destination, LocalDate _outboundTime, LocalDate _inboundTime);

    public QuotesResponse FetchQuotes(Country _country, Currency _currency, Location _origin, Location _destination, LocalDate _outboundTime);
    public QuotesResponse FetchQuotes(Country _country, Currency _currency, Location _origin, Location _destination, LocalDate _outboundTime, LocalDate _inboundTime);

}
