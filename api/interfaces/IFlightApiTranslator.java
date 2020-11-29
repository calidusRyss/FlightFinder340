package main.java.api.interfaces;

import java.time.LocalDateTime;
import main.java.models.flightapi.responses.CountriesResponse;
import main.java.models.flightapi.responses.CurrenciesResponse;
import main.java.models.flightapi.responses.PlacesResponse;
import main.java.models.flightapi.responses.QuotesResponse;

/**
 * An interface dictating standard flight API functionality
 *
 * @author Teegan Krieger
 * @LastModified 11/27/2020
 */
public interface IFlightApiTranslator {

    public CountriesResponse fetchAvaliableCountries();

    public CurrenciesResponse fetchAvaliableCurrencies();

    public PlacesResponse fetchAvaliablePlaces(String _country, String _currency, String _query);

    public QuotesResponse fetchQuotes(String _country, String _currency, String _origin, String _destination, LocalDateTime _outboundTime);

    public QuotesResponse fetchQuotes(String _country, String _currency, String _origin, String _destination, LocalDateTime _outboundTime, LocalDateTime _inboundTime);

}
