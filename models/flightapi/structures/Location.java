package main.java.models.flightapi.structures;

/**
 * A class holding location data
 * @author Teegan Krieger
 */
public class Location {

    private String country;
    private String city;
    private String airport;

    public Location(Country _country)
    {
        throw new UnsupportedOperationException();
    }

    public Location(Country _country, Place _place, boolean useAirport)
    {
        throw new UnsupportedOperationException();
    }

    //=================  GETTERS ===============
    
    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAirport() {
        return airport;
    }
    
    public String getMostAccurateLocation()
    {
        if (airport != null)
            return airport;
        if (city != null)
            return city;
        return country;
    }
    
}
