package main.java.models.flightapi.structures;

/**
 * A class the represents a place obtained via a places request
 *
 * @author Teegan Krieger
 * @LastModified 11/15/2020
 */
public class Place {

    private final String placeID;
    private final String placeName;
    private final String countryID;
    private final String regionID;
    private final String cityID;
    private final String countryName;

    public Place(String _placeID, String _placeName, String _countryID, String _regionID, String _cityID, String _countryName) {
        this.placeID = _placeID;
        this.placeName = _placeName;
        this.countryID = _countryID;
        this.regionID = _regionID;
        this.cityID = _cityID;
        this.countryName = _countryName;
    }

    @Override
    public String toString() {
        return "Place{" + "placeID=" + this.placeID + ", placeName=" + this.placeName + ", countryID=" + this.countryID + ", regionID=" + this.regionID + ", cityID=" + this.cityID + ", countryName=" + this.countryName + '}';
    }

    //=================  GETTERS ===============
    /**
     * Get a string that represents the ID of the place
     *
     * @return A string that represents the ID of the place
     */
    public String getPlaceID() {
        return this.placeID;
    }

    /**
     * Get the name of the place
     *
     * @return The name of the place
     */
    public String getPlaceName() {
        return this.placeName;
    }

    /**
     * Get a string the represents the ID of the country this place holds
     *
     * @return A string the represents the ID of the country this place holds
     */
    public String getCountryID() {
        return this.countryID;
    }

    /**
     * Get a string the represents the ID of the region this place holds
     *
     * @return A string the represents the ID of the region this place holds
     */
    public String getRegionID() {
        return this.regionID;
    }

    /**
     * Get a string the represents the ID of the city this place holds
     *
     * @return A string the represents the ID of the city this place holds
     */
    public String getCityID() {
        return this.cityID;
    }

    /**
     * Get the name of the country this place holds
     *
     * @return The name of the country this place holds
     */
    public String getCountryName() {
        return this.countryName;
    }

}
