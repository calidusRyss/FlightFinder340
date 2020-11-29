package main.java.models.flightapi.structures;

/**
 * A class holding location data with varying accuracy
 *
 * @author Teegan Krieger
 * @LastUpdated 10/22/2020
 */
public class Location {

    private String country;
    private String city;
    private String airport;

    public Location()
    {
        
    }

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

    @Override
    public String toString() {
        return "Location{" + "country=" + country + ", city=" + city + ", airport=" + airport + '}';
    }

}
