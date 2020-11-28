package main.java.models.flightapi.structures;

/**
 * A class holding location data with varying accuracy
 *
 * @author Teegan Krieger
 * @LastModified 10/22/2020
 */
public class Location {

    private String country;
    private String city;
    private String airport;

    public Location() {

    }

    public Location(String _country, String _city, String _airport) {
        this.country = _country;
        this.city = _city;
        this.airport = _airport;
    }

    //=================  GETTERS ===============
    /**
     * Get the country, if one exists
     *
     * @return The country, if one exists
     */
    public String getCountry() {
        if (country == null) {
            return "";
        }
        return country;
    }

    /**
     * Get the city, if one exists
     *
     * @return The city, if one exists
     */
    public String getCity() {
        if (city == null) {
            return "";
        }
        return city;
    }

    /**
     * Get the airport, if one exists
     *
     * @return The airport, if one exists
     */
    public String getAirport() {
        if (airport == null) {
            return "";
        }
        return airport;
    }

    /**
     * Get the most accurate location Accuracy is determined in this order: Airport -> City -> Country
     *
     * @return The most accurate location
     */
    public String getMostAccurateLocation() {
        if (airport != null) {
            return airport;
        }
        if (city != null) {
            return city;
        }
        return country;
    }

    @Override
    public String toString() {
        return "Location{" + "country=" + country + ", city=" + city + ", airport=" + airport + '}';
    }

}
