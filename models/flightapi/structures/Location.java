package main.java.models.flightapi.structures;

/**
 * A class holding location data
 * @author Teegan Krieger
 */
public class Location {

    private final String country;
    private final String city;
    private final String airport;

    public Location(String _country, String _city, String _airport) {
        this.country = _country;
        this.city = _city;
        this.airport = _airport;
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
