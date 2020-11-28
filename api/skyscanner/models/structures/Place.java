package main.java.api.skyscanner.models.structures;

/**
 * A class the represents a place obtained via a places request
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
        return "Place{" + "placeID=" + placeID + ", placeName=" + placeName + ", countryID=" + countryID + ", regionID=" + regionID + ", cityID=" + cityID + ", countryName=" + countryName + '}';
    }

    //=================  GETTERS ===============

    /**
     * Get a string that represents the ID of the place
     * @return A string that represents the ID of the place
     */
    public String getPlaceID() {
        return placeID;
    }

    /**
     * Get the name of the place
     * @return The name of the place
     */
    public String getPlaceName() {
        return placeName;
    }

    /**
     * Get a string the represents the ID of the country this place holds
     * @return A string the represents the ID of the country this place holds
     */
    public String getCountryID() {
        return countryID;
    }

    /**
     * Get a string the represents the ID of the region this place holds
     * @return A string the represents the ID of the region this place holds
     */
    public String getRegionID() {
        return regionID;
    }

    /**
     * Get a string the represents the ID of the city this place holds
     * @return A string the represents the ID of the city this place holds
     */
    public String getCityID() {
        return cityID;
    }

    /**
     * Get the name of the country this place holds
     * @return The name of the country this place holds
     */
    public String getCountryName() {
        return countryName;
    }

}
