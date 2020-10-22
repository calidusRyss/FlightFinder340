package main.java.models.flightapi.structures;

/**
 *
 * @author STUB
 */
public class Country {

    private String countryCode;
    private String countryName;

    public Country(String _countryCode, String _countryName) {
        this.countryCode = _countryCode;
        this.countryName = _countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }
    
}
