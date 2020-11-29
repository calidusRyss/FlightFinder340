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
        if (this.country == null) {
            return "";
        }
        return this.country;
    }

    /**
     * Get the city, if one exists
     *
     * @return The city, if one exists
     */
    public String getCity() {
        if (this.city == null) {
            return "";
        }
        return this.city;
    }

    /**
     * Get the airport, if one exists
     *
     * @return The airport, if one exists
     */
    public String getAirport() {
        if (this.airport == null) {
            return "";
        }
        return this.airport;
    }

    /**
     * Get the most accurate location Accuracy is determined in this order: Airport -> City -> Country
     *
     * @return The most accurate location
     */
    public String getMostAccurateLocation() {
        if (this.airport != null) {
            return this.airport;
        }
        if (this.city != null) {
            return this.city;
        }
        return this.country;
    }

    @Override
    public String toString() {
        return "Location{" + "country=" + this.country + ", city=" + this.city + ", airport=" + this.airport + '}';
    }

}
